package com.filipemcoelho.controller;

import com.filipemcoelho.entities.Person;
import com.filipemcoelho.model.PersonFacade;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

@Named(value = "teamController")
@SessionScoped
public class TeamController implements Serializable {

    @EJB
    private PersonFacade personFacade;

    public TeamController() {
    }

    public void edit(Person entity) {
        personFacade.edit(entity);
    }

    public void remove(Person entity) {
        personFacade.remove(entity);
    }

    public List<Person> findAll() {
        return personFacade.findAll();
    }

    
    
}
