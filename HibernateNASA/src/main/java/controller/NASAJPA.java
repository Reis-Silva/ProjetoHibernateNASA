package controller;

import java.util.List;

import javax.persistence.EntityManager;

import dao.NASADAO;
import entity.NASA;

public class NASAJPA extends DAOJPA<NASA, Integer> implements NASADAO<NASA, Integer>{

	@Override
	public void save(NASA entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Class<NASA> classGeneric, Integer pk) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NASA getById(Class<NASA> classGeneric, Integer pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NASA> buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

}
