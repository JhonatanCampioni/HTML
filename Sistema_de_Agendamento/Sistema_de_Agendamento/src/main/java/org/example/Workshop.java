package org.example;

import java.util.ArrayList;

public class Workshop extends Evento {

    ArrayList<String> listaPart = new ArrayList<>();

    public Workshop(String nome, String data) {
        super(nome, data);
    }

    public boolean inscreverParticipante(String participante) {
        if (listaPart.size() < 30) {
            listaPart.add(participante);
            System.out.println(participante + " adicionado");
            return true;
        } else {
            System.out.println("Lista cheia :(");
            return false;
        }
    }

    public boolean validar() {
        if (nome.isEmpty() || data.isEmpty()) {
            System.out.println("Não foi possível criar o workshop :(");
            return false;
        }
        return true;
    }

    public void getInfo() {
        System.out.println("\n\n   Workshop: " + nome);
        System.out.println("Data: " + data);
        System.out.println("Participantes: ");
        for (String s : listaPart) {
            System.out.println("  - " + s);
        }
    }
}
