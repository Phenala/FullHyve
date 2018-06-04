package com.ux7.fullhyve.interfaces;

import android.content.Context;
import android.content.Intent;

import com.ux7.fullhyve.data.ListContact;
import com.ux7.fullhyve.data.ListProject;
import com.ux7.fullhyve.data.ListTeam;

/**
 * Created by hp on 4/19/2018.
 */


public interface OnHomeInteractionListener {
    // TODO: Update argument type and name
    void onContactListFragmentInteraction(ListContact item);

    void onTeamListFragmentInteraction(ListTeam team);

    void onProjectListFragmentInteraction(ListProject project);

    void onStartNewActivity(Intent intent);

    Context getHomeContext();
}
