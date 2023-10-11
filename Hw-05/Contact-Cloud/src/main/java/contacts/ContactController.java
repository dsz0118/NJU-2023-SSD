package contacts;

import contacts.data.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/")

public class ContactController {
    //TODO

    private final ContactRepository contactRepository;

    @Autowired
    public ContactController(
            ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
        this.contactRepository.deleteAll();
    }

    @ModelAttribute(name = "contact")
    public Contact contact() {
        return new Contact();
    }

    @ModelAttribute(name = "contacts")
    public List<Contact> contacts() {
        List<Contact> contactRepositories = new ArrayList<>();
        contactRepository.findAll().forEach(i -> contactRepositories.add(i));
        return contactRepositories;
    }

    @GetMapping
    public String showContactsForm() {
        return "home";
    }

    @PostMapping
    public String processContacts(
            @Valid Contact contact, Errors errors, Model model) {
        if(!errors.hasErrors()) {
            contactRepository.save(contact);
            model.addAttribute("contacts", contacts());
        }
        return "home";
    }
}
