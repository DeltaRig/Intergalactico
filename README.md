# Desafio de tradução intergalactica
Este programa deve ajudar um viajante intergaláctico a converter valores dos locais que encontrar que tem o mesmo sistema de organização conhecida dos números romananos.

Desenvolvedora: [Daniela Rigoli](https://www.linkedin.com/in/daniela-rigoli-304b9b190/)

## Solução
####Com uma classe Main:
Onde se recebe o arquivo com afirmações e perguntas e retorna as respostas para as perguntas.

Métodos usados:
	main

####Classe Tradutor:
Faz todo processo de encontrar correspondencia entre os números intergalaticos e os números dos humanos para conseguir responder as perguntas.

Métodos usados:
	métodos básicos

	trad: faz o encaminhamento para as outras classes para obter o resultado desejado

	classific: classifica em true se a frase for uma afirmação e false se for uma pergunta. E também se for pergunta irá excluir o "?" para não o programa não ter que se preocupar com isso depois, se está com espaço ou não o que poderia conflitar na hora de comparar com outra palavra.

	aprende: é onde ocorre o aprendizado da linguagem, ou seja, as afirmações são encaminhadas para esse métodos

	ehRomano: recebe o valor em romano e armazena seu correspondente intergaláctico

	credito: recebe o número intergalactico com o credito e calcula o valor de um credito do metal e armazena

	traduzirNumeral: transforma o número galáctico em inteiro

	traduzirUnidade: retorna o valor da unidade do número intergalático

	responde: analisa a pergunta e mostra ao usuário a resposta




## Andamento:
Feitos:
* Recebe o arquivo
* Lê linha por linha
* Etapa de classificar afirmações e perguntas
* Extrair valores das linhas
 - Identificar se o valor da linguagem humana está em romanos ou inteiros
 - Identificar valores galacticos
 - Identificar valores das unidades de metais

Em andamento:
* Responder alguma entrada

A fazer:
* Revisar e corrigir erros
* Revisar e otimizar os métodos
