# Dicionário

<img src="https://sme.goiania.go.gov.br/conexaoescola/wp-content/uploads/2023/04/25.png" width="600">

Neste exercício vamos modelar um dicionário que armazena palavras em Português e sua respectiva tradução para o Inglês, bem como palavras do Inglês e sua equivalente em Português.

## Classe Dicionario.java

Esta será a classe central da aplicação e deve possuir como públicos **somente** os métodos explicados abaixo:

### adicionarPalavra()
Inicialmente, nosso dicionário será vazio e, por meio deste método, vamos cadastrando as palavras. Os parametros deste método devem ser a **palavra** do tipo String, a **traducao** desta palavra, também do tipo String, e o **dicionario** no qual ela será vinculada do tipo TipoDicionario.

Por fim, o método deverá possuir a seguinte assinatura: 

`public void adicionarPalavra(String palavra, String traducao, TipoDicionario dicionario)`

### traduzir()
Este método receberá como parâmetro a **palavra** pela qual se busca a tradução e o **dicionario** no qual ela deve ser pesquisada.

Quando a palavra não existir no dicionário pesquisado, o sistema deve lançar uma exceção do tipo `unchecked` chamada `PalavraNaoEncontradaException`. 

O sistema também deve traduzir a palavra sem diferenciar letras maiúsculas e minúsculas.

Por fim, o método deverá possuir a seguinte assinatura: 

`public String traduzir(String palavra, TipoDicionario dicionarioDeBusca)`

## Enumerador TipoDicionario.java
Este enumerador será utilizado para classificar os dicionários de Inglês e Português. Sendo assim, seus valores deverão ser `INGLES` e `PORTUGUES`.

## Mapas
Devem ser utilizados os recursos do Map, conforme vistos em aula, para cadastrar as palavras onde a chave é a palavra pesquisada e o valor a sua tradução. Como dica final, crie um mapa para as palavras em Português e um mapa para as palavras do Inglês.

