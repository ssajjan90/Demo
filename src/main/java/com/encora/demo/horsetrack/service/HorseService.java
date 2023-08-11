/**
 * 
 */
package com.encora.demo.horsetrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encora.demo.horsetrack.dao.HorseRepository;
import com.encora.demo.horsetrack.model.Horse;
import com.encora.demo.horsetrack.model.RaceStatus;

/**
 * @author ssajjan
 *
 */
@Service
public class HorseService {
	
	@Autowired
	HorseRepository horseRepository;
	
	public String getHorseNameByNumber(int horseNumber) {
	
		Horse horse = horseRepository.findByHorseNumberEquals(horseNumber);
		return horse.getHorseName();
		
		
	}
	
	public int getHorseOdds(int horseNumber) {
		Horse horse = horseRepository.findByHorseNumberEquals(horseNumber);

		return horse.getOdds();
	}

			public boolean isHorseWon(int horseNumber) {
				Horse horse = horseRepository.findByHorseNumberEquals(horseNumber);
				if (horse.getRaceStatus() == RaceStatus.WIN) {
					return true;
				} else {
					return false;
				}
			}

			public boolean isHorseNumberExists(int horseNumber) {
				if (horseRepository.findByHorseNumberEquals(horseNumber) == null) {
					return false;
				} else {
					return true;
				}
			}

			public void setWinner(int horseNumber) {

				List<Horse> horses = horseRepository.findAll();

				for (Horse horse : horses) {
					if (horseNumber == (horse.getHorseNumber())) {
						horse.setRaceStatus(RaceStatus.WIN);
						horseRepository.save(horse);
					}else {
						horse.setRaceStatus(RaceStatus.LOSE);
						horseRepository.save(horse);
					}
				}

			}

}
