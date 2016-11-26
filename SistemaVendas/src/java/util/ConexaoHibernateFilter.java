/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author crisjana
 */
public class ConexaoHibernateFilter implements Filter {

    private SessionFactory sf;

    @Override
    public void init(FilterConfig conf) throws ServletException {
        this.sf = HibernateUtil.getSession();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            this.sf.getCurrentSession().beginTransaction();
            chain.doFilter(request, response);
            this.sf.getCurrentSession().getTransaction().commit();
            this.sf.getCurrentSession().close();
            
        } catch (Throwable e) {
            try {
                if (this.sf.getCurrentSession().getTransaction().isActive()) {
                    this.sf.getCurrentSession().getTransaction().rollback();
                }
            } catch (Throwable ex) {
                ex.printStackTrace();
            }
            throw new ServletException();
        }
        
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
