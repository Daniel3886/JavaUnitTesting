package org.springboot.javaunittesting.expectedExceptionsAndVerification;

public interface Domain {
    String getAddress();

    boolean isRegisteredInDns();

    int getDnsFailures();
}

