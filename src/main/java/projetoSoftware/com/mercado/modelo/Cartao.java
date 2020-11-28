package projetoSoftware.com.mercado.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cartao extends FormaPagamento {
    private Enum<TipoDeCartao> tipoDeCartaoEnum;

    public void contactarEmpresa() {
        System.out.println("Cartão :: contactarEmpresa :: Pagamento com sucesso ");
    }

}

enum TipoDeCartao {
    Debito,
    Credito
}

