/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import db.HibernateUtil;
import db.Message;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rain_Vision
 */
public class MessageHelper {
    Session session = null;

    public MessageHelper() {
        this.session = HibernateUtil.getSession();
    }
    
    public List<Message> getMessageListOrderByTime(){
        List<Message> list = null;

        try {
            Criteria q = session.createCriteria(Message.class);
            q.setMaxResults(50);
            q.addOrder(Order.desc("time"));
            list = (List<Message>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }
    
    public Message getMessageByID(int id){
        Message instance = null;
        
        try {
            Criteria q = session.createCriteria(Message.class);
            q.add(Restrictions.idEq(id));
            instance = (Message) q.uniqueResult();
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            return instance;
        }
    }
    
    public boolean saveOrUpdateMessage(Message instance){
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            session.saveOrUpdate(instance);
            session.flush();
            session.clear();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
