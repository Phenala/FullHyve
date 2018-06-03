package com.ux7.fullhyve.activities;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.ux7.fullhyve.R;
import com.ux7.fullhyve.adapters.MessagesRecyclerViewAdapter;
import com.ux7.fullhyve.data.ListMessage;
import com.ux7.fullhyve.util.CircleTransform;

import java.util.ArrayList;

public class ContactView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_view);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.messages_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        buildActionBar();

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

    public void buildActionBar() {
        final ActionBar actionBar = getSupportActionBar();
        setTitle("   " + getIntent().getStringExtra("name"));
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        Picasso.with(this)
                .load("http://0.gravatar.com/avatar/c77b7988df1396d40ed4a62be4e55565?s=64&d=mm&r=g")
                .transform(new CircleTransform())
                .into(new Target()
                {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from)
                    {
                        Drawable d = new BitmapDrawable(getResources(), bitmap);
                        actionBar.setIcon(d);
                        actionBar.setDisplayShowHomeEnabled(true);
                        actionBar.setDisplayHomeAsUpEnabled(true);
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable)
                    {
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable)
                    {
                    }
                });
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
