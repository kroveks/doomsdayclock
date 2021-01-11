package com.ddclock.doomsday.dao.impl.dto;

import com.ddclock.doomsday.dao.abstracts.dto.DictionaryDtoDao;
import com.ddclock.doomsday.dao.util.SingleResultUtil;
import com.ddclock.doomsday.models.dto.DictionaryDto;
import com.ddclock.doomsday.models.entity.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

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

}