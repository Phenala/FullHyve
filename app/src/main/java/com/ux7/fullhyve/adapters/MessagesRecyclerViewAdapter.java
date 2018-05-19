package com.ux7.fullhyve.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ux7.fullhyve.R;
import com.ux7.fullhyve.data.ListMessage;

import java.util.List;

/**
 * Created by hp on 4/17/2018.
 */

public class MessagesRecyclerViewAdapter extends RecyclerView.Adapter<MessagesRecyclerViewAdapter.ViewHolder> {

    public List<ListMessage> mMessages;

    public MessagesRecyclerViewAdapter(List<ListMessage> messageList) {
        mMessages = messageList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_message, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mMessage = mMessages.get(position);
        holder.mMessageContent.setText(mMessages.get(position).message);
        holder.mMessageTime.setText(mMessages.get(position).time);

        if (mMessages.get(position).sent) {
            ((ImageView)holder.mView.findViewById(R.id.callout_spike_receive)).setVisibility(View.GONE);
            ((ImageView)holder.mView.findViewById(R.id.callout_spike_send)).setVisibility(View.VISIBLE);
            ((View)holder.mView.findViewById(R.id.callout_body)).setBackgroundColor(holder.mView.getResources().getColor(R.color.messageSent));
            holder.mMessageContent.setTextColor(holder.mView.getResources().getColor(R.color.textLight));
            holder.mView.findViewById(R.id.messages_loading_spinner).setVisibility(View.GONE);
        }

        if (mMessages.get(position).spinner) {
            holder.mView.findViewById(R.id.message_layout).setVisibility(View.GONE);
            holder.mView.findViewById(R.id.messages_loading_spinner).setVisibility(View.VISIBLE);
        }

        holder.mView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final TextView mMessageContent;
        public final TextView mMessageTime;

        public ListMessage mMessage;


        public ViewHolder(View view) {

            super(view);
            mView = view;
            mMessageContent = (TextView)view.findViewById(R.id.message_content);
            mMessageTime = (TextView)view.findViewById(R.id.message_time);


        }

    }

}
