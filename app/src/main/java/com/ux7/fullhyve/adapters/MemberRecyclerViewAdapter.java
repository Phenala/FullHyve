package com.ux7.fullhyve.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.ux7.fullhyve.R;
import com.ux7.fullhyve.data.ListMember;
import com.ux7.fullhyve.fragments.MemberFragment.OnListFragmentInteractionListener;
import com.ux7.fullhyve.util.CircleTransform;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MemberRecyclerViewAdapter extends RecyclerView.Adapter<MemberRecyclerViewAdapter.ViewHolder> {

    private final List<ListMember> mMembers;
    private final OnListFragmentInteractionListener mListener;

    public MemberRecyclerViewAdapter(List<ListMember> items, OnListFragmentInteractionListener listener) {
        mMembers = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_member, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mMember = mMembers.get(position);
        holder.mMemberNameView.setText(mMembers.get(position).name);
        Picasso.with(holder.itemView.getContext()).load(holder.mMember.image).transform(new CircleTransform()).into(holder.mMemberPictureView);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                   // mListener.onListFragmentInteraction(holder.mMember);
                    notifyItemChanged(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMembers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mMemberPictureView;
        public final TextView mMemberNameView;
        public ListMember mMember;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mMemberPictureView = (ImageView) view.findViewById(R.id.member_picture);
            mMemberNameView = (TextView) view.findViewById(R.id.member_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mMemberNameView.getText() + "'";
        }
    }
}
