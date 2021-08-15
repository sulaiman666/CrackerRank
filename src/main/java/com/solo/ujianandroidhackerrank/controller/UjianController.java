package com.solo.ujianandroidhackerrank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solo.ujianandroidhackerrank.entity.Ujian;
import com.solo.ujianandroidhackerrank.services.UjianServices;

@RestController
@RequestMapping("/ujian")
public class UjianController {
	@Autowired
	UjianServices ujianServices;
	
	@GetMapping("/")
	public List<Ujian> getAll() {
		return this.ujianServices.getAllUjian();
	}
	
	@GetMapping("/solved")
	public List<Ujian> getSolvedUjian() {
		return this.ujianServices.getSolvedUjian();
	}
	
	@PostMapping("/solved")
	public String postSolvedUjian(Ujian ujian) {
		return this.ujianServices.postSolvedUjian(ujian);
	}
}
