package projetoSoftware.com.mercado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "estoque")
public class Estoque implements Serializable {

    @Id
    @JoinColumn(name="codigo_barras_produto")
    private Integer codigoDeBarrasProduto;
    @Column(name = "quantidade")
    private int quantidade;

//    @OneToOne(mappedBy = "produto")
//    private Produto produto;


    boolean verificarDisponibilidade(int quantidade) {
        if (quantidade > 0) return true;
        return false;
    }

    public void addEstoque(int qtdAdd) {
        this.setQuantidade(this.getQuantidade() + qtdAdd);
    }

    public boolean retiraEstoque(int qtdRetira) {
        if (qtdRetira <= this.getQuantidade()) {
            this.setQuantidade(this.getQuantidade() - qtdRetira);
            System.out.println("Quantidade atual no estoque = " + this.getQuantidade());
            return true;
        } else {
            return false;
        }
    }

}
