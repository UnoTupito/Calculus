package com.example.calculus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView displayTask;
    private TextView displayResult;
    private String task = "";
    private String result = "";
    private static final String TASK_KEY = "TASK_KEY";
    private static final String RESULT_KEY = "RESULT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayTask = findViewById(R.id.display);
        displayResult = findViewById(R.id.result);

        if (savedInstanceState == null) {
            displayTask.setText("0");
            displayResult.setText("0");

        } else {
            displayTask.setText(savedInstanceState.getString(TASK_KEY));
            displayResult.setText(savedInstanceState.getString(RESULT_KEY));
        }

        findViewById(R.id.b_one).setOnClickListener(view -> {
            task = task + "1";
            displayTask.setText(task);
        });

        findViewById(R.id.b_two).setOnClickListener(view -> {
            task = task + "2";
            displayTask.setText(task);
        });

        findViewById(R.id.b_tree).setOnClickListener(view -> {
            task = task + "3";
            displayTask.setText(task);
        });

        findViewById(R.id.b_multiplication).setOnClickListener(view -> {
            task = task + "*";
            displayTask.setText(task);
        });

        findViewById(R.id.b_four).setOnClickListener(view -> {
            task = task + "4";
            displayTask.setText(task);
        });

        findViewById(R.id.b_five).setOnClickListener(view -> {
            task = task + "5";
            displayTask.setText(task);
        });

        findViewById(R.id.b_six).setOnClickListener(view -> {
            task = task + "6";
            displayTask.setText(task);
        });

        findViewById(R.id.b_subtraction).setOnClickListener(view -> {
            task = task + "-";
            displayTask.setText(task);
        });

        findViewById(R.id.b_seven).setOnClickListener(view -> {
            task = task + "7";
            displayTask.setText(task);
        });

        findViewById(R.id.b_eight).setOnClickListener(view -> {
            task = task + "8";
            displayTask.setText(task);
        });

        findViewById(R.id.b_nine).setOnClickListener(view -> {
            task = task + "9";
            displayTask.setText(task);
        });

        findViewById(R.id.b_addition).setOnClickListener(view -> {
            task = task + "+";
            displayTask.setText(task);
        });

        findViewById(R.id.b_dot).setOnClickListener(view -> {
            if (task.isEmpty() || (task.charAt(task.length()-1) == '+') ||
                    (task.charAt(task.length()-1) == '-') ||
                    (task.charAt(task.length()-1) == 'x') ||
                    (task.charAt(-task.length()-1) == '÷')) {
                task = task + "0.";
            } else {
                task = task + ".";
            }
            displayTask.setText(task);
        });

        findViewById(R.id.b_zero).setOnClickListener(view -> {
            task = task + "0";
            displayTask.setText(task);
        });

        findViewById(R.id.b_division).setOnClickListener(view -> {
            task = task + "÷";
            displayTask.setText(task);
        });

        findViewById(R.id.b_clear).setOnClickListener(view -> {
            task = "";
            result = "0";
            displayTask.setText(task);
            displayResult.setText(result);
        });

        findViewById(R.id.b_backspace).setOnClickListener(view -> {
            if (task.length() == 0) {
                task = "";
            } else {
                task = task.substring(0, task.length() - 1);
            }
            displayTask.setText(task);
        });

        findViewById(R.id.b_equals).setOnClickListener(view -> {
            //TODO
            displayResult.setText(result);
        });

        findViewById(R.id.b_percent).setOnClickListener(view -> {
            //TODO;
            displayTask.setText(task);
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TASK_KEY, task);
        outState.putString(RESULT_KEY, result);

    }
}