package org.springboot.javaunittesting.mockingPrintWriter;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportService {
    List<ReportData> getReportData(Filter filter);
}

