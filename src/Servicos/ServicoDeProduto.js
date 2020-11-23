import Request from './Request';

class ServicoDeVendedor {
    
    async verificarDisponibilidade(codigoDeBarras, quantidade) {

        // let resultado = {
        //     status: null
        // }

        // await Request.post('/login', usuario).then(resp => {
        //     resultado.status = resp;
        // });

        // if (quantidade <= resultado.algo) {
        //     resultado = this.consultarPorId(codigoDeBarras);
        // }

        return true;
    };

    async consultarPorId(codigoDeBarras) {
        return true;
    }
}

export default new ServicoDeVendedor();