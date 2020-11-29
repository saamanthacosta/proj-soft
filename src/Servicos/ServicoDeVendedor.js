import Request from './Request';
import { ROTAS } from '../Config/routes';

class ServicoDeVendedor {
    
    async autenticar(usuario) {
        // return await Request.post(ROTAS.API.vendedor.autenticar, usuario);

        return true;
    };
}

export default new ServicoDeVendedor();