package com.danroy.todolistredo;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {
    public TaskAdapter(@NonNull Context context, ArrayList<Task> tasks) {
        super(context, 0, tasks);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Task newTask = getItem(position);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        if(convertView == null){
            convertView = inflater.inflate(R.layout.task_view,parent,false);
        }
        TextView taskName = convertView.findViewById(R.id.taskNameDisplay);
        TextView taskStartTime = convertView.findViewById(R.id.taskStartTimeDisplay);
        TextView taskCompleteTime =convertView.findViewById(R.id.taskCompleteTimeDisplay);
        TextView taskCompletionProgress =convertView.findViewById(R.id.taskCompletionDisplay);

        taskName.setText(newTask.getTaskName());
        taskStartTime.setText("Start Time: " + newTask.getTaskStartTime());
        taskCompleteTime.setText("Complete Time:N/A");
        taskCompletionProgress.setText(newTask.getTaskCompletion());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent taskDetails = new Intent(getContext(),TaskDetails.class);
                taskDetails.putExtra("taskName",newTask.getTaskName());
                taskDetails.putExtra("taskStartTime",newTask.getTaskStartTime());
                taskDetails.putExtra("taskStatus",newTask.getTaskCompletion());
                getContext().startActivity(taskDetails);
            }
        });
        return convertView;
    }
}
