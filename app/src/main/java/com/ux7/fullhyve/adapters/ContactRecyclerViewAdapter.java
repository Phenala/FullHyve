package com.ux7.fullhyve.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ux7.fullhyve.R;
import com.ux7.fullhyve.activities.ContactView;
import com.ux7.fullhyve.data.ListContact;
import com.ux7.fullhyve.interfaces.OnHomeInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a DummyItem and makes a call to the
 * specified .
 * TODO: Replace the implementation with code for your data type.
 */
public class ContactRecyclerViewAdapter extends RecyclerView.Adapter<ContactRecyclerViewAdapter.ViewHolder> {

    private final List<ListContact> mContacts;
    private final OnHomeInteractionListener mListener;

    public ContactRecyclerViewAdapter(List<ListContact> items, OnHomeInteractionListener listener) {
        mContacts = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mContact = mContacts.get(position);
        holder.mName.setText(mContacts.get(position).name);
        holder.mMessage.setText(mContacts.get(position).lastMessage);
        holder.mMessageCount.setText(String.valueOf(mContacts.get(position).newMessages));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    Intent intent = new Intent(mListener.getHomeContext(), ContactView.class);
                    intent.putExtra("name", "Eliza Woods");
                    intent.putExtra("image", "lol");
                    mListener.onStartNewActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mPicture;
        public final TextView mName;
        public final TextView mMessage;
        public final TextView mMessageCount;
        public ListContact mContact;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mPicture = (ImageView) view.findViewById(R.id.profilePicture);
            mName = (TextView) view.findViewById(R.id.profileName);
            mMessage = (TextView) view.findViewById(R.id.message) ;
            mMessageCount = (TextView) view.findViewById(R.id.newMessageCount);
        }

        @Override
        public String toString() {
            return super.toString() + " ";
        }
    }
}
