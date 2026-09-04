package university.management.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import university.management.entity.Departments;
import university.management.entity.Professors;
import java.util.List;
import university.management.entity.Courses;
import university.management.entity.Students;




@Repository
public interface ProfessorsRepository extends JpaRepository<Professors, Long> {

        Optional <Professors> findById(long id);

        Optional <Professors> findByEmail(String email);

        List<Professors> findByFirstName(String firstName);

        List<Professors> findByLastName(String lastName);

        List<Professors> findByPhone(String phone);

        List<Professors> findBySalary(Double salary);

        List<Professors> findByHireDate(LocalDate hireDate);

        List<Professors> findByDepartments(Departments departments);

        List<Professors> findByCourses(Courses courses);

        List<Professors> findByStudents(Students student);
        @Transactional
        @Modifying
        @Query("""
                        delete FROM Professors p
                        where p.id=:id
                                """)
        int deleteProfessors(@Param("id") Long id);

        @Transactional
        @Modifying
        @Query("""
                        update Professors p
                        set p.firstName=:firstName,
                        p.lastName=:lastName
                        where p.id=:id
                        """)
        int professorsUpdateFirstAndLastName(@Param("id") Long id, @Param("firstName") String firstName,
                        @Param("lastName") String lastName);

        @Transactional
        @Modifying
        @Query("""
                        update Professors p
                        set p.hireDate=:hireDate
                        where p.id=:id
                        """)
        int professorsUpdateHireDate(@Param("id") Long id, @Param("hireDate") LocalDate hireDate);

        @Transactional
        @Modifying
        @Query("""
                        update Professors p
                        set p.email=:email
                        where p.id=:id
                        """)
        int professorsUpdateEmail(@Param("id") Long id, @Param("email") String email);

        @Transactional
        @Modifying
        @Query("""
                        update Professors p
                        set p.phone=:phone
                        where p.id=:id
                        """)
        int professorsUpdatePhone(@Param("id") Long id, @Param("phone") String phone);

        @Transactional
        @Modifying
        @Query("""
                        update Professors p
                        set p.salary=:salary
                        where p.id=:id
                        """)
        int professorsUpdateSalary(@Param("id") Long id, @Param("salary") Double salary);
}
