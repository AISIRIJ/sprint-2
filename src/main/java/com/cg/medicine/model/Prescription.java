package com.cg.medicine.model;

/**
 * @author aisiri
 * This class provides the prescription details
 *
 */
public class Prescription {
	/**
	 * Prescription id
	 *
	 */
   private int prescriptionId;
   /**
	 * Prescribed doctor name
	 *
	 */
   private String doctorName;
   /**
	 * patient id
	 *
	 */
   private int patientId;
   /**
  	 * Prescribed medicine name
  	 *
  	 */
   private String medicineName;
   /**
  	 * Prescribed medicine quantity
  	 *
  	 */
   private int medicineQuantity;
   /**
 	 * Prescribed medicine dosage
 	 *
 	 */
   private int medicineDosage;
   
   	public Prescription(int prescriptionId, String doctorName, int patientId, String medicineName, int medicineQuantity,int medicineDosage) {
		this.prescriptionId = prescriptionId;
		this.doctorName = doctorName;
		this.patientId = patientId;
		this.medicineName = medicineName;
		this.medicineQuantity = medicineQuantity;
		this.medicineDosage=medicineDosage;
   	}
   	public int getMedicineDosage() {
		return medicineDosage;
	}
	public void setMedicineDosage(int medicineDosage) {
		this.medicineDosage = medicineDosage;
	}
	public int getPrescriptionId() {
   		return prescriptionId;
   	}
   	public void setPrescriptionId(int prescriptionId) {
   		this.prescriptionId = prescriptionId;
   	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public int getMedicineQuantity() {
		return medicineQuantity;
	}
public void setMedicineQuantity(int medicineQuantity) {
	this.medicineQuantity = medicineQuantity;
}
@Override
public String toString() {
	return "/n[prescriptionId=" + prescriptionId + ", doctorName=" + doctorName + ", patientId=" + patientId
			+ ", medicineName=" + medicineName + ", medicineQuantity=" + medicineQuantity + "]";
}
   
    
}
