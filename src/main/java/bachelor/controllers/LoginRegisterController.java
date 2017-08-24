package bachelor.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

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
	
	@Autowired
	private LoginRegisterService loginRegisterService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody User user, @Context HttpServletRequest request){
		User u = this.loginRegisterService.login(user);
		
		if(u != null) {
			request.getSession().setAttribute("user", u);
			return "success";
		}
		
		return "no user";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout(@Context HttpServletRequest request){
		request.getSession().invalidate();
	}
	
	@RequestMapping(value = "/getLogedUser", method = RequestMethod.GET)
	public User getLogedUser(@Context HttpServletRequest request){
		return (User) request.getSession().getAttribute("user");
	}
	
	@RequestMapping(value = "/createRegistrationReport", method = RequestMethod.POST)
	public void createRegistrationRequest(@RequestBody ReportRegistration report, @Context HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		if(user == null)
			return;
		
		this.loginRegisterService.createRegistrationReport(report, user);
	}
	
	@RequestMapping(value = "/getRegistrationReports", method = RequestMethod.GET)
	public List<ReportRegistration> getRegistrationReports(){
		return this.loginRegisterService.getReportRegistrations();
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(@RequestBody ReportRegistration rr, @Context HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		if(user == null)
			return;
		
		this.loginRegisterService.register(rr, user);
	}
}
