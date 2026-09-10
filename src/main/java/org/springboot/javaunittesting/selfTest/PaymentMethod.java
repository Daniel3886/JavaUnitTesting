package org.springboot.javaunittesting.selfTest;

import java.util.ArrayList;
import java.util.List;

public enum PaymentMethod {

    VISA, MASTERCARD, BANK_TRANSFER;

    public boolean isEligibleForCountry(String country) {
        return false;
    }

    public static List<PaymentMethod> getMethodsForCountry(
            String country, List<PaymentMethod> availableMethods) {
        List<PaymentMethod> methodsForCountry = new ArrayList<>();
        for (PaymentMethod method : availableMethods) {
            if (method.isEligibleForCountry(country)) {
                methodsForCountry.add(method);
            }
        }
        return methodsForCountry;
    }
}

