package com.example.XamineRIS_RE_JAVA.receptionist;

import com.example.XamineRIS_RE_JAVA.AppointmentSystem;

import java.util.ArrayList;
import java.util.Date;

public class Receptionist {

    private Date birthDay;
    private String name;
    private String phoneNumber;
    private AppointmentSystem appointmentSystem;

    public Receptionist(Date birthDay, String name, String phoneNumber, AppointmentSystem appointmentSystem) {
        this.birthDay = birthDay;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.appointmentSystem = appointmentSystem;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AppointmentSystem getAppointmentSystem() {
        return appointmentSystem;
    }

    public void setAppointmentSystem(AppointmentSystem appointmentSystem) {
        this.appointmentSystem = appointmentSystem;
    }

    
    @Override
    public String toString() {
        return "Receptionist{" + "birthDay=" + birthDay + ", name=" + name + ", phoneNumber=" + phoneNumber + '}';
    }
}
