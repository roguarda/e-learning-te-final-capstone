package com.techelevator.model.dao;

import com.techelevator.model.dto.Curricula;

import java.util.List;

public interface CurriculaDAO {

		public List<Curricula> getAllCurricula();

		public List<Curricula> search (String curriculaId);

		public Curricula getById(int curriculaId);

		public void add(String curriculaName, String dailyInstruction, String dailyHomework);

		public void update(String updateCriteria, String newValue, int curriculaId);

		public void delete(int curriculaId);

	}
