/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.Information;
import db.Message;
import helper.MessageHelper;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

/**
 *
 * @author Rain_Vision
 */
@Named(value = "messageController")
@SessionScoped
public class MessageController implements Serializable {
    
    private MessageHelper helper = null;
    
    private List<Message> message_list = null;
    
    private String inputContext;
    private String outputInfo;
    
    public MessageController(){
        helper = new MessageHelper();
    }
    
    public void addNewMessage(ActionEvent e){
        FacesContext context = FacesContext.getCurrentInstance();
        ValueBinding binding = context.getApplication().createValueBinding("#{userController}");
        UserController userC = (UserController) binding.getValue(context);
        
        Information user = userC.getUser();
        if(user != null){
            if(inputContext != null){
                
                inputContext = util.ToUTF8Fixer.encode(inputContext);
                
                Message msg = new Message();
                msg.setContext(inputContext);
                msg.setInformation(user);
                msg.setTime(new Date(System.currentTimeMillis()));
                msg.setTitle("");
                if(helper.saveOrUpdateMessage(msg)){
                    inputContext = null;
                    outputInfo = "留言已提交";
                }
            }
            outputInfo = "请输入内容";
        }
        outputInfo = "请先登录";
    }
    
    public String addNewMessage(){
        FacesContext context = FacesContext.getCurrentInstance();
        ValueBinding binding = context.getApplication().createValueBinding("#{userController}");
        UserController userC = (UserController) binding.getValue(context);
        
        Information user = userC.getUser();
        if(user != null){
            if(inputContext != null){
                Message msg = new Message();
                msg.setContext(inputContext);
                msg.setInformation(user);
                msg.setTime(new Date(System.currentTimeMillis()));
                msg.setTitle("");
                if(helper.saveOrUpdateMessage(msg)){
                    return "留言已提交";
                }
            }
            return "请输入内容";
        }
        return "请先登录";
    }
    
    public void prepareMessageList(ActionEvent e){
        message_list = helper.getMessageListOrderByTime();
    }
    
    public List<Message> prepareAndReturnMessageList(){
        message_list = helper.getMessageListOrderByTime();
        return message_list;
    }

    public List<Message> getMessage_list() {
        if(message_list == null){
            prepareMessageList(null);
        }
        return message_list;
    }

    public void setMessage_list(List<Message> message_list) {
        this.message_list = message_list;
    }

    public String getInputContext() {
        return inputContext;
    }

    public void setInputContext(String inputContext) {
        this.inputContext = inputContext;
    }

    public String getOutputInfo() {
        return outputInfo;
    }

    public void setOutputInfo(String outputInfo) {
        this.outputInfo = outputInfo;
    }
    
    
}
