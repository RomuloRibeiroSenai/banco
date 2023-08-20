package com.projetos.senai;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente implements Serializable{
    
    public String nome;
    private String cpf;
    private String login;
    private int senha;
    private double saldo;
    
    public int getSenha() {
        return senha;
    }
    public void setSenha(int senha) {
        this.senha = senha;
    }
    public double getSaldo() {
        return saldo;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public void add_cliente(ArrayList<Cliente> clientes, String [] frases){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nome do Cliente: ");
        this.nome = sc.nextLine();
        System.out.println("Cpf do Cliente: ");
        this.cpf = sc.nextLine();
        System.out.println(frases[6]);
        this.login = sc.nextLine();
        System.out.println("(Numérica)" + frases[7]);
        this.senha = sc.nextInt();
        this.saldo = 0;

        clientes.add(this);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
            outputStream.writeObject(clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sc.close();
    }

}
