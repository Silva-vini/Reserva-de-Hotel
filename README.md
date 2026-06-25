# Sistema de Reservas de Hotel

Projeto desenvolvido em Java durante o curso Especialista Back-End Java da EBAC.

---

## O projeto

Um sistema de gerenciamento de reservas que roda no terminal. O usuário consegue cadastrar, listar, alterar, cancelar e buscar reservas, além de ordenar por número de diárias.

Escolhi esse projeto porque queria algo que tivesse lógica de negócio real — validação de dados, cálculo de valores, manipulação de estrutura de dados — não só um "Hello World" incrementado.

---

## Funcionalidades

- Cadastro de reserva com validação de tipo de quarto, numeros de dia acima de 0 e valor mínimo de diária
- Listagem completa das reservas ativas
- Alteração e cancelamento por CPF
- Busca de hóspede
- Ordenação decrescente por número de diárias (Bubble Sort implementado manualmente)

**Tipos de quarto e valores mínimos:**

- Standard — R$ 210,99
- Luxo — R$ 549,99
- Presidencial — R$ 1.000,99

---

## Tecnologias

- Java 11
- Orientação a objetos (encapsulamento, getters/setters, toString)
- Arrays e controle de fluxo com Scanner

Sem frameworks. Quis entender a base antes de subir o nível de abstração.

---

## Como rodar

```bash
git clone https://github.com/Silva-vini/hotel-reservas.git
cd hotel-reservas
javac src/Hotel.java src/com/controle/entity/Reserva.java
java -cp src Hotel
```

---

## Estrutura

```
src/
├── Hotel.java                        # menu e operações
└── com/controle/entity/
    └── Reserva.java                  # entidade com regras de negócio
```

---

## O que vem a seguir

Esse projeto foi feito com array fixo de 10 posições de propósito — quero refatorar usando `ArrayList`, depois adicionar persistência e, eventualmente, expor tudo via API REST com Spring Boot. Cada versão vai estar aqui no histórico de commits.

---

Estou em transição de carreira para desenvolvimento back-end. Este é o primeiro de vários projetos que vou construir e documentar publicamente enquanto avanço no curso.

