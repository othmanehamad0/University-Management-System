package university.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import university.management.entity.Grades;
import university.management.repository.GradesRepository;
import university.management.validation.ServiceValidation;

@Service
public class GradesService {

    private final GradesRepository gradesRepository;

    public GradesService(GradesRepository gradesRepository) {
        this.gradesRepository = gradesRepository;
    }

    @Transactional
    public Optional<Grades> findById(Long id) {
        ServiceValidation.validateId(id);
        return gradesRepository.findById(id);
    }

    @Transactional
    public List<Grades> findByStudents_Id(Long studentId) {
        ServiceValidation.validateId(studentId);
        return gradesRepository.findByStudents_Id(studentId);
    }

    @Transactional
    public List<Grades> findByExams_Id(Long examId) {
        ServiceValidation.validateId(examId);
        return gradesRepository.findByExams_Id(examId);
    }

    @Transactional
    public List<Grades> findByMarks(Double marks) {
        return gradesRepository.findByMarks(marks);
    }

    @Transactional
    public List<Grades> findByLetterGrade(String letterGrade) {
        ServiceValidation.validateString(letterGrade, "letter grade");
        return gradesRepository.findByLetterGrade(letterGrade);
    }

    @Transactional
    public List<Grades> findByEnrollments_Id(Long enrollmentId) {
        ServiceValidation.validateId(enrollmentId);
        return gradesRepository.findByEnrollments_Id(enrollmentId);
    }
}
