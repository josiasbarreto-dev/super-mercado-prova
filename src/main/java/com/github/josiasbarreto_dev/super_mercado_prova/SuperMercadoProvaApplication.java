package com.github.josiasbarreto_dev.super_mercado_prova;

import com.github.josiasbarreto_dev.super_mercado_prova.Menu.Menu;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuperMercadoProvaApplication {
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.controlaMenu();
	}
}
