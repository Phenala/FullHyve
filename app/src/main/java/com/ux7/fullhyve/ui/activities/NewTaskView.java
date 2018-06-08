package com.ux7.fullhyve.ui.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import com.ux7.fullhyve.R;

public class NewTaskView extends AppCompatActivity {

    AutoCompleteTextView assigneeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task_view);

        buildActionBar();

    }



    public void buildActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("New Task Set");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }

    @Override
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
}
