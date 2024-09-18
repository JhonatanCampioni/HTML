package org.example;

public class EventoCorporativo extends Evento {

    String sala;
    String refeicao;

    public EventoCorporativo(String nome, String data, String sala, String refeicao) {
        super(nome, data);
        this.sala = sala;
        this.refeicao = refeicao;
    }

    public boolean validar() {
        if (nome.isEmpty() || data.isEmpty() || sala.isEmpty() || refeicao.isEmpty()) {
            System.out.println("Não foi possível criar o Evento corporativo :(");
            return false;
        }
        return true;
    }

    public void getInfo() {
        System.out.println("\n\n   Evento corporativo: " + nome);
        System.out.println("Data: " + data);
        System.out.println("Sala reservada: " + sala);
        System.out.println("Área de refeições: " + refeicao);
    }
}
