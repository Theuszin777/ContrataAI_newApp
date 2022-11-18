package magnago.matheus.contrata_app.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import magnago.matheus.contrata_app.ChatActivity;
import magnago.matheus.contrata_app.MainActivity;
import magnago.matheus.contrata_app.R;

public class MessagesFragment extends Fragment {

    ImageButton imbMen1;
    ImageButton imbMen2;
    ImageButton imbMen3;
    ImageButton imbMen4;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        imbMen1.findViewById(R.id.imbMen1);
        imbMen2.findViewById(R.id.imbMen2);
        imbMen3.findViewById(R.id.imbMen3);
        imbMen4.findViewById(R.id.imbMen4);

        imbMen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();
                activity.navigateToHomeActivity();
            }
        });

        imbMen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();
                activity.navigateToHomeActivity();
            }
        });

        imbMen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();
                activity.navigateToHomeActivity();
            }
        });

        imbMen4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();
                activity.navigateToHomeActivity();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_messages, container, false);
    }
}