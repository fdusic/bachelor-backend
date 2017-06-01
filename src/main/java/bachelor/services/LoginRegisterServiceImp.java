package bachelor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bachelor.beans.ReportRegistration;
import bachelor.beans.User;
import bachelor.repositories.RegistrationReportRepo;
import bachelor.repositories.UserRepo;

@Service
public class LoginRegisterServiceImp implements LoginRegisterService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RegistrationReportRepo registrationReportRepo;
	
	public String login(User user) {
		
		List<User> list = this.userRepo.findByUsername(user.getUsername());
		
		if(list.size() == 0)
			return "no user";
		
		if(!(list.get(0).getPassword().equals(user.getPassword())))
			return "wrong password";
		
		return "success";
	}

	public void createRegistrationReport(ReportRegistration rr) {
		this.registrationReportRepo.save(rr);
	}

	public void register(ReportRegistration rr) {
		rr.setExecuted(true);
		this.registrationReportRepo.save(rr);
		
		User user = new User();
		user.setAddress(rr.getAddress());
		user.setEmail(rr.getEmail());
		user.setName(rr.getName());
		user.setPhone(rr.getPhone());
		user.setProffesion(rr.getProffesion());
		user.setSurname(rr.getSurname());
		user.setUsername(rr.getUsername());

		this.userRepo.save(user);
	}

}
