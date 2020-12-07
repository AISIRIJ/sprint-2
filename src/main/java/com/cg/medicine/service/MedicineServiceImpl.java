package com.cg.medicine.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.medicine.PrescrpitionList;
import com.cg.medicine.exception.MedicineIdException;
import com.cg.medicine.model.MedicineDetailsEntity;
import com.cg.medicine.model.Prescription;
import com.cg.medicine.repository.MedicineRepository;
/**
 * @author aisiri
 * This class implements medicine services 
 */
@Service
public class MedicineServiceImpl implements MedicineService{

	
	List<MedicineDetailsEntity> getBill=new ArrayList<>();
	Scanner sc=new Scanner(System.in);
	@Autowired
	
	private MedicineRepository medicinerepo;
	
	private PrescrpitionList presc=new PrescrpitionList() ;
	List<Prescription> plist= presc.prescriptionDetails();
	@Override
	public MedicineDetailsEntity addMedicine(MedicineDetailsEntity medicine) {
		 MedicineDetailsEntity med=medicinerepo.findById(medicine.getMedicineId());
		 if(med!=null)
			 throw new MedicineIdException("Medicine already available");
		return medicinerepo.save(medicine);	
	}

	@Override
	public  MedicineDetailsEntity upadteMedicineStock(int medicineId,int stock) {
		 MedicineDetailsEntity medicine=medicinerepo.findById(medicineId);
		 if(medicine==null)
			 throw new MedicineIdException("Medicine not available");
		 medicine.setInstockMedicines(medicine.getInstockMedicines()-stock);
		 return medicinerepo.save(medicine);	
	}

	@Override
	public List<MedicineDetailsEntity> checkAvailability(int patientId) {
		for(Prescription i:plist) {
			
			if(i.getPatientId()==patientId) {
				List<MedicineDetailsEntity> medicines=medicinerepo.findByMedicineName(i.getMedicineName()) ;
				for(MedicineDetailsEntity j:medicines) {
					if(j.getMedicineDosage()== i.getMedicineDosage()) 	
						getBill.add(j);			
						
					}	
			}
		
				
			
			}
		
		return getBill;
	}
	
	@Override
	public List<String> generateBill()
	{       double sum=0;
			List<String> billdetails=new ArrayList<>();
	        String str="";
		    for(MedicineDetailsEntity i:getBill) {
		    	for(Prescription j:plist) {
		    		if(i.getMedicineName().equalsIgnoreCase(j.getMedicineName()) && i.getMedicineDosage()==j.getMedicineDosage()) {
		    			sum=sum+(i.getMedicinePrice()*j.getMedicineQuantity());
		    			 upadteMedicineStock(i.getMedicineId(),j.getMedicineQuantity());
		    		}
		    	}
		   
			 str= "Medicine name: "+i.getMedicineName()+" "+i.getMedicineDosage()+"mg---Medicine price:"+i.getMedicinePrice()+" per unit";
			 billdetails.add(str);
		    }
			String res="Total amount="+sum;
			billdetails.add(res);
			return billdetails;
	}
}
