package ifrn.pi.vendasperfumes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

	@RequestMapping("/")
	public String index() {
		System.out.println("chamou o método index");
		return "home";
	}
	
}
