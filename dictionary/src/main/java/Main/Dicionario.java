package Main;

import Enums.TipoDicionario;
import Exceptions.PalavraNaoEncontradaException;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private TipoDicionario dicionario;
    private Map<String, String> mapaIngles;
    private Map<String, String> mapaPortugues;

    public Dicionario() {
        this.mapaIngles = new HashMap<>();
        this.mapaPortugues = new HashMap<>();
    }

    public void adicionarPalavra( String palavra, String traducao, TipoDicionario dicionario) {
        //O sistema também deve traduzir a palavra sem diferenciar letras maiúsculas e minúsculas.
        String palavraChave = palavra.toLowerCase();

        if (dicionario == TipoDicionario.INGLES) {
            this.mapaIngles.put(palavraChave, traducao);
        } else if (dicionario == TipoDicionario.PORTUGUES) {
            this.mapaPortugues.put(palavraChave, traducao);
        }
    };

    public String traduzir(String palavra, TipoDicionario dicionarioDeBusca) {
        //O sistema também deve traduzir a palavra sem diferenciar letras maiúsculas e minúsculas.
        String palavraChave = palavra.toLowerCase();

        String traducaoDisponivel = null;

        if (dicionarioDeBusca == TipoDicionario.INGLES) {
            traducaoDisponivel = this.mapaIngles.get(palavraChave);

        } else if (dicionarioDeBusca == TipoDicionario.PORTUGUES) {

            traducaoDisponivel = this.mapaPortugues.get(palavraChave);
        }

        if (traducaoDisponivel == null) {
            throw new PalavraNaoEncontradaException("A palavra '" + palavra + "' não foi encontrada no dicionário " + dicionarioDeBusca);
        }

        return traducaoDisponivel;
    }
};

