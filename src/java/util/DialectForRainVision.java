/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Types;
import org.hibernate.Hibernate;
import org.hibernate.dialect.SQLServerDialect;

/**
 *
 * @author Rain_Vision
 */
public class DialectForRainVision extends SQLServerDialect {

    public DialectForRainVision() {
        super();
        //registerHibernateType(Types.LONGVARCHAR, 65535, "text");//.LONGVARCHAR
        registerHibernateType(Types.DECIMAL, Hibernate.BIG_DECIMAL.getName());
        registerHibernateType(-1, Hibernate.STRING.getName());
    }
}