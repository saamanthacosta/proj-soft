import Request from './Request';
import { ROTAS } from '../Config/routes';

class ServicoDeVendedor {
    
    async verificarDisponibilidade(codigoDeBarras, quantidade) {

        let resultado = null;
        
        await Request.post(ROTAS.API.produto.disponibilidade + codigoDeBarras).then( resultado => {
            if (resultado.quantidade <= quantidade) {
                resultado = this.consultarPorId(codigoDeBarras);
            } else {
                if (resultado === 1) {
                    resultado = `Existe somente 1 unidade desse produto disponível em estoque.`
                } else {
                    resultado = `Existe somente ${resultado.quantidade} unidades desse produto disponíveis em estoque.`
                }
            }
        }).catch(erro => {
            resultado = erro;
        });


        return resultado;
    };

    async consultarPorId(codigoDeBarras) {
       
        let resultado = null

        await Request.get(ROTAS.API.produto.identificar + codigoDeBarras).then(resp => {
            resultado = resp;
        }).catch(erro => {
            resultado = erro;
        });

        return resultado;
    }
}

export default new ServicoDeVendedor();