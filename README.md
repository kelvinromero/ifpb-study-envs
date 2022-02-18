# Ambientes de estudo das disciplinas dockerizados

A maioria das disciplinas do curso de Sistemas para Internet do IFPB exige a instalação de servidores e SDKs das linguagens de programação lecionados no curso.
Em algum momento as instalações acabam sendo processos bem destrutivos ou apenas repetitivas.
Então a ideia é não ter que instalar nada na sua máquina virtual e sim dentro de containers.


## Contexto

Para quem ainda não entende bem o que são containers, já devem estar familiarizados com máquinas virtuais.
São praticamente a mesma coisa, uma das principais diferenças é que não há necessidade de instalar um sistema operacional em um hardware virtual, como no caso das VMS.
Os containers executam como processos compartilhando os recursos do host.

Para alguns o uso disso pode ser detrimental, já que pode roubar o conhecimento de configurar essas coisas manualmente, mas para quem quer economizar tempo pode ser útil.

Sintam-se avontade para solicitar um ambiente ou tirar dúvidas.


## Como usar

Dentro da pasta de cada discplina existe o arquivo README.md explicando como poderá ser utilizado para o desenvolvimento das atividades.

## Sobre o docker-compose.yml

- Em cada diretório de discplina é possível encontrar um arquivo chamado `docker-compose.yml`;
- Esse arquivo define a infraestrutura do ambiente de desenvolvimento
- O docker trabalha com containers, que são similares a máquinas virtuais
- O arquivo `docker-compose.yml` geralmente vai definir 3 chaves na raiz:
  - **version**: versão da linguagem utilizada no docker-compose
  - **services**: serviços que serão criados (equivalente a VMs)
  - **networks**: Define uma rede na qual os containers serão inseridos
- Dentro de services você vai encontrar a definição dos containers, por exemplo:
    - O serviço **pgadmin** define o nosso cliente web para o gerenciar o servidor
    - O serviço **db** define o container que conterá nosso servidor de banco de dados postgres
- Dentro de cada **serviço** no `docker-compose.yml` você poderá encontrará algumas definições:
    - **image**: É a nossa *blueprint* de como construir aquele container
    - **ports**: Mapeia a porta do host (sua máquina) para uma porta do container, permitindo acessar containers em localhost
    - **environment**: São variáveis de ambiente que estarão disponíveis dentro do container.
    - **volumes**: Os volumes sincronizam pastas no host para dentro do container
