package list.Ordenacao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> numerosList;

    public OrdenacaoNumeros() {
        this.numerosList = new ArrayList<>();
    }
    public void adicionarNumero(int numero){
        numerosList.add(numero);
    }
    public List<Integer> ordenarAscendente(){
        List<Integer> ordenacaoAscendente = new ArrayList<>(numerosList);
        if (!numerosList.isEmpty()) {
            Collections.sort(ordenacaoAscendente);
            return ordenacaoAscendente;
        }else
            throw new RuntimeException("A lista está vazia!");
    }
    public List<Integer> ordenarDescendente(){
        List<Integer> ordenacaoDescendente = new ArrayList<>(numerosList);
        if (!numerosList.isEmpty()){
            ordenacaoDescendente.sort(Collections.reverseOrder());
            return ordenacaoDescendente;
        }else
            throw new RuntimeException("A lista está vazia");
    }
    public void exibirNumeros(){
        if (!numerosList.isEmpty()){
            System.out.println(this.numerosList);
        }else
            throw new RuntimeException("A lista está vazia");
    }

    public static void main(String[] args) {
        OrdenacaoNumeros numeros = new OrdenacaoNumeros();

        numeros.adicionarNumero(23);
        numeros.adicionarNumero(100);
        numeros.adicionarNumero(55);
        numeros.adicionarNumero(1500);
        numeros.adicionarNumero(85);
        numeros.adicionarNumero(425);

        numeros.exibirNumeros();

        System.out.println(numeros.ordenarAscendente());

        System.out.println(numeros.ordenarDescendente());

    }

}
