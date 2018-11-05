package spring_training.lab10_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import spring_training.lab10_mvc.model.Country;
import spring_training.lab10_mvc.repo.CountryDao;

@Controller
@SessionAttributes("country")
public class CountryController {

	@Autowired
	private CountryDao countryDao;

	@RequestMapping(value="/country", method = RequestMethod.GET)
	public String displayCountryPage(Model model) {
		Country country = new Country();

		country.setName("input name");
		country.setCodeName("input code");

		model.addAttribute("country", country);
	
		return "country";
	}
	
	@RequestMapping(value="/country", method = RequestMethod.POST)
	public String processCountry(@ModelAttribute("country") Country country) {
		countryDao.save(country);
		return "redirect:index.html";
	}
}
