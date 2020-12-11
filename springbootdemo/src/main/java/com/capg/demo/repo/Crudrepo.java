package com.capg.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.demo.pojo.Alien;
@Repository
public interface Crudrepo extends JpaRepository<Alien, Integer>{

	@Query("from Alien where aid=(select MAX(aid) from Alien)")
	public Alien getmaxaidalien();

}
