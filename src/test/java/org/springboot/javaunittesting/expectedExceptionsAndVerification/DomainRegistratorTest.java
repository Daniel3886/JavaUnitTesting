package org.springboot.javaunittesting.expectedExceptionsAndVerification;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class DomainRegistratorTest {

    // mocking the dependencies of the class under test (DomainRegistrator)
    @Mock
    private DnsService dnsService;
    @Mock
    private DomainService domainService;
    @Mock
    private Domain domain;

    @InjectMocks // gives a real instance of the object and we dont need to make the new DomainRegistator();
    private DomainRegistrator domainRegistrator;

//    private DomainRegistrator domainRegistrator = new DomainRegistrator(); the same as the above line

    private static final String DOMAIN_ADDRESS = "example.com";
    private static final int DNS_FAILURES = 1;

    @Test
    void shouldSaveFailureInformationWhenExceptionOccurWhenAddingDomain() {
         // given
        doThrow(new RuntimeException())
                .when(dnsService)
                .addDomainIfMissing(DOMAIN_ADDRESS);

        // when - then
        verify(domainService)
                .saveDomain(domain, false, DNS_FAILURES + 1);

        assertThrows(
                RuntimeException.class,
                () -> domainRegistrator.registerDomain(domain)
        );
    }
}