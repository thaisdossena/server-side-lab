public class Batalha {
    public Ninja lutar(Ninja primeiroNinja, Ninja segundoNinja) {
        //Cada Ninja ataca o seu oponente 3 vezes.
        for (int i = 0; i < 3; i++) {
            primeiroNinja.atacar(segundoNinja);
            segundoNinja.atacar(primeiroNinja);
        }

        if (primeiroNinja.getNome().equals("Itachi")) {
            return primeiroNinja;
        }
        else if (segundoNinja.getNome().equals("Itachi")){
            return segundoNinja;
        }

        if (primeiroNinja.getChakra() >= segundoNinja.getChakra()) {
            return primeiroNinja;
        } else {
            return segundoNinja;
        }
    }
}
