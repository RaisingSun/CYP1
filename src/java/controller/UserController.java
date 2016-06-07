/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.Information;
import helper.UserHelper;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import util.ToUTF8Fixer;

/**
 *
 * @author Rain_Vision
 */

@Named(value = "userController")
@SessionScoped
public class UserController implements Serializable {
    
    private UserHelper helper = null;
    
    private Information user = null;
    
    private String inputName;
    private String inputPassword;
    private String loginStatus;
    
    private String infopage = "notlogin.xhtml";
    
    public UserController(){
        helper = new UserHelper();
        loginStatus = "登录";
    }
    
    public String prepareLoginView(){
        
        return "index";
    }
    
    public boolean isLogin(){
        return user != null;
    }
    
    public void pressLoginBtn(ActionEvent e){
        auth();
    }
    
    public boolean auth(){
        if (inputName == null || inputPassword == null) {
            return false;
        }
        
        try {
            inputName = new String(inputName.getBytes("ISO-8859-1"), "utf8");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        user = helper.getUserByName(inputName);
        if (user != null && user.getName().equals(inputName) && user.getPassword().equals(inputPassword)) {
            inputPassword = null;
            loginStatus = user.getName();
            infopage = "personinfo.xhtml";
            return true;
        }
        inputPassword = null;
        return false;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getInputPassword() {
        return inputPassword;
    }

    public void setInputPassword(String inputPassword) {
        this.inputPassword = inputPassword;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Information getUser() {
        return user;
    }

    public void setUser(Information user) {
        this.user = user;
    }

    public String getInfopage() {
        return infopage;
    }

    public void setInfopage(String infopage) {
        this.infopage = infopage;
    }
    
}