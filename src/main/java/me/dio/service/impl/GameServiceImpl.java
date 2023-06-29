package me.dio.service.impl;

import lombok.AllArgsConstructor;
import me.dio.exception.NotFoundException;
import me.dio.model.Game;
import me.dio.repository.GameRepository;
import me.dio.service.GameService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class GameServiceImpl implements GameService {
  private final GameRepository gameRepository;

  @Transactional(readOnly = true)
  public List<Game> findAll() {
    List<Game> games = new ArrayList<>();
    this.gameRepository.findAll().forEach(games::add);
    return games;
  }

  @Transactional(readOnly = true)
  public Game findById(Long id) {
    return this.gameRepository.findById(id)
        .orElseThrow(NotFoundException::new);
  }

  public Game create(Game entity) {
    return this.gameRepository.save(entity);
  }

  public Game update(Long id, Game entity) {
    // Ensure idempotency by retrieving the record by ID.
    Game existingGame = this.findById(id);
    entity.setId(existingGame.getId());
    return this.gameRepository.save(entity);
  }

  public void delete(Long id) {
    Game game = this.findById(id);
    this.gameRepository.delete(game);
  }

  public void vote(Long id) {
    Game game = this.findById(id);
    game.setVotes(game.getVotes() + 1);
    gameRepository.save(game);
  }
}