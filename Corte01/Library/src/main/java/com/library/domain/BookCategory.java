package com.library.domain;

import com.library.util.BookCategoryCompositeKey;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookCategory {
    @EmbeddedId
    private BookCategoryCompositeKey id;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "bookId")
    private Book book;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "categoryId")
    private Category category;
}
