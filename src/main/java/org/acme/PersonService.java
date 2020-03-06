package org.acme;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    @Transactional
    public void persist(List<Person> personList) {
        LOGGER.info("Starting");
        final long start = System.currentTimeMillis();
        Person.persist(personList);
        LOGGER.info("time={}", System.currentTimeMillis() - start);
    }

}
