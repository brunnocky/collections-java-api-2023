package list.pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> listInteiros;

    public SomaNumeros() {
        this.listInteiros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        listInteiros.add(numero);
    }

    public int calcularSoma() {
        int somaInteiros = 0;
        if (!listInteiros.isEmpty()) {
            for (int i : listInteiros) {
                somaInteiros = somaInteiros + i;
            }
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
        return somaInteiros;
    }

    public int encontrarMaiorNumero() {
        int maiorNumero = 0;
        if (!listInteiros.isEmpty()) {
            for (int i : listInteiros) {
                if (i > maiorNumero) {
                    maiorNumero = i;
                }
            }
        } else {
            throw new RuntimeException("A lista está vazia!");
        }

        return maiorNumero;
    }

    public int encontrarMenorNumero() {
        int menorNumero = encontrarMaiorNumero();
        if (!listInteiros.isEmpty()){
            for (int i : listInteiros) {
                if (i < menorNumero) {
                    menorNumero = i;
                }
            }
        }else {
            throw new RuntimeException("A lista está vazia");
        }

        return menorNumero;
    }

    public void exibirNumeros() {
        if (!listInteiros.isEmpty()){
            for (int i : listInteiros) {
                System.out.println(i);
            }
        }else{
            throw new RuntimeException("A lista está vazia!");
        }

    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adicionarNumero(25);
        somaNumeros.adicionarNumero(10);
        somaNumeros.adicionarNumero(5);
        somaNumeros.adicionarNumero(255);
        somaNumeros.adicionarNumero(100);
        somaNumeros.adicionarNumero(85);
        somaNumeros.adicionarNumero(70);

        System.out.println(somaNumeros.calcularSoma());
        System.out.println(somaNumeros.encontrarMaiorNumero());
        System.out.println(somaNumeros.encontrarMenorNumero());
        somaNumeros.exibirNumeros();
    }
}
