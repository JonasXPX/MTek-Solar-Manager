# MTek-Solar-Manager
MTeck Solar Manager - With Authentication

## Usando autenticação
### Criar conta:
`POST /user`
```json
{
  "username": "conta@conta.com",
  "password": "senha"
}
```
### Login
 Header retorna o token necessário para a autorazação da request
`POST /login`
```json
{
  "username": "conta@conta.com",
  "password": "senha"
}
```
#### Header
```json
"Authorization": "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0ZUB0ZXN0ZS5jb20iLCJleHAiOjE2MDM4NDQ5MTN9.-O6E3pbrtTeRuWlSpH1MqxR12Y1VuWIvGTy47yP9QVSO_CkK9_lJjb_ilI4kMqIbH8-qcckNhQ0bTXGj5ovk0g"
```

### Exemplo de requisição autorizada
consulta de informação do fernecedor `GET /fornecedor/{id}`
Header 
```json
"method": "GET"
"url": "/fornecedor/1"
"header": {
  "Authorization": "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0ZUB0ZXN0ZS5jb20iLCJleHAiOjE2MDM4NDQ5MTN9.-O6E3pbrtTeRuWlSpH1MqxR12Y1VuWIvGTy47yP9QVSO_CkK9_lJjb_ilI4kMqIbH8-qcckNhQ0bTXGj5ovk0g"
}
```
