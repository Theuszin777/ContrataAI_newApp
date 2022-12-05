package magnago.matheus.contrata_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RatingBar;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import magnago.matheus.contrata_app.fragment.HomeFragment;
import magnago.matheus.contrata_app.fragment.MessagesFragment;
import magnago.matheus.contrata_app.fragment.NotifyFragment;
import magnago.matheus.contrata_app.fragment.ProfileFragment;
import magnago.matheus.contrata_app.fragment.SearchFragment;


public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar
        Toolbar tbar = findViewById(R.id.tbarHome);
        tbar.setTitle("CONTRATAÍ");
        setSupportActionBar(tbar);

        // Configurar bottom nav view
        ConfigBottomNavigationView();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Inicia na HOME.
        fragmentTransaction.replace(R.id.viewPager, new HomeFragment()).commit();

        //RatingBar
        /*ratingBar.findViewById(R.id.ratingBarProfile);
        ratingBar.setRating(2.5f);
        ratingBar.setStepSize(.5f);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Cria a navegação do bottomNav
    private void ConfigBottomNavigationView() {
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottomNav);
        // config inicial Bottom Nav
        //bottomNavigationViewEx.enableAnimation(true);
        //bottomNavigationViewEx.enableItemShiftingMode(false);
        //bottomNavigationViewEx.enableShiftingMode(false);
        //bottomNavigationViewEx.setTextVisibility(false);

        // Navegação
        habilitarNavegacao(bottomNavigationViewEx);
    }

    // Método para eventos click na Bottom Navigation.
    private void habilitarNavegacao(BottomNavigationViewEx viewEx) {
        viewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.home:
                        fragmentTransaction.replace(R.id.viewPager, new HomeFragment()).commit();
                        return true;
                    case R.id.search:
                        fragmentTransaction.replace(R.id.viewPager, new SearchFragment()).commit();
                        return true;
                    case R.id.notify:
                        fragmentTransaction.replace(R.id.viewPager, new NotifyFragment()).commit();
                        return true;
                    case R.id.messages:
                        fragmentTransaction.replace(R.id.viewPager, new MessagesFragment()).commit();
                        return true;
                    case R.id.profile:
                        fragmentTransaction.replace(R.id.viewPager, new ProfileFragment()).commit();
                        return true;
                }
                return false;
            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_deslog:
                //deslogarUsuario();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;

            case R.id.menu_settings:
                //Configurações;
                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /*// Função para deslogar um usuário -> aguardando PHP
    private void deslogarUsuario() {
        try {

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}