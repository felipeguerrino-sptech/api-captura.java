package com.eyesonserver.terminal;

import com.eyesonserver.dao.maquina.ServidorDAO;
import com.eyesonserver.dao.metrica.RegistroDAO;
import com.eyesonserver.dao.negocio.UsuarioDAO;
import com.eyesonserver.database.Conexao;
import com.eyesonserver.login.Login;
import com.eyesonserver.model.maquina.Servidor;
import com.eyesonserver.model.metrica.Registro;
import com.eyesonserver.model.negocio.Usuario;
import com.github.britooo.looca.api.core.Looca;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Terminal {
    //Aqui sera desenvolvida a interface de terminal da aplicacao
    static EscolhadoDoMenu escolhadoDoMenu = new EscolhadoDoMenu();

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        Boolean login;
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


        while (!escolhadoDoMenu.getEscolhaDoMenu().equals(6)){

        System.out.print("Login: ");
        email = leitor.nextLine();

        System.out.print("Senha: ");
        senha = leitor.nextLine();

        UsuarioDAO user = new UsuarioDAO();
        login = user.getUsuarioPorEmailSenha(email, senha);

        if (login){
            new Thread(capturaDeDados).start();
            Looca looca = new Looca();

            System.out.printf("\n\n\nOlá %s", login);

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
                        5. Todos
                        6. Sair
                        """);
                System.out.print("Escolha: ");
                escolhadoDoMenu.setEscolhaDoMenu(leitor.nextInt());

                if (escolhadoDoMenu.getEscolhaDoMenu().equals(1)){
                    System.out.println("Opção (Disco) escolhida!");

                    long discoTotal = looca.getGrupoDeDiscos().getVolumes().get(0).getTotal() / 1000000000;
                    long discoDisponivel = looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel() / 1000000000;

                    System.out.print("Porcentagem de uso: ");
                    System.out.print((discoTotal - discoDisponivel) * 100 / discoTotal);
                    System.out.println(" %");

                } else if (escolhadoDoMenu.getEscolhaDoMenu().equals(2)) {
                    System.out.println("Opção (Memória) escolhida! ");

                    long memoriaTotal = looca.getMemoria().getTotal() / 100000000;
                    long memoriaEmUso = looca.getMemoria().getEmUso() / 100000000;

                    System.out.print("Porcentagem de uso: ");
                    System.out.print(memoriaEmUso * 100 / memoriaTotal);
                    System.out.println(" %");


                } else if (escolhadoDoMenu.getEscolhaDoMenu().equals(3)) {
                    System.out.println("Opção (Rede) escolhida! ");

                    System.out.print("Bytes enviados: ");
                    System.out.print(looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getBytesEnviados());
                    System.out.println(" bytes");

                    System.out.print("Bytes recebidos: ");
                    System.out.print(looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getBytesRecebidos());
                    System.out.println(" bytes");


                } else if (escolhadoDoMenu.getEscolhaDoMenu().equals(4)) {
                    System.out.println("Opção (CPU) escolhida!");

                    System.out.print("Frequência de CPU: ");
                    System.out.print(looca.getProcessador().getFrequencia() / 1000000000);
                    System.out.println(" Hz");

                } else if (escolhadoDoMenu.getEscolhaDoMenu().equals(5)) {
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




                } else if (escolhadoDoMenu.getEscolhaDoMenu().equals(6)) {
                    System.out.println("Até mais!");
                    Thread.currentThread().stop();

                } else {
                    System.out.println("Escolha inválida!");
                }

                try {
                     Thread.sleep(4000);
                } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                }


                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            } while (escolhadoDoMenu.getEscolhaDoMenu() != 6);

        } else {
            System.out.println("""
                    Usuário não encontrado!
                    
                    Escolha uma opção: 
                    1. Tentar novamente
                    2. Sair
                    """);

            System.out.print("Opção: ");
            escolhadoDoMenu.setEscolhaDoMenu(leitor.nextInt() + 4);
            leitor.nextLine();
        }

        }
    }


    public static Runnable capturaDeDados = new Runnable() {
        @Override
        public void run() {

            for (; escolhadoDoMenu.getEscolhaDoMenu() != 6; ) {
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                Looca looca = new Looca();
                RegistroDAO registro = new RegistroDAO();

                LocalDateTime horaAtual = LocalDateTime.now();
                DateTimeFormatter formatarHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                formatarHora.format(horaAtual);

                String cpuFrequencia = "";
                String cpuPorcentagemUso = "";
                String redeBytesEnviados = "";
                String redeBytesRecebidos = "";
                String discoPorcentagemUso = "";
                String memoriaPorcentagemUso = "";


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


                // Insert no banco de dados:
                registro.insertRegistro(memoriaPorcentagemUsoRegistro);
                registro.insertRegistro(discoPorcentagemUsoRegistro);
                registro.insertRegistro(cpuFrequenciaRegistro);
                registro.insertRegistro(cpuPorcentagemUsoRegistro);
                registro.insertRegistro(redeByteEnviadosRegistro);
                registro.insertRegistro(redeByteRecebidosRegistro);


            }
        }
    };


}
