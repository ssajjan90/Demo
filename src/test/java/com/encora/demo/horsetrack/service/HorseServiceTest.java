/**
 * 
 */
package com.encora.demo.horsetrack.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.encora.demo.horsetrack.dao.HorseRepository;
import com.encora.demo.horsetrack.model.Horse;
import com.encora.demo.horsetrack.model.RaceStatus;

/**
 * @author ssajjan
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class HorseServiceTest {
	
	
	@InjectMocks
	HorseService horseService;
	@Mock
	HorseRepository horseRepository;
	
	
	@Before
	public void setUp() throws Exception {
		 MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void testGetHorseNameByNumber() {
		Mockito.when(horseRepository.findByHorseNumberEquals(1)).thenReturn(getHorse());
		String horseName = horseService.getHorseNameByNumber(1);
		assertEquals("test", horseName);
	}
	
	@Test
	public void testgetHorseOdds() {
		Mockito.when(horseRepository.findByHorseNumberEquals(1)).thenReturn(getHorse());
		Integer odds = horseService.getHorseOdds(1);
		assertEquals(2, odds);
	}
	
	@Test
	public void testIsHorseWon() {
		Mockito.when(horseRepository.findByHorseNumberEquals(1)).thenReturn(getHorse());
		Boolean isWOn = horseService.isHorseWon(1);
		assertEquals(true, isWOn);
	}
	
	@Test
	public void testIsHorseNumberExists() {
		Mockito.when(horseRepository.findByHorseNumberEquals(0)).thenReturn(null);
		Boolean isExists = horseService.isHorseNumberExists(0);
		assertEquals(false, isExists);
	}


	private Horse getHorse() {
		Horse horse = new Horse();
		 horse.setHorseName("test");
		 horse.setHorseNumber(1);
		 horse.setOdds(2);
		 horse.setRaceStatus(RaceStatus.WIN);
		return horse;
	}

}
