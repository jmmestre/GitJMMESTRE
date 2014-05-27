----- MOTIVAÇÃO ---------------------------------------------------------------

A minha motivação para resolver este problema, foi logo quando recebi o mesmo,
é difícil em um teste seletivo, realizar um teste complicado como esse, foi uma surpresa, para
mim isso significa uma preocupação maior da empresa, em relação a desenvolvimento de sistemas,
acredito que vocês se preocupam mais com a qualidade, do que com o prazo, e meu objetivo
e vestir a camisa de uma empresa como esta, quero utilizar todo o meu conhecimento teórico,
que está guardado há algum tempo, devido a realidade das empresas de hoje.

Gostaria de agradecer pela oportunidade, pois, com certeza, quando eu for resolver um outro problema,
estarei mais preparado, me fez pensar fora da caixa.

----- INTRODUÇÃO --------------------------------------------------------------

Foi desenvolvido para o problema proposto, onde os parâmetros de entrada são
origem, destino, autonomia, valor combustível (todos parâmetros são inteiros)
e a resposta é um xml com os campos codigoRetorno, mensagemRetorno, origem, destino,
menor caminho, menor distancia e menor custo.

A parte de persistência foi desenvolvida com Spring Jdbc Template, visando a
performance.

O Webservice foi desenvolvido na arquitetura Rest, utilizando WS-RS e Jersey.

O algoritmo utilizado para resolver o problema, foi o dijkstra.

O serviço funciona da seguinte maneira, a partir de um cadastro de cidades, é
realizado um cadastro de rotas (via script sql), utilizando os códigos das cidades cadastradas
anteriormente, o serviço retornará o menor caminho de uma cidade a outra.
Obs: não é possível informar um código de uma cidade que não esteja cadastrada na base.

O Webservice não realiza nenhum cadastro, eles devem ser feitos via script, ele
apenas retorna a menor roda de uma origem a um destino e o seu custo.

É bem simples testar o serviço, basta informar os dados via URl, e visualizar o xml
gerado no próprio browser, segue um exemplo:
http://localhost:8585/Logistica/rest/restwebservice/consultaRota?origem=1&destino=7&autonomia=10&valorCombustivel=2.35

Foi realizado um tratamento de erros, onde retorna 0 para requisições bem sucedidas, e 0 para requisições
com erros, juntamente com uma mensagem de sucesso ou não.
                                                             
----- CONFIGURAÇÃO BASE DE DADOS -----------------------------------------------

A configuração da base de dados, é a seguinte:

	<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="com.mysql.jdbc.Driver" />
		<property name="url" value="jdbc:mysql://localhost:3306/logistica" />
		<property name="username" value="root" />
		<property name="password" value="mysql" />
	</bean>

Localizado no arquivo Spring-Datasource.xml

Na pasta Logistica/WebContent/WEB-INF/Scripts, existe um arquivo chamado DUMP_BASE_LOGISTICA.sql, 
com o DUMP da base de dados utilizada, as informações devem ser inseridas através de scripts.

----- INSTALAÇÃO APLICAÇÃO -----------------------------------------------------

A aplicação pode ser instalada em qualquer servidor de aplicação, nos testes realizados,
foi utilizado o JBOSS 7.1, onde não foi utilizado nenhum recurso do mesmo.

----- DOCUMENTAÇÂO e TESTES -----------------------------------------------------

Não foi gerado nenhuma documentação técnica do sistema, e nem de testes.

