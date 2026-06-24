Nome do Projeto (Insira aqui)
Este projeto consiste em uma API RESTful desenvolvida em Java com Spring Boot, focada no gerenciamento de agendamentos, serviços, profissionais e clientes. O projeto utiliza o Swagger UI para documentação interativa e testes dos endpoints.

🚀 Tecnologias Utilizadas
Linguagem: Java

Framework: Spring Boot

Documentação: Swagger/OpenAPI

📖 Funcionalidades (Endpoints)
A API está organizada nos seguintes controladores:

1. servico-controller
   Gerencia o catálogo de serviços oferecidos.

GET /api/servicos: Lista todos os serviços.

POST /api/servicos: Cria um novo serviço.

GET /api/servicos/{id}: Busca um serviço específico por ID.

PUT /api/servicos/{id}: Atualiza um serviço existente.

DELETE /api/servicos/{id}: Remove um serviço.

2. profissional-controller
   Gerencia o cadastro dos profissionais.

GET /api/profissionais: Lista todos os profissionais cadastrados.

POST /api/profissionais: Adiciona um novo profissional.

GET /api/profissionais/{id}: Busca um profissional por ID.

PUT /api/profissionais/{id}: Atualiza os dados de um profissional.

DELETE /api/profissionais/{id}: Remove um profissional da base.

3. cliente-controller
   Gerencia o cadastro dos clientes.

GET /api/clientes: Lista todos os clientes.

POST /api/clientes: Cadastra um novo cliente.

GET /api/clientes/{id}: Detalha um cliente por ID.

PUT /api/clientes/{id}: Atualiza as informações do cliente.

DELETE /api/clientes/{id}: Remove um cliente.

4. agendamento-controller
   Gerencia a lógica de negócio principal: o agendamento de serviços.

GET /api/agendamentos: Lista todos os agendamentos realizados.

POST /api/agendamentos: Cria um novo agendamento.

GET /api/agendamentos/{id}: Busca um agendamento específico.

PUT /api/agendamentos/{id}: Atualiza um agendamento.

DELETE /api/agendamentos/{id}: Cancela ou remove um agendamento.

5. usuario-controller
   Gerencia o acesso e autenticação dos usuários do sistema.