package com.danroy.todolistredo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button addTaskBtn,timePickerBtn;
    private EditText taskNameInput;
    private ListView taskListView;
    private ArrayList<Task> taskArray = new ArrayList<>();
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addTaskBtn = findViewById(R.id.addTaskBtn);
        timePickerBtn = findViewById(R.id.timePickerBtn);
        taskNameInput = findViewById(R.id.taskNameInput);
        taskListView = findViewById(R.id.taskList);

        timePickerBtn.setOnClickListener(new BtnClicks());
        addTaskBtn.setOnClickListener(new BtnClicks());


        taskAdapter = new TaskAdapter(MainActivity.this,taskArray);
        taskListView.setAdapter(taskAdapter);
    }

    private class BtnClicks implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.timePickerBtn:
                    DialogFragment timePicker = new TimePickerFragment();
                    timePicker.show(getSupportFragmentManager(),"Time Picker");
                    break;
                case R.id.addTaskBtn:
                        String taskName = taskNameInput.getText().toString();
                        String taskStartTime = TimePickerFragment.getTimeSet();
                        Task newTask= new Task(taskName,taskStartTime);
                        taskArray.add(newTask);
                        taskAdapter.notifyDataSetChanged();
                    break;
                default:
                    Toast.makeText(MainActivity.this,"Invalid",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}