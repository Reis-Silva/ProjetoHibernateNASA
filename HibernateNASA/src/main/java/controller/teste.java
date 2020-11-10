package controller;

import java.util.List;

import entity.nasa.Items;
import entity.nasa.NASA;
import webservice.WEBService;

public class teste {
	
	public static void main(String[] args) throws Exception {
		
		NASA teste = new NASA();
		List<Items> items = null;
	
			items = WEBService.listarDadosNASA();
		
		
		System.out.println("teste: "+items.get(0).getData()[0].getNasa_id()+"\n");
	}
	
}
