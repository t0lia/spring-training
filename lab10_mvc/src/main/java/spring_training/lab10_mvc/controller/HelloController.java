package spring_training.lab10_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring_training.lab10_mvc.repo.CountryDao;

@Controller
public class HelloController {

	@Autowired
	private CountryDao countryDao;

	@RequestMapping(value="/index")
	public String index(Model model){
		model.addAttribute("all", countryDao.getAll());
		return "forward:index.jsp";
	}
	
}
