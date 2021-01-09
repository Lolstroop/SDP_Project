package Entrega;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entrega")
public class Entrega implements Serializable {

    @Id
    @Column(name = "id_entrega", unique = true, nullable = false)
    private int id_entrega;

    @Column(name = "quantidade_entrega", nullable = false)
    private int quantidade_entrega;

    @Column(name = "local", nullable = false)
    private String local;

    @Column(name = "telemover", nullable = false)
    private int telemovel;

    @Column(name = "nome_item", nullable = false)
    private String nome_item;

    public int getId_entrega() {
        return id_entrega;
    }
    public void setId_entrega(int id_entrega) {
        this.id_entrega = id_entrega;
    }

    public int getQuantidade_entrega() {
        return quantidade_entrega;
    }
    public void setQuantidade_entrega(int quantidade_entrega) {
        this.quantidade_entrega = quantidade_entrega;
    }

    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }

    public int getTelemovel() {
        return telemovel;
    }
    public void setTelemovel(int telemovel) {
        this.telemovel = telemovel;
    }

    public String getNome_item() {
        return nome_item;
    }
    public void setNome_item(String nome_item) {
        this.nome_item = nome_item;
    }
}
