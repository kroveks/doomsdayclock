package com.ddclock.doomsday.IntegrationTests;

import com.ddclock.doomsday.AbstractIntegrationTest;
import com.ddclock.doomsday.models.entity.Dictionary;
import com.ddclock.doomsday.models.entity.User;
import com.ddclock.doomsday.models.entity.Word;
import com.ddclock.doomsday.service.abstracts.model.DictionaryService;
import com.ddclock.doomsday.service.abstracts.model.RoleService;
import com.ddclock.doomsday.service.abstracts.model.UserService;
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
public class UnitTestsForUserAndRoles extends AbstractIntegrationTest {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Test
    void countGetAllUsersFromBD() {
        Assert.assertEquals(4, userService.getAll().size());
    }

    @Test
    void countGetAllRolesFromBD() {
        Assert.assertEquals(1, roleService.getAll().size());
    }

    @Test
    void getUserByIDTest() {
        Assert.assertNotNull(userService.getById(1L).get());
        Assert.assertNotNull(userService.getById(2L).get());
        Assert.assertNotNull(userService.getById(3L).get());
        Assert.assertNotNull(userService.getById(153L).get());
    }

    @Test
    void getRoleByIDTest() {
        Assert.assertNotNull(roleService.getById(1L).get());
    }

    @Test
    void updateUserMethodTest() {
        String testString = "testString";
        User user = userService.getById(1l).get();
        user.setFullName(testString);
        userService.update(user);
        Assert.assertEquals(testString, userService.getById(1l).get().getFullName());
    }

    @Test
    void getUserByEmail() {
        Assert.assertNotNull(userService.getUserByEmail("principal@mail.ru").get());
    }

    @Test
    void getUserByName() {
        Assert.assertNotNull(userService.getUserByName("Teat").get());
    }

    @Test
    void getRoleByName() {
        Assert.assertNotNull(roleService.getRoleByName("USER").get());
    }


}
