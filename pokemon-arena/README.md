![](https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/International_Pok%C3%A9mon_logo.svg/1200px-International_Pok%C3%A9mon_logo.svg.png)
# Batalha Pokémon
Pokémon é uma das franquias de entretenimento mais populares do mundo, criada pela Nintendo, Game Freak e Creatures em 1996. 
O primeiro jogo foi originalmente lançado para o Game Boy, mas a série rapidamente se expandiu para outras mídias, como desenhos animados, filmes e cartas colecionáveis.

No mundo de Pokémon, treinadores capturam criaturas chamadas **Pokémon**, sendo que 
cada uma delas possui ***tipos***, ***atributos*** e ***movimentos*** únicos. 

Os **treinadores** capturam Pokémons e os utilizam para participar de batalhas amistosas contra outros treinadores. 
Durante as batalhas, os Pokémons utilizam movimentos para atacar o adversário e, em certos casos, os treinadores também podem utilizar **Itens** para ajudar seu Pokémon a vencer.

___
# **Parte 1**
# Pokémon
Cada Pokémon, obrigatoriamente, deve possuir [Atributos](#Atributos), [Movimentos](#Movimentos) e [Tipos](#Tipos) próprios.

Além disso, os Pokémons devem possuir os seguintes métodos: 
```java
String falar(); // retorna uma String do próprio nome 
int calcularDano(Pokemon pokemonAdversario); // retorna o dano que aquele pokemon ira causar ao adversário
```

## *Charmander*
**Pokémon salamandra do tipo fogo**

![](https://i.pinimg.com/originals/b5/13/28/b51328854f9214688f594d76b7a45a49.gif)

Atributos

    pontosDeSaude: 39
    ataque: 52
    defesa: 43
    ataqueEspecial: 60
    defesaEspecial: 50
    velocidade: 65

Movimento: ```Brasas(poder=70, TipoMovimento = ESPECIAL)```

Falar: "Charmander"

## *Squirtle*
**Pokémon tartaruga do tipo água**

![](https://pa1.aminoapps.com/7516/1a29b2aefb7546e26e83c79013374f4a84e2abf8r1-500-289_hq.gif)

Atributos

    pontosDeSaude: 44
    ataque: 48
    defesa: 65
    ataqueEspecial: 50
    defesaEspecial: 64
    velocidade: 43

Movimento: ```Bolhas(poder=75, TipoMovimento = ESPECIAL)```

Falar: "Squirtle"

## *Bulbasaur*
**Pokémon semente do tipo grama**

![](https://media.tenor.com/mGw-ec0YlK0AAAAM/bulbasaur-pokemon.gif)

Atributos

    pontosDeSaude: 45
    ataque: 49
    defesa: 49
    ataqueEspecial: 65
    defesaEspecial: 65
    velocidade: 45

Movimento: ```FolhaNavalha(poder=60, TipoMovimento = FISICO)```

Falar: "Bulbasaur"

## *Pikachu*
**Pokémon rato do tipo elétrico**

![](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEicl8XIeVrdQEvFi5k0SV_yTky-FgUKuBED6OOYFIzgr5YfYUtPl4GXaY8AMhuDLXPz6DRbbxJ_7CSnvpaxl7DPYNEyjSlanaEBIRFuBIYQfjkz0pH906AtdFZw2eSjEQFgGJJE22xjHGqn/s1600/cutepikachu.gif)

Atributos

    pontosDeSaude: 35
    ataque: 55
    defesa: 40
    ataqueEspecial: 50
    defesaEspecial: 50
    velocidade: 90

Movimento: ```AtaqueRapido(poder=60, TipoMovimento = FISICO)```

Falar: "Pikachu"


# Atributos
Todos os Pokémon possuem atributos iniciais, sendo eles:
- pontosDeSaude
- ataque
- ataqueEspecial
- defesa
- defesaEspecial
- velocidade

Durante a batalha, o atributo ***pontosDeSaude*** sofrerá alterações a cada ataque que o Pokémon receber de seu adversário.

# Movimentos
Os Pokémons podem utilizar movimentos durante as batalhas para causar dano a seus adversários.

Todo movimento possui um nível de ***Poder*** (que pode variar entre 0 e 100) e uma categoria **TipoMovimento** (que pode ser ESPECIAL ou FISICO).

No caso de movimentos **físicos**, os atributos *ataque* e *defesa* são levados em consideração, e no caso de movimentos especiais, os atributos de *ataqueEspecial* e *defesaEspecial* serão levados em consideração.

# Tipos
![](https://static.tvtropes.org/pmwiki/pub/images/pokemon_1stgen.jpg)

Todo Pokémon possui um tipo atrelado a ele

Essa tipagem tem um papel crucial nas batalhas, pois certos Pokémon têm uma vantagem sobre Pokémon de determinados tipos diferentes.

São eles:
- Fogo (vantagem contra Grama)
- Grama (vantagem contra Água)
- Água (vantagem contra Fogo)
- Eletrico (vantagem contra Água)

Caso um Pokémon que esta atacando, tenha uma vantagem de tipo sobre o Pokémon que esta defendendo, o ***multiplicadorVantagem*** irá assumir o valor **2**, do contrário, assumirá o valor **1**.

# **Parte 2**
## Treinador

![](https://i.pinimg.com/originals/ae/81/28/ae8128a504b3452049db9dd88d24140d.jpg)


Cada treinador deve possuir: 
```java
private String nome; // nome proprio
private List<Pokemon> pokemons // lista de pokemons (tambem poderia ser um array)
private Item item; // item para usar, por vezes recebe null
```

Além disso, os treinadores devem possuir dois construtores (utilizar sobrecarga).
```java
new Treinador(String nome); // informando apenas o nome
new Treinador(String nome, Item item); // informando opicionalmente o item
```

Um método próprio.
```java
void adicionarAoTime(Pokemon pokemon); //adiciona um pokemon ao array/lista de pokemons
```

E sobreescrever os métodos nativos.
```java
public boolean equals(Object o); // utilizar o atributo nome como criterio de comparação
public String toString(); // retornar o atributo nome
```


# **Parte 3**
# Item

Durante as batalhas, os treinadores têm a possibilidade de utilizar um item no seu pokemon ativo (que está em batalha).

Todo item deve implementar o método.
```java
void usarItem(Pokemon pokemon);
```

## ![](https://img.pokemondb.net/sprites/items/potion.png) Poção

Função: Cura em 50 pontos o pokemon, não podendo ultrapassar o valor inicial de pontos de vida.

Turno de acionamento: 2

## ![](https://img.pokemondb.net/sprites/items/x-attack.png) Ataque X 
Função: Aumenta em **200** pontos o atributo de *ataque* do pokemon.

Turno de acionamento: 1

## ![](https://img.pokemondb.net/sprites/items/x-sp-atk.png) Ataque Especial X
Função: Aumenta em **200** pontos o atributo de *ataqueEspecial* do pokemon.

Turno de acionamento: 1


# **Parte 4**
# Arena
![](https://www.pokemon.com/static-assets/content-assets/cms2/img/watch-pokemon-tv/seasons/season15/season15_ep42_ss01.jpg)

A arena é onde dois treinadores pokemon se enfrentam, cada um utilizando seu próprio time de pokemons.

Durante a batalha, cada treinador utilizará apenas um pokemon por vez, e quando este for derrotado, o próximo Pokémon de seu time entrará em campo.

Uma batalha só termina quando todos os Pokémons de um dos dois treinadores forem derrotados.

A classe Arena deve implementar o seguinte construtor.
```java
new Arena(Treinador treinadorA, Treinador treinadorB);
```

E conter o seguinte método
```java
public Treinador batalhar(); // retorna o treinador vencedor
```

## Turnos
Cada turno é definido por uma rodada de ataques entre os pokemons de cada treinador. Uma batalha pode ter infinitos turnos.

Para cada turno, o Pokémon que tiver o ***atributo de velocidade maior***, deve iniciar atacando primeiro.

No caso de movimentos do tipo físico, o dano é calculado da seguinte maneira:

    dano = 0.5 * poderDoMovimento * multiplicadorVantagem * (atributoAtaqueDoAtacante / atributoDefesaDoDefesor)

No caso de movimentos do tipo especial, o dano é calculado da seguinte maneira:

    dano = 0.5 * poderDoMovimento * multiplicadorVantagem * (atributoAtaqueEspecialDoAtacante / atributoDefesaEspecialDoDefesor)

## Importante
- O dano sempre deve ser um valor inteiro. Em caso de valores não inteiros, arredondar para cima (Exemplo: 5.1 se torna 6).
- Em caso de empate entre os atributos de velocidade, o pokemon do primeiro treinador informado no construtor da classe **Arena** deve atacar primeiro.
- A contagem de turnos apenas influencia no uso de itens, ela não determina o fim da batalha.

## Exemplo de calculo de dano durante o turno

### Canário: Red e seu charmander batalham contra Blue e squirtle
Decisão da ordem: 

    Charmander ataca primeiro devido sua velocidade ser maior que squirtle (65 contra 43)

Charmander ataca Squirtle

    33 = (int) 0.5 * 70 * 1 * (60/64)
    Charmander ataca Squirtle causando 33 de dano
    Squirtle fica com 11 de pontos de saúde

Squirtle ataca Charmander

    75 = (int) 0.5 * 75 * 2 * (50/50)
    Squirtle ataca Charmander causando 75 de dano        
    Charmander é derrotado pois seus pontos de vida se tornam menor que zero




## Exemplos de testes
```java
@Test
public void deveEncerrarBatalhaComVitoriaDeAsh() {
    Treinador red = new Treinador("Red");
    red.adicionarAoTime(new Charmander());
  
    Treinador ash = new Treinador("Ash");
    ash.adicionarAoTime(new Squirtle());
  
    Arena arena = new Arena(red, ash);
    Treinador vencedor = arena.batalhar();
    assertEquals(ash, vencedor);
}

@Test
public void deveEncerrarBatalhaComVitoriaDeAshMesmoAposInverterAOrdem() {
    Treinador ash = new Treinador("Ash");
    ash.adicionarAoTime(new Squirtle());
  
    Treinador red = new Treinador("Red");
    red.adicionarAoTime(new Charmander());
  
    Arena arena = new Arena(ash, red);
    Treinador vencedor = arena.batalhar();
    assertEquals(ash, vencedor);
}

@Test
public void deveEncerrarBatalhaComVitoriaDeRedDevidoAPocao() {
    Treinador ash = new Treinador("Ash");
    ash.adicionarAoTime(new Squirtle());
  
    Treinador red = new Treinador("Red", new Pocao());
    red.adicionarAoTime(new Squirtle());
  
    Arena arena = new Arena(ash, red);
    Treinador vencedor = arena.batalhar();
    assertEquals(red, vencedor);
}

@Test
public void deveEncerrarComVitoriaDeRedDevidoAItemApelao() {
    Treinador red = new Treinador("Red", new XAtaqueEspecial());
    red.adicionarAoTime(new Charmander());
    
    Treinador ash = new Treinador("Ash");
    ash.adicionarAoTime(new Squirtle());
    ash.adicionarAoTime(new Bulbasaur());
    ash.adicionarAoTime(new Charmander());
    
    Arena arena = new Arena(red, ash);
    Treinador vencedor = arena.batalhar();
    assertEquals(red, vencedor);
}

@Test
public void deveEncerrarComVitoriaDeAshDevidoAVelocidadeDePikachu() {
    Treinador red = new Treinador("Red", new XAtaqueEspecial());
    red.adicionarAoTime(new Charmander());
    
    Treinador ash = new Treinador("Ash");
    ash.adicionarAoTime(new Squirtle());
    ash.adicionarAoTime(new Pikachu());
    
    Arena arena = new Arena(red, ash);
    Treinador vencedor = arena.batalhar();
    assertEquals(ash, vencedor);
}
```

## Testes Obrigatórios

* Devem existir **obrigatoriamente** na solução entregue testes unitários com os seguintes nomes:
    - deveEncerrarBatalhaComVitoriaDeAsh
    - deveEncerrarBatalhaComVitoriaDeAshMesmoAposInverterAOrdem
    - deveEncerrarBatalhaComVitoriaDeRedDevidoAPocao
    - deveEncerrarComVitoriaDeRedDevidoAItemApelao
    - deveEncerrarComVitoriaDeAshDevidoAVelocidadeDePikachu
