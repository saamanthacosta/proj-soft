package projetoSoftware.com.mercado.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pix extends FormaPagamento {
    private int chave;
    private TipoDeChavePix tipoDaChave;

    public static boolean verificarChave(String chave) {
        return false;
    }
}

enum TipoDeChavePix {
    cpf, cnpj, email, telefone, chaveAleatoria;
}