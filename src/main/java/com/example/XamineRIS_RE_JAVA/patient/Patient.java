package com.example.XamineRIS_RE_JAVA.patient;
import java.util.ArrayList;
import java.util.Date;

// patient class that will hold the methods for a patient object
public class Patient {
	private String birthDay;
	private String firstName;
	private String lastName;
	private String middleName;
	private String email;
	private long phoneNumber;
	private Boolean asthmaAllergy, xraydyeAllergy, mriAllergy, latexAllergy;
	private String notes;
	private Object orders;

    public Patient(String birthDay, String firstName, String lastName, String middleName, String email, long phoneNumber, Boolean asthmaAllergy, Boolean xraydyeAllergy, Boolean mriAllergy, Boolean latexAllergy, String notes, Object orders) {
        this.birthDay = birthDay;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.asthmaAllergy = asthmaAllergy;
        this.xraydyeAllergy = xraydyeAllergy;
        this.mriAllergy = mriAllergy;
        this.latexAllergy = latexAllergy;
        this.notes = notes;
        this.orders = orders;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getAsthmaAllergy() {
        return asthmaAllergy;
    }

    public void setAsthmaAllergy(Boolean asthmaAllergy) {
        this.asthmaAllergy = asthmaAllergy;
    }

    public Boolean getXraydyeAllergy() {
        return xraydyeAllergy;
    }

    public void setXraydyeAllergy(Boolean xraydyeAllergy) {
        this.xraydyeAllergy = xraydyeAllergy;
    }

    public Boolean getMriAllergy() {
        return mriAllergy;
    }

    public void setMriAllergy(Boolean mriAllergy) {
        this.mriAllergy = mriAllergy;
    }

    public Boolean getLatexAllergy() {
        return latexAllergy;
    }

    public void setLatexAllergy(Boolean latexAllergy) {
        this.latexAllergy = latexAllergy;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getName() {
        return firstName +" "+lastName;
    }

    public void setOrders(Object orders) {
        this.orders = orders;
    }

    public Object getOrders() {
        return orders;
    }

    public String toString() {
        return this.firstName + " " + this.lastName + " DOB: " + this.birthDay + " " + phoneNumber;
    }
}
