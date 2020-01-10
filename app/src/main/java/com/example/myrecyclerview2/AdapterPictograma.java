package com.example.myrecyclerview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterPictograma extends RecyclerView.Adapter<AdapterPictograma.ViewHolderPictograma> {

    Context context;
    private ArrayList<pictograma> lista_pictogramas;

    public AdapterPictograma(ArrayList<pictograma> lista_pictogramas) {
        this.lista_pictogramas = lista_pictogramas;
    }


    @NonNull
    @Override
    public ViewHolderPictograma onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid, null);
        return new ViewHolderPictograma(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPictograma holder, int position) {

        //pictograma pic = lista_pictogramas.get(position);
        //holder.view_btn_pictograma.setImageResource(pic.getPicto_foto());
        //holder.view_txt_titulo.setText(pic.getPicto_detalle());
        //holder.view_txt_detalle.setText(pic.getPicto_detalle());
        holder.view_btn_pictograma.setImageResource(lista_pictogramas.get(position).getPicto_foto());
        holder.view_txt_titulo.setText(lista_pictogramas.get(position).getPicto_nombre());
        holder.view_txt_detalle.setText(lista_pictogramas.get(position).getPicto_detalle());
    }

    @Override
    public int getItemCount() {
        return lista_pictogramas.size();
    }

    public class ViewHolderPictograma extends RecyclerView.ViewHolder {
        ImageView view_btn_pictograma;
        TextView view_txt_titulo;
        TextView view_txt_detalle;
        LinearLayout li;

        public ViewHolderPictograma(@NonNull View itemView) {
            super(itemView);

            view_btn_pictograma = itemView.findViewById(R.id.img_pictograma);
            view_txt_titulo = itemView.findViewById(R.id.titulo);
            view_txt_detalle = itemView.findViewById(R.id.detalle);
            li = itemView.findViewById(R.id.item);
            li.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((MainActivity) context).ClickEnPictograma(getAdapterPosition());
                }
            });

        }
    }
}
