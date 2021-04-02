package com.example.XamineRIS_RE_JAVA;
import java.util.ArrayList;

// doctor class that hold the methods a Doctor can use
public class Doctor {

    // instantiate the parameters for a doctor
	private String name;
    private String departmentSpecialist;
    private ArrayList<Appointment> appoints;

    // constructor for a doctor
    public Doctor(String name, String departmentSpecialist) {
        this.appoints=new ArrayList<>();
        this.name = name;
        this.departmentSpecialist = departmentSpecialist;
    }

    // Getters and Setters for all parameters
    public ArrayList<Appointment> getAppoints() {
        return appoints;
    }

    public void setAppoints(ArrayList<Appointment> appoint) {
        this.appoints = appoint;

}
    public void addAppointment(Appointment ap)
    {
        this.appoints.add(ap);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment_Specialist() {
		return departmentSpecialist;
	}

	public void setDepartmentSpecialist(String departmentSpecialist) {
		this.departmentSpecialist = departmentSpecialist;
	}

}
