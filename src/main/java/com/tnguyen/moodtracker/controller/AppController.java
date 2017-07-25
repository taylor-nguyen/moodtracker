package com.tnguyen.moodtracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller to pass to the view in front end
 *
 * @author Taylor Nguyen
 */
@Controller
public class AppController {
	@RequestMapping("/")
	public String home() {
		return "index";
	}

}
