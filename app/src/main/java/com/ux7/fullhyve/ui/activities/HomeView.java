package com.ux7.fullhyve.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.ux7.fullhyve.R;
import com.ux7.fullhyve.ui.data.ListContact;
import com.ux7.fullhyve.ui.data.ListProject;
import com.ux7.fullhyve.ui.data.ListTeam;
import com.ux7.fullhyve.ui.fragments.ContactsListFragment;
import com.ux7.fullhyve.ui.fragments.ProjectsListFragment;
import com.ux7.fullhyve.ui.fragments.TeamsListFragment;
import com.ux7.fullhyve.ui.interfaces.OnHomeInteractionListener;

public class HomeView extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnHomeInteractionListener {

    ContactsListFragment contactsListFragment = new ContactsListFragment();
    TeamsListFragment teamsListFragment = new TeamsListFragment();
    ProjectsListFragment projectsListFragment = new ProjectsListFragment();

    FloatingActionButton fab;
    View.OnClickListener addTeam;
    View.OnClickListener addProject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeFloatingActionButton();
        initializeAdders();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        ImageView userPicture = (ImageView)(((NavigationView)findViewById(R.id.nav_view)).getHeaderView(0).findViewById(R.id.userPicture));
        Picasso.with(this).load(R.mipmap.ic_launcher_round).into(userPicture);

        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contactsListFragment).commit();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void initializeAdders() {
        addTeam = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), NewTeam.class);
                startActivity(intent);
            }
        };
        addProject = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), NewProject.class);
                startActivity(intent);
            }
        };
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Toast.makeText(this, "Navigated", Toast.LENGTH_SHORT).show();

        if (id == R.id.nav_notifications) {
            setTitle("Notifications");
        } else if (id == R.id.nav_chat) {
            setTitle("Chat");
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contactsListFragment).commit();
            fab.hide();
        } else if (id == R.id.nav_teams) {
            setTitle("Teams");
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, teamsListFragment).commit();
            fab.show();
            fab.setOnClickListener(addTeam);
        } else if (id == R.id.nav_projects) {
            setTitle("Projects");
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, projectsListFragment).commit();
            fab.show();
            fab.setOnClickListener(addProject);
        } else if (id == R.id.nav_log_out) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void initializeFloatingActionButton() {

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        fab.hide();
    }

    @Override
    public void onContactListFragmentInteraction(ListContact item) {

    }

    @Override
    public void onTeamListFragmentInteraction(ListTeam team) {

    }

    @Override
    public void onProjectListFragmentInteraction(ListProject project) {

    }

    @Override
    public void onStartNewActivity(Intent intent) {
        startActivity(intent);
    }

    @Override
    public Context getHomeContext() {
        return this;
    }


}