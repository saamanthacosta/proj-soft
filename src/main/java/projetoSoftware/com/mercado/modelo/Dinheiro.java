package projetoSoftware.com.mercado.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dinheiro extends FormaPagamento {
    private int valorRecebido;

    public float calcularTroco(float valorRecebido) {
        return 0.0f;
    }
}
