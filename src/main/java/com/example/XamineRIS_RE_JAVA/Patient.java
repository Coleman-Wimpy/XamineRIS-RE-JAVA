package com.example.XamineRIS_RE_JAVA;
import java.util.ArrayList;
import java.util.Date;

// patient class that will hold the methods for a patient object
public class Patient {
	private Date birthDay;
	private String name;
	private String phoneNumber;
	private String SSN;
	private ArrayList<Appointment> appoints;
	
	private String otherInfos;	// the infos that the doctor can add for the patient

    public Patient() {
        appoints= new ArrayList<Appointment>();
    }

    // patient constructor using the parameters
    public Patient(String name, Date birthDay, String phoneNumber, String sSN) {
    	this.name = name;
		this.birthDay = birthDay;
		this.phoneNumber = phoneNumber;
		SSN = sSN;
		appoints= new ArrayList<Appointment>();
	}

	// getter and setter methods for all parameters
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

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public ArrayList<Appointment> getAppoints() {
        return appoints;
    }

    public void setAppoints(ArrayList<Appointment> appoints) {
        this.appoints = appoints;
    }

    public void addAppointment(Appointment ap)
    {
        appoints.add(ap);
    }

    // get data method that will return all the data from a patient
    public String getData() {
    	String str = "Patient[ Name: "+name+", Birthday: "+birthDay+", Phone number: "+phoneNumber+", SSN: "+SSN+" ]\n";
    	str += "Appointments : "+appoints.size();
    	for (int i=0; i<appoints.size(); i++) {
    		str += "\nDate: " + appoints.get(i).getAppointDate() +
    				", Address: " + appoints.get(i).getAddress() +
    				", Doctor: " + appoints.get(i).getTreatmentDr().getName() +
    				", Symptom: " + appoints.get(i).getSymptom();
    	}
    	return str;
    }

	public String getOtherInfos() {
		return otherInfos;
	}

	public void setOtherInfos(String otherInfos) {
		this.otherInfos = otherInfos;
	}
    
}
