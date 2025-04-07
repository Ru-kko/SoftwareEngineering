package com.dentalia.domain.util;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Builder
@Setter
@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorPopup implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    public enum Level {
        WARNING, ERROR
    }
    private Level level;
    private String message;
}
