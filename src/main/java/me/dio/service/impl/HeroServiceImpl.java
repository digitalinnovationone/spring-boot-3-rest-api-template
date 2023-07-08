package me.dio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.dio.exception.BusinessException;
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
        // DONE! Sort Heroes by "xp" descending.
        return this.heroRepository.findAll(Sort.by(Sort.Direction.DESC, "xp"));
    }

    @Transactional(readOnly = true)
    public Hero findById(Long id) {
        return this.heroRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Hero create(Hero heroToCreate) {
        heroToCreate.setXp(0);
        return this.heroRepository.save(heroToCreate);
    }

    public Hero update(Long id, Hero heroToUpdate) {
        Hero dbHero = this.findById(id);
        if (!dbHero.getId().equals(heroToUpdate.getId())) {
            throw new BusinessException("Update IDs must be the same.");
        }
        // DONE! Make sure "xp" is not changed. In practice, only "name" can be changed.
        dbHero.setName(heroToUpdate.getName());
        return this.heroRepository.save(dbHero);
    }

    public void delete(Long id) {
        Hero dbHero = this.findById(id);
        this.heroRepository.delete(dbHero);
    }

    public void increaseXp(Long id) {
        Hero dbHero = this.findById(id);
        dbHero.setXp(dbHero.getXp() + 2);
        heroRepository.save(dbHero);
    }
}