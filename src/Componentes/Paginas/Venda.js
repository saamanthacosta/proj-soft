import React, { Component } from 'react';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import CssBaseline from '@material-ui/core/CssBaseline';
import Paper from '@material-ui/core/Paper';
import { Avatar } from '@material-ui/core';
import Grid from '@material-ui/core/Grid';
import ShoppingCartIcon from '@material-ui/icons/ShoppingCart';
import PersonIcon from '@material-ui/icons/Person';
import Tabela from '../Genericos/Tabela';
import CardProduto from '../Genericos/CardProduto';
import InserirProduto from '../Modais/InserirProduto';
import CancelarCompra from '../Modais/CancelarCompra';
import ModalActions from '../../Gerenciamento de Estados/Actions/ModalActions';
import ProdutoStore from '../../Gerenciamento de Estados/Stores/ProdutoStore';
import { BotaoCancelarCompra, BotaoFinalizarCompra, BotaoInserirProduto, venda } from '../../Estilizacao/estilizacao';
import FinalizarCompra from '../Modais/FinalizarCompra';

const classe = venda;

const  criarData = (item, nome, valorUnitario, quantidade) => {
    var valorTotal = valorUnitario * quantidade;
    return { item, nome, valorUnitario, quantidade, valorTotal };
}

const produtos = [
    criarData(1, "Cupcake", 30.5, 3),
    criarData(2, "Donut", 4.52, 2),
    criarData(3, "Eclair", 26.2, 16),
    criarData(4, "Frozen yoghurt", 15.9, 6),
    criarData(5, "Gingerbread", 35.6, 16),
    criarData(6, "Honeycomb", 4.08, 3),
    criarData(7, "Ice cream sandwich", 23.7, 9),
    criarData(8, "dasdsadsa", 35.6, 16),
    criarData(9, "daseada", 4.08, 3),
    criarData(10, "safaIce cream sandwich", 23.7, 9),
    criarData(11, "Gingereaeeebread", 35.6, 1),
    criarData(12, "Honeycadasdsomb", 4.08, 3),
    criarData(13, "Ice creamdadsaasa sandwich", 23.7, 2)
];

export default class Venda extends Component {

    constructor(props) {
        super(props);
        this.state = {
            venda: '',
            produtos: produtos.reverse(),
            valorTotal: 0
        }

        this.cliente = {
            nome: 'Paulo',
            tipo: 'Preferencial'
        }

        this.modal = {
            cancelar: 'CANCELAR_COMPRA',
            inserir: 'INSERIR_PRODUTO',
            finalizar: 'FINALIZAR_COMPRA'
        }
    }

    componentDidMount() {
        ProdutoStore.on('DISPONIBILIDADE', this.adicionarProduto);
    }

    componentWillUnmount() {
        ProdutoStore.removeListener('DISPONIBILIDADE', this.adicionarProduto);
    }

    abrirModal = (tipo, evento) => {
        evento.preventDefault();
        ModalActions.abrir(tipo);
    }

    adicionarProduto = () => {
        var produtoAdicionado = ProdutoStore.produto
        produtoAdicionado.item = this.state.produtos.length + 1;
        var produtos = this.state.produtos;
        produtos.unshift(produtoAdicionado);
        this.setState({ produtos });

        this.atualizarValorTotal();
    }

    atualizarValorTotal = () => {
        var valorTotal = this.state.produtos.map(({ valorTotal }) => valorTotal).reduce((sum, i) => sum + i, 0);
        this.setState({valorTotal})
    }

    render() {

        return <>
            <CssBaseline />
            <CancelarCompra />
            <InserirProduto />
            <FinalizarCompra valorTotal={this.state.valorTotal} venda={this.state.venda} />
            <AppBar position="relative" style={{ backgroundColor: '#b71c1c', color: '#fff' }}>
                <Toolbar style={{display: 'block', height: 80 + 'px'}}>
                    <div style={{marginTop: 10 +'px'}}>
                    <ShoppingCartIcon style={classe.espacamentoIcon} />
                    <Typography variant="h5" color="inherit" display="inline">
                        Bem vindo, {this.cliente.nome}
                    </Typography>
                    </div>
                    <Typography variant="subtitle1" color="inherit" style={{marginLeft: 33 + 'px'}}>
                        Cliente {this.cliente.tipo}
                    </Typography>
                    <div style={classe.dadosDoVendedor}>
                        <Avatar style={classe.iconeVendedor}>
                            <PersonIcon />
                        </Avatar>
                    </div>
                </Toolbar>
            </AppBar>

            <div style={classe.grid}>
                <Grid container spacing={3}>
                    <Grid item xs={6}>
                        <CardProduto />
                    </Grid>
                    <Grid item xs={6}>
                        <Tabela produtos={this.state.produtos} />
                    </Grid>
                    <Grid item xs={2}>
                        <BotaoCancelarCompra variant="contained" style={classe.botao} onClick={this.abrirModal.bind(this, this.modal.cancelar)}> Cancelar Compra </BotaoCancelarCompra>
                    </Grid>
                    <Grid item xs={2}>
                        <BotaoInserirProduto variant="contained" style={classe.botao} onClick={this.abrirModal.bind(this, this.modal.inserir)}> Inserir Produto </BotaoInserirProduto>
                    </Grid>
                    <Grid item xs={2}>
                        <BotaoFinalizarCompra variant="contained" style={classe.botao} onClick={this.abrirModal.bind(this, this.modal.finalizar)}> Finalizar Compra </BotaoFinalizarCompra>
                    </Grid>
                    <Grid item xs={4}>
                    </Grid>
                    <Grid item xs={2}>
                        <Paper style={classe.paper}>
                            <Typography variant="h6" style={classe.valorTotal}> Valor Total: </Typography>
                            <Typography variant="h6" style={classe.valor}> {parseFloat(this.state.valorTotal).toFixed(2)} </Typography>
                        </Paper>
                    </Grid>
                </Grid>
            </div>
        </>
    }
}
