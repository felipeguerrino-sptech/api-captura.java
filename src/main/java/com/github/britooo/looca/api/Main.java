package com.github.britooo.looca.api;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;

public class Main {

    public static void main(String[] args) {

        Looca Looca = new Looca();
        Sistema Sistema = Looca.getSistema();

        System.out.println(Looca.getMemoria());

        System.out.println(Sistema.getFabricante());
        System.out.println(Sistema);
    }
}
