package university.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import university.management.entity.Scholarships;
import university.management.repository.ScholarshipsRepository;
import university.management.validation.ServiceValidation;

@Service
public class ScholarshipsService {

    private final ScholarshipsRepository scholarshipsRepository;

    public ScholarshipsService(ScholarshipsRepository scholarshipsRepository) {
        this.scholarshipsRepository = scholarshipsRepository;
    }

    @Transactional
    public Optional<Scholarships> findById(Long id) {
        ServiceValidation.validateId(id);
        return scholarshipsRepository.findById(id);
    }

    @Transactional
    public List<Scholarships> findByStudents_Id(Long studentId) {
        ServiceValidation.validateId(studentId);
        return scholarshipsRepository.findByStudents_Id(studentId);
    }

    @Transactional
    public List<Scholarships> findByAmount(Double amount) {
        return scholarshipsRepository.findByAmount(amount);
    }

    @Transactional
    public List<Scholarships> findByReason(String reason) {
        ServiceValidation.validateString(reason, "reason");
        return scholarshipsRepository.findByReason(reason);
    }
}
