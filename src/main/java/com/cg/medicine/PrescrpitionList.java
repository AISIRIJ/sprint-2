package com.cg.medicine;

import java.util.ArrayList;
import java.util.List;

import com.cg.medicine.model.Prescription;

/**
 * @author aisiri
 * This class provides the list of prescriptions w.r.t patient id
 *
 */
public class PrescrpitionList {

	public  List<Prescription> prescriptionDetails()
	{
		Prescription  prescription = new  Prescription (1,"Dr.Akash",102,"dolo",5,650);
		Prescription  prescription1 = new  Prescription (2,"Dr.Amar",101,"ibuprofen",4,200);
	    Prescription  prescription2 = new  Prescription (3,"Dr.sapna",101,"Acetaminophen",16,15);
		Prescription  prescription3 = new  Prescription (4,"Dr.Akash",104,"aspirin",1,75);
		Prescription  prescription4 = new  Prescription (5,"Dr.Akash",102,"dolo",6,550);
		List<Prescription> prescriptionlist =new ArrayList<>();
		prescriptionlist.add(prescription);
		prescriptionlist.add(prescription1);
		prescriptionlist.add(prescription2);
		prescriptionlist.add(prescription3);
		prescriptionlist.add(prescription4);
		return  prescriptionlist ;
		
	}
}
