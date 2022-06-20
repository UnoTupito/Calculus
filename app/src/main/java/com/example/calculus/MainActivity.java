package com.example.calculus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView displayTask;
    private TextView displayResult;
    private SwitchCompat nightSwitch;
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
        sharedPreferences = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);

        nightSwitch = findViewById(R.id.switchNightMode);

        NightModeIsActivated();

        displayTask = findViewById(R.id.display);
        displayResult = findViewById(R.id.result);

        nightSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    saveNightModeState(true);
                    recreate();
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    saveNightModeState(false);
                    recreate();
                }
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
                    Toast.makeText(getApplicationContext(), "Your number already has a dot", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getApplicationContext(), "Only one action a time, sorry", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getApplicationContext(), "Only one action a time, sorry", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getApplicationContext(), "Only one action a time, sorry", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getApplicationContext(), "Only one action a time, sorry", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getApplicationContext(), "There is no problem", Toast.LENGTH_SHORT).show();
            } else {
                Calculus cl = new Calculus(task);
                result = cl.Calculate(task);
                displayResult.setText(result);
                Toast.makeText(getApplicationContext(), "Calculating...", Toast.LENGTH_SHORT).show();
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

    private void saveNightModeState(boolean nightMode) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_ISNIGHTMODE, nightMode);
        editor.apply();
    }
    public void NightModeIsActivated(){
        if(sharedPreferences.getBoolean(KEY_ISNIGHTMODE, false)){
            nightSwitch.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            nightSwitch.setChecked(false);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
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