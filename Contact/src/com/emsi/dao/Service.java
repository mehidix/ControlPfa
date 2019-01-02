package com.emsi.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Service<T> implements IDeao<T>{
	public Session session;
	
	public Service() {
		super();
		session =HibernateUtil.openSession();
	}

	@Override
	public T Find(String Nom,String Nom2,String Nomdeclass,String nomculum,String nomculum2) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		Object ob = null;
		try {
			tx = session.getTransaction();
			tx.begin();
 			Query query =session.createQuery("from "+Nomdeclass+" where "+nomculum+" like ? and "+nomculum2
 					+" like ?");
			query.setString(0,Nom);
			query.setString(1,Nom2);
			ob = query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return (T) ob;
	}

	@Override
	public void InsertUser(T o) {
		session.beginTransaction();
		session.save(o);
		session.getTransaction().commit();
		
	}

	@Override
	public Boolean ChekUser(String Nom, String Nomdeclass,String nomcum) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		Object ob = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from "+Nomdeclass+" where "+nomcum+ " like ?");
			query.setString(0,Nom);
			ob = query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		if(ob!=null) return true;
		return false;
	}

	@Override
	public ArrayList<T> FindALL(String Nomdeclass) {
		ArrayList<T> list = new ArrayList<T>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query=session.createQuery("from "+Nomdeclass);
			list=(ArrayList<T>) query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				System.out.println("deeeeeeee");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void Delete(T o) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.delete(o);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

	@Override
	public void Update(T o) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.update(o);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

	@Override
	public T FindById(int id, String Nomdeclass) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		Object ob = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from "+Nomdeclass+" where id=? ");
			query.setInteger(0,id);
			ob = query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return (T) ob;
	}

	@Override
	public ArrayList<T> FindALLbyCle(String cle, String Nomdeclass) {
		ArrayList<T> list = new ArrayList<T>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from "+Nomdeclass+" where nom  like ?");
			query.setString(0, "%"+cle+"%");
			list=(ArrayList<T>) query.list();
			
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	public ArrayList<T> FindALLbyEtat(String Nomdeclass) {
		ArrayList<T> list = new ArrayList<T>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from "+Nomdeclass+" where etat=1");
			list=(ArrayList<T>) query.list();
			
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	@Override
	public ArrayList<T> Findbyclee(String Nomdeclass,String cle) {
		ArrayList<T> list = new ArrayList<T>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query= session.createQuery("from "+Nomdeclass+ " where aeroportDepart like ? "
					+ "OR aeroportArrive like ?" );
			query.setString(0, "%"+cle+"%");
			query.setString(1, "%"+cle+"%");
			list=(ArrayList<T>) query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public ArrayList<T> FindReseId(String Nomdeclass, int id) {
		ArrayList<T> list = new ArrayList<T>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from "+Nomdeclass+" where utlisateur_id=?");
			query.setInteger(0,id);
			list=(ArrayList<T>) query.list();
			
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	public List<T> FindRE(String Nomdeclass) {
		List<T> list = new ArrayList<T>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query=session.createQuery("from "+Nomdeclass);
			list=query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	

	

	
}
