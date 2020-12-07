package com.cg.medicine.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.medicine.model.MedicineDetailsEntity;

/**
 * @author aisiri
 * This class provides the crud operation performed with database by extending CrudRepository
 *
 */
@Repository
public interface MedicineRepository extends CrudRepository<MedicineDetailsEntity, Integer> {

	 MedicineDetailsEntity findById(int medicineId);
	 List<MedicineDetailsEntity> findByMedicineName(String medicineName);
	 MedicineDetailsEntity findByMedicineDosage(int medicineDosage);
	 
}
