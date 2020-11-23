import React, { Component } from 'react';
import Modal from '../Genericos/Modal'
import ProdutoActions from '../../Gerenciamento de Estados/Actions/ProdutoActions';
import ProdutoStore from '../../Gerenciamento de Estados/Stores/ProdutoStore';
import ModalStore from '../../Gerenciamento de Estados/Stores/ModalStore';
import TextField from '@material-ui/core/TextField';

export default class InserirProduto extends Component {

  constructor(props) {
    super(props);
    this.state = {
      aberto: false,
      codigoDeBarras: ''
    };
  }

  componentDidMount() {
    ProdutoStore.on('DISPONIBILIDADE', this.fechar);
    ModalStore.on('INSERIR_PRODUTO', this.abrir);
  }

  componentWillUnmount() {
    ProdutoStore.removeListener('DISPONIBILIDADE', this.fechar);
    ModalStore.removeListener('INSERIR_PRODUTO', this.abrir);
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
    this.setState({ codigoDeBarras: value });
  }
  
  onClick = () => {
    ProdutoActions.verificarDisponibilidade(this.state.codigoDeBarras);
  }

  render() {
    
    const conteudoModal =
      <TextField
        autoFocus
        margin="dense"
        label="Código de Barras"
        type="text"
        name="codigoDeBarras"
        fullWidth
        onChange={this.onChange}
      />

    return <>
      <Modal fecharModal={this.fechar} aberto={this.state.aberto} titulo="Inserir Produto" conteudo={conteudoModal} 
      descricao="Insira o Código de Barras do Produto" onClick={this.onClick} botao='Inserir Produto' />
    </>
  }
}