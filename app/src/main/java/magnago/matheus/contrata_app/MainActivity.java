package magnago.matheus.contrata_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;

import magnago.matheus.contrata_app.databinding.ActivityMainBinding;
import magnago.matheus.contrata_app.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private NavHostFragment navHostFragment;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        initNavigation();

    }

    private void initNavigation() {
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController);
    }

    public void navigateToHomeActivity() {

       Intent i = new Intent(MainActivity.this, ChatActivity.class);
       startActivity(i);

    }
}