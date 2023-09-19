package contacts;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ContactRepositoryImpl implements ContactRepository{

    List<Contact> tempLib = new ArrayList<>();
    public List<Contact> findAll(){
        return this.tempLib;
    }

    public void save(Contact contact){
        this.tempLib.add(contact);
    }

    public void clear(){
        this.tempLib.clear();
    }
}
