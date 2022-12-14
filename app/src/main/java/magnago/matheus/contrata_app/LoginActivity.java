package magnago.matheus.contrata_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import magnago.matheus.contrata_app.Util.Config;
import magnago.matheus.contrata_app.model.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    ImageButton imbLA;
    Button btnLA, btnLogar;
    EditText etLog1, etLog2;
    static int RESULT_REQUEST_PERMISSION = 2;
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        Button btnLogin = findViewById(R.id.btnLog1);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText etEmail = findViewById(R.id.etEmailLog1);
                final String email = etEmail.getText().toString();

                EditText etPassword = findViewById(R.id.etSenhaLog2);
                final String password = etPassword.getText().toString();

                LiveData<Boolean> resultLD = loginViewModel.login(email, password);


                resultLD.observe(LoginActivity.this, new Observer<Boolean>() {

                    @Override
                    public void onChanged(Boolean aBoolean) {

                        if(aBoolean) {

                            Config.setEmail(LoginActivity.this, email);
                            Config.setPassword(LoginActivity.this, password);

                            Toast.makeText(LoginActivity.this, "Login realizado com sucesso", Toast.LENGTH_LONG).show();

                            Intent i = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(i);
                        }
                        else {

                            Toast.makeText(LoginActivity.this, "Não foi possível realizar o login da aplicação", Toast.LENGTH_LONG).show();
                            Intent i2 = new Intent(LoginActivity.this, LpageActivity.class);
                            startActivity(i2);
                        }
                    }
                });
            }
        });


        AbrirHome();
        BackLandingPage();


    }

    public void AbrirHome() {
        btnLA = findViewById(R.id.btnLog1);

            btnLA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i1 = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i1);
                }
            });
    }

    public void BackLandingPage() {
        imbLA = findViewById(R.id.imbLog1);

        imbLA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(LoginActivity.this, LpageActivity.class);
                startActivity(i2);
            }
        });
    }

    /*public void inicializarLog () {

        etLog1 = findViewById(R.id.etEmailLog1);
        etLog2 = findViewById(R.id.etSenhaLog2);
        btnLogar = findViewById(R.id.btnLog1);


    }*/


}