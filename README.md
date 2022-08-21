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

- Acesse o seguinte endereço no navegador para testar
http://localhost:8080/swagger-ui.html

- Ou se preferir pode testar através do PostMan
localhost:8080/validation (POST)

``` json

{      
        "password": "abtp9!fok"
    }

```



- Acesse o H2
- [H2](http://localhost:8080/h2-console/login.jsp?jsessionid=55c3678c0293261b804c5fbbaa97f7b6).
- JDBC URL: jdbc:h2:mem:valid_secdb


## Detalhes Técnicos
- Java 11
- Spring Boot 2.7.2
- Banco de Dados H2
- Regex para validar o formato da senha
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
Senha informada: "AbTp9!fok"
![senhaok](https://user-images.githubusercontent.com/80723896/185800913-cf508df0-098c-4d9c-b681-fe3f0dccafbd.png)

Imagem de como ficará salvo no Banco de Dadps H2:
[Exemplo]![senha h2](https://user-images.githubusercontent.com/80723896/185799716-c2c7342b-426d-487f-a581-1f82a6184a13.png)

Imagem de exemplo quando a senha não tiver caracter minúsculo:
Senha informada: ABTP9!FOK
![miniuscula](https://user-images.githubusercontent.com/80723896/185801057-7ceb54de-1520-4645-ac8a-6170c632e9b7.png)

Imagem de exemplo quando a senha não tiver caracter maiúsculo:
Senha informada: abtp9!fok
![maiuscula](https://user-images.githubusercontent.com/80723896/185801399-6e2250ab-3e69-44c3-9d08-af7f00c79652.png)




