package university.management.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import university.management.entity.Gender;
import university.management.entity.Students;

public interface StudentsRepository extends JpaRepository<Students, Long> {

    @Transactional
    @Modifying
    @Query("delete from Students s where s.id = :id")
    int deleteByStudentId(@Param("id") Long id);

    Optional<Students> findStudentById(Long id);
    Optional<Students> findByEmail(String email);
    List<Students> findByDepartments_Id(Long departmentId);
    List<Students> findByEnrollmentDate(LocalDate enrollmentDate);
    List<Students> findByGender(Gender gender);
    List<Students> findByFirstName(String firstName);
    List<Students> findByLastName(String lastName);

    @Transactional
    @Modifying
    @Query("update Students s set s.firstName = :firstName where s.id = :id")
    int updateStudentFirstName(@Param("id") Long id, @Param("firstName") String firstName);

    @Transactional
    @Modifying
    @Query("update Students s set s.lastName = :lastName where s.id = :id")
    int updateStudentLastName(@Param("id") Long id, @Param("lastName") String lastName);

    @Transactional
    @Modifying
    @Query("update Students s set s.gender = :gender where s.id = :id")
    int updateStudentGender(@Param("id") Long id, @Param("gender") Gender gender);

    @Transactional
    @Modifying
    @Query("update Students s set s.birthDate = :birthDate where s.id = :id")
    int updateStudentBirthDate(@Param("id") Long id, @Param("birthDate") LocalDate birthDate);

    @Transactional
    @Modifying
    @Query("update Students s set s.email = :email where s.id = :id")
    int updateStudentEmail(@Param("id") Long id, @Param("email") String email);
}
