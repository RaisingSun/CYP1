/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import db.HibernateUtil;
import db.Information;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rain_Vision
 */
public class UserHelper {
    Session session = null;

    public UserHelper() {
        this.session = HibernateUtil.getSession();
    }
    
    public Information getUserByName(String name){
        Information instance = null;
        
        try {
            Criteria q = session.createCriteria(Information.class);
            q.add(Restrictions.eq("name", name));
            instance = (Information) q.uniqueResult();
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            return instance;
        }
    }
    
    public Information getUserByID(String id){
        Information instance = null;
        
        try {
            Criteria q = session.createCriteria(Information.class);
            q.add(Restrictions.eq("sNo", id));
            instance = (Information) q.uniqueResult();
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            return instance;
        }
    }
    
    public boolean saveOrUpdateInformation(Information instance){
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
