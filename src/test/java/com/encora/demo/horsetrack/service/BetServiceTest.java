/**
 * 
 */
package com.encora.demo.horsetrack.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.encora.demo.horsetrack.dao.InventoryRepository;
import com.encora.demo.horsetrack.model.Inventory;
import com.encora.demo.horsetrack.model.Winning;

/**
 * @author ssajjan
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class BetServiceTest {
	


	  @InjectMocks
	  BetService betService;
	  
	  @Mock
	  InventoryService inventoryService;
	  
	  @Mock
	  InventoryRepository inventoryRepository;
	  
	

	  @Before
	  public void setUp() throws Exception {
	  }
	  
	  @Test
	  public void testDispenseWinning() {
		  List<Inventory> inventories =  new ArrayList<>();
		  Inventory inventory =  new Inventory();
		  inventory.setCount(10);
		  inventory.setDenomination(10);
		  inventories.add(inventory);
		  Mockito.when(inventoryService.getInventory()).thenReturn(inventories);
		  Mockito.when(inventoryService.getInventory(10)).thenReturn(inventory);
		  List<Winning> winnings=betService.dispenseWinnings(20);
		  assertNotNull(winnings);
		  assertEquals(2, winnings.get(0).getCount());
		  assertEquals(10, winnings.get(0).getDenomination());
	  }

	  @Test
	  public void testCalculateAmountWon() {
	    int betAmount = 55;
	    int odds = 5;
	    int expected = 275;
	    int actual = betService.calculateAmountWon(betAmount, odds);

	    Assert.assertEquals("Winnings does not equal", expected, actual);
	  }
	  
	



}
