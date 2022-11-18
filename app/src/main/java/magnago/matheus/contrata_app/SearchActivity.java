package magnago.matheus.contrata_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import magnago.matheus.contrata_app.fragments.HomeFragment;

public class SearchActivity extends AppCompatActivity {

    ImageButton imbSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        imbSearch.findViewById(R.id.imbtnSF);

        imbSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SearchActivity.this, HomeFragment.class);
                startActivity(i);
            }
        });
    }
}