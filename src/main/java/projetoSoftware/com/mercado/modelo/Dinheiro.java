package projetoSoftware.com.mercado.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dinheiro extends FormaPagamento {
    private int valorRecebido;

    public static float calcularTroco(float valorRecebido, float valorTotal) {
        return valorRecebido-valorTotal;
    }
}
