package com.example.calculus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView displayTask;
    private TextView displayResult;
    private String task = "";
    private String result = "";
    private static final String PARCELABLE = "PARCELABLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayTask = findViewById(R.id.display);
        displayResult = findViewById(R.id.result);

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
            if (task.isEmpty()) {
                task = "0x";
            } else if ((task.charAt(task.length() - 1) == '+') ||
                    (task.charAt(task.length() - 1) == '-') ||
                    (task.charAt(task.length() - 1) == '÷') ||
                    (task.charAt(task.length() - 1) == '.')) {
                task = task.substring(0, task.length() - 1) + "x";
            } else {
                task = task + "*";
            }
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
            if (task.isEmpty()) {
                task = "0-";
            } else if ((task.charAt(task.length() - 1) == '+') ||
                    (task.charAt(task.length() - 1) == 'x') ||
                    (task.charAt(task.length() - 1) == '÷') ||
                    (task.charAt(task.length() - 1) == '.')) {
                task = task.substring(0, task.length() - 1) + "-";
            } else {
                task = task + "-";
            }
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
            if (task.isEmpty()) {
                task = "0+";
            } else if ((task.charAt(task.length() - 1) == '÷') ||
                    (task.charAt(task.length() - 1) == '-') ||
                    (task.charAt(task.length() - 1) == 'x') ||
                    (task.charAt(task.length() - 1) == '.')) {
                task = task.substring(0, task.length() - 1) + "+";
            } else {
                task = task + "+";
            }
            displayTask.setText(task);
        });

        findViewById(R.id.b_dot).setOnClickListener(view -> {
            if (task.isEmpty() || (task.charAt(task.length() - 1) == '+') ||
                    (task.charAt(task.length() - 1) == '-') ||
                    (task.charAt(task.length() - 1) == 'x') ||
                    (task.charAt(task.length() - 1) == '÷')) {
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
            if (task.isEmpty()) {
                task = "0÷";
            } else if ((task.charAt(task.length() - 1) == '+') ||
                    (task.charAt(task.length() - 1) == '-') ||
                    (task.charAt(task.length() - 1) == 'x') ||
                    (task.charAt(task.length() - 1) == '.')) {
                task = task.substring(0, task.length() - 1) + "÷";
            } else {
                task = task + "÷";
            }
            displayTask.setText(task);
        });

        findViewById(R.id.b_clear).setOnClickListener(view -> {
            task = "";
            result = "";
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
            Calculus cl = new Calculus(task);
            Toast.makeText(getApplicationContext(), "Calculating...", Toast.LENGTH_SHORT).show();
            displayResult.setText(result);
        });

        findViewById(R.id.b_percent).setOnClickListener(view -> {
            //TODO;
            displayTask.setText(task);
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        Displays display = new Displays(task, result);
        instanceState.putParcelable(PARCELABLE, display);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        Displays display = instanceState.getParcelable(PARCELABLE);
        task = display.getTaskDisplay();
        result = display.getResultDisplay();
        displayTask.setText(task);
        displayResult.setText(result);

    }

}