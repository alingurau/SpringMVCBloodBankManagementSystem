package ro.emanuel.project.bbms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontPageController {
	@RequestMapping(value = "frontPage.htm")
	public ModelAndView getIndex() {
		ModelMap model = new ModelMap();

		return new ModelAndView("frontPage", model);

	}
}
