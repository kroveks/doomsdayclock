package com.ddclock.doomsday.IntegrationTests;

import com.ddclock.doomsday.AbstractIntegrationTest;
import com.ddclock.doomsday.models.entity.User;
import com.ddclock.doomsday.service.abstracts.model.UserService;
import com.github.database.rider.core.api.dataset.DataSet;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@DataSet(value = {"dataset/user/user.yml",
                  "dataset/user/roleUser.yml" }, disableConstraints = true, cleanBefore = true, cleanAfter = true)
class DoomsdayApplicationTests extends AbstractIntegrationTest {

    @Autowired
    UserService userService;

    @Test
    void testMethodGetAllReturnsCorrectListUsersSize() {
        Assert.assertEquals(4, userService.getAll().size());
    }

}
