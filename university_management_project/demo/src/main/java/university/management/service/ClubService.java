package university.management.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import university.management.entity.StudentClub;
import university.management.repository.StudentClubRepository;
import university.management.validation.ServiceValidation;

@Service
public class ClubService {

    private final StudentClubRepository studentClubRepository;

    public ClubService(StudentClubRepository studentClubRepository) {
        this.studentClubRepository = studentClubRepository;
    }

    @Transactional
    public List<StudentClub> findByStudents_Id(Long studentId) {
        ServiceValidation.validateId(studentId);
        return studentClubRepository.findByStudents_Id(studentId);
    }

    @Transactional
    public List<StudentClub> findByClubs_Id(Long clubId) {
        ServiceValidation.validateId(clubId);
        return studentClubRepository.findByClubs_Id(clubId);
    }

    @Transactional
    public List<StudentClub> findByJoinDate(LocalDate joinDate) {
        ServiceValidation.validateDate(joinDate);
        return studentClubRepository.findByJoinDate(joinDate);
    }
}
