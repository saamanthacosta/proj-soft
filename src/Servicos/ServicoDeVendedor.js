import Request from './Request';

class ServicoDeVendedor {
    
    async autenticar(usuario) {

        // let resultado = {
        //     status: null
        // }

        // await Request.post('/login', usuario).then(resp => {
        //     resultado.status = resp;
        // });

        return true;
    };
}

export default new ServicoDeVendedor();