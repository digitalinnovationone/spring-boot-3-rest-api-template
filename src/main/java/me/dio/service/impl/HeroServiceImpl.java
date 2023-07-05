package me.dio.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.dio.exception.NotFoundException;
import me.dio.model.Hero;
import me.dio.repository.HeroRepository;
import me.dio.service.HeroService;

@Service
@Transactional
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroRepository heroRepository;

    @Transactional(readOnly = true)
    public List<Hero> findAll() {
        List<Hero> games = new ArrayList<>();
        this.heroRepository.findAll().forEach(games::add);
        return games;
    }

    @Transactional(readOnly = true)
    public Hero findById(Long id) {
        return this.heroRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Hero create(Hero entity) {
        return this.heroRepository.save(entity);
    }

    public Hero update(Long id, Hero entity) {
        // Ensure idempotency by retrieving the record by ID.
        Hero existingHero = this.findById(id);
        entity.setId(existingHero.getId());
        return this.heroRepository.save(entity);
    }

    public void delete(Long id) {
        Hero hero = this.findById(id);
        this.heroRepository.delete(hero);
    }

    public void vote(Long id) {
        Hero hero = this.findById(id);
        hero.setXp(hero.getXp() + 2);
        heroRepository.save(hero);
    }
}