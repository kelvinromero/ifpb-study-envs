# Ambiente de estudos para disciplina de programação orientada a objetos - IFPB
Rapidamente construa o ambiente de estudos com o Docker e docker-compose.

## Dependências
- Docker Compose 
- Docker 

## Como usar
- Depois de clonar o repositório
- Acesse ifpb-study-env/poo
- E execute o comando abaixo:
```sh
# O comando abaixo inicia o container
# Inicia o bash dentro do container

docker-compose run openjdk bash
```
- Dentro do container você poderá executar o javac e java dos arquivos criados na pasta.

### Executando exemplo
```
docker-compose run openjdk bash
cd Hello\ World/
javac HelloWorld.java
java HelloWorld.java
```


## Explicando
### docker-compose.yml
Aqui o docker-compose.yml é bem minimalista, ele define o minimo possível.
- Existe apenas um serviço chamado openjdk
- A imagem inclui a openjdk na última versão
- Define o **working_dir** ou diretório de trabalho, ao executar o bash dentro do container o usuário já começa na pasta /src
- Define o **volumes** e diz que a pasta atual do host será mapeada (e sincronizada) com a pasta /src dentro do container

### Makefile
Facilita nossa vida com várias "receitas" que funcionam como atalhos para executar comandos.