package Armazem;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "armazem")
public class Armazem implements Serializable{

    @Id
    @Column(name="item_id", unique = true , nullable = false)
    private int id;

    @Column(name="nome", nullable = false)
    private String nome;

    @Column(name="quantidade")
    private int quantidade;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    //Getters e Setters

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
