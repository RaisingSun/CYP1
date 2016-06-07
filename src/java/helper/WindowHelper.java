/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import db.HibernateUtil;
import db.Window;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Rain_Vision
 */
public class WindowHelper {

    Session session = null;

    public WindowHelper() {
        this.session = HibernateUtil.getSession();
    }

    public List<Window> getWindowList() {
        List<Window> list = null;

        try {
            Criteria q = session.createCriteria(Window.class);
            q.setMaxResults(50);
            list = (List<Window>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }
}
