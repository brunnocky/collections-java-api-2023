package map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String,Integer> contagemMap;

    public ContagemPalavras() {
        this.contagemMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem){
        contagemMap.put(palavra,contagem);
    }
    public void removerPalavra(String palavra){
        if (!contagemMap.isEmpty()){
            contagemMap.remove(palavra);
        }else
            System.out.println("Não existe contagem para essa palavra");
    }
    public int exibirContagemPalavras(){
      int contagem = 0;
      for (int c : contagemMap.values()){
          contagem += contagem + c;
      }
      return contagem;
    }
    public String encontrarPalavraMaisFrequente() {
        int maiorContagem = Integer.MIN_VALUE;
        String palavraMaisFrequente = null;

        if (!contagemMap.isEmpty()) {
           for (Map.Entry<String,Integer> entry : contagemMap.entrySet()){
               if (entry.getValue() > maiorContagem){
                   palavraMaisFrequente = entry.getKey();
                   maiorContagem = entry.getValue();
               }
           }
        }
        return "Palavra mais frequente é:" + palavraMaisFrequente + "e " + "aparece " + maiorContagem;
    }
}
