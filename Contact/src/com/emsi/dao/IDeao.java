package com.emsi.dao;

import java.util.ArrayList;

public interface IDeao<T> {
	public T Find(String Nom,String Nom2,String Nomdeclass,String nomculum,String nomculum2);
	public void InsertUser(T o);
	public Boolean ChekUser(String Nom,String Nomdeclass,String nmculm);
	public ArrayList<T> FindALL(String Nomdeclass);
	public void Delete(T o);
	public void Update(T o);
	public T FindById(int id,String Nomdeclass);
	public ArrayList<T> FindALLbyCle(String cle,String Nomdeclass); 
	public ArrayList<T> Findbyclee(String Nomdeclass,String cle);
	public ArrayList<T> FindReseId(String Nomdeclass,int id);
}
