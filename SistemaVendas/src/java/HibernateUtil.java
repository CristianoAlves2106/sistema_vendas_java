
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author crisjana
 */
public class HibernateUtil {
    private static final SessionFactory session = buildSessionFactory();
   
    private static final SessionFactory buildSessionFactory(){
        try {
            Configuration cfg= new Configuration();
            cfg.configure("hibernate.cfg.xml");
            return cfg.buildSessionFactory();
        } catch (Throwable e) {
            System.out.println("Deu erro"+e);
            throw new ExceptionInInitializerError();
        }
    }

    public static SessionFactory getSession() {
        return session;
    }
    
    
}
