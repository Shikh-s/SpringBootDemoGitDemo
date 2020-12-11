package com.capg.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.capg.demo.pojo.Alien;
import com.capg.demo.repo.Crudrepo;


@RestController
public class AleinController {
	@Autowired
	Crudrepo repo;
	
	@PostMapping(path="/addalien")
	public Alien addAlien(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	
	@GetMapping(path="/getalien/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) 
	{
		return repo.findById(aid);
	}
	
	@PutMapping(path="/updatealien")
	public Alien updateAlien(@RequestBody Alien alien)
	{
		return repo.saveAndFlush(alien);
	}
	
	@DeleteMapping(path="/deletealien")
	public Alien deleteAlien(@RequestBody Alien alien)
	{
		Alien a=alien;
		repo.delete(alien);
		return a;
	}
	
	@GetMapping(path="/getallalien")
	public List<Alien> getAllAlien()
	{
		return repo.findAll();
	}
	
	@GetMapping(path="/getmaxaidalien")
	public Alien getMaxAidAlien()
	{
		return repo.getmaxaidalien();
	}
}
