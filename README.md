Este projeto é uma API RESTful de Inventário (CRUD) desenvolvida em Java e Spring Boot, utilizando o Oracle Database Express Edition (XE) como backend. 
O objetivo é demonstrar proficiência em JPA, arquitetura limpa e manipulação de relacionamentos complexos.

Endpoints Principais:

POST /api/v1/categorias: Criação de categorias.

POST /api/v1/produtos: Criação de produtos com relacionamento ManyToOne com Categoria.

PUT /api/v1/estoque: Operação de Upsert (Criação ou Atualização) do estoque por ProdutoId e LocalizacaoId.

GET /api/v1/estoque?produtoId=...: Consulta por combinação de chaves.

