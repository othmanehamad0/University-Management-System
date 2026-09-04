package university.management.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", unique = true, nullable = false)
    private long id;

    @Column(name = "first_name", length = 50, nullable = false)
    @NotBlank
    @Size(max = 50)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    @NotBlank
    @Size(max = 50)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    @NotNull
    private Gender gender;

    @Column(name = "birth_date", nullable = false)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Column(name = "email", unique = true, nullable = false)
    @NotBlank
    @Email
    private String email;

    @Column(name = "phone", unique = true, nullable = false)
    @NotBlank
    @Size(max = 13)
    private String phone;

    @Column(name = "enrollment_date", nullable = false)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Departments departments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id")
    private Professors professors;

    @Column(name = "address", length = 255)
    @Size(max = 255)
    private String address;

    @OneToMany(mappedBy = "students", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollments> enrollments;

    @OneToMany(mappedBy = "students", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grades> grades;

    @OneToMany(mappedBy = "students", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attendance> attendance;

    @OneToMany(mappedBy = "students", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payments> payments;

    @OneToMany(mappedBy = "students", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Scholarships> scholarships;

    @OneToMany(mappedBy = "students", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LibraryLoans> libraryLoans;

    @ManyToMany
    @JoinTable(
        name = "student_club",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "club_id")
    )
    private Set<Clubs> clubs = new HashSet<>();
}
