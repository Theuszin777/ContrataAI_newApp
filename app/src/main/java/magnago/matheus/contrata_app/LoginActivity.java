package magnago.matheus.contrata_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    ImageButton imbLA;
    Button btnLA, btnLogar;
    EditText etLog1, etLog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // LOGAR
        /*btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtEmailLog1 = etLog1.getText().toString();
                String txtSenhaLog2 = etLog2.getText().toString();

                if (!txtEmailLog1.isEmpty()) {
                    if (!txtSenhaLog2.isEmpty()) {

                    }
                    else {
                        Toast.makeText(LoginActivity.this,"Senha não informada!!!",Toast.LENGTH_SHORT).show();

                    }
                }
                else {
                    Toast.makeText(LoginActivity.this,"E-mail não informado!!!",Toast.LENGTH_SHORT).show();

                }
            }
        });*/

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