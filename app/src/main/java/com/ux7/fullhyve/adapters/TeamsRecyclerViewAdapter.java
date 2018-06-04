package com.ux7.fullhyve.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ux7.fullhyve.R;
import com.ux7.fullhyve.activities.TeamView;
import com.ux7.fullhyve.data.ListTeam;
import com.ux7.fullhyve.interfaces.OnHomeInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {} and makes a call to the
 * specified {@link OnHomeInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class TeamsRecyclerViewAdapter extends RecyclerView.Adapter<TeamsRecyclerViewAdapter.ViewHolder> {

    private final List<ListTeam> mTeams;
    private final OnHomeInteractionListener mListener;

    public TeamsRecyclerViewAdapter(List<ListTeam> items, OnHomeInteractionListener listener) {
        mTeams = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_team, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mTeam = mTeams.get(position);
        holder.mNameView.setText(mTeams.get(position).name);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    goToTeam(holder.mView.getContext(), holder.mTeam);
                    mListener.onTeamListFragmentInteraction(holder.mTeam);
                    notifyItemChanged(position);
                }
            }
        });
    }

    public void goToTeam(Context context, ListTeam team) {

        Intent intent = new Intent(context, TeamView.class);
        intent.putExtra("name", team.name);
        intent.putExtra("image", team.image);
        context.startActivity(intent);

    }

    @Override
    public int getItemCount() {
        return mTeams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mPicture;
        public final TextView mNameView;
        public ListTeam mTeam;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mPicture = (ImageView) view.findViewById(R.id.teamPicture);
            mNameView = (TextView) view.findViewById(R.id.teamName);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
