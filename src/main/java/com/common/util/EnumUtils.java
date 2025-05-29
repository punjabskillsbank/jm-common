package com.common.util;

import com.common.exceptionHandling.InvalidEnumValueException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EnumUtils {
    public static <E extends Enum<E>> List<E> parseEnumList(String input, Class<E> enumClass) {
        if (input == null || input.trim().isEmpty()) {
            return Collections.emptyList();
        }

        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(value -> {
                    try {
                        return Enum.valueOf(enumClass, value.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        throw new InvalidEnumValueException(enumClass.getSimpleName(), value);
                    }
                })
                .collect(Collectors.toList());
    }
}
