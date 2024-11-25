package zw.co.afrocodemy;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReportingServiceImpl implements ReportingService {
    private final DataSource dataSource;
    @Override
    public byte[] processReport(String reportName, Map<String, Object> params) throws SQLException, JRException {
         byte[] bytes;

        System.out.println("Report name: " + reportName);
        InputStream jasperStream = this.getClass().getClassLoader().getResourceAsStream("templates/reports/" + reportName + ".jasper");


        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        Connection con = dataSource.getConnection();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);

        con.close();
        bytes = JasperExportManager.exportReportToPdf(jasperPrint);
        return bytes;
    }
}
