package magnago.matheus.contrata_app.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import magnago.matheus.contrata_app.R;


public class SearchFragment extends Fragment {


    private SearchView svSearchh;
    private RecyclerView rvSearchh;

    public SearchFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        svSearchh = view.findViewById(R.id.svSearch);
        rvSearchh = view.findViewById(R.id.rvSearch);

        svSearchh.setQueryHint("O que você precisa?");
        svSearchh.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Log.i("onQueryTextSubmit", "texto digitado: " + query);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                String txtDigitado = newText.toUpperCase();
                searchUsuarios(txtDigitado);
                //Log.d("onQueryTextChange", "texto digitado: " + newText);
                return true;
            }
        });
        return view;
    }

    private void searchUsuarios(String string) {

    }


}