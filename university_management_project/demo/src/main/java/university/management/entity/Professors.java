package university.management.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "professors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Professors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id")
    private long id;

    @Column(name = "first_name", length = 50, nullable = false)
    @NotBlank
    @Size(max = 50)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    @NotBlank
    @Size(max = 50)
    private String lastName;

    @Column(name = "email", length = 100, unique = true, nullable = false)
    @NotBlank
    @Email
    @Size(max = 100)
    private String email;

    @Column(name = "phone", length = 20, unique = true, nullable = false)
    @NotBlank
    @Size(max = 20)
    private String phone;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "hire_date", nullable = false)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hireDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Departments departments;

    @OneToMany(mappedBy = "professors", cascade = CascadeType.ALL)
    private List<Courses> courses;

    @OneToMany(mappedBy = "professors", cascade = CascadeType.ALL)
    private List<Students> students;
}
