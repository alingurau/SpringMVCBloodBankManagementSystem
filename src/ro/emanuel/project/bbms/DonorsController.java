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

import ro.emanuel.project.dao.DonorDAO;
import ro.emanuel.project.pojo.Donor;

@Controller
public class DonorsController {

	// READ
	@RequestMapping(value = "donors.htm")
	public ModelAndView getDonors() throws SQLException {

		ArrayList<Donor> donors = DonorDAO.getDonors();

		ModelMap model = new ModelMap();
		model.put("donorsList", donors);

		return new ModelAndView("DonorsJSP/donors", model);
	}

	@RequestMapping(value = "donors/detalii/{donorId}")
	public ModelAndView getDonor(@PathVariable String donorId) throws SQLException {

		Donor donor = DonorDAO.getDonorById(Integer.parseInt(donorId));

		ModelMap model = new ModelMap();
		model.put("donor", donor);

		return new ModelAndView("DonorsJSP/detalii", model);
	}

	// DELETE
	@RequestMapping(value = "donors/{donorId}")
	public ModelAndView deleteDonor(@PathVariable String donorId) throws SQLException {

		DonorDAO.deleteDonorById(Integer.parseInt(donorId));
		ArrayList<Donor> donors = DonorDAO.getDonors();

		return new ModelAndView("redirect:/donors.htm");
	}

	// CREATE
	@RequestMapping(value = "/donors/adauga/{donorId}")
	public ModelAndView showCreateDonor(Model model) {

		Donor d = new Donor();

		model.addAttribute("donorForm", d);

		return new ModelAndView("DonorsJSP/adauga", "model", model);

	}

	@RequestMapping(value = "/donors/adaugaSave", method = RequestMethod.POST)
	public ModelAndView adaugaDonor(@ModelAttribute("donorForm") Donor donor, ModelMap model, BindingResult result)
			throws SQLException {

		DonorDAO.createDonor(donor);
		return new ModelAndView("redirect:/donors.htm");
	}

	// UPDATE
	@RequestMapping(value = "/donors/editeaza/{donorId}")
	public ModelAndView editDetalii(@PathVariable String donorId, Model model)
			throws NumberFormatException, SQLException {

		Donor d = DonorDAO.getDonorById(Integer.parseInt(donorId));
		model.addAttribute("donorForm", d);

		return new ModelAndView("DonorsJSP/edit", "model", model);

	}

	@RequestMapping(value = "/donors/save", method = RequestMethod.POST)
	public ModelAndView saveDonor(@ModelAttribute("donorForm") Donor donor, ModelMap model, BindingResult result)
			throws SQLException {

		Donor donorObj;
		donorObj = DonorDAO.getDonorById(Integer.valueOf(donor.getId()));
		donorObj.setNume(donor.getNume());
		donorObj.setPrenume(donor.getPrenume());
		donorObj.setCnp(donor.getCnp());
		donorObj.setAdresa(donor.getAdresa());
		donorObj.setEmail(donor.getEmail());
		donorObj.setNumarTelefon(donor.getNumarTelefon());
		DonorDAO.updateDonor(donorObj);
		model.put("donorForm", donor);

		return new ModelAndView("redirect:/donors.htm", "command", donor);
	}

}
