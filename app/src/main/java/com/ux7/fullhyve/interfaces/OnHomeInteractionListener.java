package com.ux7.fullhyve.interfaces;

import android.content.Context;
import android.content.Intent;

import com.ux7.fullhyve.data.ListContact;

/**
 * Created by hp on 4/19/2018.
 */


public interface OnHomeInteractionListener {
    // TODO: Update argument type and name
    void onListFragmentInteraction(ListContact item);

    void onStartNewActivity(Intent intent);

    Context getHomeContext();
}
