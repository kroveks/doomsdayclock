package com.ddclock.doomsday.dao.util;

import javax.persistence.TypedQuery;
import java.util.Optional;


public class SingleResultUtil {

    private SingleResultUtil() {
    }

    public static <T> Optional<T> getSingleResultOrNull(TypedQuery<T> var) {
        try {
            return Optional.of(var.getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
