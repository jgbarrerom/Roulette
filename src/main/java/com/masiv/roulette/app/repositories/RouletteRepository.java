package com.masiv.roulette.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.masiv.roulette.app.models.Roulette;

@Repository
public interface RouletteRepository extends CrudRepository<Roulette, String>{
}
