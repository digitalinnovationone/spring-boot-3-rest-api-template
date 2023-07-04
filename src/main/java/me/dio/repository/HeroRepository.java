package me.dio.repository;

import org.springframework.data.repository.CrudRepository;

import me.dio.model.Hero;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends CrudRepository<Hero, Long> {
}
