package set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }
    public void adicionarTarefa(String descricao){
        tarefaSet.add(new Tarefa(descricao));
    }
    public void removerTarefa(String descricao){
        Tarefa tarefasParaRemover = null;
        if(!tarefaSet.isEmpty()){
            for (Tarefa t : tarefaSet){
                if (t.getDescricao().equalsIgnoreCase(descricao)){
                    tarefasParaRemover = t;
                    break;
                }else
                    System.out.println("Não existe tarefa com essa descrição");
            }
            tarefaSet.remove(tarefasParaRemover);
        }else
            throw new RuntimeException("O conjunto está vazio");
    }
    public void exibirTarefas(){
        System.out.println(tarefaSet);
    }
    public int contarTarefas(){
        int numeroTarefas;
        numeroTarefas = tarefaSet.size();

        return numeroTarefas;
    }

    public Set<Tarefa> obterTarefasConcluidas(){

        if (!tarefaSet.isEmpty()){
            Set<Tarefa> tarefasConcluidas = new HashSet<>();

            for (Tarefa t: tarefaSet) {
                if (t.isConcluida()){
                    tarefasConcluidas.add(t);
                }
            }
            return tarefasConcluidas;
        }else
            throw new RuntimeException("O conjunto está vazio");

    }
    public Set<Tarefa> obterTarefasPendentes(){
        if (!tarefaSet.isEmpty()){

            Set<Tarefa> tarefasPendentes = new HashSet<>();

            for (Tarefa t: tarefaSet) {
                if (!t.isConcluida()){
                    tarefasPendentes.add(t);
                }
            }
            return tarefasPendentes;
        }else
            throw new RuntimeException("O Conjunto está vazio");

    }

    public void marcarTarefaConcluida(String descricao){
        if (!tarefaSet.isEmpty()){
            for (Tarefa t: tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)){
                    t.setConcluida(true);
                }
            }
        }else
            throw new RuntimeException("O conjunto está vazio");

    }
    public void marcarTarefaPendente(String descricao){
        if (!tarefaSet.isEmpty()){
            Tarefa tarefaParaMarcarComoPendente = null;
            for (Tarefa t: tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)){
                   tarefaParaMarcarComoPendente = t;
                   break;
                }
            }
            if (tarefaParaMarcarComoPendente != null){
                if (tarefaParaMarcarComoPendente.isConcluida()){
                    tarefaParaMarcarComoPendente.setConcluida(false);
                }else {
                    System.out.println("Tarefa não encontrada no conjunto");
                }
            }
        }else
            throw new RuntimeException("O conjunto está vazio");

    }
    public void limparListaTarefas(){
        if (tarefaSet.isEmpty()){
            System.out.println("O conjuntoe está vazio ");
        }else{
            tarefaSet.clear();
        }
    }






}
