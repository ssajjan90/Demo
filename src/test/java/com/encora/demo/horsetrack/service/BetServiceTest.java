/**
 * 
 */
package com.encora.demo.horsetrack.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.encora.demo.horsetrack.model.Winning;

/**
 * @author ssajjan
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class BetServiceTest {
	


	  @InjectMocks
	  BetService betService= new BetService();

	  @Before
	  public void setUp() throws Exception {
	  }
	  
	  @Test
	  public void testDispenseWinning() {
	  
	    
	  }

	  @Test
	  public void testCalculateAmountWon() {
	    int wagerAmount = 55;
	    int odds = 5;
	    int expected = 275;
	    int actual = betService.calculateAmountWon(wagerAmount, odds);

	    Assert.assertEquals("Winnings does not equal", expected, actual);
	  }
	  
	



}
