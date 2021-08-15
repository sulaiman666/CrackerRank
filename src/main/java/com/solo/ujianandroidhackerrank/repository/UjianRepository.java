package com.solo.ujianandroidhackerrank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.solo.ujianandroidhackerrank.entity.Ujian;

public interface UjianRepository extends JpaRepository<Ujian, Long>{
	@Query(value = "Select * from ujian where solved = 1", nativeQuery = true)
	List<Ujian> findSolvedUjian();
}
