package com.example.XamineRIS_RE_JAVA;

public class RadiologyTechnician {

	private String name;
	Billing bill;
	Patient patient;

	public RadiologyTechnician(String name, Billing bill, Patient patient) {
		this.name = name;
		this.bill = bill;
		this.patient = patient;
	}

	public void performOperation() {
		if (bill.ct || bill.mri || bill.xray) {
			System.out.println("Technician " + name + " will be counducting tests according to the bill for patient " + patient.getName());
			if (bill.ct) {
				performCT();
			}
			if (bill.mri) {
				performMRI();
			}
			if (bill.xray) {
				performXRAY();
			}
			System.out.println("All test(s) done.");
		}
		else {
			System.out.println("No test(s) done.");
		}
	}

	private void performCT() {
		System.out.println("Performing CT Scan.");
	}

	private void performMRI() {
		System.out.println("Performing MRI.");
	}

	private void performXRAY() {
		System.out.println("Performing XRAY.");
	}

}
