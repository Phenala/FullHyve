package com.ux7.fullhyve.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ux7.fullhyve.R;
import com.ux7.fullhyve.adapters.MessagesRecyclerViewAdapter;
import com.ux7.fullhyve.data.ListMessage;

import java.util.ArrayList;
import java.util.Random;

public class ContactView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_view);

        ActionBar actionBar = getSupportActionBar();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.messages_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setTitle(getIntent().getStringExtra("name"));
        actionBar.setLogo(R.drawable.ic_chat_icon);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);

        ArrayList<ListMessage> nlist = new ArrayList<>();
        //nlist.add(ListMessage.getSpinnerValue());
        for (int i = 0; i < 20; i++) {
            ListMessage l = new ListMessage();
            l.sent = Math.random() > 0.5;
            nlist.add(l);
        }

        recyclerView.setAdapter(new MessagesRecyclerViewAdapter(nlist));
        Toast.makeText(this, String.valueOf(recyclerView.getScrollY()), Toast.LENGTH_SHORT).show();
        recyclerView.getLayoutManager().scrollToPosition(recyclerView.getAdapter().getItemCount() - 1);


    }
}
