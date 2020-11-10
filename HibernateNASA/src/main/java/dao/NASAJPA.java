package dao;

import java.util.List;

import entity.nasa.Items;
import entity.nasa.NASA;
import webservice.WEBService;

public class NASAJPA extends DAOJPA<NASA, Integer> implements NASADAO<NASA, Integer>{

	
	@Override
	public List<NASA> buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	public void BuscarDados() {
		try {
			setEntidades(WEBService.listarDadosNASA());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}


}
