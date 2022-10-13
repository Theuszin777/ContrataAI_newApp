package magnago.matheus.contrata_app;

import android.content.Context;
import android.content.Intent;
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

public class FragmentLogin extends Fragment {



    Button btnLF1;
    EditText etEmailLF, etSenhaLF;
    VoltarFragment voltarFragment;
    String userEmail, Senha;
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

        View view = inflater.inflate(R.layout.login_fragment, container, false);
        etEmailLF = view.findViewById(R.id.etEmailLF);
        etSenhaLF = view.findViewById(R.id.etSenhaLF);

        btnLF1 = view.findViewById(R.id.btnLF1);

        btnLF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userEmail = etEmailLF.getText().toString();
                Senha = etSenhaLF.getText().toString();
                String uEmail, uSenha;
                uEmail = sharedPreferences.getString("userEmail", null);
                uSenha = sharedPreferences.getString("Senha", null);

                if(userEmail.equals(uEmail) && uSenha.equals(Senha)) {
                    Toast.makeText(getContext(), "Entrar", Toast.LENGTH_SHORT).show();
                    //Intent i = new Intent();

                }
                else {
                    Toast.makeText(getContext(), "Usuário ou Senha inválido.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;

    }

    public void setVoltarFragment(VoltarFragment voltarFragment) {
        this.voltarFragment = voltarFragment;
    }

}
