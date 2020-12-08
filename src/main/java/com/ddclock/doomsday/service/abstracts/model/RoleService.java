package com.ddclock.doomsday.service.abstracts.model;
import com.ddclock.doomsday.models.entity.Role;

import java.util.Optional;


public interface RoleService extends ReadWriteService<Role, String> {
    Optional<Role> getRoleByName(String name);
}
