package university.management.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import university.management.entity.StudentClub;
import university.management.entity.StudentClubId;

@Repository
public interface StudentClubRepository extends JpaRepository<StudentClub, StudentClubId> {

    List<StudentClub> findByStudents_Id(Long studentId);
    List<StudentClub> findByClubs_Id(Long clubId);
    List<StudentClub> findByJoinDate(LocalDate joinDate);

    @Transactional
    @Modifying
    @Query("delete from StudentClub s where s.id = :id")
    int deleteStudentClubById(@Param("id") StudentClubId id);
}
