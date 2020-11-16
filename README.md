# ProjetoHibernateNASA

## Resume



## Source

<p align="center">
<a name="top" href="https://api.nasa.gov/"><img src="https://api.nasa.gov/assets/footer/img/favicon-192.png"></a>
</p>

## Features

- Suporte no JavaEE podendo ser utilizado o JavaSE-8 (`jdk 8.x e 11.x`).

- Suporte no Servidor Apache Tomcat versões `8.x e 9.x`, aconselhável a versão `9.x` - Link: https://downloads.apache.org/tomcat/tomcat-9/v9.0.39/bin/apache-tomcat-9.0.39-windows-x64.zip

- Dados recorrentes de dependencias do projeto podem ser utilizadas de acordo como está definido no Link do pom.xml: https://github.com/Reis-Silva/ProjetoHibernateNASA/blob/main/HibernateNASA/pom.xml desde de que esteja dentro das versões do jdk.

## Troubleshooting

- Nas configurações do Microsoft SQLServer Management Studio em: `SQL Server Configuration Manager/Configurações de Rede do SQL Server/Protocolos para o servidor"`. Verificar se a opção do protocolo está `Habilitada`.
 
<p align="center">
<img src="https://github.com/Reis-Silva/ProjetoHibernateNASA/blob/main/HibernateNASA/src/main/webapp/resources/NASA/img/ProtocoloHabilitado.png">
</p>
 
- Em caso de erro referente ao bloqueio efetuado pelo Firewall, ir para a aba Endereço IP, selecionar `IP4` e mudar o endereço IP para `194.100.1.100`, em `IPAll` verificar se a porta está como `1433` e as portas dinamicas como 0 ou 55629. Reinicie todas os processos da conexão do SQL server pela aba `serviços/abrir serviços` do Gerenciador de Tarefas. 
 
 <p align="center">
<img src="https://github.com/Reis-Silva/ProjetoHibernateNASA/blob/main/HibernateNASA/src/main/webapp/resources/NASA/img/IP4_IPAll.png">
</p>

## How to Use

-  1 - Clone o projeto através do link: `https://github.com/Reis-Silva/ProjetoHibernateNASA`;

-  2 - Coloque a pasta do Servidor Apache Tomcat em um local de preferência. Na IDE eclipseEE, utilize a opção File/new/new server, escolha a versão do servidor adquirida através do donwload, depois selecione onde se encontra esta pasta;

-  3 - Utilizar a opção "update Maven" para atualizar as referências de bibliotecas;

-  4 - Quando o Servidor estiver conectado, utilize a página para utilizar o aplicativo `http://localhost:8080/HibernateNASA/index.xhtml`.

## Observed:

OBS: No mecanismos de Banco de Dados do SQL Server utiliza-se da "Autenticação do SQL Server": `Logon: root e Senha 1234`; 

OBS2: Função de criação do banco de dados não está automática (foi estabelecido a criação obrigatória do "bancogenerico" no servidor, pode ser mudado) apenas para a tabela;

OBS3: Utilizou-se o Eclipse EE - Version: 2020-09 (4.17.0).


########################################################################################################################################################################################
### []´s
