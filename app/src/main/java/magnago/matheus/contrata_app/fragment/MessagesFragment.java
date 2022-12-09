package magnago.matheus.contrata_app.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import magnago.matheus.contrata_app.ChatActivity;
import magnago.matheus.contrata_app.R;

public class MessagesFragment extends Fragment {

    ImageButton imageButton;
    //private RecyclerView rcviewListMensagens;
    //private MensagensAdapter adapter;
    /*Usuario*/
    //private ArrayList<> listaMensagens = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_messages, container, false);

        imageButton = view.findViewById(R.id.ibMens1);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getActivity(), ChatActivity.class);
                startActivity(i1);
            }
        });
        //rcviewListMensagens = view.findViewById(R.id.rcViewListaMensagens);

        // Colocar lista de contatos/mensagens.
        //adapter = new MensagensAdapter(listaMensagens, getActivity());

        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //rcviewListMensagens.setLayoutManager(layoutManager);
        //rcviewListMensagens.setHasFixedSize(true);
        //rcviewListMensagens.setAdapter(adapter);

        return view;
    }
}