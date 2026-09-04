package university.management.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import university.management.entity.PaymentMethod;
import university.management.entity.PaymentStatus;
import university.management.entity.Payments;
import university.management.repository.PaymentsRepository;
import university.management.validation.ServiceValidation;

@Service
public class PaymentsService {

    private final PaymentsRepository paymentsRepository;

    public PaymentsService(PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
    }

    @Transactional
    public Optional<Payments> findById(Long id) {
        ServiceValidation.validateId(id);
        return paymentsRepository.findById(id);
    }

    @Transactional
    public List<Payments> findByStudents_Id(Long studentId) {
        ServiceValidation.validateId(studentId);
        return paymentsRepository.findByStudents_Id(studentId);
    }

    @Transactional
    public List<Payments> findByAmount(Double amount) {
        return paymentsRepository.findByAmount(amount);
    }

    @Transactional
    public List<Payments> findByPaymentDate(LocalDate paymentDate) {
        ServiceValidation.validateDate(paymentDate);
        return paymentsRepository.findByPaymentDate(paymentDate);
    }

    @Transactional
    public List<Payments> findByMethod(PaymentMethod method) {
        ServiceValidation.validateNotNull(method, "payment method");
        return paymentsRepository.findByMethod(method);
    }

    @Transactional
    public List<Payments> findByStatus(PaymentStatus status) {
        ServiceValidation.validateNotNull(status, "payment status");
        return paymentsRepository.findByStatus(status);
    }
}
