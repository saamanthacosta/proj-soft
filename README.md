# Frontend

## Requisistos

Node 12.13

## Scripts

### `npm install`

Instala todas as dependências no projeto

### `npm start`

Roda a aplicação locamente e abre a abre automaticamente na porta 3000

## Dados para serem manipulados na interface

Foram tratados situações de sucesso e erro na interface

### Tela inicial (Gerente):
Usuario: gerente
Senha: password

### Dashboard Gerente:
Basta clicar em Iniciar Venda

### Login do Vendedor:
Usuario: vendedor
Senha: password

### Tela de Venda:
Há váras manipulações possíveis nessa tela.
Após inserir um produto, a tela de venda irá atualizar e na esquerda exibirá um card com as informações referentes ao último produto adicionado na venda.
A tabela de venda é atualizada automaticamente, possuindo paginação. Os itens da venda são ordenados de forma decrescente, com o último item adicionado indo para o topo da tabela. 
As interações de adicionar e remover produto da venda fazem com que o valor total da compra seja atualizado automaticamente.

#### Cancelar Venda:
O gerente precisa inserir os dados para a venda ser finalizada, bastando inserir os dados do gerente, utilizados na tela inicial.
Se o backend retornar um status de sucesso, a tela redireciona automaticamente para a tela de login do vendedor, para que ele possa efetuar uma nova venda.

### Inserir Produto:
Existem sete produtos salvos no banco, com código de barras do 1 ao 7, todos com 40 quantidades no estoque. Basta inserir o código de barras e a quantidade desejada. 

### Remover Produto:
A tabela está disponibilizada com um checkbox, basta selecionar o produto que será exibido na head da tabela um ícone de lixeira. Ao clicar nele, o item é removido da tela.

### Finalizar Compra:
O vendedor precisa selecionar uma das opções de compra, abrindo um novo modal com as informações necessárias para ele preencher.
Pensando no PIX, disponbiilizamos um campo para "Chave Aleatória", já que não sabemos como funcionará na prática o pagamento do PIX em mercado.
Pensando em cartão, em um cenário normal, seria necessário que o cliente inserisse o cartão na maquininha. Colocamos um campo pedindo o número do cartão apenas para ser simbólico.
Ao selecionar dinheiro, o sistema disponibiliza um campo não editável para exibir o valor do troco necessário para o valor que o cliente está pagando. 
Se a compra for concluída com sucesso e salva no banco, o sistema redireciona para a tela de vendedor, para que ele possa efetuar uma nova venda.
