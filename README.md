# Persistência de Dados com JPA e Hibernate

Este repositório contém um projeto prático desenvolvido para compreender os conceitos fundamentais de mapeamento objeto-relacional (ORM) utilizando a especificação JPA (Jakarta Persistence) e o framework Hibernate como provedor de persistência. O banco de dados utilizado para os testes locais foi o MySQL.

## Objetivos do Aprendizado

* Configuração do ciclo de vida de entidades e mapeamento de chaves primárias com estratégia de auto-incremento.
* Estruturação correta do arquivo de configuração `persistence.xml` dentro do diretório padrão do Maven.
* Utilização da interface `EntityManager` para operações de persistência (`persist`) e consulta (`find`).
* Compreensão dos conceitos de gerenciamento de transações no ecossistema Java.

## Arquitetura e Tecnologias

* **Linguagem:** Java
* **Gerenciador de Dependências:** Maven
* **Especificação:** JPA (Jakarta Persistence)
* **Provedor ORM:** Hibernate Core
* **Banco de Dados:** MySQL

## Estrutura do Projeto

O código-fonte está dividido em dois pacotes principais dentro de `src/main/java`:

* `dominio`: Contém a classe de entidade (`Pessoa.java`) mapeada com as anotações `@Entity`, `@Id` e `@GeneratedValue`.
* `application`: Contém a classe principal (`programa.java`) que inicializa o `EntityManagerFactory`, gerencia o ciclo de vida do `EntityManager` e executa as transações no banco de dados.

## Configuração do Ambiente

O arquivo `persistence.xml` foi alocado em `src/main/resources/META-INF/` com as seguintes propriedades essenciais:

* `javax.persistence.jdbc.url`: URL de conexão local com o schema do MySQL.
* `javax.persistence.jdbc.user` / `password`: Credenciais de acesso ao banco de dados.
* `hibernate.hbm2ddl.auto`: Definido como `update` para que a estrutura das tabelas seja gerada automaticamente pelo Hibernate a partir das classes Java durante a execução.

## Como Executar

1. Certifique-se de que o serviço do MySQL está ativo e que o schema configurado no `persistence.xml` existe localmente.
2. Clone o repositório.
3. Importe o projeto em uma IDE (IntelliJ IDEA ou VS Code) como um projeto Maven para que as dependências sejam baixadas.
4. Execute o método `main` da classe `programa.java`.

O programa irá instanciar objetos do tipo `Pessoa`, abrir uma transação, persistir os dados no banco, confirmar a transação (`commit`) e realizar uma busca por ID utilizando o método `find`.
