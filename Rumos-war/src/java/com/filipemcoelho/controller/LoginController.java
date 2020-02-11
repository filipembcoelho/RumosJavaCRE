package com.filipemcoelho.controller;

import com.filipemcoelho.entities.Person;
import com.filipemcoelho.entities.Users;
import com.filipemcoelho.model.UsersFacade;
import com.filipemcoelho.filters.utils.SessionUtils;
import com.filipemcoelho.model.PersonFacade;
import javax.inject.Named;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    @EJB
    private PersonFacade personFacade;

    @EJB
    private UsersFacade usersFacade;

    // @ManagedProperty(value = "#{loggedInUser}")
    private Users loggedInUser;

    // @ManagedProperty(value = "#{loggedInPerson}")
    private Person loggedInPerson;

    private String enteredUsername;
    private String enteredPassword;

    public LoginController() {
    }

    public Users getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(Users loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public Person getLoggedInPerson() {
        return loggedInPerson;
    }

    public void setLoggedInPerson(Person loggedInPerson) {
        this.loggedInPerson = loggedInPerson;
    }

    public String getEnteredUsername() {
        return enteredUsername;
    }

    public void setEnteredUsername(String enteredUsername) {
        this.enteredUsername = enteredUsername;
    }

    public String getEnteredPassword() {
        return enteredPassword;
    }

    public void setEnteredPassword(String enteredPassword) {
        this.enteredPassword = enteredPassword;
    }

    public String login() {
        // System.out.println("Verifying login");

        for (Users u : usersFacade.findAll()) {
//            System.out.println("Verifying user: " + u.getUName() + " " + u.getUPassword());
            if (enteredUsername.equals(u.getUName()) && enteredPassword.equals(u.getUPassword())) {
//                System.out.println("User verified: " + u.getUserId().getFirstName() + " " + u.getUserId().getLastName());

                // Add user to Session
                SessionUtils.setParam("loggedInUser", u);
                // Easy access to loggedInPerson object
                loggedInUser = u;
                loggedInPerson = personFacade.find(u.getUserId().getUserId());

                System.out.println(loggedInPerson.getFirstName() + " " + loggedInPerson.getLastName());

                return "filterloggedin.xhtml?faces-redirect=true";
            }
        }

        return "";
    }

    public String logout() {
        SessionUtils.remove("loggedInUser");
        SessionUtils.invalidate();
        loggedInUser = null;
        return "index.xhtml?faces-redirect=true";
    }

    // Method to check if there is logged in user or not
    public boolean checkLogin() {
        return SessionUtils.getParam("loggedInUser") != null;
    }

}
