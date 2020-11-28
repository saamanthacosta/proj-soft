package projetoSoftware.com.mercado.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "produto")
@AllArgsConstructor
@NoArgsConstructor
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "codigo_barras")
    private Integer codigoDeBarras;
    @Column(name = "nome")
    private String nome;
    @Column(name = "preco")
    private Float preco;
    @Column(name = "fornecedor")
    private String fornecedor;

    public void atualizar(Produto produto) {
        this.setNome(produto.getNome());
        this.setPreco(produto.getPreco());
    }

}
