package map.operacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String,String> dicionarioMap;

    public Dicionario() {
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao){
        dicionarioMap.put(palavra,definicao);
    }
    public void removerPalavra(String palavra){

        if (dicionarioMap.containsKey(palavra)){
            dicionarioMap.remove(palavra);
        }else {
            System.out.println("Não existe essa palavra no dicionario");
        }
    }
    public void exibirPalavras(){
        System.out.println(dicionarioMap);
    }
    public String pesquisarPorPalavra(String palavra){
        String definicao = dicionarioMap.get(palavra);
        if (definicao != null){
            return definicao;
        }else
            return "não existe definicao para essa palavra";

    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        dicionario.adicionarPalavra("Palavra 1", "Definicao 1");
        dicionario.adicionarPalavra("Palavra 2", "Definicao 2");
        dicionario.adicionarPalavra("Palavra 3", "Definicao 3");

        dicionario.exibirPalavras();

        dicionario.removerPalavra("Palavra");

        dicionario.exibirPalavras();

        System.out.println(dicionario.pesquisarPorPalavra("Palavra "));
    }

}
