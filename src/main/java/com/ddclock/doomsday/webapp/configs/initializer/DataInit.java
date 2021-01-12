package com.ddclock.doomsday.webapp.configs.initializer;

import com.ddclock.doomsday.exeptions.DictionaryDoesNotExistException;
import com.ddclock.doomsday.exeptions.WordAlreadyExistInDictException;
import com.ddclock.doomsday.models.entity.Dictionary;
import com.ddclock.doomsday.models.entity.Role;
import com.ddclock.doomsday.models.entity.User;
import com.ddclock.doomsday.models.entity.Word;
import com.ddclock.doomsday.service.abstracts.model.DictionaryService;
import com.ddclock.doomsday.service.abstracts.model.RoleService;
import com.ddclock.doomsday.service.abstracts.model.UserService;
import com.ddclock.doomsday.service.abstracts.model.WordService;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class DataInit {

    private final UserService userService;
    private final RoleService roleService;
    private final DictionaryService dictionaryService;
    private final WordService wordService;


    private final static int NUMBER_OF_USERS = 10;
    private final static int NUMBER_OF_DICTIONARIES = 2;
    private final static int NUMBER_OF_WORDS = 100;


    private Role USER_ROLE = Role.builder().name("USER").build();
    private Role ADMIN_ROLE = Role.builder().name("ADMIN").build();


    /**
     * Основной метод для заполнения базы данных.
     * Вызов методов добавлять в этод метод.
     * Следить за последовательностью вызова.
     */

    //@PostConstruct//раскомментировать аннотацию при первом запуске проекта для создания таблиц БД, потом закомментировать
    public void initDataBaseFilling() {
        createEntity();
      //  testForAddMethod();
    }


    public void createEntity() {

        roleService.persist(USER_ROLE);
        roleService.persist(ADMIN_ROLE);
        for (int i = 0; i < NUMBER_OF_USERS; i++) {
            User user = new User();
            user.setEmail("ivanov@mail.com" + i);
            user.setPassword("password" + i);
            user.setFullName("Ivanov Ivan" + i);
            user.setIsEnabled(true);
            user.setCity("Moscow" + i);
            user.setAbout("very good man");
            if (i == 0) user.setRole(ADMIN_ROLE);
            else user.setRole(USER_ROLE);
            userService.persist(user);

            Dictionary dictionary1 = Dictionary.builder().title("Dictionary_" + i).description("DescriptionDictionary_" + i).build();
            List<Word> words = new ArrayList<>();

            Word word = new Word();
            word.setValue("word " + i);
            word.setExampleSentence("blah blah blah " + i);
            word.setTranslationValue("anime vpered " + i);
            wordService.persist(word);

            words.add(word);

            dictionary1.setWords(words);
            dictionary1.setUser(user);
            dictionaryService.persist(dictionary1);

        }


    }

    public void testForAddMethod() {
        Word wordToTest = new Word();
        wordToTest.setValue("testWord");
        wordToTest.setExampleSentence("Nu cho pognaly nahuy");
        wordToTest.setTranslationValue("Ebanniy v rot");
        wordService.persist(wordToTest);

        try {
            dictionaryService.addWordToDictionary(wordToTest, 170L);
        }catch (DictionaryDoesNotExistException | WordAlreadyExistInDictException e) {
            System.out.println("Problemes");
        }
    }

}
