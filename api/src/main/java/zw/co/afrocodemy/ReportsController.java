package zw.co.afrocodemy;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reports")
public class ReportsController {

    private final ReportingService reportingService;

//    @GetMapping("/students")
//    @Operation(description = "get all reports")
//    public @ResponseBody ResponseEntity<byte[]> getReport() throws IOException, JRException, SQLException {
//        Map<String, Object> params = new HashMap<>();
//
//        String fileName = "AfrocodemyLecture_Demo";
//        String reportName = "AfrocodemyLecture_Demo";
//
//        return ResponseEntity.ok(reportingService.processReport(reportName, params));
//    }

    @GetMapping("/students")
    @Operation(description = "get all reports")
    public  @ResponseBody ResponseEntity<byte[]> getReports()throws IOException, SQLException, JRException {
        Map<String, Object> params = new HashMap<>();

        String fileName = "AfrocodemyLecture_Demo";
        String reportName = "AfrocodemyLecture_Demo";
        byte[] bytes = reportingService.processReport(reportName, params);

        return ResponseEntity.ok()
                .header("Content-Type", "application/pdf; charset=UTF-8")
                .header("Content-Disposition", "inline;filename=\""+fileName+".pdf\"")
                .body(bytes);
    }

}
