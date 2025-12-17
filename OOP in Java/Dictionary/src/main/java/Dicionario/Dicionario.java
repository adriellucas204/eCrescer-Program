package Dicionario;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class Dicionario {
    private Map<String, String> dicPortugues; // tipo PORTUGUES
    private Map<String, String> dicIngles; // tipo INGLES

    public Dicionario(){
        this.dicPortugues = new HashMap<>();
        this.dicIngles = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String traducao, TipoDicionario dicionario){
        // se o tipo for portugues
        if (dicionario == TipoDicionario.PORTUGUES) {
            this.dicPortugues.put(palavra, traducao);
            return;
        }
        // se for ingles
        this.dicIngles.put(palavra, traducao);
    }

    //Car - car
    public String traduzir(String palavra, TipoDicionario dicionarioDeBusca){
        String palavraEmMinusculo = palavra.toLowerCase();

        if (dicionarioDeBusca == TipoDicionario.PORTUGUES) {
            for (String chave : this.dicPortugues.keySet()){
                if (Objects.equals(palavraEmMinusculo, chave.toLowerCase())){
                    return this.dicPortugues.get(chave);
                }
            }
            throw new PalavraNaoEncontradaException("Palavra nao encontrada.");
        } else if (dicionarioDeBusca == TipoDicionario.INGLES) {
            for (String chave : this.dicIngles.keySet()){
                if (Objects.equals(palavraEmMinusculo, chave.toLowerCase())){
                    return this.dicIngles.get(chave);
                }
            }
            throw new PalavraNaoEncontradaException("Palavra nao encontrada.");
        }

        return null;
    }
}
