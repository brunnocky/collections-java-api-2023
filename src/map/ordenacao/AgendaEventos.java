package map.ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventoMap;

    public AgendaEventos() {
        this.eventoMap = new HashMap<>();

    }
    public void adicionarEvento(LocalDate data, String nome, String atracao){
        eventoMap.put(data,new Evento(nome,atracao));
    }
    public void exibirAgenda(){
        Map<LocalDate,Evento> eventoTreeMap = new TreeMap<>(eventoMap);
        System.out.println(eventoTreeMap);
    }
    public void obterProximoEvento(){
        /*Set<LocalDate> localDateSet = eventoMap.keySet();
        Collection<Evento> eventoCollection = eventoMap.values();*/
        //eventoMap.get();

        LocalDate proximaData = null;
        Evento proximoEvento = null;

        Map<LocalDate,Evento> eventoTreeMap = new TreeMap<>(eventoMap);
        LocalDate dataAtual =  LocalDate.now();

        for (Map.Entry<LocalDate,Evento> entry : eventoTreeMap.entrySet()){
            if (entry.getKey().isEqual(dataAtual)|| entry.getKey().isAfter(dataAtual)){
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                System.out.println("Próximo evento :" + proximoEvento + "Acontecerá na data: " + proximaData);
                break;
            }
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

       // agendaEventos.adicionarEvento(LocalDate.of(2023, Month.OCTOBER,5), "Evento 1", "Atração 1");
        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.OCTOBER,6), "Evento 2", "Atração 2");
        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.OCTOBER,7), "Evento 3", "Atração 3");
        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.OCTOBER,8), "Evento 4", "Atração 4");
        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.OCTOBER,9), "Evento 5", "Atração 5");

        agendaEventos.exibirAgenda();
        agendaEventos.obterProximoEvento();
    }
}
