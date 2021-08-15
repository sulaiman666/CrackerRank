package com.solo.ujianandroidhackerrank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solo.ujianandroidhackerrank.entity.Ujian;
import com.solo.ujianandroidhackerrank.repository.UjianRepository;

@Service
public class UjianServices implements UjianServicesInterface{
	@Autowired
	UjianRepository ujianRepo;
	
	@Override
	public List<Ujian> getAllUjian() {
		// TODO Auto-generated method stub
		return this.ujianRepo.findAll();
	}

	@Override
	public List<Ujian> getSolvedUjian() {
		// TODO Auto-generated method stub
		return this.ujianRepo.findSolvedUjian();
	}

	@Override
	public String postSolvedUjian(Ujian ujian) {
		// TODO Auto-generated method stub
		this.ujianRepo.save(ujian);
		return "Solved";
	}

}
