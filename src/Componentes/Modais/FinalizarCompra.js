import React, { Component } from 'react';
import VendaStore from '../../Gerenciamento de Estados/Stores/VendaStore';
import ModalStore from '../../Gerenciamento de Estados/Stores/ModalStore';
import VendaActions from '../../Gerenciamento de Estados/Actions/VendaActions';
import Modal from '../Genericos/Modal'
import { FormaDePagamento } from '../../Modelos/FormaDePagamento'
import { withRouter } from "react-router-dom";
import { routes } from '../../Config/routes';
import Radio from '@material-ui/core/Radio';
import RadioGroup from '@material-ui/core/RadioGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import FormControl from '@material-ui/core/FormControl';
import { TextField } from '@material-ui/core';

class FinalizarCompra extends Component {

    constructor(props) {
        super(props);
        this.state = {
            aberto: false,
            venda: this.props.venda,
            pagamento: null,
            formaDePagamento: null,
            valorTroco: 0
        };
    }

    componentDidMount() {
        ModalStore.on('FINALIZAR_COMPRA', this.abrir);
        VendaStore.on('CHANGE', this.redirecionar);
    }

    componentWillUnmount() {
        ModalStore.removeListener('FINALIZAR_COMPRA', this.abrir);
        VendaStore.removeListener('CHANGE', this.redirecionar);
    }


    redirecionar = () => {
        return this.props.history.push(routes.LOGIN_VENDEDOR);
    }

    abrir = () => {
        this.setState({ aberto: true })
    }

    fechar = () => {
        this.setState({ aberto: false })
    };

    onChange = (evento) => {
        evento.preventDefault();
        const { value } = evento.target;
        this.setState({ pagamento: value });
    }

    onClick = () => {
        this.setState({ formaDePagamento: this.state.pagamento })
    }

    onChangeDinheiro = (evento) => {
        evento.preventDefault();
        const { value } = evento.target;
        var valorDevido = this.props.valorTotal;
        var valorTroco = value - valorDevido;
        if (valorTroco <= 0) {
            this.setState({ valorTroco: 0 });
        } else {
            this.setState({ valorTroco })
        }
    }

    voltar = () => {
        this.setState({formaDePagamento: null})
    }

    finalizar = () => {
        VendaActions.cadastrar(this.state.venda)

    }

    render() {

        return <>

        {this.state.formaDePagamento === null && 
            <Modal fecharModal={this.fechar} aberto={this.state.aberto} titulo="Forma de pagamento" 
                descricao="Selecione a forma de pagamento" onClick={this.onClick} botao='Finalizar Venda'
                conteudo={
                    <FormControl component="fieldset">
                        <RadioGroup aria-label="gender" name="gender1" onChange={this.onChange}>
                            <FormControlLabel value={FormaDePagamento.PIX} control={<Radio />} label={FormaDePagamento.PIX} />
                            <FormControlLabel value={FormaDePagamento.CARTAO_CREDITO} control={<Radio />} label={FormaDePagamento.CARTAO_CREDITO} />
                            <FormControlLabel value={FormaDePagamento.CARTAO_DEBITO} control={<Radio />} label={FormaDePagamento.CARTAO_DEBITO} />
                            <FormControlLabel value={FormaDePagamento.DINHEIRO} control={<Radio />} label={FormaDePagamento.DINHEIRO} />
                        </RadioGroup>
                    </FormControl>
                }
            />
        }
        {
            this.state.formaDePagamento === FormaDePagamento.PIX &&
            <Modal fecharModal={this.fechar} aberto={this.state.aberto} titulo="Forma de pagamento - PIX" descricao="Insira a chave aleatória do PIX" 
            onClick={this.onClick} botao='Finalizar Venda' possuiOutroBotao={true} outroBotao="Voltar" onClickOutroBotao={this.voltar}
            conteudo= {
                <TextField
                    autoFocus
                    margin="dense"
                    label="Chave aleatória PIX"
                    type="text"
                    name="chavePix"
                    fullWidth
                />
            }
            />
        }
        {
            (this.state.formaDePagamento === FormaDePagamento.CARTAO_DEBITO || this.state.formaDePagamento === FormaDePagamento.CARTAO_CREDITO) &&
            <Modal fecharModal={this.fechar} aberto={this.state.aberto} titulo="Forma de pagamento - Cartão" descricao="Insira o número do cartão" 
            onClick={this.onClick} botao='Finalizar Venda' possuiOutroBotao={true} outroBotao="Voltar" onClickOutroBotao={this.voltar}
            conteudo= {
                <TextField
                    autoFocus
                    margin="dense"
                    label="Número do Cartão"
                    type="text"
                    name="numCartao"
                    fullWidth
                />
            }
            />
        }
        {
            this.state.formaDePagamento === FormaDePagamento.DINHEIRO &&
            <Modal fecharModal={this.fechar} aberto={this.state.aberto} titulo="Forma de pagamento - Dinheiro" descricao="Insira o valor pago em dinheiro" 
            onClick={this.onClick} botao='Finalizar Venda' possuiOutroBotao={true} outroBotao="Voltar" onClickOutroBotao={this.voltar}
            conteudo= {
                <>
                <TextField
                    autoFocus
                    margin="dense"
                    label="Valor pago"
                    type="text"
                    name="dinheiro"
                    fullWidth
                    onChange={this.onChangeDinheiro}
                />
                <TextField
                    autoFocus
                    margin="dense"
                    label="Valor troco"
                    value={this.state.valorTroco}
                    fullWidth
                    disabled={true}
                />
                </>
            }
            />
        }
        </>
    }
}


export default withRouter(FinalizarCompra);