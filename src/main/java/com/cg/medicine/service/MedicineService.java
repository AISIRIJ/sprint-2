package com.cg.medicine.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.medicine.model.MedicineDetailsEntity;

/**
 * @author aisiri
 * This MedicineService provides functionalities as per the requirements
 */
@Service
public interface MedicineService {
	/**
	 * This method will add new medicines to the DB using JPA
	 *@param medicine details to be added to the database
	 */
	public abstract MedicineDetailsEntity addMedicine(MedicineDetailsEntity medicine);
	/**
	 * This method will update the stock of the specified medicine in DB using JPA   
	 * @param medicine details to update the in-stock medicines in DB
	 */
	public abstract MedicineDetailsEntity upadteMedicineStock(int medicineId,int stock);
	/**
	 * This method will get the medicine details from DB using JPA   
	 * @param name of the medicine to find and  its dosage
	 * @return medicine if found else null
	 */
	public abstract List<MedicineDetailsEntity> checkAvailability(int patientId);
	/**
	 * This method will generate the bill for prescribed medicines
	 * @return the bill
	 */
	public abstract List<String> generateBill();
}
