package magnago.matheus.contrata_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import magnago.matheus.contrata_app.model.RegisterViewModel;

public class CadastroActivity extends AppCompatActivity {

    ImageButton imbCF;
    Button btnCF, btnCadastrar;
    private EditText etNome, etEmail, etCPF, etSenha, etProf;
    RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        registerViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

        Button btnRegister =  findViewById(R.id.btnCad1);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                etNome = findViewById(R.id.etNomeCad1);
                final String newNome = etNome.getText().toString();
                if (newNome.isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "Nome não preenchido", Toast.LENGTH_LONG).show();
                }

                etEmail =  findViewById(R.id.etEmailCad2);
                final String newEmail = etEmail.getText().toString();
                if(newEmail.isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "Campo de email não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                etCPF = findViewById(R.id.etCpfCad3);
                final String newCpf = etCPF.getText().toString();
                if (newNome.isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "CPF não informado!", Toast.LENGTH_LONG).show();
                }

                etSenha =  findViewById(R.id.etSenhaCad4);
                final String newPassword = etSenha.getText().toString();
                if(newPassword.isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "Campo de senha não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                EditText etNewPasswordCheck =  findViewById(R.id.etSenhaCadConfirm5);
                String newPasswordCheck = etNewPasswordCheck.getText().toString();
                if(newPasswordCheck.isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "Campo de checagem de senha não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                if(!newPassword.equals(newPasswordCheck)) {
                    Toast.makeText(CadastroActivity.this, "Senha não confere", Toast.LENGTH_LONG).show();
                    return;
                }

                etProf = findViewById(R.id.etProfCad5);
                final String newProfissao = etProf.getText().toString();
                if (newNome.isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "Profissão não preenchida", Toast.LENGTH_LONG).show();
                }

                LiveData<Boolean> resultLD = registerViewModel.register(newNome, newEmail, newCpf, newPassword, newProfissao);


                resultLD.observe(CadastroActivity.this, new Observer<Boolean>() {
                    @Override
                    public void onChanged(Boolean aBoolean) {

                        if(aBoolean) {
                            Toast.makeText(CadastroActivity.this, "Novo usuario registrado com sucesso", Toast.LENGTH_LONG).show();
                            finish();
                        }
                        else {
                            Toast.makeText(CadastroActivity.this, "Erro ao registrar novo usuário", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });


        BackLandingPageC1();
        //Cadastrado();

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