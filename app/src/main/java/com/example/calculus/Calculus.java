package com.example.calculus;

import android.widget.Toast;

public class Calculus {
    private String task;
    private final String[] ACTIONS = new String[]{"+", "-", "x", "÷"};
    private String action;
    private Double number1;
    private Double number2;
    private Double count;

    public Calculus(String task) {
        this.task = task;
    }

    String Calculate(String task) {
        for (String s : ACTIONS) {
            if (task.contains(s)) {
                action = s;
                break;
            }
        }
        int actionPlace = task.indexOf(action);
        number1 = Double.parseDouble(task.substring(0, actionPlace));
        number2 = Double.parseDouble(task.substring(actionPlace + 1));

        switch (action) {
            case "+":
                count = number1 + number2;
                break;
            case "-":
                count = number1 - number2;
                break;
            case "x":
                count = number1 * number2;
                break;
            case "÷":
                count = number1 / number2;
                break;
        }

        return "=" + Double.toString(count);
    }

    String Percent(String task) {
        String result = "";
        for (String s : ACTIONS) {
            if (task.contains(s)) {
                action = s;
                int actionPlace = task.indexOf(action);
                number1 = Double.parseDouble(task.substring(0, actionPlace));
                number2 = Double.parseDouble(task.substring(actionPlace + 1));

                Double percent = number1 / 100 * number2;
                result = task.substring(0, actionPlace+1) + Double.toString(percent);

                break;
            } else {
                number1 = Double.parseDouble(task);
                count = number1 / 100;
                result = Double.toString(count);
            }
        }
        return result;
    }

}
