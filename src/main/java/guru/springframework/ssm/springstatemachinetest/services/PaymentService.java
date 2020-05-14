package guru.springframework.ssm.springstatemachinetest.services;

import guru.springframework.ssm.springstatemachinetest.domain.Payment;
import guru.springframework.ssm.springstatemachinetest.domain.PaymentEvent;
import guru.springframework.ssm.springstatemachinetest.domain.PaymentState;
import org.springframework.statemachine.StateMachine;

public interface PaymentService {

    Payment newPayment(Payment payment);

    StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId);
}
