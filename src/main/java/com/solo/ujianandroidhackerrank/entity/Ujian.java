package com.solo.ujianandroidhackerrank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="ujian")
public class Ujian {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String namaSoal;
	private String difficultySoal;
	private String kategoriSoal;
	@Column(length = 1000)
	private String isiSoal;
	private String templateJawaban;
	private String jawabanSoal;
	private String submissionToken;
	private boolean solved;
}
