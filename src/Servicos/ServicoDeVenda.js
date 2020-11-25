import Request from './Request';
import { ROTAS } from '../Config/routes';

class ServicoDeVenda {
    
    async cadastrar(usuario) {


        // let resultado = await Request.post(ROTAS.API.venda.cadastrar, venda);

        // return resultado;

        return true;
    };
}

export default new ServicoDeVenda();