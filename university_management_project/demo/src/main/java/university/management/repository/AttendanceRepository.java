package university.management.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import university.management.entity.Attendance;
import university.management.entity.AttendanceStatus;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    Optional<Attendance> findById(Long id);
    List<Attendance> findByStudents_Id(Long studentId);
    List<Attendance> findByCourses_Id(Long courseId);
    List<Attendance> findByDate(LocalDate date);
    List<Attendance> findByStatus(AttendanceStatus status);

    @Transactional
    @Modifying
    @Query("delete from Attendance a where a.id = :id")
    int deleteAttendanceById(@Param("id") Long id);
}
