package map.ordenacao;

import java.util.*;

public class LivrariaOnline {
    private Map<String, Livro> livroMap;

    public LivrariaOnline() {
        this.livroMap = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco){
        livroMap.put(link, new Livro(titulo, autor, preco));
    }
    public void removerLivro(String titulo){
        if (!livroMap.isEmpty()){
            List<String> chavesRemover = new ArrayList<>();
            for (Map.Entry<String,Livro> entry : livroMap.entrySet()) {
                if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)){
                    chavesRemover.add(entry.getKey());
                }
            }
            for (String chave : chavesRemover){
                livroMap.remove(chave);
            }
        }else {
            System.out.println("O Map está vazio");
        }
    }
    public Map<String,Livro> exibirLivrosOrdenadosPorPreco(){
        List<Map.Entry<String,Livro>> livrosOrdenadosPorPreco = new ArrayList<>(livroMap.entrySet());

        Collections.sort(livrosOrdenadosPorPreco, new ComparatorPorPreco());

        Map<String, Livro> livrosOrdenadosPreco = new LinkedHashMap<>();

        for (Map.Entry<String,Livro> entry : livrosOrdenadosPorPreco){
            livrosOrdenadosPreco.put(entry.getKey(),entry.getValue());
        }
        return livrosOrdenadosPreco;
    }
    public List<Map.Entry<String,Livro>> pesquisarLivrosPorAutor(String autor){
        List<Map.Entry<String,Livro>> livroPorAutor = new ArrayList<>();
        for (Map.Entry<String,Livro> entry : livroMap.entrySet()){
            if (entry.getValue().getAutor().equalsIgnoreCase(autor)){
                livroPorAutor.add(entry);
            }
        }
        return livroPorAutor;
    }
    public List<Map.Entry<String ,Livro>> obterLivroMaisCaro(){

        List<Map.Entry<String,Livro>> livroMaisCaro = new ArrayList<>();
        double precoMaisAlto = 0;

        for (Map.Entry<String, Livro> entry : livroMap.entrySet()){
            if (entry.getValue().getPreco() > precoMaisAlto){
                precoMaisAlto = entry.getValue().getPreco();
            }
        }
        for (Map.Entry<String, Livro> entry : livroMap.entrySet()){
            if (entry.getValue().getPreco() == precoMaisAlto){
                livroMaisCaro.add(entry);
            }
        }
        return livroMaisCaro;
    }
    public List<Map.Entry<String,Livro>> exibirLivroMaisBarato(){

        List<Map.Entry<String,Livro>> livrosMaisBaratos = new ArrayList<>();
        double precoMaisBarato = Double.MAX_VALUE;

        for (Map.Entry<String, Livro> entry : livroMap.entrySet()){
            if (entry.getValue().getPreco() <= precoMaisBarato ){
                precoMaisBarato = entry.getValue().getPreco();
            }
        }
        for (Map.Entry<String,Livro> entry : livroMap.entrySet()){
            if (entry.getValue().getPreco() == precoMaisBarato){
                livrosMaisBaratos.add(entry);
            }
        }
        return livrosMaisBaratos;
    }


    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();

        livrariaOnline.adicionarLivro("Link 1", "Titulo 1", "Autor 1", 55);
        livrariaOnline.adicionarLivro("Link 4", "Titulo 4", "Autor 1", 30);
        livrariaOnline.adicionarLivro("Link 5", "Titulo 5", "Autor 1", 40);
        livrariaOnline.adicionarLivro("Link 2", "Titulo 2", "Autor 2", 15);
        livrariaOnline.adicionarLivro("Link 3", "Titulo 3", "Autor 3", 55);

        //System.out.println(livrariaOnline.exibirLivrosOrdenadosPorPreco());

        //System.out.println(livrariaOnline.pesquisarLivrosPorAutor("Autor 1"));
        System.out.println(livrariaOnline.obterLivroMaisCaro());

        //System.out.println(livrariaOnline.exibirLivroMaisBarato());
    }
}
