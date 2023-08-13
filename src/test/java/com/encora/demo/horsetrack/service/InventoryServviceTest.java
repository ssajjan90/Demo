/**
 * 
 */
package com.encora.demo.horsetrack.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.encora.demo.horsetrack.dao.InventoryRepository;
import com.encora.demo.horsetrack.model.Inventory;

/**
 * @author ssajjan
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class InventoryServviceTest {
	
	@InjectMocks
	InventoryService inventoryService;
	
	@Mock
	InventoryRepository inventoryRepository;
	
	
	@Test
	public void testRestock() {
		 List<Inventory> inventories =  new ArrayList<>();
		  Inventory inventory =  new Inventory();
		  inventory.setCount(10);
		  inventory.setDenomination(10);
		  inventories.add(inventory);
		  Mockito.when(inventoryRepository.findAll()).thenReturn(inventories);
		  inventoryService.restock();
		
	}
	
	@Test
	public void testDecrementInventory() {
		 
		 Inventory inventory =  new Inventory();
		  inventory.setCount(10);
		  inventory.setDenomination(10);
		  Mockito.when(inventoryRepository.findByDenominationEquals(10)).thenReturn(inventory);
		  inventoryService.decrementInventory(10,3);
		
	}
	
	@Test
	public void testSufficientFunds() {
		 
		 List<Inventory> inventories =  new ArrayList<>();
		  Inventory inventory =  new Inventory();
		  inventory.setCount(10);
		  inventory.setDenomination(10);
		  inventories.add(inventory);
		  Mockito.when(inventoryRepository.findAll()).thenReturn(inventories);
		  assertTrue(inventoryService.sufficientFunds(100));
		
	}

}
