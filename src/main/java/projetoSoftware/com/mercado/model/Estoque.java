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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "codigo_barras_produto")
    Integer codigoDeBarrasProduto;
    @Column(name = "quantidade")
    int quantidade;

    boolean verificarDisponibilidade(int quantidade) {
        if (quantidade > 0) return true;
        return false;
    }

    public void addEstoque(Estoque produtoAdicionado) {
        this.setQuantidade(this.quantidade + produtoAdicionado.getQuantidade());
    }

}
