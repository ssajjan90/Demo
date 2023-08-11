/**
 * 
 */
package com.encora.demo.horsetrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.encora.demo.horsetrack.dao.InventoryRepository;
import com.encora.demo.horsetrack.model.Inventory;

/**
 * @author ssajjan
 *
 */
@Service
public class InventoryService {
	


	  @Value("${restock.amount}")
	  private int restockAmount;

	  @Autowired
	  private InventoryRepository inventoryRepository;

	  public void restock() {
	    List<Inventory> inventories = inventoryRepository.findAll();

	    inventories.stream()
	      .forEach(inventory-> {
	        inventory.setCount(restockAmount);
	        inventoryRepository.save(inventory);
	      });
	  }

	  public void decrementInventory(int denomination, int amount) {

	    Inventory inventory = inventoryRepository.findByDenominationEquals(denomination);

	    int currentBillCount = inventory.getCount();
	    if ((currentBillCount - amount) >= 0) {
	      inventory.setCount(currentBillCount - amount);
	      inventoryRepository.save(inventory);
	    }
	  }

	  public boolean sufficientFunds(int amountWon) {

	    List<Inventory> inventories = inventoryRepository.findAll();
	    Integer result = inventories.stream().reduce(0,
	        (total, inventory) -> total + (inventory.getDenomination() * inventory.getCount()), Integer::sum);
	    if ((result - amountWon) >= 0) {
	      return true;
	    } else {
	      return false;
	    }
	  }

	  public List<Inventory>  getInventory() {
	    return inventoryRepository.findAll();
	  }

	  public Inventory  getInventory(int denomination) {
	    return inventoryRepository.findByDenominationEquals(denomination);
	  }



}
