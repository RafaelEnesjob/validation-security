# Uma API para realizar a validação do nível de segurança da senha fornecida pelo usuário. 
Será considerada uma senha válida aquela que seguir as regras abaixo.

###### Regras
 - Nove ou mais caracteres
 - Ao menos 1 dígito
 - Ao menos 1 letra minúscula
 - Ao menos 1 letra maiúscula
 - Ao menos 1 caractere especial
 - Considere como especial os seguintes caracteres: !@#$%^&*()-+
 - Não possuir caracteres repetidos dentro do conjunto

 **Exemplo:**

![example](https://user-images.githubusercontent.com/80723896/185744384-1a102957-e7db-4ec1-9384-1472f8057985.png)


## Instruções básicas para execução do projeto
Antes de começar será necessário que a máquina possua a versão 11 do Java e uma IDE de sua preferência. Eu utilizei o IntelliJ IDEA.
[Tutorial para Instalação do Java 11](https://www.youtube.com/watch?v=bE5GbXgfi8c&t=758s).

###### Iniciando o projeto pela primeira vez

- Clone este repositório
git clone https://github.com/RafaelEnesjob/validation-security.git

- Inicie a aplicação com sua IDE de sua preferência

- Acesse o seguinte endereço no navegador
http://localhost:8080/swagger-ui.html

- Acesse o H2
- [H2](http://localhost:8080/h2-console/login.jsp?jsessionid=55c3678c0293261b804c5fbbaa97f7b6).


## Detalhes Técnicos
- Java 11
- Spring Boot 2.7.2
- Banco de Dados H2
- Testes unitários com Junit utilizando Mockito
- Teste integrado utilizando RestAssured
- Criptografia da senha com MD5

## Documentação da API

- Inserindo uma senha para verificar se é válida

| Parâmetro  |  Tipo  | 
| ------------------- | ------------------- |
| password |  String |

CURL de exemplo:
`curl -X 'POST' \
  'http://localhost:8080/validation' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "password": "AbTp9!fok"
}'`

Imagem de exemplo do Swagger quando a senha for válida:

