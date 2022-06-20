package com.example.calculus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView displayTask;
    private TextView displayResult;
    private Button buttonTheme;
    private String task = "";
    private String result = "";
    private final String[] ACTIONS = new String[] {"+", "-", "x", "÷"};


    private static final String PARCELABLE = "PARCELABLE";
    private static final String MY_PREFERENCES = "NightModePref";
    private static final String KEY_ISNIGHTMODE = "IsNightMode";
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        displayTask = findViewById(R.id.display);
        displayResult = findViewById(R.id.result);



        buttonTheme = findViewById(R.id.b_theme);
        buttonTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThemeChooser.class);
                startActivity(intent);
            }
        });

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

        findViewById(R.id.b_zero).setOnClickListener(view -> {
            task = task + "0";
            displayTask.setText(task);
        });

        findViewById(R.id.b_dot).setOnClickListener(view -> {
            if (!hasActionSign(task)){
                if (task.isEmpty()){
                    task = task + "0.";
                } else if (task.contains(".")){
                    Toast.makeText(getApplicationContext(), R.string.one_dot, Toast.LENGTH_SHORT).show();
                } else {
                    task = task + ".";
                }
            } else if ((task.charAt(task.length() - 1) == '+') ||
                    (task.charAt(task.length() - 1) == '-') ||
                    (task.charAt(task.length() - 1) == 'x') ||
                    (task.charAt(task.length() - 1) == '÷')) {
                task = task + "0.";
            } else {
                task = task + ".";
            }
            displayTask.setText(task);
        });

        findViewById(R.id.b_addition).setOnClickListener(view -> {
            if (task.isEmpty()) {
                task = "0+";
            } else if((task.charAt(task.length() - 1) == '÷') ||
                    (task.charAt(task.length() - 1) == '-') ||
                    (task.charAt(task.length() - 1) == 'x') ||
                    (task.charAt(task.length() - 1) == '.')){
                task = task.substring(0, task.length() - 1) + "+";
            } else if (hasActionSign(task)){
                Toast.makeText(getApplicationContext(), R.string.one_action, Toast.LENGTH_SHORT).show();
            } else {
                task = task + "+";
            }
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
            } else if (hasActionSign(task)){
                Toast.makeText(getApplicationContext(), R.string.one_action, Toast.LENGTH_SHORT).show();
            }else {
                task = task + "-";
            }
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
            } else if (hasActionSign(task)){
                Toast.makeText(getApplicationContext(), R.string.one_action, Toast.LENGTH_SHORT).show();
            }else {
                task = task + "x";
            }
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
            } else if (hasActionSign(task)){
                Toast.makeText(getApplicationContext(), R.string.one_action, Toast.LENGTH_SHORT).show();
            }else {
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
            if (!hasActionSign(task)) {
                Toast.makeText(getApplicationContext(), R.string.no_problem, Toast.LENGTH_SHORT).show();
            } else {
                Calculus cl = new Calculus(task);
                result = cl.Calculate(task);
                displayResult.setText(result);
            }
            displayResult.setText(result);
        });

        findViewById(R.id.b_percent).setOnClickListener(view -> {
            Calculus cl = new Calculus(task);
            task = cl.Percent(task);
            displayTask.setText(task);
            displayTask.setText(task);
        });
    }

    boolean hasActionSign(String task){
        return (task.contains("+") || task.contains("-") || task.contains("x") || task.contains("÷"));
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