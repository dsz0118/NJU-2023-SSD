package contacts.data;

import contacts.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {
//    List<Contact> findAll();
//
//    void save(Contact contact);
//
//    void clear();
}
