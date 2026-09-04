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

import university.management.entity.Payments;
import university.management.entity.PaymentMethod;
import university.management.entity.PaymentStatus;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Long> {

    Optional<Payments> findById(Long id);
    List<Payments> findByStudents_Id(Long studentId);
    List<Payments> findByAmount(Double amount);
    List<Payments> findByPaymentDate(LocalDate paymentDate);
    List<Payments> findByMethod(PaymentMethod method);
    List<Payments> findByStatus(PaymentStatus status);

    @Transactional
    @Modifying
    @Query("delete from Payments p where p.id = :id")
    int deletePaymentById(@Param("id") Long id);
}
