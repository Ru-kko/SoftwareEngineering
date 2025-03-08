package com.library.util;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookCategoryCompositeKey implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private UUID bookId;
    private UUID categoryId;
}
