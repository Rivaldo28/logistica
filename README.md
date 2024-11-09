# logistica
# Sistema de Logística

## Descrição

Este é um sistema de logística desenvolvido com a arquitetura hexagonal e seguindo os princípios do DDD (Domain-Driven Design). A aplicação foi construída utilizando o Gradle como ferramenta de gerenciamento de dependências e construção, permitindo uma configuração simples e eficiente do projeto.

### Tecnologias Utilizadas

- **Java**: Versão 21
- **Spring Boot**: Framework principal para construção de aplicações Java
- **Gradle**: Ferramenta de automação de builds
- **H2**: Banco de dados em memória para testes
- **PostgreSQL**: Banco de dados utilizado na aplicação
- **Swagger**: Para documentação da API
- **JUnit**: Framework de testes unitários
- **Mockito**: Biblioteca para simulação de objetos em testes

### Funcionalidades

- **API RESTful**: A aplicação expõe uma API RESTful que permite gerenciar operações logísticas, como criação, atualização e consulta de produtos.
- **Documentação**: A documentação da API é gerada automaticamente com o Swagger, facilitando a integração e o teste das funcionalidades.
- **Testes Automatizados**: O sistema é acompanhado por uma suíte de testes unitários utilizando JUnit e Mockito, garantindo a qualidade do código e a cobertura dos casos de teste.

## Como Executar a Aplicação

### Pré-requisitos

- JDK 21
- Gradle

### Instalação

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu_usuario/sistema-logistica.git
   cd sistema-logistica
   