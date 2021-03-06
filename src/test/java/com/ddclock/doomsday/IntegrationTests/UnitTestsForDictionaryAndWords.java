package com.ddclock.doomsday.IntegrationTests;

import com.ddclock.doomsday.AbstractIntegrationTest;
import com.ddclock.doomsday.exeptions.DictionaryDoesNotExistException;
import com.ddclock.doomsday.models.entity.Dictionary;
import com.ddclock.doomsday.service.abstracts.model.DictionaryService;
import com.ddclock.doomsday.service.abstracts.model.WordService;
import com.github.database.rider.core.api.dataset.DataSet;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;



@DataSet(value = {"dataset/user/user.yml",
        "dataset/user/roleUser.yml" ,
        "dataset/dictionary/dictionary.yml",
        "dataset/dictionary/word.yml" ,
        "dataset/dictionary/dictionaryWord.yml"}, disableConstraints = true, cleanBefore = true, cleanAfter = true)
class UnitTestsForDictionaryAndWords extends AbstractIntegrationTest {

    @Autowired
    DictionaryService dictionaryService;

    @Autowired
    WordService wordService;

    @Test
    void countGetAllDictionaryFromBD() {
        Assert.assertEquals(4, dictionaryService.getAll().size());
    }

    @Test
    void countGetAllWordsFromBD() {
        Assert.assertEquals(4, wordService.getAll().size());
    }

    @Test
    void getDictionaryByIDTest() {
        Assert.assertNotNull(dictionaryService.getById(1L).get());
        Assert.assertNotNull(dictionaryService.getById(2L).get());
        Assert.assertNotNull(dictionaryService.getById(3L).get());
        Assert.assertNotNull(dictionaryService.getById(4L).get());
    }

    @Test
    void getWordByIDTest() {
        Assert.assertNotNull(wordService.getById(1L).get());
        Assert.assertNotNull(wordService.getById(2L).get());
        Assert.assertNotNull(wordService.getById(3L).get());
        Assert.assertNotNull(wordService.getById(4L).get());
    }

    @Test
    void updateDictionaryMethodTest() {
        String testString = "testString";
        Dictionary dictionary = dictionaryService.getById(1l).get();
        dictionary.setTitle(testString);
        dictionaryService.update(dictionary);
        Assert.assertEquals(testString, dictionaryService.getById(1l).get().getTitle());
    }

    @Test
    void testAddNewWordIntoDictionary() {

        int countOfWords = dictionaryService.getById(1l).get().getWords().size();


        //test when you try to add word in not existed dictionary
        Assert.assertThrows(DictionaryDoesNotExistException.class, () -> {
            dictionaryService.addWordToDictionary(wordService.getById(3l).get(), 5l);
        });


        Assert.assertThrows(DictionaryDoesNotExistException.class, () -> {
            dictionaryService.addWordToDictionary(wordService.getById(3l).get(), 1l);
        });

        Assert.assertEquals(++countOfWords, dictionaryService.getById(1l).get().getWords().size());
    }

    @Test
    void testAddManyWordsIntoDictionary() {
        int countOfWords = dictionaryService.getById(3l).get().getWords().size();


        Assert.assertThrows(DictionaryDoesNotExistException.class, () -> {
            dictionaryService.addWordToDictionary(wordService.getById(1l).get(), 3l);
        });

        Assert.assertThrows(DictionaryDoesNotExistException.class, () -> {
            dictionaryService.addWordToDictionary(wordService.getById(2l).get(), 3L);
        });

        Assert.assertThrows(DictionaryDoesNotExistException.class, () -> {
            dictionaryService.addWordToDictionary(wordService.getById(3l).get(), 3l);
        });

        Assert.assertEquals(countOfWords + 3, dictionaryService.getById(3l).get().getWords().size());
    }


    @Test
    void testDeleteWordFromBD() {

        int countOfWords = dictionaryService.getById(1l).get().getWords().size();

        wordService.deleteById(2l);

        Assert.assertEquals(--countOfWords, dictionaryService.getById(1l).get().getWords().size());
    }

    @Test
    void testDeleteDictionaryFromBD() {

        int countOfDictionary = dictionaryService.getAll().size();
        int countOfWords = wordService.getAll().size();

        dictionaryService.deleteById(1l);

        Assert.assertEquals(--countOfDictionary, dictionaryService.getAll().size());
        Assert.assertEquals(countOfWords, wordService.getAll().size());
    }

    @Test
    void getDictionaryByTitle() {
        Assert.assertNotNull(dictionaryService.getDictionaryByTitle("title of dic 2").get());
    }




}
