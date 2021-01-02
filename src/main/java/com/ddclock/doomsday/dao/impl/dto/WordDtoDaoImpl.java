package com.ddclock.doomsday.dao.impl.dto;

import com.ddclock.doomsday.dao.abstracts.dto.WordDtoDao;
import com.ddclock.doomsday.models.dto.WordDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class WordDtoDaoImpl implements WordDtoDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<WordDto> getAll() {
        return entityManager.createQuery("SELECT " +
                "new com.ddclock.doomsday.models.dto.WordDto(w.id, w.translationValue , w.translationValue, w.exampleSentence, w.persistDateTime, w.persistDateTime, 0 ) " +
                "from Word as w").getResultList();
    }
}

