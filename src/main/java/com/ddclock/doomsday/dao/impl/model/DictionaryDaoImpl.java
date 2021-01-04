package com.ddclock.doomsday.dao.impl.model;

import com.ddclock.doomsday.dao.abstracts.model.DictionaryDao;
import com.ddclock.doomsday.dao.util.SingleResultUtil;
import com.ddclock.doomsday.models.entity.Dictionary;
import com.ddclock.doomsday.models.entity.Word;
import com.ddclock.doomsday.service.abstracts.model.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DictionaryDaoImpl extends ReadWriteDaoImpl<Dictionary, Long> implements DictionaryDao {

    @Autowired
    DictionaryService dictionaryService;

    @Autowired
    public DictionaryDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Optional<Dictionary> getDictionaryByTitle(String title) {
        String hql = "FROM Dictionary WHERE title = :title";
        TypedQuery<Dictionary> query = (TypedQuery<Dictionary>) getEntityManager().createQuery(hql).setParameter("title", title);
        return SingleResultUtil.getSingleResultOrNull(query);
    }

    @Override
    public List<Word> addWordToDictionary(Word word, Long id) {
        String newWordValue = word.getValue();
        //сделать првоерку на null or "", почитать про Optional
        //Подумать над тем, чтобыисключение кидать, которое будет вылетать если такое слово уже есть, чтобы как-то это ловить и говорить пользователю
        // что он еблан

        List<Word> words = new ArrayList<>(dictionaryService.getById(id).get().getWords());

        boolean noneMatch = words.stream()
                               .map(s -> s.getValue())
                               .noneMatch(s -> s==newWordValue);

        if(noneMatch) {
            words.add(word);
            return words;
        }

        return words;
    }
}
