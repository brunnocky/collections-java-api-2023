package map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto>  estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco){
        estoqueProdutosMap.put(cod, new Produto(nome,preco,quantidade));
    }
    public void exibirProdutos(){
        System.out.println(estoqueProdutosMap);
    }
    public double calcularValorTotalEstoque(){
        double valorTotalEstoque = 0d;
        if (!estoqueProdutosMap.isEmpty()){
            for (Produto p: estoqueProdutosMap.values()) {
                valorTotalEstoque += p.getQuantidade() * p.getPreco();
            }
        }

        return  valorTotalEstoque;

    }

    public Produto obterProdutoMaisCaro(){
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;

        if (!estoqueProdutosMap.isEmpty()){
            for (Produto p : estoqueProdutosMap.values()){
                if (p.getPreco() > maiorPreco){
                    produtoMaisCaro = p;
                    maiorPreco = p.getPreco();
                }
            }
        }
        return produtoMaisCaro;
    }
    public Produto obterProdutoMaisBarato(){
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;

        if (!estoqueProdutosMap.isEmpty()){
            for (Produto p : estoqueProdutosMap.values()){
                if (p.getPreco() < menorPreco){
                    produtoMaisBarato = p;
                    menorPreco = p.getPreco();
                }
            }
        }
        return produtoMaisBarato;
    }
    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque(){
        Produto produtoEmMaiorQuantidadeEPreco = null;
        double maiorQuantidadePreco = 0;
        double menorValor = Double.MIN_VALUE;

        if (!estoqueProdutosMap.isEmpty()){
            for (Produto p : estoqueProdutosMap.values()){
                maiorQuantidadePreco = p.getPreco() * p.getQuantidade();
                if (maiorQuantidadePreco > menorValor){
                    produtoEmMaiorQuantidadeEPreco = p;
                    menorValor = maiorQuantidadePreco;
                }
            }
        }
        return produtoEmMaiorQuantidadeEPreco;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

        estoqueProdutos.adicionarProduto(1, "Produto 1",1, 5000);
        estoqueProdutos.adicionarProduto(2, "Produto 2",300, 10);
        estoqueProdutos.adicionarProduto(3, "Produto 3",7, 5.50);
        estoqueProdutos.adicionarProduto(4, "Produto 4",25, 12);

        estoqueProdutos.exibirProdutos();

         //System.out.println(estoqueProdutos.obterProdutoMaisCaro());
        //System.out.println(estoqueProdutos.obterProdutoMaisBarato());
       //System.out.println(estoqueProdutos.calcularValorTotalEstoque());
        System.out.println(estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
    }
}
