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

import ro.emanuel.project.dao.BloodGroupDAO;
import ro.emanuel.project.pojo.BloodGroup;

@Controller
public class BloodGroupsController {
	@RequestMapping(value = "bloodGroups.htm")

	public ModelAndView getBloodGroups() throws SQLException {

		ArrayList<BloodGroup> bloodGroups = BloodGroupDAO.getBloodGroups();

		ModelMap model = new ModelMap();
		model.put("bloodGroupsList", bloodGroups);

		return new ModelAndView("BloodGroupsJSP/bloodGroups", model);
	}

	@RequestMapping(value = "bloodGroups/detalii/{bloodGroupId}")
	public ModelAndView getBloodGroup(@PathVariable String bloodGroupId) throws SQLException {

		BloodGroup bloodGroup = BloodGroupDAO.getBloodGroupById(Integer.parseInt(bloodGroupId));

		ModelMap model = new ModelMap();
		model.put("bloodGroup", bloodGroup);

		return new ModelAndView("BloodGroupsJSP/detalii", model);
	}

	// DELETE
	@RequestMapping(value = "bloodGroups/{bloodGroupId}")
	public ModelAndView deleteBloodGroup(@PathVariable String bloodGroupId) throws SQLException {

		BloodGroupDAO.deleteBloodGroupById(Integer.parseInt(bloodGroupId));
		ArrayList<BloodGroup> bloodGroups = BloodGroupDAO.getBloodGroups();

		return new ModelAndView("redirect:/bloodGroups.htm");
	}

	// CREATE
	@RequestMapping(value = "/bloodGroups/adauga/{bloodGroupId}")
	public ModelAndView showCreateBloodGroup(Model model) {

		BloodGroup bg = new BloodGroup();

		model.addAttribute("bloodGroupForm", bg);

		return new ModelAndView("BloodGroupsJSP/adauga", "model", model);

	}

	@RequestMapping(value = "/bloodGroups/adaugaSave", method = RequestMethod.POST)
	public ModelAndView adaugaBloodGroup(@ModelAttribute("bloodGroupForm") BloodGroup bloodGroup, ModelMap model,
			BindingResult result) throws SQLException {

		BloodGroupDAO.createBloodGroup(bloodGroup);
		return new ModelAndView("redirect:/bloodGroups.htm");
	}

	// UPDATE
	@RequestMapping(value = "/bloodGroups/editeaza/{bloodGroupId}")
	public ModelAndView editDetalii(@PathVariable String bloodGroupId, Model model)
			throws NumberFormatException, SQLException {

		BloodGroup bg = BloodGroupDAO.getBloodGroupById(Integer.parseInt(bloodGroupId));
		model.addAttribute("bloodGroupForm", bg);

		return new ModelAndView("BloodGroupsJSP/edit", "model", model);

	}

	@RequestMapping(value = "/bloodGroups/save", method = RequestMethod.POST)
	public ModelAndView saveBloodGroup(@ModelAttribute("bloodGroupForm") BloodGroup bloodGroup, ModelMap model,
			BindingResult result) throws SQLException {

		BloodGroup bloodGroupObj;
		bloodGroupObj = BloodGroupDAO.getBloodGroupById(Integer.valueOf(bloodGroup.getId()));
		bloodGroupObj.setType(bloodGroup.getType());
		bloodGroupObj.setRh(bloodGroup.getRh());
		bloodGroupObj.setDescription(bloodGroup.getDescription());
		BloodGroupDAO.updateBloodGroup(bloodGroupObj);
		model.put("bloodGroupForm", bloodGroup);

		return new ModelAndView("redirect:/bloodGroups.htm", "command", bloodGroup);
	}

}
