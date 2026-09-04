package university.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import university.management.entity.Courses;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Long> {

    Optional<Courses> findById(Long id);
    List<Courses> findByCourseName(String courseName);
    List<Courses> findByCredit(Integer credit);
    List<Courses> findBySemester(Integer semester);
    List<Courses> findByProfessors_Id(Long professorId);
    List<Courses> findByDepartments_Id(Long departmentId);

    @Transactional
    @Modifying
    @Query("delete from Courses c where c.id = :id")
    int deleteCourseById(@Param("id") Long id);
}
