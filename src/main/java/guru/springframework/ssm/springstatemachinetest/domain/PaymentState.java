/*
 * Copyright (c) by censhare AG
 */
package guru.springframework.ssm.springstatemachinetest.domain;

/**
 * Enum for payment states
 *
 * @author Martin Wunderlich
 */
public enum PaymentState {
    NEW, PRE_AUTH, PRE_AUTH_ERROR, AUTH, AUTH_ERROR
}
