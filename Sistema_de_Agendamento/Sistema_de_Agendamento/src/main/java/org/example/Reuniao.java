package org.example;

public class Reuniao extends Evento {

    boolean privada;
    String senha;

    public Reuniao(String nome, String data, boolean privada, String senha) {
        super(nome, data);
        this.privada = privada;
        this.senha = senha;
    }

    public boolean validar() {
        if (nome.isEmpty() || data.isEmpty()) {
            System.out.println("Não foi possível criar a reunião :(");
            return false;
        }
        return true;
    }

    public boolean acessarReuniao(String senha) {
        if (privada) {
            if (this.senha.equals(senha)) {
                System.out.println("Reunião acessada!");
                return true;
            } else {
                System.out.println("Acesso negado.");
                return false;
            }
        } else {
            System.out.println("Reunião pública acessada!");
            return true;
        }
    }

    public void getInfo() {
        System.out.println("\n\n   Reunião: " + nome);
        System.out.println("Data: " + data);

        if (privada) {
            System.out.println("Reunião privada");
        } else {
            System.out.println("Reunião pública");
        }
    }
}
