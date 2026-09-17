package org.springboot.javaunittesting.beGeneric;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


public class PacketServletTest {

    private static final String PACKET = "packet";
    private static final String TYPE = "type";

    @Mock
    HttpServletRequest request;
    @Mock
    PacketDataProcessor packetDataProcessor;
    @Mock
    HttpServletResponse response;
    @InjectMocks
    PacketServlet servlet;

    @Test
    void shouldProcessPacket() throws ServletException, IOException {
        // given
        given(request.getParameter(PacketApi.PACKET_PARAMETER))
                .willReturn(PACKET);
        given(request.getParameter(PacketApi.TYPE_PARAMETER))
                .willReturn(TYPE);

        // when
        servlet.doGet(request, response);

        // then
        verify(packetDataProcessor).process(PACKET, TYPE);
    }

    // "If one of the required
    // parameters is missing, then packetDataProcessor should process nothing"
    @Test
    void shouldProcessIfPacketParameterIsMissing() throws ServletException, IOException {
        // given
        given(request.getParameter(PacketApi.PACKET_PARAMETER))
                .willReturn(PACKET);

        // when
        servlet.doGet(request, response);

        // then
        verifyNoInteractions(packetDataProcessor); // processes nothing and allows us to generalize the test
    }

    @Test
    void shouldReturnStatus500IfThereWasAnErrorDuringProcessing_Improved() throws ServletException, IOException {
        // given
        given(request.getParameter(PacketApi.PACKET_PARAMETER))
                .willReturn(PACKET);
        given(request.getParameter(PacketApi.TYPE_PARAMETER))
                .willReturn(TYPE);
        doThrow(Exception.class) // generalize, don't use a specific exceptions, because the test won't cover other cases
                .when(packetDataProcessor).process(PACKET, TYPE);

        // when
        servlet.doGet(request, response);

        // then
        verify(response).setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }

}
