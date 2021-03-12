package com.example.XamineRIS_RE_JAVA;
import java.util.ArrayList;
import java.util.Date;

// appointment system class that will hold all the current appointments
public class AppointmentSystem {
	ArrayList<Patient> patients = new ArrayList<Patient>();
	ArrayList<Doctor> doctors = new ArrayList<Doctor>();
	ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	
	public AppointmentSystem() {
		
	}

	// add patients to the patients array
	public boolean addPatient(Patient p) {
		patients.add(p);
		return true;
	}

	//add doctors to the doctor array
	public boolean addDoctor(Doctor d) {
		doctors.add(d);
		return true;
	}

	// add appointments to the appointment array
	public boolean addAppointment(Appointment app) {
		appointments.add(app);

		//verifies that the patient and doctor are both in the corresponding arrays of current objects
		getPatientByNB(app.getPatient().getName(), app.getPatient().getBirthDay()).addAppointment(app);
		getDoctorByND(app.getTreatmentDr().getName(), app.getTreatmentDr().getDepartment_Specialist()).addAppointment(app);
		return true;
	}
	
	public Patient getPatientByNB(String name, Date birthDay) {
		for (Patient p : patients) {
			if (p.getName().equalsIgnoreCase(name) && p.getBirthDay().equals(birthDay))
				return p;
		}
		return null;
	}
	
	public Doctor getDoctorByND(String name, String department) {
		for (Doctor d : doctors) {
			if (d.getName().equalsIgnoreCase(name) && d.getDepartment_Specialist().equals(department))
				return d;
		}
		return null;
	}
}
