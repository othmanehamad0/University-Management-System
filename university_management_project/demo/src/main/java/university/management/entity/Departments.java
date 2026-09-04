package university.management.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private long id;

    @Column(name = "department_name", length = 50, unique = true, nullable = false)
    @NotBlank
    @Size(max = 50)
    private String departmentName;

    @Column(name = "building", length = 50, nullable = false)
    @NotBlank
    @Size(max = 50)
    private String building;

    @Column(name = "budget", nullable = false)
    @NotNull
    @Positive
    private Double budget;

    @OneToMany(mappedBy = "departments", cascade = CascadeType.ALL)
    private List<Professors> professors;

    @OneToMany(mappedBy = "departments", cascade = CascadeType.ALL)
    private List<Students> students;
}
