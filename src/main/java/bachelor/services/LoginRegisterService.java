package bachelor.services;

import bachelor.beans.ReportRegistration;
import bachelor.beans.User;

public interface LoginRegisterService {

	public String login(User user);
	public void createRegistrationReport(ReportRegistration rr);
	public void register(ReportRegistration rr);
	
}
