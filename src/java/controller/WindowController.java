/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.Window;
import helper.WindowHelper;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

/**
 *
 * @author Rain_Vision
 */
@Named(value = "windowController")
@SessionScoped
public class WindowController implements Serializable {
    
    private WindowHelper helper = null;
    
    private List<Window> window_list = null;
    
    public WindowController(){
        helper = new WindowHelper();
    }
    
    public void prepareWindowList(ActionEvent e){
        window_list = helper.getWindowList();
    }

    public List<Window> getWindow_list() {
        if(window_list == null){
            prepareWindowList(null);
        }
        return window_list;
    }

    public void setWindow_list(List<Window> window_list) {
        this.window_list = window_list;
    }
    
    
}
