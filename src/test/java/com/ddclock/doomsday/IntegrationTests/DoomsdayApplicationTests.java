package com.ddclock.doomsday.IntegrationTests;

import com.ddclock.doomsday.AbstractIntegrationTest;
import com.ddclock.doomsday.models.dto.WordDto;
import com.ddclock.doomsday.models.entity.User;
import com.ddclock.doomsday.models.entity.Word;
import com.ddclock.doomsday.models.mappers.WordMapper;
import com.ddclock.doomsday.service.abstracts.model.UserService;
import com.github.database.rider.core.api.dataset.DataSet;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@DataSet(value = {"dataset/user/user.yml",
                  "dataset/user/roleUser.yml" }, disableConstraints = true, cleanBefore = true, cleanAfter = true)
class DoomsdayApplicationTests extends AbstractIntegrationTest {

    @Autowired
    UserService userService;

    @Autowired
    WordMapper wordMapper;

    @Test
    void testMethodGetAllReturnsCorrectListUsersSize() {
        Assert.assertEquals(4, userService.getAll().size());
    }

    @Test
    void test() {
        Word word = new Word();
        word.setValue("Value");
        word.setExampleSentence("ExampleSentence");
        word.setTranslationValue("TranslationValue");
        WordDto wordDto = wordMapper.wordToWordDto(word);

        System.out.println(word);
        System.out.println(wordDto);

    }


}
