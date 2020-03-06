package org.acme;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @Inject
    PersonService personService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            Person person = new Person();
            person.name = UUID.randomUUID().toString();
            person.birth = new Date();
            personList.add(person);
        }

        personService.persist(personList);
        return "hello";
    }

}