package guru.springframework.ssm.springstatemachinetest.repository;

import guru.springframework.ssm.springstatemachinetest.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
