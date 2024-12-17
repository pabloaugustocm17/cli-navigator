# CLI

*CLI* criada em *Java* com objetivo de fazer a navegação entre projetos a partir de sua criação no terminal.

## Instalação

Para instalar deve ser seguidos as etapas:

1. Clonar o repositório
2. Criar executável *Java* em *.jar*, recomendado utilizar o comando:

```bash

mvn clean package

```

3. Criar uma pasta dentro da pasta raiz do projeto chamada *bin*
4. Criar um arquivo *.bat* apontando para o *.jar* com o seguinte código, substituindo para o caminho correspondente:

```bat

@echo off
java -jar "C:\...\navigator.jar" %*

```

5. Adicionar nas variáveis de ambiente do sistema o caminho para a pasta *bin*
5.1. Em *Windows* basta pesquisar por *Editar as variáveis de ambiente do sistema* > *Variáveis de ambiente* > *Path* e colocar o caminho.


## Funcionalidades

### Criar projeto

Para criar um projeto basta digitar em seu terminal:

```bash

navigator -c

Name: {input}
Description: {input}
Path: {input}

```

O *Name* representa o *alias* para acessar seu projeto (Suporta apenas uma palavra).
O *Description* seria uma descrição que será exibida na funcionalidade de exibir o projeto.
o *Path* seria o referencial ao seu projeto, que será aberto em uma *IDE* (exemplo: *C:\Users\user_test\dev\navigation*)

### Listar projeto

Para um listar um projeto basta digitar em seu terminal:

```bash

navigator -l

Name: navigator
Description: CLI utilizada para navegar entre seus projetos
Path: C:\Users\user_test\dev\navigation

...

```

### Entrar em um projeto

Para entrar em um projeto basta digitar em seu terminal:

```bash

navigator -e {alias}

```
