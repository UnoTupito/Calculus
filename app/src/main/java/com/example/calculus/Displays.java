package com.example.calculus;

import android.os.Parcel;
import android.os.Parcelable;

public class Displays implements Parcelable {

    private String taskDisplay;
    private String resultDisplay;

    public Displays(String taskDisplay, String resultDisplay) {
        this.taskDisplay = taskDisplay;
        this.resultDisplay = resultDisplay;
    }

    protected Displays(Parcel in) {
        taskDisplay = in.readString();
        resultDisplay = in.readString();
    }

    public static final Creator<Displays> CREATOR = new Creator<Displays>() {
        @Override
        public Displays createFromParcel(Parcel in) {
            return new Displays(in);
        }

        @Override
        public Displays[] newArray(int size) {
            return new Displays[size];
        }
    };

    public String getTaskDisplay() {
        return taskDisplay;
    }

    public void setTaskDisplay(String taskDisplay) {
        this.taskDisplay = taskDisplay;
    }

    public String getResultDisplay() {
        return resultDisplay;
    }

    public void setResultDisplay(String resultDisplay) {
        this.resultDisplay = resultDisplay;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(taskDisplay);
        parcel.writeString(resultDisplay);
    }
}
