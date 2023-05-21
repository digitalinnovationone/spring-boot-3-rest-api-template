package me.dio.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.dio.model.Game;
import me.dio.model.repository.GameRepository;
import me.dio.service.GameService;
import me.dio.service.exception.NotFoundException;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<Game> findAll() {
        List<Game> games = new ArrayList<>();
        this.gameRepository.findAll().forEach(games::add);
        return games;
    }

    @Transactional(readOnly = true)
    public Game findById(Long id) {
        return this.gameRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    @Transactional
    public Game create(Game entity) {
        return this.gameRepository.save(entity);
    }

    @Transactional
    public Game update(Long id, Game entity) {
        // Ensure idempotency by retrieving the record by ID.
        Game existingGame = this.findById(id);
        entity.setId(existingGame.getId());
        return this.gameRepository.save(entity);
    }

    @Transactional
    public void delete(Long id) {
        Game game = this.findById(id);
        this.gameRepository.delete(game);
    }

    @Transactional
    public void vote(Long id) {
        Game game = this.findById(id);
        game.setVotes(game.getVotes() + 1);
        gameRepository.save(game);
    }

}
