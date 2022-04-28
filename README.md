# Pupil Platform - API

## Sobre

A aplicação se trata de uma API que será utilizada para funcionamento da Pupil Platform, plataforma para os alunos da Alfa11 assessoria.

O objetivo da API é proporcionar ao front-end um ranking dos alunos que cadastram suas operações de day trade em mini índice (real e dólar) na plataforma. Além disso, é claro, é possível buscar as informações das operações registradas e dos alunos (chamados pupils), seus respectivos cadastros, atualizações e remoções.
 
## Tecnologias

* Java
* Spring Boot | Security | Data
* H2 Database
* Json Web Token
* Maven

## Rodando o projeto

Para utilizar o projeto em sua máquina é necessário seguir os seguintes passos:
1) Ter o Java instalado corretamente.
2) Clonar este repositório.
3) Entrar na pasta do projeto pelo terminal e executar o seguinte comando:
<pre>
mvn spring-boot:run
</pre>
4)<strong>Agora seu projeto estará rodando e suas rotas podem ser acessadas pelos controllers.</strong> (Obs: Observe os controllers para saber que rotas utilizar)

## Ordem de criação das entidades

Abaixo estará um passo a passo das rotas e quais entidades devem ser criadas primeiro, mas é importante que os controllers e services sejam acessados para verificar quais são os parâmetros necessários para cada rota da aplicação.

1) Crie primeiramente um Pupil (usuário). | Rota POST para "/pupil".
2) Realize uma requisição para a rota de autenticação para geração do Token JWT que será necessário para as requisições que geram inclusão, atualização ou remoção de dados no DB. | Rota POST para "/auth"
3) Crie registros de operações para o Pupil. | Rota POST para "/operations".
4) Acesse as rotas de ranking e veja quem está na frente | Rotas POST para "/ranking/b3" e "/ranking/dolar".
<strong>Obs:</strong> O arquivo <strong>data.sql</strong> está com diversas instruções sql para cadastro automático de dois Pupils e algumas operações, para que seja mais simples visualizar a funcionalidade da aplicação.

## Funcionalidades principais

* Geração de token JWT para autenticação em rotas específicas
* CRUD de Usuários (Pupils)
* CRUD de Operações (Operations)
* Geração dos rankings com base nas operations cadastradas por cada usuário.