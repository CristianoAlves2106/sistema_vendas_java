
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author crisjana
 */
public class Conecta {

    public static void main(String[] args) {
        Session session = null;
        try {
            session = HibernateUtil.getSession().openSession();
            System.out.println("Conectou");
        } finally {
            session.close();
            System.out.println("fechou a conexao");
        }
    }

}
