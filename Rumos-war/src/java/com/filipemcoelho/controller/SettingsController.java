package com.filipemcoelho.controller;

import com.filipemcoelho.entities.Person;
import com.filipemcoelho.model.PersonFacade;
import java.io.Serializable;
import java.util.Locale;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

@Named(value = "settingsController")
@SessionScoped
public class SettingsController implements Serializable {

    @EJB
    private PersonFacade personFacade;

    private String locale = "en";

    @ManagedProperty(value = "#{loginController}")
    private Person loggedInPerson;

    public String getLocale() {
        return locale;
    }

    public Person getLoggedInPerson() {
        return loggedInPerson;
    }

    public void setLoggedInPerson(Person loggedInPerson) {
        this.loggedInPerson = loggedInPerson;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void changeLanguage() {
        FacesContext.getCurrentInstance().getViewRoot()
                .setLocale(new Locale(this.locale));
//        System.out.println("com.filipemcoelho.controller.SettingsController.changeLanguage() " + locale);
//        System.out.println(FacesContext.getCurrentInstance().getViewRoot()
//                .getLocale());
    }

    public void updateEmployee() {
        personFacade.edit(loggedInPerson);
    }
}
