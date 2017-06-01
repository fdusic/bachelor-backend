package bachelor.controllers;

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
@CrossOrigin
public class LoginRegisterController {
	
	@Autowired
	private LoginRegisterService loginRegisterService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody User user){
		return this.loginRegisterService.login(user);
	}
	
	@RequestMapping(value = "/createRegistrationReport", method = RequestMethod.POST)
	public void createRegistrationRequest(@RequestBody ReportRegistration report){
		this.loginRegisterService.createRegistrationReport(report);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(@RequestBody ReportRegistration rr){
		this.loginRegisterService.register(rr);
	}
}
