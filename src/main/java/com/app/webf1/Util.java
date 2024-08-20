package com.app.webf1;

import com.app.webf1.exception.NotFoundException;
import lombok.experimental.UtilityClass;

import java.util.Optional;

@UtilityClass
public class Util {
    public static  <T> T checkExists(int id, Optional<T> optional) {
        return optional.orElseThrow( ()-> new NotFoundException("Entity with id "+ id + " not found"));
    }
}
