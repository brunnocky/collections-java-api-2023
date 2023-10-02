package set.operacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    //atributos
    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados() {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite) {
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }


    public void removerConvidadoPorCodigoConvite(int codigoConvite) {
        Convidado convidadoParaRemover = null;
        for (Convidado c : convidadoSet) {
            if (c.getCodigo() == codigoConvite) {
                convidadoParaRemover = c;
                break;
            }
        }
        convidadoSet.remove(convidadoParaRemover);
    }

        public int contarConvidados () {
            return convidadoSet.size();
        }
        public void exibirConvidados () {
            System.out.println(convidadoSet);
        }

        public static void main (String[]args){
            ConjuntoConvidados convidados = new ConjuntoConvidados();

            convidados.adicionarConvidado("Brunno", 12);
            convidados.adicionarConvidado("Milena", 18);
            convidados.adicionarConvidado("Bárbara", 16);
            convidados.adicionarConvidado("Chicco", 15);
            convidados.adicionarConvidado("Tigo", 1);

            convidados.exibirConvidados();

            convidados.removerConvidadoPorCodigoConvite(16);

            convidados.exibirConvidados();

        }

    }
