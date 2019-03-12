package ca.sheridancollege;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.sheridancollege.beans.Person;
import ca.sheridancollege.dao.DAO;

@Controller
public class HomeController {

	DAO dao = new DAO();

	@RequestMapping("/")
	public String goHome(Model model) {

		model.addAttribute("person", new Person());
		
		return "AddContact";
	}
	
	@RequestMapping("/generateRandom")
	public String generateRandom(Model model) {

		model.addAttribute("person", new Person());
		dao.generateRandom();
		return "AddContact";
	}

	@RequestMapping(value = "addContact", method = RequestMethod.POST)
	public String savePerson(Model model, @ModelAttribute Person person) {
		// This way it does not cause thread interference
		synchronized (Person.class) {
			dao.addPerson(person);
		}

		Person p = new Person();
		model.addAttribute("person", p);
		return "AddContact";
	}

	@RequestMapping("/view")
	public String viewContact(Model model) {

		model.addAttribute("person", dao.getPerson());
		return "ViewContacts";
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateById(Model model, @PathVariable int id) {

		Person person = dao.queryByID(id);
		if(person.getId()!=0) {
			dao.deletePerson(id);
		}
		model.addAttribute("person", person);

		return "AddContact";
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String deleteById(Model model, @PathVariable int id) {

		dao.deletePerson(id);
		
		model.addAttribute("person", dao.getPerson());
		return "ViewContacts";
	}

}
