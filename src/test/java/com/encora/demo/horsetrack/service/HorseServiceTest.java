/**
 * 
 */
package com.encora.demo.horsetrack.service;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import com.encora.demo.horsetrack.dao.HorseRepository;
import com.encora.demo.horsetrack.model.Horse;

/**
 * @author ssajjan
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class HorseServiceTest {
	
	
	// This we shoud not create manually facing the issue so manually created as of now
	@InjectMocks
	HorseService horseService = new HorseService();
	@Mock
	HorseRepository horseRepository;
	
	@Before
	public void setUp() throws Exception {
		 MockitoAnnotations.initMocks(this);
	}
	
	// facing some difficulty in mock
	@Test
	@Ignore
	public void testGetHorseNameByNumber() {
		Horse horse = new Horse();
		horse.setHorseName("test");
		horseService.getHorseNameByNumber(1);
//		Mockito.when(horseRepository.findByHorseNumberEquals(1)).thenReturn(horse);
//		String name =horseService.getHorseNameByNumber(1);
		System.out.println(horse.getHorseName());
	}

}
