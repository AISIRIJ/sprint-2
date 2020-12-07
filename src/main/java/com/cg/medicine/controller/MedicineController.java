package com.cg.medicine.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.medicine.model.MedicineDetailsEntity;
import com.cg.medicine.service.MapValidationErrorService;
import com.cg.medicine.service.MedicineService;


/**
 * @author aisiri
 * This class provides the controller mapping for post,get and patch methods.
 *
 */
@RestController
@RequestMapping("/medicine")
public class MedicineController {

	@Autowired
	MedicineService medicineservice;
	 @Autowired
     private MapValidationErrorService mapvalidationservice ;
	
	@PostMapping("/insert")
	public ResponseEntity<?> insertMedicine(@Valid @RequestBody MedicineDetailsEntity medicine,BindingResult result){
		  ResponseEntity<?>  errorMap=mapvalidationservice.mapvalidationError(result);
	    	if(errorMap!=null)
	    		return errorMap;
		return new ResponseEntity<>( medicineservice.addMedicine(medicine),HttpStatus.CREATED);
	}
	
	@PatchMapping("/update/")
    public ResponseEntity<?> updateStock(@RequestParam  int medicineId,@RequestParam int instockMedicines){
  	  return new ResponseEntity<>(medicineservice.upadteMedicineStock(medicineId, instockMedicines),HttpStatus.OK);
    }
	
	@GetMapping("/{patientId}")
	public ResponseEntity<?> getMedicine(@PathVariable int patientId){
		 return new ResponseEntity<>(medicineservice.checkAvailability(patientId),HttpStatus.OK);
	}
	
	@GetMapping("/getbill")
	public ResponseEntity<?> getBill(){
		return new ResponseEntity<>(medicineservice.generateBill(),HttpStatus.OK);
	}
}
