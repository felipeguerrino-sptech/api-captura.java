package com.eyesonserver.terminal;

import com.eyesonserver.login.Login;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Terminal {
    //Aqui sera desenvolvida a interface de terminal da aplicacao

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


        System.out.print("Login: ");
        email = leitor.nextLine();

        System.out.print("Senha: ");
        senha = leitor.nextLine();

        Login login = new Login(email,senha);







    }


}
