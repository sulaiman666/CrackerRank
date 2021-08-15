package com.solo.ujianandroidhackerrank.services;

import java.util.List;

import com.solo.ujianandroidhackerrank.entity.Ujian;

public interface UjianServicesInterface {
	public List<Ujian> getAllUjian();
	public List<Ujian> getSolvedUjian();
	public String postSolvedUjian(Ujian ujian);
}
