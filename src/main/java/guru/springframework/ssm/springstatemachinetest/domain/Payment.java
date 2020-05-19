/*
 * Copyright (c) by censhare AG
 */
package guru.springframework.ssm.springstatemachinetest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Payment entity
 *
 * @author Martin Wunderlich
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {

    @Id
    @GeneratedValue
    private Long id;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private PaymentState paymentState;
}
