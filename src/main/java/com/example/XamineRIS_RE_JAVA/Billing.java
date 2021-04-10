package com.example.XamineRIS_RE_JAVA;
import java.io.Console;

public class Billing {
	private final double COST_CT = 200;
	private final double COST_MRI = 350;
	private final double COST_XRAY = 125;

	public boolean ct, mri, xray;
	public Doctor doctor;

	public Billing(boolean ct, boolean mri, boolean xray, Doctor doctor) {
		this.ct = ct;
		this.mri = mri;
		this.xray = xray;
		this.doctor = doctor;
	}

	public void printBillInformation() {
		double cost = 0;
		if (ct || mri || xray) {
			System.out.println("You had the Following Tests:");
			int test = 1;
			if (ct) {
				System.out.println(test + ".) CT Scan. ($" + COST_CT + ")");
				cost += COST_CT;
			}
			if (mri) {
				System.out.println(++test + ".) MRI. ($" + COST_MRI + ")");
				cost += COST_MRI;
			}
			if (xray) {
				System.out.println(++test + ".) XRAY. ($" + COST_XRAY + ")");
				cost += COST_XRAY;
			}
			System.out.println("You have total " + test + " test(s). Assigned by doctor " + doctor.getName() + ". Your total is $" + cost + ".");
		}
		else {
			System.out.println("You do not have test(s). Assigned by doctor " + doctor.getName() + ".");
		}
	}
}
