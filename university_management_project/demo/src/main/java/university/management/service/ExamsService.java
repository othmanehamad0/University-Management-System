package university.management.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import university.management.entity.Exams;
import university.management.entity.examType;
import university.management.repository.ExamsRepository;
import university.management.validation.ServiceValidation;

@Service
public class ExamsService {

    private final ExamsRepository examsRepository;

    public ExamsService(ExamsRepository examsRepository) {
        this.examsRepository = examsRepository;
    }

    @Transactional
    public Optional<Exams> findById(Long id) {
        ServiceValidation.validateId(id);
        return examsRepository.findById(id);
    }

    @Transactional
    public List<Exams> findByCourses_Id(Long courseId) {
        ServiceValidation.validateId(courseId);
        return examsRepository.findByCourses_Id(courseId);
    }

    @Transactional
    public List<Exams> findByExamDate(LocalDate examDate) {
        ServiceValidation.validateDate(examDate);
        return examsRepository.findByExamDate(examDate);
    }

    @Transactional
    public List<Exams> findByType(examType type) {
        ServiceValidation.validateNotNull(type, "exam type");
        return examsRepository.findByType(type);
    }

    @Transactional
    public List<Exams> findByTotalMarks(Integer totalMarks) {
        return examsRepository.findByTotalMarks(totalMarks);
    }
}
