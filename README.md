# Measure Shelter Project!

## Tecnologias

* Apache Maven
* Docker
* Docker compose
* Java
* Spring
* jUnit
* MongoDB
* Hibernate
* Heroku

## Como usar


No seu terminal digite:
```
git clone git@github.com:DavioLopes/measure-shelter.git

cd measure-shelter
```

## Inicializando a aplicação

Já na pasta raiz do projeto use o comando:

```
docker-compose up

```

## Testando a aplicação

Raiz do projeto use o comando:

```
mvn test
```

## API Endpoints

A aplicação contem os seguintes endpoints:

# Ilha endpoint

| Method | Description |
|---|---|
| `GET - localhost:8888/ilhas` | Retorna todas as ilhas. |
| `GET - localhost:8888/ilhas/{id}` | Retorna ilha por id. |
| `POST - localhost:8888/ilhas` | Cadastra uma nova ilha no banco de dados. |
| `DELETE - localhost:8888/ilhas/{id}` | Remove uma ilha do banco de dados. |
| `PUT - localhost:8888/ilhas/{id}` | Atualiza uma ilha no banco de dados. |
| `PATCH - localhost:8888/ilhas/{id}/status` | Atualiza o status da ilha por id. |



# Medicoes endpoint

| Method | Description |
|---|---|
| `GET - localhost:8888/medicoes` | Retorna todas as medicoes. |
| `GET - localhost:8888/medicoes/{id}` | Retorna medicoes por id. |
| `POST - localhost:8888/medicoes` | Cadastra uma nova medicao no banco de dados. |
| `DELETE - localhost:8888/medicoes/{id}` | Remove uma medicao do banco de dados. |
| `PUT - localhost:8888/medicoes/{id}` | Atualiza uma medicao no banco de dados. |


# Imagens endpoint

| Method | Description |
|---|---|
| `GET - localhost:8888/imagens` | Retorna todas as imagens. |
| `GET - localhost:8888/imagens/{id}` | Retorna imagem por id. |
| `POST - localhost:8888/imagens` | Cadastra uma nova imagem no banco de dados. |


## Authors

<table>
  <tr>
    <td align="center">
      <a href="https://www.linkedin.com/in/rodolfomno/" target="_blank" rel="noopener noreferrer">
        <sub>
          <b>Rodolfo Marqeus</b>
        </sub>
      </a>
    </td>
        <td align="center">
      <a href="https://www.linkedin.com/in/lucas-m-toledo/" target="_blank" rel="noopener noreferrer">
        <sub>
          <b>Lucas Toledo</b>
        </sub>
      </a>
    </td>
        <td align="center">
      <a href="https://www.linkedin.com/in/rodolfomno/" target="_blank" rel="noopener noreferrer">
        <sub>
          <b>Davio Lopes</b>
        </sub>
      </a>
    </td>
  </tr>
</table>
