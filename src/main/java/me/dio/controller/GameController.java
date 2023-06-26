package me.dio.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.model.Game;
import me.dio.service.GameService;

@RestController
@RequestMapping("/games")
@CrossOrigin
@Tag(name = "Game Controller", description = "APIs for managing games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    @Operation(summary = "Get all games", description = "Get a list of all registered games")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation"),
    })
    public ResponseEntity<List<Game>> findAll() {
        return ResponseEntity.ok(gameService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a game by ID", description = "Get a specific game based on its ID")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation"),
        @ApiResponse(responseCode = "404", description = "Game not found"),
    })
    public ResponseEntity<Game> findById(@PathVariable Long id) {
        return ResponseEntity.ok(gameService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new game", description = "Create a new game and returns the created game")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Game created successfully"),
        @ApiResponse(responseCode = "422", description = "Invalid game data provided"),
    })
    public ResponseEntity<Game> create(@RequestBody Game game) {
        Game createdGame = gameService.create(game);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdGame.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdGame);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a game", description = "Update an existing game based on its ID")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Game updated successfully"),
        @ApiResponse(responseCode = "404", description = "Game not found"),
        @ApiResponse(responseCode = "422", description = "Invalid game data provided"),
    })
    public ResponseEntity<Game> update(@PathVariable Long id, @RequestBody Game game) {
        return ResponseEntity.ok(gameService.update(id, game));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a game", description = "Delete an existing game based on its ID")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Game deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Game not found"),
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        gameService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/vote")
    @Operation(summary = "Vote for a game", description = "Add a vote to a specific game based on its ID")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Vote registered successfully"),
        @ApiResponse(responseCode = "404", description = "Game not found"),
    })
    public ResponseEntity<Void> vote(@PathVariable Long id) {
        gameService.vote(id);
        return ResponseEntity.noContent().build();
    }
    
}
