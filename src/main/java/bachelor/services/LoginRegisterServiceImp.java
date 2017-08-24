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
	
	public User login(User user) {
		
		List<User> list = this.userRepo.findByUsername(user.getUsername());
		
		if(list.size() == 0)
			return null;
		
		if(!(list.get(0).getPassword().equals(user.getPassword())))
			return null;
		
		return list.get(0);
	}

	public void createRegistrationReport(ReportRegistration rr, User user) {
		rr.setManager(user);
		this.registrationReportRepo.save(rr);
	}

	public List<ReportRegistration> getReportRegistrations() {
		return this.registrationReportRepo.findByExecuted(false);
	}

	public void register(ReportRegistration rr, User u) {
		rr.setExecuted(true);
		rr.setAdmin(u);
		this.registrationReportRepo.save(rr);
		
		User user = new User();
		user.setAddress(rr.getAddress());
		user.setEmail(rr.getEmail());
		user.setName(rr.getName());
		user.setPhone(rr.getPhone());
		user.setProffesion(rr.getProffesion());
		user.setSurname(rr.getSurname());
		user.setUsername(rr.getUsername());
		user.setPassword(rr.getPassword());

		this.userRepo.save(user);
	}


}
