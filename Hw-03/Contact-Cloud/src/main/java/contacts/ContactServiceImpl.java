package contacts;

import contacts.annotations.OutputIntercept;

import java.util.List;

public class ContactServiceImpl implements ContactService{
    private ContactRepository repository;

    public ContactServiceImpl(ContactRepository repository) {
        this.repository = repository;
    }
    @OutputIntercept
    public List<Contact> getAll(){
        return this.repository.findAll();
    }

    public void add(Contact contact){
        this.repository.save(contact);
    }

}
