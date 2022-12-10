package magnago.matheus.contrata_app.Util;

import android.util.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HttpRequest {

    private String method;
    private String requestUrl;
    private String charset;

    HashMap<String, String> params = new HashMap<>();

    String user = "";
    String password = "";

    int timeout = 3000;

    private String boundary;
    private static final String LINE_FEED = "\r\n";
    private HttpURLConnection httpConn;
    private OutputStream outputStream;
    private PrintWriter writer;

    public HttpRequest( String requestUrl, String method, String charset) {

        this.method = method;
        this.requestUrl = requestUrl;
        this.charset = charset;
    }

    public void addParam(String key, String value) {this.params.put(key, value);}

    public void setBasicAuth(String user, String password) {
        this.user = user;
        this.password = password;
    }


    // Seta o tempo maximo (em milisegundos) de espera por uma resposta do servidor.
    public void setTimeout(int time) {
        this.timeout = time;
    }

    // Executa a conexao: anexa os parametros e arquivos a serem enviados ao servidor, abre uma
    // conexao com o servidor. Ao final, retorna a resposta do servidor na forma de um InputStream,
    // o qual deve ser convertido para o dado originalmente enviado.
    public InputStream execute() throws IOException {

        if(method == "GET") {
            requestUrl = requestUrl + "?";
            Iterator it = params.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                requestUrl = requestUrl + URLEncoder.encode(pair.getKey().toString(),"UTF-8");
                requestUrl = requestUrl + "=";
                requestUrl = requestUrl + URLEncoder.encode(pair.getValue().toString(),"UTF-8");
                requestUrl = requestUrl + "&";
            }
            requestUrl =  requestUrl.substring(0, requestUrl.length() - 1);
        }

        URL url = new URL(this.requestUrl);
        httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setUseCaches(false);
        httpConn.setDoInput(true);

        // Timeout for reading InputStream arbitrarily set to 3000ms.
        httpConn.setReadTimeout(3000);
        // Timeout for connection.connect() arbitrarily set to 3000ms.
        httpConn.setConnectTimeout(3000);
        // GET or POST
        httpConn.setRequestMethod(method);

        if(!this.user.isEmpty() && !this.password.isEmpty()) {
            String auth = user + ":" + password;
            byte[] encodedAuth = Base64.encode(auth.getBytes(), Base64.NO_WRAP);
            String authHeaderValue = "Basic " + new String(encodedAuth);
            httpConn.setRequestProperty("Authorization", authHeaderValue);
        }

        if(method == "POST") {
            boundary = "===" + System.currentTimeMillis() + "===";
            httpConn.setDoOutput(true);    // indicates POST method
            httpConn.setRequestProperty("Content-Type",
                    "multipart/form-data; boundary=" + boundary);
            outputStream = httpConn.getOutputStream();
            writer = new PrintWriter(new OutputStreamWriter(outputStream, charset),
                    true);

            Iterator itParams = params.entrySet().iterator();
            while (itParams.hasNext()) {
                Map.Entry pair = (Map.Entry) itParams.next();
                writer.append("--" + boundary).append(LINE_FEED);
                writer.append("Content-Disposition: form-data; name=\"" + pair.getKey().toString() + "\"")
                        .append(LINE_FEED);
                writer.append("Content-Type: text/plain; charset=" + charset).append(
                        LINE_FEED);
                writer.append(LINE_FEED);
                writer.append(pair.getValue().toString()).append(LINE_FEED);
                writer.flush();
            }

        }

        int responseCode = httpConn.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP error code: " + responseCode);
        }
        // Retrieve the response body as an InputStream.
        return httpConn.getInputStream();
    }

    // Fecha a conexao
    public void finish() throws IOException {
        InputStream inputStream = httpConn.getInputStream();
        if (inputStream != null) {
            inputStream.close();
        }
        if (httpConn != null) {
            httpConn.disconnect();
        }
    }

}
