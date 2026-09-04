package university.management.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "enrollments")
public class Enrollments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "enrollment_date", nullable = false)
    @NotNull(message = "this field is required") // Fixed: Changed from @NotBlank to @NotNull for LocalDate
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Fixed: 'MM' must be uppercase for months
    private LocalDate enrollmentDate; // Fixed: Changed variable name to standard camelCase

    // Fixed: Replaced illegal @Query with @ManyToOne relationship to enforce an INNER JOIN
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Students students;

    // Fixed: Replaced illegal @Query with @ManyToOne relationship to enforce an INNER JOIN
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Courses courses;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @NotBlank
    private Status status;

    @OneToMany(mappedBy = "enrollments", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grades> grades;

}
