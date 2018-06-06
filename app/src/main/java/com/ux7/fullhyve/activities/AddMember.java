package com.ux7.fullhyve.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.squareup.picasso.Picasso;
import com.ux7.fullhyve.R;
import com.ux7.fullhyve.adapters.AddMemberRecyclerViewAdapter;
import com.ux7.fullhyve.data.ListMember;
import com.ux7.fullhyve.util.ActionBarTarget;
import com.ux7.fullhyve.util.CircleTransform;

import java.util.ArrayList;

public class AddMember extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);

        buildActionBar();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.add_member_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<ListMember> users = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            users.add(new ListMember());
        }

        recyclerView.setAdapter(new AddMemberRecyclerViewAdapter(users));


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {

            case android.R.id.home:
                finish();
                return false;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_view, menu);
        return true;
    }


    public void buildActionBar() {
        ActionBar actionBar = getSupportActionBar();
        setTitle("Add Users");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }
}
