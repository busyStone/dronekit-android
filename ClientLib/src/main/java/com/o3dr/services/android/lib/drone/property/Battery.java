package com.o3dr.services.android.lib.drone.property;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fhuya on 10/28/14.
 */
public class Battery implements DroneAttribute {

    private double batteryVoltage;
    private Double batteryRemain;
    private Double batteryCurrent;
    private Double batteryDischarge;
    private Double batteryTemperature;

    public Battery(){}

    public Battery(double batteryVoltage, Double batteryRemain, Double batteryCurrent,
                   Double batteryDischarge,
                   Double batteryTemperature) {
        this.batteryVoltage = batteryVoltage;
        this.batteryRemain = batteryRemain;
        this.batteryCurrent = batteryCurrent;
        this.batteryDischarge = batteryDischarge;
        this.batteryTemperature = batteryTemperature;
    }

    public void setBatteryVoltage(double batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    public void setBatteryRemain(Double batteryRemain) {
        this.batteryRemain = batteryRemain;
    }

    public void setBatteryCurrent(Double batteryCurrent) {
        this.batteryCurrent = batteryCurrent;
    }

    public void setBatteryDischarge(Double batteryDischarge) {
        this.batteryDischarge = batteryDischarge;
    }

    public void setBatteryTemperature(Double batteryTemperature){
        this.batteryTemperature = batteryTemperature;
    }

    public double getBatteryVoltage() {
        return batteryVoltage;
    }

    public Double getBatteryRemain() {
        return batteryRemain;
    }

    public Double getBatteryCurrent() {
        return batteryCurrent;
    }

    public Double getBatteryDischarge() {
        return batteryDischarge;
    }

    public Double getBatteryTemperature() {return batteryTemperature; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.batteryVoltage);
        dest.writeValue(this.batteryRemain);
        dest.writeValue(this.batteryCurrent);
        dest.writeValue(this.batteryDischarge);
        dest.writeValue(this.batteryTemperature);
    }

    private Battery(Parcel in) {
        this.batteryVoltage = in.readDouble();
        this.batteryRemain = (Double) in.readValue(Double.class.getClassLoader());
        this.batteryCurrent = (Double) in.readValue(Double.class.getClassLoader());
        this.batteryDischarge = (Double) in.readValue(Double.class.getClassLoader());
        this.batteryTemperature = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Creator<Battery> CREATOR = new Creator<Battery>() {
        public Battery createFromParcel(Parcel source) {
            return new Battery(source);
        }

        public Battery[] newArray(int size) {
            return new Battery[size];
        }
    };
}
