/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda;

import cliente.Cliente;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import produto.Produto;

/**
 *
 * @author crisjana
 */
@Entity
@Table(name = "venda")
public class Venda {

    @Id
    private Integer Id;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente",nullable = false)
    private cliente.Cliente cliente;
    
     @ManyToOne
    @JoinColumn(name = "id_produto",nullable = false)
    private produto.Produto produto;
     
     @Column(name = "data_venda")
     private Date dataVenda;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
     
     

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }
    
    
}
