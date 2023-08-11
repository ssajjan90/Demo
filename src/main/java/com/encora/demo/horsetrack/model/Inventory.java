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
@Table(name="INVENTORY")
public class Inventory {
	
	private long id;
	
	private int denomination;
	
	private int count;
	
	
	 public Inventory() {
	}

	public Inventory(int denomination, int count) {
		    this.denomination = denomination;
		    this.count = count;
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
	public int getDenomination() {
		return denomination;
	}

	public void setDenomination(int denomination) {
		this.denomination = denomination;
	}

	@Column
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	

}
