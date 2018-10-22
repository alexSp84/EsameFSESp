package com.example.amministratore.esamefsespinelli;

import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class RubricaActivity extends AppCompatActivity {

    private RecyclerView contactRecyclerView;
    private ContactsAdapter contactAdapter;
    private RecyclerView.LayoutManager contactLayoutManager;
    private FloatingActionButton addContactBtn;

    private ArrayList<Contact> cDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rubrica);

        contactRecyclerView = findViewById(R.id.my_recycler_view);
        addContactBtn = (FloatingActionButton) findViewById(R.id.action_btn);

        contactRecyclerView.setHasFixedSize(true);
        contactLayoutManager = new LinearLayoutManager(this);
        contactRecyclerView.setLayoutManager(contactLayoutManager);

        cDataset = new ArrayList<>();
        contactAdapter = new ContactsAdapter(cDataset, this);

        contactRecyclerView.setAdapter(contactAdapter);

        addContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });

    }

    private void showAlertDialog() {

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        View dialogView = (View) LayoutInflater.from(this).inflate(R.layout.dialog_contact, null);
        alertBuilder.setView(dialogView);
        alertBuilder.setTitle(R.string.dialog_contact_title);

        final EditText nameEdTxt = dialogView.findViewById(R.id.name_ed_txt);
        final EditText phoneEdTxt = dialogView.findViewById(R.id.phone_ed_txt);

        alertBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = nameEdTxt.getText().toString();
                String phone = phoneEdTxt.getText().toString();

                if(name.length() != 0 && phone.length() != 0) {
                    Contact contact = new Contact(name, phone);
                    contactAdapter.addContact(contact);
                }

            }
        });

        alertBuilder.setNegativeButton(R.string.annulla, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertBuilder.show();

    }

}
