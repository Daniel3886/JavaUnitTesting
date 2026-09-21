package org.springboot.javaunittesting.mockingPrintWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

class ReportControllerTest {

    @Mock
    HttpServletRequest req;
    @Mock
    HttpServletResponse res;
    @Mock
    ReportService reportService;

    @InjectMocks
    ReportController reportController;

    @Test
    void shouldWriteReportData() throws IOException {
        // given
        // instead of making PrintWriter a mock, we can use a real PrintWriter that writes to a StringWriter,
        // which allows us to capture the output and verify it
        ReportData dataPl = new ReportData(1, 2, 1.5); // also split the report data into two separate instances
        ReportData dataFr = new ReportData(3, 4, 0.12345); //  to make the test more realistic

        Writer stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        given(res.getWriter()).willReturn(writer);
        given(reportService.getReportData(any(Filter.class)))
                .willReturn(Arrays.asList(dataPl, dataFr));

        // when
        reportController.generateReport(req, res);

        // then
        // verify output in a simpler format which wont break if the order changes
        assertThat(stringWriter.toString())
                .isEqualTo("min,max,avg\n1,2,1.5\n3,4,0.12345\n");
    }

}