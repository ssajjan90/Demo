/**
 * 
 */
package com.encora.demo.horsetrack.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author ssajjan
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CommandServiceTest {

//	  This we shoud not create manually facing the issue so manually created as of now
	  @InjectMocks
	  CommandService commandService = new CommandService();


	  @Before
	  public void setUp() throws Exception {
	  }

	  @Test
	  public void testParseCommandWinner() {
	    String commandString = "W 5";
	    String expected = "winner";
	    String actual = commandService.parseCommand(commandString);
	    Assert.assertEquals("Incorrect command returned", expected, actual);
	  }

	  @Test
	  public void testParseCommandWager() {
	    String commandString = "1 55";
	    String expected = "wager";
	    String actual = commandService.parseCommand(commandString);
	    Assert.assertEquals("Incorrect command returned", expected, actual);
	  }

	  @Test
	  public void testParseCommandWagerError() {
	    String commandString = "1 5.5";
	    String expected = "error";
	    String actual = commandService.parseCommand(commandString);
	    Assert.assertEquals("Incorrect command returned", expected, actual);
	  }

	  @Test
	  public void testParseCommandQuit() {
	    String commandString = "q";
	    String expected = "quit";
	    String actual = commandService.parseCommand(commandString);
	    Assert.assertEquals("Incorrect command returned", expected, actual);
	  }

	  @Test
	  public void testParseCommandRestock() {
	    String commandString = "R";
	    String expected = "restock";
	    String actual = commandService.parseCommand(commandString);
	    Assert.assertEquals("Incorrect command returned", expected, actual);
	  }

	  @Test
	  public void testParseCommandInvalid() {
	    String commandString = "X";
	    String expected = "invalid";
	    String actual = commandService.parseCommand(commandString);
	    Assert.assertEquals("Incorrect command returned", expected, actual);
	  }



	}