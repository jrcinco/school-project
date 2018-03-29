package com.school.registerdb.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static String configFile = "/hibernate-generation.cfg.xml";    

    public static Session openSession() {
        Configuration cfg = new Configuration();
        cfg.configure(configFile);
        cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/" + Constants.DATA_BASE);        

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        return session;
    }

    public static Session openSession(boolean ddl) {
        Configuration cfg = new Configuration();
        cfg.configure(configFile);

        cfg.setProperty("hibernate.hbm2ddl.auto", "update");
        cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/" + Constants.DATA_BASE);        

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        return session;
    }
}
