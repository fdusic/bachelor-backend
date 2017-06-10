package bachelor.services;

import java.util.List;

import bachelor.beans.ReportRegistration;
import bachelor.beans.User;

public interface LoginRegisterService {

	public String login(User user);
	public void createRegistrationReport(ReportRegistration rr);
	public List<ReportRegistration> getReportRegistrations();
	public void register(ReportRegistration rr);
	
}
