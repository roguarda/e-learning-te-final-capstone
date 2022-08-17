package com.techelevator.model.dao;

import com.techelevator.model.dto.Curricula;

import java.util.List;

public interface CurriculaDAO {


		List<Curricula> getAllCurricula();

		List<Curricula> search (String curriculaId);

		Curricula getById(int curriculaId);

		void add(String curriculaName, String dailyInstruction, String dailyHomework);

		void update(int curriculaId, Curricula curricula);

		void delete(int curriculaId);

	}
