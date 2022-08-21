# Uma API para realizar a validação do nível de segurança da senha fornecida pelo usuário. :lock:
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


## :hammer: Instruções básicas para execução do projeto
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


## :gear: Detalhes Técnicos
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


```json
`curl -X 'POST' \
  'http://localhost:8080/validation' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "password": "AbTp9!fok"
}'`
```

:white_check_mark: Imagem de exemplo do Swagger quando a senha for válida: 
Senha informada: "AbTp9!fok" 
![senhaok](https://user-images.githubusercontent.com/80723896/185800913-cf508df0-098c-4d9c-b681-fe3f0dccafbd.png)

:x: Imagem de como ficará salvo no Banco de Dadps H2:
[Exemplo]![senha h2](https://user-images.githubusercontent.com/80723896/185799716-c2c7342b-426d-487f-a581-1f82a6184a13.png)

:x: Imagem de exemplo quando a senha não tiver caracter minúsculo:
Senha informada: ABTP9!FOK
![miniuscula](https://user-images.githubusercontent.com/80723896/185801057-7ceb54de-1520-4645-ac8a-6170c632e9b7.png)

:x: Imagem de exemplo quando a senha não tiver caracter maiúsculo:
Senha informada: abtp9!fok
![maiuscula](https://user-images.githubusercontent.com/80723896/185801399-6e2250ab-3e69-44c3-9d08-af7f00c79652.png)

:x: Imagem de exemplo quando a senha não tiver caracter especial:
Senha informada: aBtp9RfoK
![caracterespecial](https://user-images.githubusercontent.com/80723896/185802568-1fe23e6a-d27a-45c9-980f-e944f6760aff.png)

:x: Imagem de exemplo quando a senha não tiver a quantidade de caracter suficiente:
Senha informada: aB
![maxcaracter](https://user-images.githubusercontent.com/80723896/185802822-6f1e1fa5-602b-43e3-befb-d352dc3445a9.png)

:x: Imagem de exemplo quando a senha tiver caracter repetido:
Senha informada: AbTp9!foA
![repetido](https://user-images.githubusercontent.com/80723896/185803165-f202a7f4-919c-4665-8b1f-4e9dfb816ee0.png)

## Detalhes sobre a sua solução:
- O meu raciocínio sobre a solução foi utilizar Regex para validar expressões regulares, nunca tinha usado Regex antes então foi um desafio pra mim pois busquei conhecimento vendo vídeos e lendo documentação para entender como funciona o recurso, acredito que ainda dê pra melhorar bastante coisa na validação das expressões.

- Pensei em fazer realmente uma API Rest utilizando a linguagem Java na versão 11 com Spring. Para isso fiz um controller com um único endpoint de Post passando a senha no body da requisição do tipo String, fiz um service onde utilizei 3 métodos, primeiro é o metodo para validar caracter repetidos, o segundo é o método para validar as expressões regulares e terceiro fiz um método para criptografar a senha para salvar no banco, pois ninguém pode conhecer as senhas dos usuários quando ficam salvas em um Banco de dados, então fiz um método que converte a senha para MD5 e por útlimo, tem o repository que persiste a entidade no banco de dados caso a senha seja true. 

- Sobre as senhas inválidas, achei mais amigável retornar uma exceção quando for informado uma senha errada, retorno um bad request 400 com uma menssagem dizendo o motivo pelo qual a senha não está válida, ficando então mais fácil para o usuário entender onde ele errou e informar então uma senha válida.

- Referente aos testes, utilizei Mockito para realizar os testes unitários na classe ValidationServiceTests e testar o retorno da mensagem, quando passa uma senha inválida e também quando passa uma senha válida. Para o teste de integração utilizei RestAssured testando todo o fluxo do endpoint na classe ValidationControllerTests
Acredito que os testes eu possa melhorar mais, montar mais cenários e adicionar alguma lib para analisar a cobertura dos testes

- Esse foi o meu raciocínio para resolução do case, mas estou aberto a criticas e sugestões para melhorar a API, acredito que com tempo posso melhorar o service onde faço a validação das expressões regulares e também melhorar a parte de testes. 

- :cloud: Quero me aperfeiçoar em AWS e tirar certificações pois ainda não tenho um conhecimento tão avançado em AWS. Aqui está um curso a qual vou iniciar referente ao assunto https://www.udemy.com/course/preparatorio-exame-aws-certified-cloud-practitioner-clf-c01/

- Agradeço desde já a oportunidade!


