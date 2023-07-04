package me.dio.service;

import me.dio.model.Hero;

public interface HeroService extends CrudService<Long, Hero> {
    void vote(Long id);
}
