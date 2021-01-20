package com.ddclock.doomsday.dao.impl.dto;

import com.ddclock.doomsday.dao.abstracts.dto.DictionaryDtoDao;
import com.ddclock.doomsday.models.dto.DictionaryDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DictionaryDtoDaoImpl implements DictionaryDtoDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<DictionaryDto> getAll() {
        return entityManager.createQuery("SELECT " +
                "new com.ddclock.doomsday.models.dto.DictionaryDto(d.id, d.title, d.description, d.words.size)" +
                " from Dictionary as d").getResultList();
    }

    @Override
    public List<DictionaryDto> getAllByUserId(long id) {

        String query = "SELECT " +
                "new com.ddclock.doomsday.models.dto.DictionaryDto(d.id, d.title, d.description, d.words.size)" +
                " from Dictionary as d where d.user.id = " + id;

        return entityManager.createQuery(query).getResultList();
    }

}
