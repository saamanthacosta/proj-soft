package projetoSoftware.com.mercado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
//@Table(name = "pagamento")
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {
    @Column(name = "identificador")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer identificador;

    @Column(name = "formaPagamento")
    private String formaPagamento;

}
