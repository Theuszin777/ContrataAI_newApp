package magnago.matheus.contrata_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    ImageButton imbCF;
    Button btnCF, btnCadastrar;
    private EditText etNome, etEmail, etCPF, etSenha, etProf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //CADASTRO
        /*btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String txtNome = etNome.getText().toString();
                String txtEmail = etEmail.getText().toString();
                String txtCPF = etCPF.getText().toString();
                String txtSenha = etSenha.getText().toString();
                String txtProf = etProf.getText().toString();

                if (!txtNome.isEmpty()) {
                    if (!txtEmail.isEmpty()) {
                        if (!txtCPF.isEmpty()) {
                            if (!txtSenha.isEmpty()) {
                                if (!txtProf.isEmpty()) {
                                    //Cadastrar Usuário.
                                }
                                else {
                                    Toast.makeText(CadastroActivity.this, "Profissão não preenchida!", Toast.LENGTH_SHORT).show();
                                }

                            }
                            else {
                                Toast.makeText(CadastroActivity.this, "Senha não preenchida!", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else {
                            Toast.makeText(CadastroActivity.this, "CPF não preenchido!", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else {
                        Toast.makeText(CadastroActivity.this, "E-mail não preenchido!", Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(CadastroActivity.this, "Nome não preenchido!", Toast.LENGTH_SHORT).show();
                }
            }
        });*/


        BackLandingPageC1();
        Cadastrado();

    }


    public void BackLandingPageC1() {
        imbCF = findViewById(R.id.imbCad1);

        imbCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(CadastroActivity.this, LpageActivity.class);
                startActivity(i2);
            }
        });
    }

    public void Cadastrado() {

        btnCF = findViewById(R.id.btnCad1);

        btnCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(CadastroActivity.this, LpageActivity.class);
                startActivity(i1);
            }
        });
    }

    /*public void inicializarComponentes() {

        etNome = findViewById(R.id.etNomeCad1);
        etEmail = findViewById(R.id.etEmailCad2);
        etCPF = findViewById(R.id.etCpfCad3);
        etSenha = findViewById(R.id.etSenhaCad4);
        etProf = findViewById(R.id.etProfCad5);
        btnCadastrar = findViewById(R.id.btnCad1);

    }*/

}