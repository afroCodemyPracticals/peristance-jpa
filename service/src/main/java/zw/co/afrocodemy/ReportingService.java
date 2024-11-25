package zw.co.afrocodemy;

import net.sf.jasperreports.engine.JRException;

import java.sql.SQLException;
import java.util.Map;

public interface ReportingService {

    byte[] processReport(String reportName, Map<String, Object> params) throws  SQLException, JRException;
}
