package com.projetos.senai;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SenaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SenaiApplication.class, args);
		ArrayList<Cliente> clientes = new ArrayList<>();
		boolean logon = false;

		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("clientes.dat"))) {
            clientes = (ArrayList<Cliente>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		Menu menu = new Menu();
		while (!logon){
			logon = menu.welcome(clientes);
		}
		menu.mensagens();
		Cliente novo = new Cliente();
		novo.add_cliente(clientes, menu.frases);
	
	for(int i = 0; i < clientes.size(); i++){
		System.out.println(clientes.get(i).nome + " " + clientes.get(i).getSaldo());
	}	
	
}
}
