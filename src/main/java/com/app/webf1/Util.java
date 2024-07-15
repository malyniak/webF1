package com.app.webf1;

import jakarta.persistence.EntityNotFoundException;
import lombok.experimental.UtilityClass;

import java.util.Optional;

@UtilityClass
public class Util {
    public static  <T> T checkExists(int id, Optional<T> optional) {
        return optional.orElseThrow( ()-> new EntityNotFoundException("Entity with id "+ id + "not found"));
    }

}
