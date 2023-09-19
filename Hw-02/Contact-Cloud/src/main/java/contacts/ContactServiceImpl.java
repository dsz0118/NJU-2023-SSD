package contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository repository;

    public List<Contact> getAll(){
        return this.repository.findAll();
    }

    public void add(Contact contact){
        this.repository.save(contact);
    }

}
