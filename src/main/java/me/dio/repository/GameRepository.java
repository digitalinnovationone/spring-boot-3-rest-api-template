package me.dio.repository;

import org.springframework.data.repository.CrudRepository;

import me.dio.model.Game;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
}
