package university.management.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import university.management.entity.Enrollments;
import university.management.entity.Status;
import university.management.repository.EnrollmentsRepository;
import university.management.validation.ServiceValidation;

@Service
public class EnrollmentsService {

    private final EnrollmentsRepository enrollmentsRepository;

    public EnrollmentsService(EnrollmentsRepository enrollmentsRepository) {
        this.enrollmentsRepository = enrollmentsRepository;
    }

    @Transactional
    public Optional<Enrollments> findById(Long id) {
        ServiceValidation.validateId(id);
        return enrollmentsRepository.findById(id);
    }

    @Transactional
    public List<Enrollments> findByStudents_Id(Long studentId) {
        ServiceValidation.validateId(studentId);
        return enrollmentsRepository.findByStudents_Id(studentId);
    }

    @Transactional
    public List<Enrollments> findByCourses_Id(Long courseId) {
        ServiceValidation.validateId(courseId);
        return enrollmentsRepository.findByCourses_Id(courseId);
    }

    @Transactional
    public List<Enrollments> findByEnrollmentDate(LocalDate enrollmentDate) {
        ServiceValidation.validateDate(enrollmentDate);
        return enrollmentsRepository.findByEnrollmentDate(enrollmentDate);
    }

    @Transactional
    public List<Enrollments> findByStatus(Status status) {
        ServiceValidation.validateNotNull(status, "status");
        return enrollmentsRepository.findByStatus(status);
    }
}
