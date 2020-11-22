package projetoSoftware.com.mercado.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "produto_venda")
public class ProdutoVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "identificador")
    private Integer identificador;
    @Column(name = "idProduto")
    private int idProduto;
    @Column(name = "venda")
    private int venda;
    @Column(name = "quantidade")
    private int quantidade;
}
