package contacts;

import contacts.aspect.AspectProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ContactConfigAOP {
    @Bean
    public ContactRepository contactRepository(){return new ContactRepositoryImpl();}

    @Bean
    public ContactService contactService(ContactRepository contactRepository){return new ContactServiceImpl(contactRepository);}

    @Bean
    public AspectProcessor aspectProcessor(){return new AspectProcessor();}
}
