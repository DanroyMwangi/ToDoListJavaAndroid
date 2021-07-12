package com.danroy.todolistredo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TaskDetails extends AppCompatActivity {

    TextView taskName,taskStartTime,taskStatus,taskCompleteTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        taskName = findViewById(R.id.detailsTaskName);
        taskStartTime = findViewById(R.id.detailsTaskStartTime);
        taskStatus = findViewById(R.id.detailsTaskProgress);
        taskCompleteTime = findViewById(R.id.detailsTaskCompleteTime);

        taskName.setText(getIntent().getStringExtra("taskName"));
        taskStartTime.setText("Task Start Time: " + getIntent().getStringExtra("taskStartTime"));
        taskStatus.setText("Task Status: " + getIntent().getStringExtra("taskStatus"));
        taskCompleteTime.setText("Task Complete Time: ");
    }
}