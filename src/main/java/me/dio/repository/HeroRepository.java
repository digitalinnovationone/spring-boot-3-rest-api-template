package me.dio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.model.Hero;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {
}
