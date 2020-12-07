package com.cg.medicine.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.cg.medicine.model.MedicineDetailsEntity;
import com.cg.medicine.service.MapValidationErrorService;
import com.cg.medicine.service.MedicineService;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * @author aisiri
 * Test cases for medicine controller class
 */
@WebMvcTest
 class MedicineControllerTests {

	 @Autowired()
	    private MockMvc mockMvc;
	
	 
	 @MockBean
	private MedicineService medicineservice;
	 @MockBean
	private MapValidationErrorService validservice;
	private static ObjectMapper mapper = new ObjectMapper();
	
	@Test
     void testpostExample() throws Exception {
       
        MedicineDetailsEntity med = new MedicineDetailsEntity(101,"abc",450,12.5,75);
        Mockito.when(medicineservice.addMedicine(ArgumentMatchers.any())).thenReturn(med);
        String json = mapper.writeValueAsString(med);
        mockMvc.perform(post("/medicine/insert").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
                .andExpect(jsonPath("$.medicineId", Matchers.equalTo(101)))
                .andExpect(jsonPath("$.medicineName", Matchers.equalTo("abc")))
                .andExpect(jsonPath("$.instockMedicines", Matchers.equalTo(450)))
                .andExpect(jsonPath("$.medicinePrice", Matchers.equalTo(12.5)))
        		.andExpect(jsonPath("$.medicineDosage", Matchers.equalTo(75)));
        
    }
	@Test
     void testGetExample() throws Exception {
        List< MedicineDetailsEntity> medicines= new ArrayList<>();
        MedicineDetailsEntity med = new  MedicineDetailsEntity(101,"abc",450,12.5,75);
        medicines.add(med);
        Mockito.when(medicineservice.checkAvailability(101)).thenReturn(medicines);
        mockMvc.perform(get("/medicine/101")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].medicineName", Matchers.equalTo("abc")));
    }
	
	 @Test
	     void testPatchExample() throws Exception {
		    MedicineDetailsEntity med = new  MedicineDetailsEntity(101,"abc",450,12.5,75);
	        Mockito.when(medicineservice.upadteMedicineStock(101,15)).thenReturn(med);
	        med.setInstockMedicines(450-15);
	        String json = mapper.writeValueAsString(med);
	        mockMvc.perform(patch("/medicine/update/?medicineId=101&instockMedicines=15").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
	                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
	                .andExpect(jsonPath("$.medicineId", Matchers.equalTo(101)))
	                .andExpect(jsonPath("$.instockMedicines", Matchers.equalTo(435)));
	    }
		@Test
	     void testGetBill() throws Exception {
	        List<String> billList= new ArrayList<>();
	        MedicineDetailsEntity med = new  MedicineDetailsEntity(101,"abc",450,12.5,75);
	        String str= "Medicine name: "+med.getMedicineName()+med.getMedicineDosage()+"mg---Medicine price:"+med.getMedicinePrice()+" per unit";
	        billList.add(str);
	        Mockito.when(medicineservice.generateBill()).thenReturn(billList);
	        mockMvc.perform(get("/medicine/getbill")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
	                .andExpect(jsonPath("$[0]", Matchers.equalTo("Medicine name: abc75mg---Medicine price:12.5 per unit")));
	    }
	
		
		

	}


