package com.ux7.fullhyve.activities;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.ux7.fullhyve.R;
import com.ux7.fullhyve.adapters.MessagesRecyclerViewAdapter;
import com.ux7.fullhyve.data.ListContact;
import com.ux7.fullhyve.data.ListMessage;
import com.ux7.fullhyve.util.ActionBarTarget;
import com.ux7.fullhyve.util.CircleTransform;

import java.util.ArrayList;

public class ContactView extends AppCompatActivity {

    ListContact contact = new ListContact();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_view);

        buildContact();
        buildActionBar();
        buildMessages();


    }

    public void buildContact() {
        contact.name = getIntent().getStringExtra("name");
        contact.image = getIntent().getStringExtra("image");
    }

    public void buildMessages() {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.messages_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<ListMessage> nlist = new ArrayList<>();
        //nlist.add(ListMessage.getSpinnerValue());
        for (int i = 0; i < 20; i++) {
            ListMessage l = new ListMessage();
            l.sent = Math.random() > 0.5;
            nlist.add(l);
        }

        recyclerView.setAdapter(new MessagesRecyclerViewAdapter(nlist));
        recyclerView.getLayoutManager().scrollToPosition(recyclerView.getAdapter().getItemCount() - 1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_view, menu);
        return true;
    }

    public void buildActionBar() {
        final ActionBar actionBar = getSupportActionBar();
        setTitle("   " + contact.name);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        Picasso.with(this)
                .load(contact.image)
                .transform(new CircleTransform())
                .into(new ActionBarTarget(getResources(), actionBar));
    }

    public void sendMessage(View view) {
        String message = ((EditText)findViewById(R.id.messageToSend)).getText().toString();

        //messageSendLogic
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {

            case android.R.id.home:

                goBack();
                return false;

            default:
                return false;

        }
    }

    public void goBack() {
        finish();
    }
}
