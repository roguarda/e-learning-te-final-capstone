package com.techelevator.model.dao;

import com.techelevator.model.dto.Curricula;

import java.util.List;

public interface CurriculaDAO {

		List<Curricula> getAllCurricula();

		List<Curricula> search (String curriculaId);

		Curricula getById(int curriculaId);

		Curricula add(Curricula curricula);

		void update(int curriculaId, Curricula curricula);

		void delete(int curriculaId);

	}
