package ro.emanuel.project.bbms;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ro.emanuel.project.dao.ClinicDAO;
import ro.emanuel.project.pojo.Clinic;

@Controller
public class ClinicsController {

	// READ
	@RequestMapping(value = "clinics.htm")
	public ModelAndView getClinics() throws SQLException {

		ArrayList<Clinic> clinics = ClinicDAO.getClinics();

		ModelMap model = new ModelMap();
		model.put("clinicsList", clinics);

		return new ModelAndView("ClinicsJSP/clinics", model);
	}

	@RequestMapping(value = "clinics/detalii/{clinicId}")
	public ModelAndView getClinic(@PathVariable String clinicId) throws SQLException {

		Clinic clinic = ClinicDAO.getClinicById(Integer.parseInt(clinicId));

		ModelMap model = new ModelMap();
		model.put("clinic", clinic);

		return new ModelAndView("ClinicsJSP/detalii", model);
	}

	// DELETE
	@RequestMapping(value = "clinics/{clinicId}")
	public ModelAndView deleteClinic(@PathVariable String clinicId) throws SQLException {

		ClinicDAO.deleteClinicById(Integer.parseInt(clinicId));
		ArrayList<Clinic> clinics = ClinicDAO.getClinics();

		return new ModelAndView("redirect:/clinics.htm");
	}

	// CREATE
	@RequestMapping(value = "/clinics/adauga/{clinicId}")
	public ModelAndView showCreateClinic(Model model) {

		Clinic c = new Clinic();

		model.addAttribute("clinicForm", c);

		return new ModelAndView("ClinicsJSP/adauga", "model", model);

	}

	@RequestMapping(value = "/clinics/adaugaSave", method = RequestMethod.POST)
	public ModelAndView adaugaClinic(@ModelAttribute("clinicForm") Clinic clinic, ModelMap model, BindingResult result)
			throws SQLException {

		ClinicDAO.createClinic(clinic);
		return new ModelAndView("redirect:/clinics.htm");
	}

	// UPDATE
	@RequestMapping(value = "/clinics/editeaza/{clinicId}")
	public ModelAndView editDetalii(@PathVariable String clinicId, Model model)
			throws NumberFormatException, SQLException {

		Clinic c = ClinicDAO.getClinicById(Integer.parseInt(clinicId));
		model.addAttribute("clinicForm", c);

		return new ModelAndView("ClinicsJSP/edit", "model", model);

	}

	@RequestMapping(value = "/clinics/save", method = RequestMethod.POST)
	public ModelAndView saveClinic(@ModelAttribute("clinicForm") Clinic clinic, ModelMap model, BindingResult result)
			throws SQLException {

		Clinic clinicObj;
		clinicObj = ClinicDAO.getClinicById(Integer.valueOf(clinic.getId()));
		clinicObj.setDenumire(clinic.getDenumire());
		clinicObj.setAdresa(clinic.getAdresa());
		clinicObj.setTelefon(clinic.getTelefon());
		clinicObj.setEmail(clinic.getEmail());
		ClinicDAO.updateClinic(clinicObj);
		model.put("clinicForm", clinic);

		return new ModelAndView("redirect:/clinics.htm", "command", clinic);
	}
}
