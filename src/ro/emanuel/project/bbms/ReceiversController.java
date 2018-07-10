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

import ro.emanuel.project.dao.ReceiverDAO;
import ro.emanuel.project.pojo.Receiver;

@Controller
public class ReceiversController {

	// READ

	@RequestMapping(value = "receivers.htm")
	public ModelAndView getReceivers() throws SQLException {

		ArrayList<Receiver> receivers = ReceiverDAO.getReceivers();

		ModelMap model = new ModelMap();
		model.put("receiversList", receivers);

		return new ModelAndView("ReceiversJSP/receivers", model);
	}

	@RequestMapping(value = "receivers/detalii/{receiverId}")
	public ModelAndView getReceiver(@PathVariable String receiverId) throws SQLException {

		Receiver receiver = ReceiverDAO.getReceiverById(Integer.parseInt(receiverId));

		ModelMap model = new ModelMap();
		model.put("receiver", receiver);

		return new ModelAndView("ReceiversJSP/detalii", model);
	}

	// DELETE
	@RequestMapping(value = "receivers/{receiverId}")
	public ModelAndView deleteReceiver(@PathVariable String receiverId) throws SQLException {

		ReceiverDAO.deleteReceiverById(Integer.parseInt(receiverId));
		ArrayList<Receiver> receivers = ReceiverDAO.getReceivers();

		return new ModelAndView("redirect:/receivers.htm");
	}

	// CREATE
	@RequestMapping(value = "/receivers/adauga/{receiverId}")
	public ModelAndView showCreateReceiver(Model model) {

		Receiver r = new Receiver();

		model.addAttribute("receiverForm", r);

		return new ModelAndView("ReceiversJSP/adauga", "model", model);

	}

	@RequestMapping(value = "/receivers/adaugaSave", method = RequestMethod.POST)
	public ModelAndView adaugaReceiver(@ModelAttribute("receiversForm") Receiver receiver, ModelMap model,
			BindingResult result) throws SQLException {

		ReceiverDAO.createReceiver(receiver);
		return new ModelAndView("redirect:/receivers.htm");
	}

	// UPDATE
	@RequestMapping(value = "/receivers/editeaza/{receiverId}")
	public ModelAndView editDetalii(@PathVariable String receiverId, Model model)
			throws NumberFormatException, SQLException {

		Receiver r = ReceiverDAO.getReceiverById(Integer.parseInt(receiverId));
		model.addAttribute("receiverForm", r);

		return new ModelAndView("ReceiversJSP/edit", "model", model);

	}

	@RequestMapping(value = "/receivers/save", method = RequestMethod.POST)
	public ModelAndView saveReceiver(@ModelAttribute("receiverForm") Receiver receiver, ModelMap model,
			BindingResult result) throws SQLException {

		Receiver receiverObj;
		receiverObj = ReceiverDAO.getReceiverById(Integer.valueOf(receiver.getId()));
		receiverObj.setNume(receiver.getNume());
		receiverObj.setPrenume(receiver.getPrenume());
		receiverObj.setGen(receiver.getGen());
		receiverObj.setCnp(receiver.getCnp());
		receiverObj.setAdresa(receiver.getAdresa());
		receiverObj.setEmail(receiver.getEmail());
		receiverObj.setNumarTelefon(receiver.getNumarTelefon());
		ReceiverDAO.updateReceiver(receiverObj);
		model.put("receiverForm", receiver);

		return new ModelAndView("redirect:/receivers.htm", "command", receiver);
	}
}
