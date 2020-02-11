package com.filipemcoelho.controller;

import com.filipemcoelho.entities.Person;
import com.filipemcoelho.model.PersonFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;

@Named(value = "employeeController")
@SessionScoped
public class EmployeeController implements Serializable {

    @EJB
    private PersonFacade personFacade;

    @ManagedProperty(value = "#{loginController}")
    private Person loggedInPerson;

    public EmployeeController() {

    }

    public Person getLoggedInPerson() {
        return loggedInPerson;
    }

    public void setLoggedInPerson(Person loggedInPerson) {
        this.loggedInPerson = loggedInPerson;
    }

    
}
