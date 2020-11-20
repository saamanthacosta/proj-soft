package projetoSoftware.com.mercado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projetoSoftware.com.mercado.enumerado.statusVenda;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Data
@Entity
@Table(name = "venda")
@AllArgsConstructor
@NoArgsConstructor
public class Venda {
    @Column(name = "identificador")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer identificador;

    @Column(name="vendedor_id")
    private Vendedor vendedor;

    @Column(name = "cliente_id")
    @OneToOne(optional = false)
    @JoinColumn(name = "cliente_id", referencedColumnName = "cpf")
    private Cliente cliente;

    @Column(name = "produtos")
    private ArrayList<Produto> produtos;

    @Column(name= "formaPagamento")
    private FormaPagamento formaPagamento;

    @Column(name = "totalAPagar")
    private int totalAPagar;

    @Column(name = "data")
    private Date data;

    @Column(name = "data")
    private Enum<statusVenda> status;


}
