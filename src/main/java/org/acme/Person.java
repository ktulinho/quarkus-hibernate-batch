package org.acme;

import java.util.Date;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Person extends PanacheEntity {

    public String name;
    public Date birth;

    public static Person findByName(String name) {
        return find("name", name).firstResult();
    }

    public static void deleteStefs() {
        delete("name", "Stef");
    }

}