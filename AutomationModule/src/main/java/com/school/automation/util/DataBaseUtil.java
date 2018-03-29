package com.school.automation.util;

import com.school.registerdb.util.Constants;
import com.school.registerdb.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @jhonny
 */
public class DataBaseUtil {
    private static Session session;      

    public static void cleanup() {
        emptyTables();
    }

    public static void emptyTables() {
        session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();

        try {
            session.createSQLQuery("SET FOREIGN_KEY_CHECKS=0").executeUpdate();

            session.createSQLQuery("TRUNCATE TABLE " + Constants.DATA_BASE + ".student").executeUpdate();            
            session.createSQLQuery("ALTER TABLE " + Constants.DATA_BASE + ".student AUTO_INCREMENT = 1").executeUpdate();

            session.createSQLQuery("SET FOREIGN_KEY_CHECKS=1").executeUpdate();

            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }    
}
