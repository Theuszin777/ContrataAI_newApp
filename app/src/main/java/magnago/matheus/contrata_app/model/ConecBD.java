package magnago.matheus.contrata_app.model;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import magnago.matheus.contrata_app.Util.Config;
import magnago.matheus.contrata_app.Util.HttpRequest;
import magnago.matheus.contrata_app.Util.Util;

public class ConecBD {

    Context context;
    public ConecBD(Context context) {
        this.context = context;
    }

    public boolean register(String newNome, String newEmail, String newCpf, String newPassword, String newTelefone) {

        HttpRequest httpRequest = new HttpRequest(Config.CONTRATAI_URL + "register.php", "POST", "UTF-8");
        httpRequest.addParam("novo_nome", newNome);
        httpRequest.addParam("novo_email", newEmail);
        httpRequest.addParam("novo_cpf", newCpf);
        httpRequest.addParam("nova_senha", newPassword);
        httpRequest.addParam("novo_telefone", newTelefone);

        String result = "";
        try {
            InputStream is = httpRequest.execute();

            result = Util.inputStream2String(is, "UTF-8");

            Log.i("HTTP REGISTER RESULT", result);

            httpRequest.finish();

            JSONObject jsonObject = new JSONObject(result);

            int success = jsonObject.getInt("sucesso");

            if(success == 1) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("HTTP RESULT", result);
        }
        return false;

    }

    public boolean login(String email, String password) {

        HttpRequest httpRequest = new HttpRequest(Config.CONTRATAI_URL + "login.php", "POST", "UTF-8");
        httpRequest.setBasicAuth(email, password);

        String result = "";
        try {

            InputStream is = httpRequest.execute();

            result = Util.inputStream2String(is, "UTF-8");

            httpRequest.finish();

            Log.i("HTTP LOGIN RESULT", result);

            JSONObject jsonObject = new JSONObject(result);

            int success = jsonObject.getInt("sucesso");

            if(success == 1) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("HTTP RESULT", result);
        }
        return false;
    }

}

