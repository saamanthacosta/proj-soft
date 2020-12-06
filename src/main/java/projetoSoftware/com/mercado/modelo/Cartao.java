package projetoSoftware.com.mercado.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projetoSoftware.com.mercado.enumerado.TipoDeCartaoEnum;

@Data
public class Cartao extends FormaPagamento {

    public static void pagar(String numero, String tipo){

        if(tipo == TipoDeCartaoEnum.DEBITO){
        contactarEmpresa();

        }if(tipo == TipoDeCartaoEnum.CREDITO){
        contactarEmpresa();
        }
    }

    public static void contactarEmpresa() {
        System.out.println("Cartão :: contactarEmpresa :: Pagamento com sucesso ");
    }

}



