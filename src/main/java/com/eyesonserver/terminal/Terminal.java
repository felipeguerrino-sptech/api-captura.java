package com.eyesonserver.terminal;

import com.eyesonserver.dao.maquina.ProcessoDAO;
import com.eyesonserver.dao.metrica.RegistroDAO;
import com.eyesonserver.dao.negocio.UsuarioDAO;
import com.eyesonserver.model.maquina.Processo;
import com.eyesonserver.model.metrica.Registro;
import com.eyesonserver.model.negocio.Usuario;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Terminal {
    //Aqui sera desenvolvida a interface de terminal da aplicacao
    static Integer escolhadoDoMenu = 0;

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        String email;
        String senha;

        System.out.print("""                                
                    ______                   ____           _____                         \s
                   / ____/_  _____  _____   / __ \\____     / ___/___  ______   _____  _____
                  / __/ / / / / _ \\/ ___/  / / / / __ \\    \\__ \\/ _ \\/ ___/ | / / _ \\/ ___/
                 / /___/ /_/ /  __(__  )  / /_/ / / / /   ___/ /  __/ /   | |/ /  __/ /   \s
                /_____/\\__, /\\___/____/   \\____/_/ /_/   /____/\\___/_/    |___/\\___/_/    \s
                      /____/                                                              \s             
                                
                Seja muito bem-vindo(a) a API Java da Eyes On Server!
                """);


        while (!escolhadoDoMenu.equals(7)){

        System.out.print("Login: ");
        email = leitor.nextLine();

        System.out.print("Senha: ");
        senha = leitor.nextLine();

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario login = usuarioDAO.getUsuarioPorEmailSenha(email, senha);

        if (Objects.nonNull(login)){
            new Thread(capturaDeDados).start();
            Looca looca = new Looca();

            System.out.printf("\n\n\nOlá %s |", login.getNome());

            Looca Sistema = new Looca();
            System.out.print("Sistema operacional: ");
            System.out.println(Sistema.getSistema().getSistemaOperacional() + "\n\n");

            do {
                System.out.println("""
                        Escolha uma opção: 
                        1. Disco
                        2. Memoria
                        3. Rede
                        4. CPU
                        5. Todos os Componentes
                        6. Processos
                        7. Sair
                        """);
                System.out.print("Escolha: ");
                escolhadoDoMenu = leitor.nextInt();

                switch (escolhadoDoMenu) {
                    case 1 -> {
                        System.out.println("Opção (Disco) escolhida!");
                        long discoTotal = looca.getGrupoDeDiscos().getVolumes().get(0).getTotal() / 1000000000;
                        long discoDisponivel = looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel() / 1000000000;
                        System.out.print("Porcentagem de uso: ");
                        System.out.print((discoTotal - discoDisponivel) * 100 / discoTotal);
                        System.out.println(" %");
                    }
                    case 2 -> {
                        System.out.println("Opção (Memória) escolhida! ");
                        long memoriaTotal = looca.getMemoria().getTotal() / 100000000;
                        long memoriaEmUso = looca.getMemoria().getEmUso() / 100000000;
                        System.out.print("Porcentagem de uso: ");
                        System.out.print(memoriaEmUso * 100 / memoriaTotal);
                        System.out.println(" %");
                    }
                    case 3 -> {
                        System.out.println("Opção (Rede) escolhida! ");
                        System.out.print("Bytes enviados: ");
                        System.out.print(looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getBytesEnviados());
                        System.out.println(" bytes");
                        System.out.print("Bytes recebidos: ");
                        System.out.print(looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getBytesRecebidos());
                        System.out.println(" bytes");
                    }
                    case 4 -> {
                        System.out.println("Opção (CPU) escolhida!");
                        System.out.print("Frequência de CPU: ");
                        System.out.print(looca.getProcessador().getFrequencia() / 1000000000);
                        System.out.println(" Hz");
                    }
                    case 5 -> {
                        System.out.println("Opção (Todos) escolhida! ");
                        long discoTotal = looca.getGrupoDeDiscos().getVolumes().get(0).getTotal() / 1000000000;
                        long discoDisponivel = looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel() / 1000000000;
                        System.out.print("Porcentagem de uso do disco: ");
                        System.out.print((discoTotal - discoDisponivel) * 100 / discoTotal);
                        System.out.println(" %");
                        long memoriaTotal = looca.getMemoria().getTotal() / 100000000;
                        long memoriaEmUso = looca.getMemoria().getEmUso() / 100000000;
                        System.out.print("Porcentagem de uso da memória: ");
                        System.out.print(memoriaEmUso * 100 / memoriaTotal);
                        System.out.println(" %");
                        System.out.print("Bytes enviados: ");
                        System.out.print(looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getBytesEnviados());
                        System.out.println(" bytes");
                        System.out.print("Bytes recebidos: ");
                        System.out.print(looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getBytesRecebidos());
                        System.out.println(" bytes");
                        System.out.print("Frequência de CPU: ");
                        System.out.print(looca.getProcessador().getFrequencia() / 1000000000);
                        System.out.println(" Hz");
                    }
                    case 6 -> {
                        System.out.println("Nome Processo; PID; % Uso CPU; % Uso RAM; MB utilizados; VRAM Utilizada");
                        ProcessoGrupo prcs = looca.getGrupoDeProcessos();
                        for (com.github.britooo.looca.api.group.processos.Processo processo : prcs.getProcessos()) {
                            System.out.printf("%s; %d; %.1f; %.1f; %.1f\n",
                                    processo.getNome(),
                                    processo.getPid(),
                                    processo.getUsoCpu(),
                                    processo.getUsoMemoria(),
                                    processo.getBytesUtilizados() / Math.pow(10, 6),
                                    processo.getMemoriaVirtualUtilizada() / Math.pow(10, 6)
                            );
                        }
                    }
                    case 7 -> {
                        System.out.println("Até mais!");
                        Thread.currentThread().stop();
                    }
                    default -> {
                        System.out.println("Escolha inválida!");
                    }
                }

                try {
                     Thread.sleep(4000);
                } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                }


                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            } while (escolhadoDoMenu != 7);

        } else {
            System.out.println("""
                    Usuário não encontrado!
                    
                    Escolha uma opção:
                    1. Tentar novamente
                    2. Sair
                    """);

            System.out.print("Opção: ");
            escolhadoDoMenu = leitor.nextInt() + 4;
            leitor.nextLine();
        }

        }
    }


    public static Runnable capturaDeDados = () -> {

        while (escolhadoDoMenu != 7) {
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Looca looca = new Looca();
            RegistroDAO registroDAO = new RegistroDAO();
            ProcessoDAO processoDAO = new ProcessoDAO();

            LocalDateTime horaAtual = LocalDateTime.now();
            DateTimeFormatter formatarHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            formatarHora.format(horaAtual);

            String cpuFrequencia = "";
            String cpuPorcentagemUso = "";
            String redeBytesEnviados = "";
            String redeBytesRecebidos = "";
            String discoPorcentagemUso = "";
            String memoriaPorcentagemUso = "";
            List<Processo> processos = new ArrayList<>();


            // Capturando a frequencia da cpu:
            cpuFrequencia = String.valueOf(looca.getProcessador().getFrequencia() / 1000000000);

            // Capturando a porcentagem de uso da cpu:
            cpuPorcentagemUso = String.valueOf(looca.getProcessador().getUso().shortValue());

            // Capturando a rede -- Bytes enviados:
            redeBytesEnviados = String.valueOf(looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getBytesEnviados());

            // Capturando a rede -- Bytes Recebidos:
            redeBytesRecebidos = String.valueOf(looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getBytesRecebidos());



            // Capturando a porcentagem de uso do disco:
            long discoTotal = looca.getGrupoDeDiscos().getVolumes().get(0).getTotal() / 1000000000;
            long discoDisponivel = looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel() / 1000000000;
            discoPorcentagemUso = String.valueOf((discoTotal - discoDisponivel) * 100 / discoTotal);


            // Capturando a porcentagem de uso da memória:
            long memoriaTotal = looca.getMemoria().getTotal() / 100000000;
            long memoriaEmUso = looca.getMemoria().getEmUso() / 100000000;
            memoriaPorcentagemUso = String.valueOf(memoriaEmUso * 100 / memoriaTotal);


            // Criando registros:
            Registro memoriaPorcentagemUsoRegistro = new Registro(2, 2, "6", memoriaPorcentagemUso, horaAtual);
            Registro discoPorcentagemUsoRegistro = new Registro(2, 3, "6", discoPorcentagemUso, horaAtual);
            Registro cpuFrequenciaRegistro = new Registro(4, 1, "6", cpuFrequencia, horaAtual);
            Registro cpuPorcentagemUsoRegistro = new Registro(2, 1, "6", cpuPorcentagemUso, horaAtual);
            Registro redeByteEnviadosRegistro = new Registro(6, 4, "6", redeBytesEnviados, horaAtual);
            Registro redeByteRecebidosRegistro = new Registro(7, 4, "6", redeBytesRecebidos, horaAtual);

            List<com.github.britooo.looca.api.group.processos.Processo> processosLooca = looca.getGrupoDeProcessos().getProcessos();

            // Insert no banco de dados:
            registroDAO.insertRegistro(memoriaPorcentagemUsoRegistro);
            registroDAO.insertRegistro(discoPorcentagemUsoRegistro);
            registroDAO.insertRegistro(cpuFrequenciaRegistro);
            registroDAO.insertRegistro(cpuPorcentagemUsoRegistro);
            registroDAO.insertRegistro(redeByteEnviadosRegistro);
            registroDAO.insertRegistro(redeByteRecebidosRegistro);

            for (com.github.britooo.looca.api.group.processos.Processo processo : processosLooca) {
                processos.add(new Processo(0, processo.getPid(), processo.getNome(), processo.getUsoMemoria(), processo.getUsoCpu())
                );
            }
            processoDAO.insertProcessos(processos, 6);

        }
    };


}
