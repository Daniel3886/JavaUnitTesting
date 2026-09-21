package org.springboot.javaunittesting.mockingPrintWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    public void generateReport(HttpServletRequest request,
                               HttpServletResponse response) throws IOException {
        Filter filter = parseRequest(request);
        List<ReportData> reportData = reportService.getReportData(filter);
        PrintWriter writer = response.getWriter();
        writeHeaders(writer);
        for (ReportData data : reportData) {
            writer.append(String.valueOf(data.min()));
            writer.append(",");
            writer.append(String.valueOf(data.max()));
            writer.append(",");
            writer.append(String.valueOf(data.avg()));
            writer.append("\n");
        }
    }

    private void writeHeaders(PrintWriter writer) {
        writer.append("min,max,avg\n");
    }

    private Filter parseRequest(HttpServletRequest request) {
        return new Filter() {};
    }
}

