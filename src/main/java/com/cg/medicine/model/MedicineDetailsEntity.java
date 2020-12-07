package com.cg.medicine.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author aisiri
 * This class provides the medicine details
 */

@Entity
@Table(name="medicines")

public class MedicineDetailsEntity {
	
	/**
	 * medicine id is referred as primary key and is auto generated
	 */
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)

    @Min(value=1, message="Enter valid medicine id and must be greater than 0")  
	private int medicineId;
	/**
	 * name of the medicine 
	 */
	@NotBlank(message = "enter medicine name")
	private String medicineName;
	/**
	 * quantity of medicines available
	 */
    @Min(value=1, message="Invalid! instock quantity must be greater than 0")  
	private int instockMedicines;
	/**
	 * price of the medicine per unit
	 */
    @DecimalMin(value="1", message=" medicine price must be greater than 0")  
    @DecimalMax(value="10000", message="medicine price must be equal or less than 10000")
	private double medicinePrice;
	/**
	 * dosage of the medicine 
	 */
	@Min(value=1, message="medicine dosage must be equal or greater than 0")  
	private int medicineDosage;
	/**
	 * getters and setters 
	 */
	

	public MedicineDetailsEntity(int medicineId, @NotBlank(message = "enter medicine name") String medicineName,
			int instockMedicines, double medicinePrice, int medicineDosage) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.instockMedicines = instockMedicines;
		this.medicinePrice = medicinePrice;
		this.medicineDosage = medicineDosage;
	}
	public MedicineDetailsEntity() {
		super();
	}
	public int getMedicineDosage() {
		return medicineDosage;
	}
	public void setMedicineDosage(int medicineDosage) {
		this.medicineDosage = medicineDosage;
	}
	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public int getInstockMedicines() {
		return instockMedicines;
	}
	public void setInstockMedicines(int instockMedicines) {
		this.instockMedicines = instockMedicines;
	}
	public double getMedicinePrice() {
		return medicinePrice;
	}
	public void setMedicinePrice(double medicinePrice) {
		this.medicinePrice = medicinePrice;
	}
}

