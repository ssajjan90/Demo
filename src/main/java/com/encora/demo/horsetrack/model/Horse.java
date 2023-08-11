/**
 * 
 */
package com.encora.demo.horsetrack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ssajjan
 *
 */
@Entity
@Table(name="HORSE")
public class Horse {

	private long id;
	private int horseNumber;
	private String horseName;
	private int odds;
	private RaceStatus raceStatus;
	
	
	
	public Horse() {
	}


	public Horse(int horseNumber, String horseName, int odds, RaceStatus raceStatus) {
	    this.horseNumber = horseNumber;
	    this.horseName = horseName;
	    this.odds = odds;
	    this.raceStatus = raceStatus;
	  }


	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column
	public int getHorseNumber() {
		return horseNumber;
	}

	public void setHorseNumber(int horseNumber) {
		this.horseNumber = horseNumber;
	}

	@Column
	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	@Column
	public int getOdds() {
		return odds;
	}

	public void setOdds(int odds) {
		this.odds = odds;
	}

	@Column
	public RaceStatus getRaceStatus() {
		return raceStatus;
	}

	public void setRaceStatus(RaceStatus raceStatus) {
		this.raceStatus = raceStatus;
	}

}
