package com.sonal.flashcardapp.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sonal.flashcardapp.domain.FcUsers;
import com.sonal.flashcardapp.exceptions.UserNotFoundException;
import com.sonal.flashcardapp.services.UserService;
import com.sonal.flashcardapp.validations.LoginValidator;
import com.sonal.flashcardapp.validations.UserLoginInfo;


@Controller
public class UserRegistrationController {
	private static final Logger logger = LoggerFactory.getLogger(UserRegistrationController.class);
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/userRegistrationForm", method=RequestMethod.GET)
	public ModelAndView registration() {
		//return "userRegistrationForm";
		ModelAndView modelView;
		modelView = new ModelAndView("userRegistrationForm");
		modelView.addObject("fcusers", new FcUsers());
		return modelView;
	}
	
	@RequestMapping(value = "/processuserRegistrationForm", method=RequestMethod.POST) 
	//public ModelAndView processRegistration(FcUsers newUser, HttpSession session) {
	public ModelAndView processRegistration(@ModelAttribute("fcusers") @Valid FcUsers newUser, BindingResult result, HttpSession session) {
		ModelAndView modelView;
		
		if (result.hasErrors()) {
		 // Re-present the form with error messages 
		modelView = new ModelAndView("userRegistrationForm");
		return modelView;
	}
		
		modelView = new ModelAndView("editOrSubmitNewUserForm");
		session.setAttribute("fcuser", newUser);
		modelView.addObject("fcuser", newUser);
		return modelView;
	}
	
	@RequestMapping(value = "/editOrStoreUserProfile", method=RequestMethod.POST, params="createProfile") 
	public ModelAndView storeNewUserProfile(HttpSession session){
		FcUsers fcuser;
		ModelAndView modelView;
		
		try {
		fcuser = (FcUsers) session.getAttribute("fcuser");
		userService.addNewUser(fcuser);
		logger.info("Adding new user in processuserRegistrationForm " + fcuser.toString());
		modelView = new ModelAndView("newUserProfileSuccess");
		modelView.addObject("fcuser", fcuser);
		session.setAttribute("fcuser", fcuser);
		return modelView;
		}catch(Exception ex) {
			modelView = new ModelAndView("userRegistrationForm");
			modelView.addObject(ex.getLocalizedMessage());
			return modelView;
		}
	}
	
	@RequestMapping(value = "/loginForm", method=RequestMethod.GET) 
	public ModelAndView login() {
		ModelAndView modelView;
		modelView = new ModelAndView("loginForm");
		modelView.addObject("fcusers", new FcUsers());
		return modelView;
	}
	
	@RequestMapping(value = "/processlogin", method = RequestMethod.POST)
	//public ModelAndView processLogin(String email, HttpSession session) 
	public ModelAndView processLogin(@ModelAttribute("fcusers") @Valid FcUsers fcusers, BindingResult result, HttpSession session) 
	{
		ModelAndView modelView;
		
		/*logger.info("email in user controller : " + fcusers.getEmail());
		logger.info(result.toString());
		if (result.hasErrors()) {
			 // Re-present the form with error messages 
			logger.info("errors in login " );
			modelView = new ModelAndView("loginForm");
			return modelView;
		}*/
		
		logger.info("email in user controller : " + fcusers.getEmail());
		
		FcUsers fcusersin = userService.loginUser(fcusers);
		session.setAttribute("fcusers", fcusersin);
		//session.getAttribute("fcusers");
		modelView = new ModelAndView("loginSuccess");
		modelView.addObject("fcusers", fcusersin);
		return modelView;
		}
	
	/*@RequestMapping(value = "/processlogin", method = RequestMethod.POST)
	public ModelAndView processLogin(@ModelAttribute("loginInfo") @Valid UserLoginInfo loginInfo, BindingResult result, HttpSession session) {
		String email;
		LoginValidator loginValidation = new LoginValidator();
		loginValidation.validate(loginInfo.toString(), result);
		ModelAndView modelView;
		
		if (result.hasErrors()) {
			 // Re-present the form with error messages 
			logger.info("errors in login " );
			modelView = new ModelAndView("loginForm");
			return modelView;
		}
		
		logger.info("login email " + loginInfo.toString());
		modelView = new ModelAndView("loginSuccess");
		return modelView;
		
	}*/
	
}

	