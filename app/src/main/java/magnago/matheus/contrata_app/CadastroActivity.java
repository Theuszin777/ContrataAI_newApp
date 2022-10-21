package magnago.matheus.contrata_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CadastroActivity extends AppCompatActivity {

    ImageButton imbCF;
    Button btnCF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        imbCF = findViewById(R.id.imbCF);
        btnCF = findViewById(R.id.btnCF);


        imbCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CadastroActivity.this, LpageActivity.class);
                startActivity(i);
            }
        });

        btnCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(CadastroActivity.this, LpageActivity.class);
                startActivity(i2);
            }
        });


    }
}