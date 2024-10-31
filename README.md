# Navegação em Jetpack Compose - Projeto em Kotlin

Este projeto é uma implementação de um sistema de navegação em um aplicativo Android utilizando **Kotlin** e **Jetpack Compose**, com o objetivo de melhorar a experiência de navegação interna sem a necessidade de bibliotecas externas.

## Visão Geral

A navegação é uma parte crucial no desenvolvimento de aplicativos, especialmente ao usar uma estrutura moderna como Jetpack Compose. Esse projeto explora como implementar navegação de maneira eficiente e organizada, usando apenas componentes nativos do Compose e as melhores práticas do Jetpack Compose para um fluxo de navegação simples, flexível e escalável.

## Objetivo

O principal objetivo deste projeto é demonstrar uma maneira de gerenciar a navegação entre telas no Android usando apenas **Kotlin** e **Jetpack Compose**, sem o uso de bibliotecas de terceiros. Com isso, espera-se:
- Facilitar o entendimento dos conceitos fundamentais de navegação no Compose.
- Demonstrar como organizar rotas, destinos e transições.
- Proporcionar uma estrutura que permita fácil expansão e adaptação a diferentes tipos de aplicativos.

## Recursos do Projeto

- **Navegação entre telas**: Configuração de navegação utilizando o próprio Compose para facilitar transições.
- **State Management**: Gerenciamento de estado para manter as telas reativas e sincronizadas com as mudanças de dados.
- **Componentes de UI modulares**: Construção de interfaces modulares para permitir uma fácil navegação e reutilização de componentes.
- **Estrutura de Rotas**: Organização de rotas em um único local, simplificando a estrutura de navegação.

## Estrutura do Projeto

O projeto está dividido em pacotes para facilitar a manutenção e a compreensão:

- **ui**: Contém os componentes visuais e telas do aplicativo.
- **navigation**: Inclui toda a lógica de navegação do aplicativo, como rotas e ações de navegação.

## Tecnologias Utilizadas

- **Kotlin**: Linguagem principal do projeto.
- **Jetpack Compose**: Framework para criar interfaces de usuário declarativas.

## Como Funciona a Navegação

1. **Configuração das Rotas**: Cada tela é registrada como uma rota dentro do módulo de navegação. Utilizamos `@Composable` para construir cada tela e os parâmetros são passados por meio de argumentos diretos.
2. **Navegação Entre Telas**: A navegação é gerenciada através de lambdas, que recebem ações e destinos como parâmetros, facilitando o redirecionamento entre telas.

## Como Executar o Projeto

1. Clone o repositório:
    ```bash
    git clone https://github.com/BerPGR/kotlin-mastering-navigation
    ```
2. Abra o projeto no Android Studio.
3. Sincronize o Gradle e execute o projeto em um emulador ou dispositivo físico.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para enviar issues e pull requests com sugestões, melhorias ou correções de bugs.

---

**Contato**: Caso tenha dúvidas ou sugestões, entre em contato através do meu [perfil GitHub](https://github.com/BerPGR).
