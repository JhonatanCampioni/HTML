package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaAgendamento {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        ArrayList<Workshop> listaWork = new ArrayList<>();
        ArrayList<Reuniao> listaReuniao = new ArrayList<>();
        ArrayList<EventoCorporativo> listaEvento = new ArrayList<>();

        String opc = "", opc2 = "";

        System.out.println("\nGerenciador de eventos:");

        do {
            System.out.println("\n\n\t1 -- Adicionar um evento\n\t2 -- Ver lista de eventos\n\n\t0 -- Sair");
            opc = sc.nextLine();

            switch (opc) {
                case "1":
                    opc2 = getOpc(sc);

                    switch (opc2) {
                        case "1":
                            Workshop workshop = addWorkshop(sc);
                            if (workshop.validar()) {
                                listaWork.add(workshop);
                                adicionarParticipantes(workshop, sc);  // Adicionando participantes
                                System.out.println("Workshop criado com sucesso!");
                            }
                            break;

                        case "2":
                            Reuniao reuniao = addReuniao(sc);
                            if (reuniao.validar()) {
                                listaReuniao.add(reuniao);
                                System.out.println("Reunião criada com sucesso!");
                            }
                            break;

                        case "3":
                            EventoCorporativo evento = addEvento(sc);
                            if (evento.validar()) {
                                listaEvento.add(evento);
                                System.out.println("Evento corporativo criado com sucesso!");
                            }
                            break;
                    }
                    break;

                case "2":
                    opc2 = getOpc(sc);

                    switch (opc2) {
                        case "1":
                            if (listaWork.isEmpty()) {
                                System.out.println("Nenhum workshop disponível.");
                            } else {
                                for (Workshop work : listaWork) {
                                    work.getInfo();
                                }
                            }
                            break;

                        case "2":
                            if (listaReuniao.isEmpty()) {
                                System.out.println("Nenhuma reunião disponível.");
                            } else {
                                for (Reuniao reun : listaReuniao) {
                                    reun.getInfo();
                                }
                            }
                            break;

                        case "3":
                            if (listaEvento.isEmpty()) {
                                System.out.println("Nenhum evento corporativo disponível.");
                            } else {
                                for (EventoCorporativo eve : listaEvento) {
                                    eve.getInfo();
                                }
                            }
                            break;
                    }
                    break;
            }
        } while (!opc.equals("0"));

        System.out.println("Volte sempre :D");
        sc.close();  // Fechando scanner apenas no final
    }

    static String getOpc(Scanner sc) {
        String op;

        System.out.println("\nQue tipo de evento?\n\n\t1 -- Workshop\n\t2 -- Reunião\n\t3 -- Evento corporativo");

        do {
            op = sc.nextLine();
        } while (!op.equals("1") && !op.equals("2") && !op.equals("3"));

        return op;
    }

    static Workshop addWorkshop(Scanner sc) {
        System.out.print("\nNome: ");
        String nome = sc.nextLine();

        System.out.print("Data: ");
        String data = sc.nextLine();

        return new Workshop(nome, data);
    }

    static Reuniao addReuniao(Scanner sc) {
        System.out.print("\nNome: ");
        String nome = sc.nextLine();

        System.out.print("Data: ");
        String data = sc.nextLine();

        System.out.print("A reunião será privada? (s/n): ");
        String priv;
        do {
            priv = sc.nextLine();
        } while (!priv.equalsIgnoreCase("s") && !priv.equalsIgnoreCase("n"));

        if (priv.equalsIgnoreCase("s")) {
            System.out.print("Senha: ");
            String senha = sc.nextLine();
            return new Reuniao(nome, data, true, senha);
        } else {
            return new Reuniao(nome, data, false, "");
        }
    }

    static EventoCorporativo addEvento(Scanner sc) {
        System.out.print("\nNome: ");
        String nome = sc.nextLine();

        System.out.print("Data: ");
        String data = sc.nextLine();

        System.out.print("Sala reservada: ");
        String sala = sc.nextLine();

        System.out.print("Área de refeições: ");
        String refeicao = sc.nextLine();

        return new EventoCorporativo(nome, data, sala, refeicao);
    }

    static void adicionarParticipantes(Workshop workshop, Scanner sc) {
        String participante;
        do {
            System.out.println("Digite o nome do participante (ou 'sair' para finalizar): ");
            participante = sc.nextLine();
            if (!participante.equalsIgnoreCase("sair")) {
                workshop.inscreverParticipante(participante);
            }
        } while (!participante.equalsIgnoreCase("sair"));
    }
}
