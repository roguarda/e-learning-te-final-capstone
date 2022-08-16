package com.techelevator.model.dao;

import com.techelevator.model.dto.Curricula;

import java.util.List;

public interface CurriculaDAO {

		List<Curricula> getAllCurricula();

		List<Curricula> search (String idcurricula);

		Curricula getById(int idcurricula);

		Curricula add(Curricula curricula);

		void update(int idcurricula, Curricula curricula);

		void delete(int idcurricula);

	}
