package university.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "title", length = 150, nullable = false)
    @NotBlank
    @Size(max = 150)
    private String title;

    @Column(name = "author", length = 100)
    @Size(max = 100)
    private String author;

    @Column(name = "publisher", length = 100)
    @Size(max = 100)
    private String publisher;

    @Column(name = "quantity", nullable = false)
    @PositiveOrZero
    private Integer quantity;

}
