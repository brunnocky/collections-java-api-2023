package set.operacoesBasicas;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasUnicasSet;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicasSet = new HashSet<>();
    }

    public void adicionarPalavra(String palavra){
        palavrasUnicasSet.add(palavra);
    }
    /*public void removerPalavra(String palavra){
        String palavraParaRemover = null;
        if (!palavrasUnicasSet.isEmpty()){
            for (String p : palavrasUnicasSet) {
                if (p.equalsIgnoreCase(palavra)){
                    palavraParaRemover = p;
                }
            }
            palavrasUnicasSet.remove(palavraParaRemover);
        }else
            throw new RuntimeException("O conjunto está vazio");
    }*/
    public void  removerPalavra(String palavra){
        if (!palavrasUnicasSet.isEmpty()){
            if(palavrasUnicasSet.contains(palavra)){
                palavrasUnicasSet.remove(palavra);
            }else
                System.out.println("Palavra não encontrada no conjunto");
        }else
            throw new RuntimeException("O conjunto está vazio");
    }
    /*public void verificarPalavra(String palavra){
        if (!palavrasUnicasSet.isEmpty()){
            for (String p: palavrasUnicasSet) {
                if (p.equalsIgnoreCase(palavra)){
                    System.out.println("Essa palavra está presente no conjunto");

                }else
                    System.out.println("Esta palavra não está presente no conjunto");
                break;
            }
        }else
            throw new RuntimeException("O conjunto está vazio");
    }*/
    public boolean verificarPalavra(String palavra) {
        return palavrasUnicasSet.contains(palavra);
    }
   public void  exibirPalavrasUnicas(){
       for (String p: palavrasUnicasSet) {
           System.out.println(p);
       }
   }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConjuntoPalavrasUnicas that)) return false;
        return palavrasUnicasSet.equals(that.palavrasUnicasSet);
    }
    @Override
    public int hashCode() {
        return Objects.hash(palavrasUnicasSet);
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

        conjuntoPalavrasUnicas.adicionarPalavra("Primeira");
        conjuntoPalavrasUnicas.adicionarPalavra("Segunda");
        conjuntoPalavrasUnicas.adicionarPalavra("Terceira");
        conjuntoPalavrasUnicas.adicionarPalavra("Quarta");
        conjuntoPalavrasUnicas.adicionarPalavra("Quinta");

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        conjuntoPalavrasUnicas.removerPalavra("Segunda");

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        conjuntoPalavrasUnicas.verificarPalavra("Sexta");
    }
}
