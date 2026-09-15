package org.springboot.javaunittesting.expectedExceptionsAndVerification;

public interface DomainService {
    void saveDomain(Domain domain, boolean registeredInDns, int tryNb);
}

