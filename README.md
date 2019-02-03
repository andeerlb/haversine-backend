# haversine-backend<br />
<p>Projeto usando spring-boot</p><br />

## Necessário

### maven 3.5.2<br/>
### Criar um banco mysql na verso 5.7 com o nome: coordinate<br />

Por padrão o usuario e senha para login no banco foram definidos como:

usuario: root

senha: root

Dependendo da sua configuração pode ser necessario alterar no arquivo<br />
<b>applications.yml</b><br /> 
linha em <br />
<b>spring.datasource.username</b>

##### Comando para executar após criar o banco
mvn spring-boot:run
