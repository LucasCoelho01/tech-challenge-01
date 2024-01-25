# tech-challenge-01
Tech Challenge FIAP - primeira fase

## Como rodar o projeto:
O projeto é composto de dois containers: Banco de dados(PostgreSql) e a API (Spring/Java), a execução dois containers está agrupada dentro do arquivo compose.yml, para subir basta rodar a linha de comando abaixo:

``` bash
docker compose up -d
```

Observações:
- Você deve estar com terminal aberto na pasta do projeto, caso contrário precisa especificar o campo até o arquivo;
- Os containers irão executar nas portas: 5432 e 8080, certifique-se que as mesmas estejam liberadas.

## Como testar as funcionalidades do projeto:
Segue nesse repositório um arquivo chamado Tech Challenge #1.postman_collection.json, nele está a Collection para fazer a chamada dos enpoints pelo Postman.
