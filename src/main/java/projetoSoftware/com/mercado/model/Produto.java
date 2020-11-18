package projetoSoftware.com.mercado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "produto")
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Column(name = "identificador")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    boolean verificarDisponibilidade(int quantidade) {
        if (quantidade > 0) return true;
        return false;
    }

    public void atualizaProduto(Produto produto) {
        this.setNome(produto.getNome());
        this.setPreco(produto.getPreco());
    }

}
