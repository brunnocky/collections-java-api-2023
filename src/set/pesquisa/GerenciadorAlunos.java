package set.pesquisa;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media) {
        alunoSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula) {
        Aluno alunoParaRemover = null;
        for (Aluno a : alunoSet) {
                if (a.getMatricula() == matricula) {
                    alunoParaRemover = a;
                }
        }
        if (alunoParaRemover == null){
            System.out.println("Não existe aluno para essa matrícula");
        }
        alunoSet.remove(alunoParaRemover);
    }

    public Set<Aluno> exibirAlunosPorNome() {
        Set<Aluno> alunosPorNome = new TreeSet<>(alunoSet);
        return alunosPorNome;
    }

    public Set<Aluno> exibirAlunosPorNota() {
        Set<Aluno> alunoPorNota = new TreeSet<>(new ComparatorAlunoPorNota());
        alunoPorNota.addAll(alunoSet);
        return alunoPorNota;
    }

    public void exibirAlunos() {
        System.out.println(alunoSet);

    }

    public static void main(String[] args) {
        GerenciadorAlunos alunos = new GerenciadorAlunos();

        alunos.adicionarAluno("Brunno", 140132694L, 8.5);
        alunos.adicionarAluno("Brain", 140132693L, 9.5);
        alunos.adicionarAluno("Breno", 140132692L, 6);
        alunos.adicionarAluno("Beto", 140132691L, 7.4);
        alunos.adicionarAluno("Betina", 140132690L, 10);

        alunos.exibirAlunos();

        System.out.println(alunos.exibirAlunosPorNome());
        System.out.println(alunos.exibirAlunosPorNota());

        alunos.removerAluno(140132690L);

        System.out.println("-------------------------------");
        alunos.exibirAlunos();
    }
}
