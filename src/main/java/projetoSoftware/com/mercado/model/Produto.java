package projetoSoftware.com.mercado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "produto")
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    @Id
    @Column(name = "identificador")
    private Integer identificador;
    @Column(name = "nome")
    private String nome;
    @Column(name = "preco")
    private Float preco;
    @Column(name = "codigo_barras")
    private Integer codigoDeBarras;
    @Column(name = "fornecedor")
    private String fornecedor;
    @Column(name = "quantidade")
    private Integer quantidade;

 /*   @Override
    public String toString() {
        return "Produto{id=" + identificador +
                ", nome='" + nome + '\'' +
                ", preco='" + preco + '\'' +
                ", codigo_barras='" + codigoDeBarras + '\'' +
                ", fornecedor='" + fornecedor + '\'' +
                ", quantidade='" + quantidade + '}';
    }

    boolean verificarDisponibilidade(int quantidade) {
        if (quantidade > 0) return true;
        return false;
    }*/
}
