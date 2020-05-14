package guru.springframework.ssm.springstatemachinetest.services;

import guru.springframework.ssm.springstatemachinetest.domain.Payment;
import guru.springframework.ssm.springstatemachinetest.domain.PaymentEvent;
import guru.springframework.ssm.springstatemachinetest.domain.PaymentState;
import guru.springframework.ssm.springstatemachinetest.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.support.StateMachineInterceptorAdapter;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * For intercepting the event that is sent to the state machine and
 * adjust state in DB
 *
 * @author Martin Wunderlich
 */
@RequiredArgsConstructor
@Component
public class PaymentStateChangeInterceptor extends StateMachineInterceptorAdapter<PaymentState, PaymentEvent> {

    private final PaymentRepository paymentRepository;

    @Override
    public void preStateChange(State<PaymentState, PaymentEvent> state, Message<PaymentEvent> message, Transition<PaymentState, PaymentEvent> transition, StateMachine<PaymentState, PaymentEvent> stateMachine) {

        Optional.ofNullable(message).ifPresent(msg -> {
            Optional.ofNullable(Long.class.cast(msg.getHeaders().getOrDefault(PaymentServiceImpl.PAYMENT_ID_HEADER, -1L)))
                    .ifPresent(paymendId -> {
                        Payment payment = paymentRepository.getOne(paymendId);
                        payment.setPaymentState(state.getId());
                        paymentRepository.save(payment);
                    });
        } );
    }
}
