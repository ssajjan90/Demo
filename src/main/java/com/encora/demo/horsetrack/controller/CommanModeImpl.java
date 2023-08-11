/**
 * 
 */
package com.encora.demo.horsetrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.encora.demo.horsetrack.service.BetService;
import com.encora.demo.horsetrack.service.CommandService;
import com.encora.demo.horsetrack.service.Configuration;
import com.encora.demo.horsetrack.service.HorseService;
import com.encora.demo.horsetrack.service.InventoryService;
import com.encora.demo.horsetrack.service.ReportService;

/**
 * @author ssajjan
 *
 */
@Service
public class CommanModeImpl implements CommandMode {
	
	@Autowired
	InventoryService inventoryService;
	
	@Autowired
	HorseService horseService;
	
	@Autowired
	Configuration configuration;
	
	@Autowired
	ReportService reportService;
	
	@Autowired
	BetService betService;
	
	@Autowired
	CommandService  commandService;

	private boolean quit=false;

	@Override
	public void init() {
		configuration.init();

	}

	@Override
	public void startUpMessages() {
		reportService.startup();

	}

	@Override
	public void winner(int horseNumber) {
		// TODO Auto-generated method stub

	    if (horseService.isHorseNumberExists(horseNumber)) {
	      horseService.setWinner(horseNumber);
	      reportService.printInventory();
	      reportService.printHorses();
	    } else {
	    	reportService.printInvalidHorse(horseNumber);
	    }
	  

	}

	@Override
	public void bet(int horseNumber, int amount) {
	    if (!(horseService.isHorseNumberExists(horseNumber))) {
	        reportService.printInvalidHorse(horseNumber);
	        return;
	      }

	      if (!(horseService.isHorseWon(horseNumber))) {
	        reportService.printNoPayout(horseService.getHorseNameByNumber(horseNumber));
	        return;
	      }

	      int amountWon = betService.calculateAmountWon(
	    		  amount,
	          horseService.getHorseOdds(horseNumber));
	      if (inventoryService.sufficientFunds(amountWon)) {
	        reportService.printPayout(horseService.getHorseNameByNumber(horseNumber), amountWon);
	        reportService.printDispense(betService.dispenseWinnings(amountWon));
	      } else {
	        reportService.printInsufficientFunds(amountWon);
	      }

	      reportService.printInventory();
	      reportService.printHorses();
	    }

	@Override
	public boolean quit() {
		return quit;

	}

	@Override
	public void execute(String commandexecuted) {
		System.out.println("Command Executed : " + commandexecuted);
		String checkForSpace = commandexecuted.trim();
		if (!StringUtils.isEmpty(checkForSpace)) {
			if ((commandService.parseCommand(commandexecuted).equalsIgnoreCase("invalid"))) {
				reportService.printInvalidCommand(commandexecuted);
			} else {
				commandFactory(commandexecuted);
			}
		}

	}
	
	 private void commandFactory(String commandLine) {
		    String command = commandService.parseCommand(commandLine);

		    switch (command) {
		      case "quit":
		        quit = true;
		        break;
		      case "restock":
		        restock();
		        break;
		      case "winner":
		        winner(commandService.getWinningHorseNumber());
		        break;
		      case "wager":
		        bet(commandService.getBetHorseNumber(), commandService.getBetAmount());
		        break;
		      case "error":
		        reportService.printErrorMessage(commandService.getErrorMessage());
		        break;
		      default:
		        // Do nothing
		    }
		  }

	@Override
	public void restock() {

	    inventoryService.restock();
	    reportService.printInventory();
	  
		
	}

}
