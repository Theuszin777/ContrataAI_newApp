package magnago.matheus.contrata_app.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;
import magnago.matheus.contrata_app.R;

public class MensagensAdapter extends RecyclerView.Adapter<MensagensAdapter.MyViewHolder> {

    //Usuario
    /*private List<> mensagens;
    private Context context;

    public MensagensAdapter(List<> listaContatos, Context c) {
        this.mensagens = listaMensagens;
        this.context = c;
    }*/


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemMsg = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_mensagens, parent, false);
        return new MyViewHolder(itemMsg);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        /*Usuario usuario = mensagens.get(position);

        holder.nome.setText(usuario.getNome());
        holder.email.setText(usuario.getEmail();

        if (usuario.getFoto() != null) {
            Uri uri = Uri.parse(usuario.getFoto());
            Glide.with(context).load(uri).into(holder.foto);
        }
        else {
            holder.foto.setImageResource(R.drawable.avatar);
        }*/
    }

    @Override
    public int getItemCount() {
        return 0/*mensagens.size()*/;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CircleImageView foto;
        TextView nome, conversa;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.imvFotoMensagem);
            nome = itemView.findViewById(R.id.tvMsgAdap1);
            conversa = itemView.findViewById(R.id.tvMsgAdap2);

        }
    }

}
