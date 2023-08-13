/**
 * 
 */
package com.encora.demo.horsetrack.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.encora.demo.horsetrack.dao.HorseRepository;
import com.encora.demo.horsetrack.dao.InventoryRepository;
import com.encora.demo.horsetrack.model.Horse;
import com.encora.demo.horsetrack.model.Inventory;
import com.encora.demo.horsetrack.model.RaceStatus;

/**
 * @author ssajjan
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ReportServiceTest {

	@InjectMocks
	ReportService reportService;

	@Mock
	private InventoryRepository inventoryRepository;
	
	@Mock
	HorseRepository horseRepository;

	@Test
	public void testprintInventory() {
		List<Inventory> inventories = new ArrayList<>();
		Inventory inventory = new Inventory();
		inventory.setCount(10);
		inventory.setDenomination(10);
		inventories.add(inventory);
		Mockito.when(inventoryRepository.findAll()).thenReturn(inventories);
		reportService.printInventory();

	}
	
	@Test
	public void testPrintHorses() {
		List<Horse> horses = new ArrayList<>();
		Horse horse = new Horse();
		 horse.setHorseName("test");
		 horse.setHorseNumber(1);
		 horse.setOdds(2);
		 horse.setRaceStatus(RaceStatus.WIN);
		 horses.add(horse);
		Mockito.when(horseRepository.findAll()).thenReturn(horses);
		reportService.printHorses();

	}

	
}
