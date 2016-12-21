package com.greenfinch.signup.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.greenfinch.signup.model.User;
import com.greenfinch.signup.service.UserService;

@Controller
public class SignupController implements MessageSourceAware{

	@Autowired
	UserService userService;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView signUpForm() {
		ModelAndView mv = new ModelAndView("SignUp.jsp");
		return mv;
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public ModelAndView submit(@Valid @ModelAttribute("user") User user,
			BindingResult result) {

		if (result.hasErrors()) {
			ModelAndView mv = new ModelAndView("SignUp.jsp");
			return mv;
		} else if (!userService.isValidUser(user.getUserName())) {
			ModelAndView mv = new ModelAndView("SignUp.jsp");
			mv.addObject("errorMessage", user.getUserName()
					+ getTextfromMessageSource("Unique.user.password"));
			return mv;
		} else {
			userService.addUser(user);
			ModelAndView mv = new ModelAndView("SubmitSucess.jsp");
			mv.addObject("successMessage", user.getUserName()
					+ getTextfromMessageSource("home.signup.sucess"));
			return mv;
		}
	}

	private MessageSource messageSource;
	
	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	private String getTextfromMessageSource(String id) {
		return messageSource.getMessage(id, null, null);
	}
}
