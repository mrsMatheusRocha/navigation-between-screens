qqqqqqq# 🚀 Navegação entre Telas com Jetpack Compose

Este projeto demonstra a evolução de um aplicativo Android focado na navegação dinâmica entre múltiplas telas utilizando **Jetpack Compose Navigation**. O desenvolvimento foi feito de forma incremental, com foco na passagem de parâmetros obrigatórios e opcionais, conforme os requisitos de avaliação do Checkpoint.

---

## 📜 Descrição do Projeto

O aplicativo simula um fluxo de navegação partindo de um menu principal (`MenuScreen`) para telas de detalhes (`PerfilScreen` e `PedidosScreen`). O projeto evoluiu a partir de uma base técnica pré-existente para implementar o roteamento dinâmico e a transferência de dados seguros entre os componentes composables.

---

## 🎯 Objetivo da Prova

O objetivo principal deste projeto é demonstrar a capacidade de evoluir um software já iniciado, aplicando na prática os conceitos de navegação entre telas no Android. O foco técnico está no domínio da passagem de parâmetros (obrigatórios, opcionais e múltiplos) configurando corretamente o `NavHost` e as rotas.

---

## 📝 Explicação de Cada Evolução Implementada (Histórico de Commits)

Abaixo está o detalhamento de cada etapa da implementação, explicando o que foi feito, como a navegação foi configurada e como os parâmetros são enviados e recebidos.

### 1️⃣ [Passagem de parâmetros obrigatórios na tela de Perfil](https://github.com/mrsMatheusRocha/navigation-between-screens/commit/000bb891cd9a2a580ed4d86bd4ac4b889680d27f)
- **O que foi implementado:** Configuração para enviar o nome do usuário para a tela de perfil de forma obrigatória.
- **Configuração da Navegação:** No `MainActivity.kt`, a rota da `PerfilScreen` foi alterada de `"perfil"` para `"perfil/{nome}"`, definindo que a tela espera um argumento obrigatório. 
- **Envio e Recebimento:** No `MenuScreen`, o botão foi configurado para disparar `navController.navigate("perfil/Matheus Rocha Sousa")`. Na recepção, o `it.arguments?.getString("Nome")` extrai o valor na declaração do `composable`, repassando-o para a `PerfilScreen`, que foi atualizada para exibir `"PERFIL - $nome"` na UI.

### 2️⃣ [Passagem de parâmetros opcionais na tela de Pedidos](https://github.com/mrsMatheusRocha/navigation-between-screens/commit/71715820b3b79202765f4ddad9e25bd0683fe7ac)
- **O que foi implementado:** Preparação da tela de Pedidos para receber um parâmetro opcional chamado `cliente`.
- **Configuração da Navegação:** A rota da `PedidosScreen` foi ajustada usando a sintaxe de query string: `"pedidos?cliente={cliente}"`. Foi utilizada a função `navArgument` para definir um `defaultValue = "Cliente Genérico"`, garantindo que o app não quebre se nenhum valor for passado.
- **Envio e Recebimento:** A assinatura da função `PedidosScreen` foi modificada para aceitar `nome: String?`, permitindo que a interface mostre o nome do cliente apenas quando ele estiver disponível, atualizando o texto para `"PEDIDOS - $nome"`.

### 3️⃣ [Inserção de valor em parâmetro opcional](https://github.com/mrsMatheusRocha/navigation-between-screens/commit/a4e3ba3ff33792580eeb784ac7ee1c5e92e71217)
- **O que foi implementado:** O envio efetivo de um dado preenchendo o parâmetro opcional criado no passo anterior.
- **Como foi configurado:** No `MenuScreen`, o evento `onClick` do botão que leva aos pedidos foi atualizado. Em vez de chamar apenas a rota base, ele agora envia ativamente o parâmetro na URI utilizando `navController.navigate("pedidos?cliente=Cliente XPTO")`. Com isso, a tela de pedidos passa a exibir "Cliente XPTO" em vez do valor default.

### 4️⃣ [Passagem de múltiplos parâmetros entre telas](https://github.com/mrsMatheusRocha/navigation-between-screens/commit/9568c4c797d8a63fbaf7b5f07d410ce3fcea3f06)
- **O que foi implementado:** A rota de Perfil foi expandida para receber dois parâmetros obrigatórios simultaneamente: Nome e Idade.
- **Configuração da Navegação:** A rota no `NavHost` foi alterada para `"perfil/{nome}/{idade}"`. Foi necessário declarar explicitamente a lista de `arguments` no `composable`, definindo que `"nome"` é do tipo `StringType` e `"idade"` é do tipo `IntType`. 
- **Envio e Recebimento:** O clique no `MenuScreen` foi atualizado para concatenar ambos os dados na rota: `navController.navigate("perfil/Matheus Rocha Sousa/27")`. No recebimento, a idade é extraída com `it.arguments?.getInt("idade")` e repassada para a `PerfilScreen`, que foi adaptada para processar múltiplos argumentos de entrada.

---

## 📂 Referências

- [Documentação oficial Jetpack Navigation Compose](https://developer.android.com/jetpack/compose/navigation)
- Repositório FIAP de referência: [android--navigation-between-screens-app](https://github.com/carreiras/android--navigation-between-screens-app)
