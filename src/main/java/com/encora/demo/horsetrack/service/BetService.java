/**
 * 
 */
package com.encora.demo.horsetrack.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encora.demo.horsetrack.model.Inventory;
import com.encora.demo.horsetrack.model.Winning;

/**
 * @author ssajjan
 *
 */
@Service
public class BetService {


	  final int ONE = 1;
	  final int FIVE = 5;
	  final int TEN = 10;
	  final int TWENTY = 20;
	  final int HUNDRED = 100;

	  @Autowired
	  private InventoryService inventoryService;

	  public int calculateAmountWon(int wager, int odds) {
	    return wager * odds;
	  }

	  public List<Winning> dispenseWinnings(int winnings) {

	    List<Winning> winList = new ArrayList<>();
	    Winning winning;
	    boolean betWinAdded = false;
	    
	    List<Inventory> inventories = inventoryService.getInventory();
	    List<Integer> denoms = new ArrayList<>();
	    for (Inventory inventory : inventories) {
	    	denoms.add(inventory.getDenomination());
		}

	    Collections.reverse(denoms);

	    for (Integer denomination : denoms) {
	      int bill = denomination;
	      betWinAdded = false;
	      for (int denominationCounts = inventoryService.getInventory(bill).getCount(); denominationCounts >0; denominationCounts--) {
	        int totalAmountOfBills = bill * denominationCounts;
	        if (winnings >= totalAmountOfBills) {
	          winning = new Winning();
	          winning.setCount(denominationCounts);
	          winning.setDenomination(bill);
	          winList.add(winning);
	          betWinAdded = true;
	          winnings -= totalAmountOfBills;
	          break;
	        }
	      }
	      if (!betWinAdded) {
	        winning = new Winning();
	        winning.setCount(0);
	        winning.setDenomination(bill);
	        winList.add(winning);
	      }
	    }

	    winList.forEach(bet-> {
	      inventoryService.decrementInventory(bet.getDenomination(), bet.getCount());
	    });
	    return winList;
	  }



}
