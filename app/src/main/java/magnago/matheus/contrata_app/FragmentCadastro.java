package magnago.matheus.contrata_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentCadastro extends Fragment {

    Button btnCF;
    EditText etNomeCF, etEmailCF, etCpfCF ,etSenhaCF, etProfCF;
    String usrNome, usrEmail, usrCPF, usrSenha, usrProf;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public void onAttach(Context context) {
        sharedPreferences = context.getSharedPreferences("usersFile", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.cadastro_fragment, container, false);
        etNomeCF = view.findViewById(R.id.etNomeCF);
        etEmailCF = view.findViewById(R.id.etEmailCF);
        etCpfCF = view.findViewById(R.id.etCpfCF);
        etSenhaCF = view.findViewById(R.id.etEmailCF);
        etProfCF = view.findViewById(R.id.etProfCF);

        btnCF = view.findViewById(R.id.btnCF);

        btnCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usrNome = etNomeCF.getText().toString();
                usrEmail = etEmailCF.getText().toString();
                usrCPF = etCpfCF.getText().toString();
                usrSenha = etSenhaCF.getText().toString();
                usrProf = etProfCF.getText().toString();

                editor.putString("Nome", usrNome);
                editor.putString("Email", usrEmail);
                editor.putString("CPF", usrCPF);
                editor.putString("Senha", usrSenha);
                editor.putString("Profissão", usrProf);
                editor.apply();
                Toast.makeText(getContext(), "Registrado(a)", Toast.LENGTH_SHORT).show();
            }
        });


        return view;

    }
}
