package magnago.matheus.contrata_app.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import magnago.matheus.contrata_app.ChatActivity;
import magnago.matheus.contrata_app.R;
import magnago.matheus.contrata_app.adapter.MensagensAdapter;

public class MessagesFragment extends Fragment {

    private Button irParaChat;
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

        irParaChat = view.findViewById(R.id.btnMsg1);
        irParaChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ChatActivity.class);
                startActivity(i);
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