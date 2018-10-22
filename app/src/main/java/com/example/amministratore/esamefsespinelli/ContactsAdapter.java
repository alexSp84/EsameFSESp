package com.example.amministratore.esamefsespinelli;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    private ArrayList<Contact> cDataset;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView nameTv, phoneTv;

        public ViewHolder(View itemView) {
            super(itemView);

            nameTv = (TextView) itemView.findViewById(R.id.name_tv);
            phoneTv = (TextView) itemView.findViewById(R.id.phone_tv);
        }
    }

    public ContactsAdapter(ArrayList<Contact> dataset, Context context){
        cDataset = dataset;
        this.context = context;
    }

    public void addContact(Contact contact){
        this.cDataset.add(0, contact);
        notifyItemInserted(0);
    }

    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.row_contact,parent , false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.nameTv.setText(cDataset.get(position).getName());
        holder.phoneTv.setText(cDataset.get(position).getPhoneNumber());

    }

    @Override
    public int getItemCount() {
        return cDataset.size();
    }
}
