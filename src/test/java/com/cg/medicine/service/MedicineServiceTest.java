package com.cg.medicine.service;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.cg.medicine.exception.MedicineIdException;
import com.cg.medicine.model.MedicineDetailsEntity;
import com.cg.medicine.model.Prescription;
import com.cg.medicine.repository.MedicineRepository;

 /**
 * @author aisiri
 * Test cases for medicine service class
 *
 */
class MedicineServiceTest {

	@Mock
	MedicineRepository medicineRepository;

	@InjectMocks
	MedicineServiceImpl medicineServiceImpl;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
     void test_addmedicine() throws Exception {

		 MedicineDetailsEntity med = new MedicineDetailsEntity(101,"abc",450,12.5,75);
	    when(medicineRepository.save(any(MedicineDetailsEntity.class))).thenReturn(med);
        when(medicineRepository.findById(102)).thenReturn(med);
        MedicineDetailsEntity medicine= medicineServiceImpl.addMedicine(med);
        assertNotNull(medicine);
        assertEquals("abc", medicine.getMedicineName());

    }
	@Test
	 void test_findById_ThrowMedicineIdException() {
		
		MedicineDetailsEntity med = new MedicineDetailsEntity(108,"abc",450,12.5,75);
    	when(medicineRepository.save(any(MedicineDetailsEntity.class))).thenReturn(med);
        when(medicineRepository.findById(102)).thenReturn(med);
	    BDDMockito.given(medicineRepository.findById(108)).willThrow(new MedicineIdException());
		assertThrows(MedicineIdException.class, ()->medicineServiceImpl.addMedicine(med));
	}
	@Test
    void test_updatestock() throws Exception {

		 MedicineDetailsEntity med = new MedicineDetailsEntity(108,"abc",450,12.5,75);
    	 when(medicineRepository.save(any(MedicineDetailsEntity.class))).thenReturn(med);
   		 when(medicineRepository.findById(108)).thenReturn(med);
		 MedicineDetailsEntity medicine= medicineServiceImpl.upadteMedicineStock(108, 150);
         assertEquals(108, medicine.getMedicineId());
         assertEquals(300, medicine.getInstockMedicines());
}
	@Test
	 void test_findMedicineById_ThrowMedicineIdException() {
		
		MedicineDetailsEntity med = new MedicineDetailsEntity(108,"abc",450,12.5,75);
    	when(medicineRepository.save(any(MedicineDetailsEntity.class))).thenReturn(med);
   		when(medicineRepository.findById(109)).thenReturn(med);
	    BDDMockito.given(medicineRepository.findById(109)).willThrow(new MedicineIdException());
		assertThrows(MedicineIdException.class, ()->medicineServiceImpl.upadteMedicineStock(108,150));

	}

	@Test
	 void test_checkavailability() throws Exception{
		List< MedicineDetailsEntity> list=new ArrayList<>();
		
		Prescription p=new Prescription(1,"Dr.Akash",101,"dolo",5,650);
		 MedicineDetailsEntity med = new MedicineDetailsEntity(108,"abc",450,12.5,75);
	
		 when(medicineRepository.findByMedicineName("abc")).thenReturn(list);
		 when(medicineRepository.findByMedicineDosage(75)).thenReturn(med);
		 when(medicineServiceImpl.checkAvailability(101)).thenReturn(list);
		
		
		
	}

	  @Test void test_generateBill() throws Exception {
		  MedicineDetailsEntity med = new MedicineDetailsEntity(108,"abc",450,12.5,75);
		  Prescription p=new Prescription(1,"Dr.Akash",101,"dolo",5,650);
		  List<String> billdetails=new ArrayList<>();
		  double sum=0;
	      sum=sum+(med.getMedicinePrice()*p.getMedicineQuantity()); test_updatestock();
	      String str= "Medicine name: "+med.getMedicineName()+" "+med.getMedicineDosage() +"mg---Medicine price:"+med.getMedicinePrice()+" per unit";
	      billdetails.add(str);
	      when( medicineServiceImpl.generateBill()).thenReturn(billdetails); 
	      for(String i:billdetails)
	    	  assertEquals(str,i);
	  
	  }
	 
}



