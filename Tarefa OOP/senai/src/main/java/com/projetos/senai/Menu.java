package com.projetos.senai;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    String frases[] =
    {"Bem vindo", "Selecione a operação", "Ver Saldo",
    "Depositar", "Sacar", "Alterar informações",
    "Login: ", "Senha: ", "Login Errado", "Senha Errada"};

    Scanner sc = new Scanner(System.in);
    
    public boolean welcome(ArrayList<Cliente> clientes){
        String temp_login;
        int temp_senha;
           
            System.out.println(frases[6]);
            temp_login = sc.nextLine();
            System.out.println(frases[7]);
            temp_senha = sc.nextInt();
            sc.nextLine();

        for (int i = 0; i < clientes.size(); i++){
            if (temp_login.equals(clientes.get(i).getLogin())){
                if (temp_senha == (clientes.get(i).getSenha())){                  
                    return true;
                } else {
                    System.out.println(frases[9]);
                }
            } else {
                System.out.println(frases[8]);
            }
        }        
        return false;
    }

    public int mensagens(){
        System.out.println(frases[0] + "\n" + frases[1]);
        System.out.println("\n(1)" + frases[2] + "\n(2)" + frases[3] + "\n(3)" + 
        frases[4] + "\n(4)" + frases[5]
        );
        int escolha = sc.nextInt();
        return escolha;
    }

}
