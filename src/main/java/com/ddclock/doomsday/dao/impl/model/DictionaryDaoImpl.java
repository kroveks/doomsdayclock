package com.ddclock.doomsday.dao.impl.model;

import com.ddclock.doomsday.dao.abstracts.model.DictionaryDao;
import com.ddclock.doomsday.dao.util.SingleResultUtil;
import com.ddclock.doomsday.exeptions.DictionaryDoesNotExistException;
import com.ddclock.doomsday.exeptions.WordAlreadyExistInDictException;
import com.ddclock.doomsday.models.entity.Dictionary;
import com.ddclock.doomsday.models.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class DictionaryDaoImpl extends ReadWriteDaoImpl<Dictionary, Long> implements DictionaryDao {


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
    public void addWordToDictionary(Word word, Long id) throws WordAlreadyExistInDictException, DictionaryDoesNotExistException{
        String newWordValue = word.getValue();
        Optional<Dictionary> dictionaryObj = getById(id);

        if(dictionaryObj.isPresent()) {
            Dictionary dictionary = dictionaryObj.get();

            try {
                List<Word> words = dictionary.getWords();
                boolean noneMatch = words.stream()
                        .map(s -> s.getValue())
                        .noneMatch(s -> s.equals(newWordValue));

                if(noneMatch) {
                    words.add(word);
                    dictionary.setWords(words);
                    persist(dictionary);

                }else {
                    throw new WordAlreadyExistInDictException("This word already exist in this dictionary");
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }

        }
        throw new DictionaryDoesNotExistException("Dictionary with " + id + " does not exist!");
    }
}
