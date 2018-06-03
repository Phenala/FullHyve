package com.ux7.fullhyve.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ux7.fullhyve.R;
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
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mTeams.get(position);
        holder.mNameView.setText(mTeams.get(position).name);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onTeamListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTeams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mPicture;
        public final TextView mNameView;
        public ListTeam mItem;

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
