package me.dio.model.repository;

import org.springframework.data.repository.CrudRepository;

import me.dio.model.Game;

public interface GameRepository extends CrudRepository<Game, Long> {
}
