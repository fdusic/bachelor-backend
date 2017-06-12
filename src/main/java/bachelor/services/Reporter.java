package bachelor.services;

 
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class Reporter {
	
	private Connection conn;
	private String templateName;
	private String templatePath;
	private String destinationPath;
	private Map<String, Object> parameters;
	
	
	public Reporter(){}
	
	public Reporter(String templatePath, String templateName,  Map<String, Object> parameters, String destinationPath){
		this.templatePath = templatePath;
		this.templateName = templateName;
		this.parameters = parameters;
		this.destinationPath = destinationPath;
	}
	
	public void setParams(String templatePath, String templateName, Map<String, Object> parameters, String destinationPath){
		this.templatePath = templatePath;
		this.templateName = templateName;
		this.parameters = parameters;
		this.destinationPath = destinationPath;
	}
	
	protected void  initConnection(){
        
        String HOST = "jdbc:oracle:thin:@//localhost:1521/xe";
        String USERNAME = "bachelor";
        String PASSWORD = "bachelor";
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
 
        try {
            conn = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
	
	protected void  closeConnection(){
		if (conn != null) {
			try { 
				conn.close(); 
			} catch (Exception e) {}
		}
	}
	
	protected void generatePdfReport () {
    	
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		
		Date date = new Date();
		try {		
			//Path to your .jasper file in your package
			String reportPathName = templatePath + templateName + ".jasper";
			System.out.println(reportPathName);
	        //Get a stream to read the file
	        InputStream is = this.getClass().getClassLoader().getResourceAsStream(reportPathName.trim());
			// fills compiled report with parameters and a connection
	        System.out.println(is + " " + parameters + " " + conn);
			JasperPrint print = JasperFillManager.fillReport(is, parameters, conn);
			// exports report to pdf
			JasperExportManager.exportReportToPdfFile(print, destinationPath + templateName +"_"+ dateFormat.format(date) + ".pdf");
			//JasperExportManager.exportReportToHtmlFile(print, destinationPath + templateName +"_"+ dateFormat.format(date) + ".html");
			JOptionPane.showMessageDialog(null, "Uspje�no generisan izvje�taj.", "Generisan izvje�taj", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			throw new RuntimeException("It's not possible to generate the pdf report.", e);
		}
    }
	
	public void generateReport() {
		initConnection();
		generatePdfReport();
		closeConnection();
	}
}