/**
 * 
 */
package com.encora.demo.horsetrack.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.encora.demo.horsetrack.model.Horse;

/**
 * @author ssajjan
 *
 */
public interface HorseRepository extends CrudRepository<Horse, Long> {

	List<Horse> findAll();
	Horse findByHorseNumberEquals(int horseNumber);
}
