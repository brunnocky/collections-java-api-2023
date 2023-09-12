package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    public List<Item> itemList;

    public CarrinhoDeCompras(){
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        itemList.add(new Item(nome,preco,quantidade));
    }
    public void removeItem(String nome){
        List<Item> itensRemover = new ArrayList<>();
        for (Item i: itemList) {
            if(i.getNome().equalsIgnoreCase(nome)){
                itensRemover.add(i);
            }
        }
        itemList.removeAll(itensRemover);
    }
    public double calcularValorTotal(){
        double addPrecoXQuantidade = 0;
        for (Item pegaItem:itemList) {
            addPrecoXQuantidade = addPrecoXQuantidade + (pegaItem.getPreco() * pegaItem.getQuantidade());
        }
        return addPrecoXQuantidade;
    }

    public void exibirItens(){
        System.out.println(itemList);
    }
    public void removeQuantidade(String nome){
        for (Item i: itemList) {
            if(i.getNome().equalsIgnoreCase(nome)){
                i.setQuantidade(i.getQuantidade() - 1);
            }
        }

    }

    public static void main(String[] args) {

        CarrinhoDeCompras carrinhoDeComprasBrunno = new CarrinhoDeCompras();

        carrinhoDeComprasBrunno.adicionarItem("Fone de ouvido",15.50,2);
        carrinhoDeComprasBrunno.adicionarItem("Carregador",45,1);
        carrinhoDeComprasBrunno.adicionarItem("Cabo tipo C",15.00,5 );

        carrinhoDeComprasBrunno.exibirItens();

        System.out.println("Valor total da compra: " + carrinhoDeComprasBrunno.calcularValorTotal());

        carrinhoDeComprasBrunno.removeQuantidade("Cabo tipo C");

        carrinhoDeComprasBrunno.exibirItens();

        System.out.println("Valor total da compra: " + carrinhoDeComprasBrunno.calcularValorTotal());



    }

}
