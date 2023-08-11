/**
 * 
 */
package com.encora.demo.horsetrack.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.encora.demo.horsetrack.model.Inventory;

/**
 * @author ssajjan
 *
 */
public interface InventoryRepository extends CrudRepository<Inventory, Long> {
	
	List<Inventory> findAll();
	Inventory findByDenominationEquals(int denomination);
}
