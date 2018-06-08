package com.ux7.fullhyve.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.ux7.fullhyve.R;
import com.ux7.fullhyve.ui.activities.TaskView;
import com.ux7.fullhyve.ui.data.ListTask;
import com.ux7.fullhyve.ui.data.TaskDetail;
import com.ux7.fullhyve.ui.interfaces.OnHomeInteractionListener;
import com.ux7.fullhyve.ui.util.CircleTransform;
import com.ux7.fullhyve.ui.util.Util;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {} and makes a call to the
 * specified {@link OnHomeInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class TaskRecyclerViewAdapter extends RecyclerView.Adapter<TaskRecyclerViewAdapter.ViewHolder> {

    private final List<ListTask> mTasks;

    public TaskRecyclerViewAdapter(List<ListTask> items) {
        mTasks = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mTask = mTasks.get(position);
        holder.mTaskNumberView.setText("Task " + holder.mTask.number);
        holder.mTaskNameView.setText(holder.mTask.name);
        holder.mTaskStatusView.setImageResource(Util.getTaskStatusIcon(holder.mTask.status));
        Picasso.with(holder.itemView.getContext())
                .load(holder.mTask.assigneeImage)
                .transform(new CircleTransform())
                .into(holder.mTaskAssigneeView);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTask(holder.mView.getContext(), holder.mTask);
                notifyItemChanged(position);
            }
        });
    }

    public void goToTask(Context context, ListTask taskSet) {

        Intent intent = new Intent(context, TaskView.class);
        intent.putExtra("task", new TaskDetail());
        context.startActivity(intent);

    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTaskNumberView;
        public final TextView mTaskNameView;
        public final ImageView mTaskAssigneeView;
        public final ImageView mTaskStatusView;
        public ListTask mTask;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTaskAssigneeView = (ImageView) view.findViewById(R.id.task_assignee_picture);
            mTaskStatusView = (ImageView) view.findViewById(R.id.task_status);
            mTaskNameView = (TextView)view.findViewById(R.id.task_name);
            mTaskNumberView = (TextView)view.findViewById(R.id.task_number);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}