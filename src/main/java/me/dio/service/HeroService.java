package me.dio.service;

import me.dio.model.Hero;

public interface HeroService extends CrudService<Long, Hero> {
    void increaseXp(Long id);

    void addingMissionQuantity(Long id, Integer qt);
}
