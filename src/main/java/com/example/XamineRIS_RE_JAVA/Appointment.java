package com.example.XamineRIS_RE_JAVA;
import com.example.XamineRIS_RE_JAVA.patient.Patient;

import java.util.Date;

// Class that holds the methods for an appointment object
public class Appointment {

    //instantiate objects and variables that are needed
	private Date appointDate;
	private Patient patient;
	private Doctor treatmentDr;
	private String address;		//the place where the doctor see patient
	private String symptom;

    public Appointment() {	
    }

    // appointment constructor using the parameters
    public Appointment(Date appointDate, Patient patient, Doctor treatmentDr, String symptom, String address) {
    	this.appointDate = appointDate;
        this.patient = patient;
        this.treatmentDr = treatmentDr;
        this.symptom = symptom;
        this.address = address;
    }

    // contructor using all parameters except for syptoms
    public Appointment(Date appointDate, Patient patient, Doctor treatmentDr, String address) {
        this.appointDate = appointDate;
        this.patient = patient;
        this.treatmentDr = treatmentDr;
        this.address = address;
    }

    // getters and setters for each object param
    public Date getAppointDate() {
        return appointDate;
    }

    public void setAppointDate(Date appointDate) {
        this.appointDate = appointDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
    	this.patient = patient;
    }

    public Doctor getTreatmentDr() {
        return treatmentDr;
    }

    public void setTreatmentDr(Doctor treatmentDr) {
        this.treatmentDr = treatmentDr;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // method to change the date of the appointment
    Appointment reschedule(Date appointDate, String address) {
    	Appointment app = new Appointment(appointDate, this.patient, this.treatmentDr, this.symptom, address);
    	return app;
    }
}
