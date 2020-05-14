/*
 * Copyright (c) by censhare AG
 */
package guru.springframework.ssm.springstatemachinetest.services;

import guru.springframework.ssm.springstatemachinetest.domain.Payment;
import guru.springframework.ssm.springstatemachinetest.domain.PaymentEvent;
import guru.springframework.ssm.springstatemachinetest.domain.PaymentState;
import guru.springframework.ssm.springstatemachinetest.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Service;

/**
 * Service impl
 *
 * @author Martin Wunderlich
 */
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final StateMachineFactory<PaymentState, PaymentEvent> stateMachineFactory;

    @Override
    public Payment newPayment(Payment payment) {
        payment.setPaymentState(PaymentState.NEW);

        return paymentRepository.save(payment);
    }

    @Override
    public StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId) {
        return null;
    }

    @Override
    public StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId) {
        return null;
    }

    @Override
    public StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId) {
        return null;
    }
}
