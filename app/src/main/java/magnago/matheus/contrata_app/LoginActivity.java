package magnago.matheus.contrata_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class LoginActivity extends AppCompatActivity {

    ImageButton imbLA;
    Button btnLA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        imbLA = findViewById(R.id.imbLF);
        btnLA = findViewById(R.id.btnLF1);

        imbLA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, LpageActivity.class);
                startActivity(i);
            }
        });

        btnLA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i4);
            }
        });
    }


}