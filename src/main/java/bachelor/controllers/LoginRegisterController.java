package bachelor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bachelor.beans.ReportRegistration;
import bachelor.beans.User;
import bachelor.services.LoginRegisterService;

@RestController
@RequestMapping("/loginRegister")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginRegisterController {
	
	private String host = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "bachelor", password = "bachelor";
	
	@Autowired
	private LoginRegisterService loginRegisterService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody User user){
		return this.loginRegisterService.login(user);
	}
	
	@RequestMapping(value = "/createRegistrationReport", method = RequestMethod.POST)
	public void createRegistrationRequest(@RequestBody ReportRegistration report){
		System.out.println(report);
		this.loginRegisterService.createRegistrationReport(report);
	}
	
	@RequestMapping(value = "/getRegistrationReports", method = RequestMethod.GET)
	public List<ReportRegistration> getRegistrationReports(){
		return this.loginRegisterService.getReportRegistrations();
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(@RequestBody ReportRegistration rr){
		this.loginRegisterService.register(rr);
	}
	
	@RequestMapping(value = "/testReports", method = RequestMethod.GET)
	public void testReports(){
		/*Connection conn;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(host, username, password);
            
            InputStream is = this.getClass().getClassLoader().getResourceAsStream("");

            JasperPrint print = JasperFillManager.fillReport(is, parameters, conn);
            JasperExportManager.exportReportToPdfFile(print, destinationPath + templateName +"_"+ dateFormat.format(date) + ".pdf");
            
            is.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}*/
		
		/*HashMap<String,Object> hm = null;
		// System.out.println("Usage: ReportGenerator ....");

		try {
			System.out.println("Start ....");
			// Get jasper report
			String jasperFileName = "D:\\bachelor\\backend\\bachelor-backend\\report1.jasper";
			String pdfFileName = "D:\\bachelor\\backend\\bachelor-backend\\report1.pdf";

			// String dbUrl = props.getProperty("jdbc.url");
			String dbUrl = "jdbc:oracle:thin:@//localhost:1521/xe";
			// String dbDriver = props.getProperty("jdbc.driver");
			String dbDriver = "oracle.jdbc.OracleDriver";
			// String dbUname = props.getProperty("db.username");
			String dbUname = "bachelor";
			// String dbPwd = props.getProperty("db.password");
			String dbPwd = "bachelor";

			// Load the JDBC driver
			Class.forName(dbDriver);
			// Get the connection
			Connection conn = DriverManager
					.getConnection(dbUrl, dbUname, dbPwd);

			// Create arguments
			// Map params = new HashMap();
			hm = new HashMap<String,Object>();
			hm.put(JRParameter.REPORT_CONNECTION, conn);

			// Generate jasper print
			System.out.println(jasperFileName + " " + hm + " " + conn);
			Object o = JasperFillManager.fillReport(jasperFileName, null ,conn);
			System.out.println(o);
			JasperPrint jprint = (JasperPrint)o;
			InputStream is = this.getClass().getClassLoader().getResourceAsStream(jasperFileName);
			JasperPrint jprint = JasperFillManager.fillReport(is, hm, conn);
			JasperExportManager.exportReportToPdfFile(jprint, pdfFileName + ".pdf");
			
			// Export pdf file
			//JasperExportManager.exportReportToPdfFile(jprint, pdfFileName);

			System.out.println("Done exporting reports to pdf");

		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
	}
}
