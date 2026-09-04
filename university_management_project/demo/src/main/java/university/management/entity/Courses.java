package university.management.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "courses")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "course_name", length = 100, unique = true, nullable = false)
    @NotBlank(message = "Course name should not be blank")
    @Size(max = 100)
    private String courseName;

    @Column(name = "credit", nullable = false)
    @NotNull(message = "The credit field is required")
    @Min(value = 1, message = "The minimum value is 1")
    @Max(value = 10, message = "The maximum value is 10")
    @Positive
    private Integer credit;

    @Column(name = "semester", nullable = false)
    @NotNull(message = "The semester field is required")
    @Min(value = 1, message = "The minimum value is 1")
    @Max(value = 8, message = "The maximum value is 8")
    private Integer semester;

    @ManyToMany
    @JoinTable(
        name = "course_department",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    private List<Departments> departments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id")
    private Professors professors;

    @OneToMany(mappedBy = "courses", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exams> exams;

    @OneToMany(mappedBy = "courses", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attendance> attendance;

    @OneToMany(mappedBy = "courses", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollments> enrollments;
}
