package projetoSoftware.com.mercado.modelo;

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
    @Column(name = "codigo_de_barras_produto")
    private Integer codigoDeBarrasProduto;
    @Column(name = "quantidade")
    private int quantidade;

    boolean verificarDisponibilidade(int quantidade) {
        if (quantidade > 0) return true;
        return false;
    }

    public void adicionar(int quantidade) {
        this.setQuantidade(this.getQuantidade() + quantidade);
    }

    public boolean retirar(int quantidade) {
        if (quantidade <= this.getQuantidade()) {
            this.setQuantidade(this.getQuantidade() - quantidade);
            System.out.println("Quantidade atual no estoque = " + this.getQuantidade());
            return true;
        } else {
            return false;
        }
    }

}
