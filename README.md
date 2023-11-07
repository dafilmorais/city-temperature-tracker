# Monitorização de Temperatura em Duas Cidades

Este repositório contém uma aplicação desenvolvida como parte de um desafio. A aplicação é projetada para recolher e processar dados de temperatura de duas cidades distintas e armazená-los para análise posterior.

## Descrição do Desafio

O objetivo deste desafio é criar uma aplicação composta por dois microserviços: um produtor e um consumidor.

- O microserviço **Produtor** é responsável por recolher dados de temperatura de duas cidades diferentes em intervalos regulares (por exemplo, a cada 5 minutos) e enviá-los para um tópico em um message broker. Cada mensagem deve conter informações sobre a cidade, temperatura e data e hora.

- O microserviço **Consumidor** deve consumir os dados do tópico do message broker em tempo real e armazená-los em um banco de dados PostgreSQL para análise posterior.

## Pré-Requisitos

Certifique-se de ter os seguintes pré-requisitos instalados antes de executar a aplicação:

- [Quarkus](https://quarkus.io/)
- Message Broker (Kafka, ActiveMQ ou Mosquitto)
- [PostgreSQL](https://www.postgresql.org/)
- [Docker](https://www.docker.com/) e [Docker Compose](https://docs.docker.com/compose/)

## Estrutura do Repositório

O repositório está organizado da seguinte forma:

- `produtor/`: Código-fonte e recursos do microserviço Produtor.
- `consumidor/`: Código-fonte e recursos do microserviço Consumidor.
- `docker-compose.yml`: Arquivo de configuração do Docker Compose para instanciar os contêineres do message broker e PostgreSQL.
- `docs/`: Documentação adicional, se necessário.

## Configuração e Uso

Antes de executar a aplicação, siga as instruções de configuração e uso em cada diretório do microserviço (produtor e consumidor) e o arquivo `docker-compose.yml` para configurar os contêineres Docker.

## Contribuição

Este é um projeto de desafio, mas contribuições são bem-vindas. Se desejar contribuir, siga as diretrizes de contribuição do projeto.

## Licença

Este projeto está sob a [licença XYZ](LICENSE).

---

Sinta-se à vontade para personalizar este arquivo `README.md` de acordo com as necessidades do seu repositório. Inclua informações adicionais, como exemplos de código, capturas de tela, instruções detalhadas ou qualquer outra informação relevante para os usuários e colaboradores do seu projeto.
