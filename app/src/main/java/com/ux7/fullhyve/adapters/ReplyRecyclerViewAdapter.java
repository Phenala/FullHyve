package com.ux7.fullhyve.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.ux7.fullhyve.R;
import com.ux7.fullhyve.activities.AnnouncementView;
import com.ux7.fullhyve.data.ListAnnouncement;
import com.ux7.fullhyve.data.ListAnnouncement;
import com.ux7.fullhyve.util.ActionBarTarget;
import com.ux7.fullhyve.util.CircleTransform;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hp on 4/17/2018.
 */

public class AnnouncementRecyclerViewAdapter extends RecyclerView.Adapter<AnnouncementRecyclerViewAdapter.ViewHolder> {

    public List<ListAnnouncement> mAnnouncements;

    public AnnouncementRecyclerViewAdapter(List<ListAnnouncement> messageList) {
        mAnnouncements = messageList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_announcement, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mAnnouncement = mAnnouncements.get(position);
        holder.mAnnouncementContent.setText(holder.mAnnouncement.message);
        holder.mAnnouncementTime.setText(holder.mAnnouncement.sentTime);
        holder.mAnnouncerName.setText(holder.mAnnouncement.senderName);
        Picasso.with(holder.mView.getContext())
                .load(holder.mAnnouncement.senderImage)
                .transform(new CircleTransform())
                .into(holder.mAnnouncerImage);

        if (holder.mAnnouncement.sent) {
            ((ImageView)holder.mView.findViewById(R.id.callout_spike_receive)).setVisibility(View.GONE);
            ((ImageView)holder.mView.findViewById(R.id.announcer_image)).setVisibility(View.GONE);
            ((ImageView)holder.mView.findViewById(R.id.callout_spike_send)).setVisibility(View.VISIBLE);
            ((View)holder.mView.findViewById(R.id.callout_body)).setBackgroundColor(holder.mView.getResources().getColor(R.color.messageSent));
            holder.mAnnouncementContent.setTextColor(holder.mView.getResources().getColor(R.color.textLight));
            holder.mView.findViewById(R.id.messages_loading_spinner).setVisibility(View.GONE);
        }
        holder.mAnnouncementTrigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.mView.getContext(), AnnouncementView.class);
                intent.putExtra("announcement", (Serializable) holder.mAnnouncement);
                holder.mView.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mAnnouncements.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final ImageView mAnnouncerImage;
        public final TextView mAnnouncementContent;
        public final TextView mAnnouncementTime;
        public final TextView mAnnouncerName;
        public final LinearLayout mAnnouncementTrigger;

        public ListAnnouncement mAnnouncement;


        public ViewHolder(View view) {

            super(view);
            mView = view;
            mAnnouncementContent = (TextView)view.findViewById(R.id.announcement_content);
            mAnnouncementTime = (TextView)view.findViewById(R.id.announcement_time);
            mAnnouncerImage = (ImageView)view.findViewById(R.id.announcer_image);
            mAnnouncerName = (TextView)view.findViewById(R.id.announcer_name);
            mAnnouncementTrigger = (LinearLayout)view.findViewById(R.id.callout_body);


        }

    }

}
