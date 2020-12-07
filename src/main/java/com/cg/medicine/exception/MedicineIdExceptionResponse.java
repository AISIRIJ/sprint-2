package com.cg.medicine.exception;

/**
 * @author aisiri
 * This class provides the response exception of medicine details entity
 *
 */
public class MedicineIdExceptionResponse {

	 	private String medicineId;
	 	public MedicineIdExceptionResponse(String medicineId) {
			super();
			this.medicineId = medicineId;
		}

		public String getMedicineId() {
			return medicineId;
		}

		public void setMedicineId(String medicineId) {
			this.medicineId = medicineId;
		}
		
	}


