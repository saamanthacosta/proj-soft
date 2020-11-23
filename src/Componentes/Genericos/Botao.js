import {BotaoPadrao} from '../../Estilização/estilizacao'

export default function Botao(props) {

    return(
        <BotaoPadrao type={props.type} fullWidth variant="contained" onClick={props.onClick} > {props.texto} </BotaoPadrao>
    )
}