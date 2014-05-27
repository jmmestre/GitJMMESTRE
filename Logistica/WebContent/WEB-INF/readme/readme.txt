----- MOTIVA��O ---------------------------------------------------------------

A minha motiva��o para resolver este problema, foi logo quando recebi o mesmo,
� dif�cil em um teste seletivo, realizar um teste complicado como esse, foi uma surpresa, para
mim isso significa uma preocupa��o maior da empresa, em rela��o a desenvolvimento de sistemas,
acredito que voc�s se preocupam mais com a qualidade, do que com o prazo, e meu objetivo
e vestir a camisa de uma empresa como esta, quero utilizar todo o meu conhecimento te�rico,
que est� guardado h� algum tempo, devido a realidade das empresas de hoje.

Gostaria de agradecer pela oportunidade, pois, com certeza, quando eu for resolver um outro problema,
estarei mais preparado, me fez pensar fora da caixa.

----- INTRODU��O --------------------------------------------------------------

Foi desenvolvido para o problema proposto, onde os par�metros de entrada s�o
origem, destino, autonomia, valor combust�vel (todos par�metros s�o inteiros)
e a resposta � um xml com os campos codigoRetorno, mensagemRetorno, origem, destino,
menor caminho, menor distancia e menor custo.

A parte de persist�ncia foi desenvolvida com Spring Jdbc Template, visando a
performance.

O Webservice foi desenvolvido na arquitetura Rest, utilizando WS-RS e Jersey.

O algoritmo utilizado para resolver o problema, foi o dijkstra.

O servi�o funciona da seguinte maneira, a partir de um cadastro de cidades, �
realizado um cadastro de rotas (via script sql), utilizando os c�digos das cidades cadastradas
anteriormente, o servi�o retornar� o menor caminho de uma cidade a outra.
Obs: n�o � poss�vel informar um c�digo de uma cidade que n�o esteja cadastrada na base.

O Webservice n�o realiza nenhum cadastro, eles devem ser feitos via script, ele
apenas retorna a menor roda de uma origem a um destino e o seu custo.

� bem simples testar o servi�o, basta informar os dados via URl, e visualizar o xml
gerado no pr�prio browser, segue um exemplo:
http://localhost:8585/Logistica/rest/restwebservice/consultaRota?origem=1&destino=7&autonomia=10&valorCombustivel=2.35

Foi realizado um tratamento de erros, onde retorna 0 para requisi��es bem sucedidas, e 0 para requisi��es
com erros, juntamente com uma mensagem de sucesso ou n�o.
                                                             
----- CONFIGURA��O BASE DE DADOS -----------------------------------------------

A configura��o da base de dados, � a seguinte:

	<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="com.mysql.jdbc.Driver" />
		<property name="url" value="jdbc:mysql://localhost:3306/logistica" />
		<property name="username" value="root" />
		<property name="password" value="mysql" />
	</bean>

Localizado no arquivo Spring-Datasource.xml

Na pasta Logistica/WebContent/WEB-INF/Scripts, existe um arquivo chamado DUMP_BASE_LOGISTICA.sql, 
com o DUMP da base de dados utilizada, as informa��es devem ser inseridas atrav�s de scripts.

----- INSTALA��O APLICA��O -----------------------------------------------------

A aplica��o pode ser instalada em qualquer servidor de aplica��o, nos testes realizados,
foi utilizado o JBOSS 7.1, onde n�o foi utilizado nenhum recurso do mesmo.

----- DOCUMENTA��O e TESTES -----------------------------------------------------

N�o foi gerado nenhuma documenta��o t�cnica do sistema, e nem de testes.
