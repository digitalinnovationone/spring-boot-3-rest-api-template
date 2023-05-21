package me.dio.service;

import me.dio.model.Game;

public interface GameService extends CrudService<Long, Game> {
    void vote(Long id);
}
