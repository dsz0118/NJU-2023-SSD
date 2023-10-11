package contacts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/")

public class ContactController {
    //TODO

    private List<Contact> contacts = new ArrayList<>();

    @ModelAttribute(name = "contact")
    public Contact contact() {
        return new Contact();
    }

    @ModelAttribute(name = "contacts")
    public List<Contact> contacts() {
        return this.contacts;
    }

    @GetMapping
    public String showContactsForm() {
        return "home";
    }

    @PostMapping
    public String processContacts(
            @Valid Contact contact, Errors errors) {
        if(!errors.hasErrors()) {
            contacts.add(contact);
        }
        return "home";
    }
}
