/**
 * 
 */
package com.encora.demo.horsetrack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.encora.demo.horsetrack.dao.HorseRepository;
import com.encora.demo.horsetrack.dao.InventoryRepository;
import com.encora.demo.horsetrack.model.Horse;
import com.encora.demo.horsetrack.model.Inventory;
import com.encora.demo.horsetrack.model.RaceStatus;

/**
 * @author ssajjan
 *
 */
@Service
public class Configuration {

	  @Value("${max.horses}")
	  private int maxHorses;

	  @Autowired
	  private HorseRepository horseRepository;

	  @Autowired
	  private InventoryRepository inventoryRepository;

	  public Configuration() {
	  }

	  public void loadHorses() {

	    // Check value maxHorses for loading correct number of horses
	    horseRepository.save(new Horse(1, "That Darn Gray Cat", 5, RaceStatus.WIN));
	    horseRepository.save(new Horse(2, "Fort Utopia", 10, RaceStatus.LOSE));
	    horseRepository.save(new Horse(3, "Count Sheep", 9, RaceStatus.LOSE));
	    horseRepository.save(new Horse(4, "Ms Traitour", 4, RaceStatus.LOSE));
	    horseRepository.save(new Horse(5, "Real Princess", 3, RaceStatus.LOSE));
	    horseRepository.save(new Horse(6, "Pa Kettle", 5, RaceStatus.LOSE));
	    horseRepository.save(new Horse(7, "Gin Stinger", 6, RaceStatus.LOSE));

	  }

	  public void loadInventory() {
	    inventoryRepository.save(new Inventory(1,10));
	    inventoryRepository.save(new Inventory(5,10));
	    inventoryRepository.save(new Inventory(10,10));
	    inventoryRepository.save(new Inventory(20,10));
	    inventoryRepository.save(new Inventory(100,10));
	  }

	  public void init() {

	    loadHorses();
	    loadInventory();

	  }



}
