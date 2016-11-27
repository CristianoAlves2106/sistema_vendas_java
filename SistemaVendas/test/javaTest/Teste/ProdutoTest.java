package javaTest.Teste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import produto.Produto;
import util.HibernateUtil;

/**
 *
 * @author crisjana
 */
public class ProdutoTest {

    private static Session session;
    private static Transaction transacao;

    @AfterClass
    public static void abreConexao() {
        session = HibernateUtil.getSession().openSession();
        transacao = session.beginTransaction();
    }

    @BeforeClass
    public static void fechaConexao() {

        try {
            transacao.commit();
        } catch (Throwable e) {

            System.out.println("erro" + e.getMessage());
        } finally {
            try {
                if (session.isOpen()) {
                    session.close();
                }
            } catch (Exception eX) {
                System.out.println("erro" + eX.getMessage());
            }
        }
    }

    @Before
    public void setup() {
        Produto produto1 = new produto.Produto("lote2", "Regua", new Date(), 30, 2.5f);
        session.save(produto1);
       
    }

    @Test
    public void salvarProdutoTest() {
        String sql = "from Produto p where p.descricao like:descricao";
        Query consulta = session.createQuery(sql);
        consulta.setString("descricao", "%Re%");

        Produto produtoPessquisaso = (Produto) consulta.uniqueResult();

        assertEquals("lote2", produtoPessquisaso.getUnidade());

    }
}
