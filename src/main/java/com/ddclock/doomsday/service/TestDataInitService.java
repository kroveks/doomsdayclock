package com.ddclock.doomsday.service;

import com.ddclock.doomsday.models.entity.Dictionary;
import com.ddclock.doomsday.models.entity.Role;
import com.ddclock.doomsday.models.entity.User;
import com.ddclock.doomsday.models.entity.Word;
import com.ddclock.doomsday.service.abstracts.model.RoleService;
import com.ddclock.doomsday.service.abstracts.model.UserService;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class TestDataInitService {

    final UserService userService;
    final RoleService roleService;


    final static int NUMBER_OF_USERS = 10;
    final static int NUMBER_OF_DICTIONARIES = 2;
    final  int NUMBER_OF_WORDS = 100;


    List<Dictionary> dictionaryList = new ArrayList<>();
    Role USER_ROLE = Role.builder().name("USER").build();
    Role ADMIN_ROLE = Role.builder().name("ADMIN").build();


    @Transactional
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
            Dictionary dictionary2 = Dictionary.builder().title("Dictionary_2_" + i).description("DescriptionDictionary_2_" + i).build();
            List<Word> words = new ArrayList<>();
            for(int j = 0; j < NUMBER_OF_WORDS; j++) {
                words.add(Word.builder().value("word" + i).exampleSentence("ex_sentence").translationValue("value").build());
            }
            dictionary1.setWords(words);
            dictionary1.setWords(words);


            dictionary1.setUser(user);
            dictionary2.setUser(user);

            //dictionaryService.persist(dictionary);
        }
    }
}
