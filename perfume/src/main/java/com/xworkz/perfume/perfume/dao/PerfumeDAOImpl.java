package com.xworkz.perfume.perfume.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.xworkz.perfume.perfume.dto.PerfumeDTO;
import com.xworkz.singleton.HibernateUtil;

public class PerfumeDAOImpl implements PerfumeDAO{
	SessionFactory sf=null;
	Session session=null;
	Transaction transaction =null;
	public void save(PerfumeDTO pDTO) {
		try {
		sf = HibernateUtil.getSessionFactory();
		System.out.println(sf);
		session = sf.openSession();
		transaction =session.beginTransaction();
		session.save(pDTO);
		transaction.commit();
		
		}catch (HibernateException e) {
			if(transaction!=null) {
				transaction.rollback();
			}
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
		
	}

	public PerfumeDTO getDetailsByName(int id, String name) {
		
		try {
			sf = HibernateUtil.getSessionFactory();
		session = sf.openSession();
		PerfumeDTO prDTO = session.get(PerfumeDTO.class, id);
		if(prDTO.getPerfumeName().equalsIgnoreCase(name)) {
			return prDTO;
			
		}
		else {
			System.out.println("Name not matching with id , enter correct id");
		}
		
		
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return null;
	}

	public void updateColorByName(int id, String name, String color) {
		try {
			sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		PerfumeDTO prDTO = session.get(PerfumeDTO.class, id);
		transaction =session.beginTransaction();
		if(prDTO.getPerfumeName().equalsIgnoreCase(name)) {
			prDTO.setPerfumeColor(color);
			session.update(prDTO);
			transaction.commit();
		}
		else {
			System.out.println("Name not matching with id , enter correct id");
		}
		
	}catch (HibernateException e) {
		if(transaction!=null) {
			transaction.rollback();
		}
	}
	finally {
		if(session!=null) {
			session.close();
		}
	}
		
	}

	public void deleteDetailsByName(int id, String name) {
		try {
			sf = HibernateUtil.getSessionFactory();
		session = sf.openSession();
		PerfumeDTO prDTO = session.get(PerfumeDTO.class, id);
		transaction =session.beginTransaction();
		if(prDTO.getPerfumeName().equalsIgnoreCase(name)) {
			session.delete(prDTO);
			transaction.commit();
		}
		else {
			System.out.println("Name not matching with id , enter correct id");
		}
		
		}catch (HibernateException e) {
			if(transaction!=null) {
				transaction.rollback();
			}
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
		
	}

	@Override
	public List<PerfumeDTO> getAllDetails() {
		try {
			
			return HibernateUtil.getSessionFactory().openSession().createQuery("from PerfumeDTO prDTO").list();
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				if(session!=null) {
					session.close();
				}
				if(HibernateUtil.getSessionFactory()!=null) {
					HibernateUtil.getSessionFactory().close();
				}
			}
			return null;
	}

	@Override
	public String getPerfumeFragnanceByPerfumeName(String name) {
		String hql = "select dto.perfumeFragnance from PerfumeDTO dto where dto.perfumeName=:name ";
		
		try {
			
			return (String) HibernateUtil.getSessionFactory().openSession().createQuery(hql).setParameter("name",name).uniqueResult();
			}catch (HibernateException e) {
				e.printStackTrace();
			}
			finally{
				if(session!=null) {
					session.close();
				}
				
			}
		return null;
	}

	@Override
	public PerfumeDTO getDetailsByperfumeName(String name) {
		String hql = "select dto from PerfumeDTO dto where dto.perfumeName=:naa";
		
		try {
			
			return (PerfumeDTO) HibernateUtil.getSessionFactory().openSession().createQuery(hql).setParameter("naa", name).uniqueResult();
			}catch (HibernateException e) {
				e.printStackTrace();
			}
			finally{
				if(session!=null) {
					session.close();
				}
				
			}
		return null;
	}

	@Override
	public Object[] getperfumeColorAndPricesByPerfumeName(String name) {
		String hql = "select dto.perfumeColor,dto.perfumePrice from PerfumeDTO dto where dto.perfumeName=:naa";
		
		try {
			
			return (Object[]) HibernateUtil.getSessionFactory().openSession().createQuery(hql).setParameter("naa",name).uniqueResult();
			}catch (HibernateException e) {
				e.printStackTrace();
			}
			finally{
				if(session!=null) {
					session.close();
				}
				if(HibernateUtil.getSessionFactory()!=null) {
					HibernateUtil.getSessionFactory().close();
				}
				
			}
		return null;
	}

	@Override
	public List<Object[]> getperfumePriceAndperfumeColorByperfumeFragnance(String fragnance) {
		String hql = "select dto.perfumeColor,dto.perfumePrice from PerfumeDTO dto where dto.perfumeFragnance=:frag ";
		
		try {
			
			return HibernateUtil.getSessionFactory().openSession().createQuery(hql).setParameter("frag", fragnance).list();
			}catch (HibernateException e) {
				e.printStackTrace();
			}
			finally{
				if(session!=null) {
					session.close();
				}
				
				
			}
		return null;
	}

	@Override
	public int updatePriceByNameH(String name,double price) {
		String hql = "update PerfumeDTO dto set dto.perfumePrice =:pri where dto.perfumeName=:na";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("na", name);
			query.setParameter("pri", price);
			int r = query.executeUpdate();
			
			transaction.commit();
			return r; 
			}catch (HibernateException e) {
				e.printStackTrace();
				transaction.rollback();
			}
			finally{
				if(session!=null) {
					session.close();
				}
				if(HibernateUtil.getSessionFactory()!=null) {
					HibernateUtil.getSessionFactory().close();
				}
				
			}
		return 0;
	}

	@Override
	public int updateColorByNameH(String name, String color) {
String hql = "update PerfumeDTO dto set dto.perfumeColor =:cl where dto.perfumeName=:na";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("na", name);
			query.setParameter("cl", color);
			int r = query.executeUpdate();
			
			transaction.commit();
			return r; 
			}catch (HibernateException e) {
				e.printStackTrace();
				transaction.rollback();
			}
			finally{
				if(session!=null) {
					session.close();
				}
				if(HibernateUtil.getSessionFactory()!=null) {
					HibernateUtil.getSessionFactory().close();
				}
				
			}
		return 0;
	}

	@Override
	public int updateperfumeFragnanceByNameH(String name, String fragnance) {
String hql = "update PerfumeDTO dto set dto.perfumeFragnance =:frg where dto.perfumeName=:nam ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("frg", fragnance);
			query.setParameter("nam", name);
			int r = query.executeUpdate();
			
			transaction.commit();
			return r; 
			}catch (HibernateException e) {
				e.printStackTrace();
				transaction.rollback();
			}
			finally{
				if(session!=null) {
					session.close();
				}
				if(HibernateUtil.getSessionFactory()!=null) {
					HibernateUtil.getSessionFactory().close();
				}
				
			}
		return 0;
	}

	@Override
	public int deleteByNameH(String name) {
String hql = "delete from PerfumeDTO dto where dto.perfumeName=:na";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("na", name);
			int r = query.executeUpdate();
			
			transaction.commit();
			return r; 
			}catch (HibernateException e) {
				e.printStackTrace();
				transaction.rollback();
			}
			finally{
				if(session!=null) {
					session.close();
				}
				if(HibernateUtil.getSessionFactory()!=null) {
					HibernateUtil.getSessionFactory().close();
				}
				
			}
		return 0;
	}

	@Override
	public int deleteByPriceH(double price) {
String hql = "delete from PerfumeDTO dto where dto.perfumePrice=:pri";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("pri", price);
			int r = query.executeUpdate();
			
			transaction.commit();
			return r; 
			}catch (HibernateException e) {
				e.printStackTrace();
				transaction.rollback();
			}
			finally{
				if(session!=null) {
					session.close();
				}
				if(HibernateUtil.getSessionFactory()!=null) {
					HibernateUtil.getSessionFactory().close();
				}
				
			}
		return 0;
	}

	@Override
	public int deleteByColorH(String color) {
String hql = "delete from PerfumeDTO dto where dto.perfumeColor= :clr";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("clr", color);
			int r = query.executeUpdate();
			
			transaction.commit();
			return r; 
			}catch (HibernateException e) {
				e.printStackTrace();
				transaction.rollback();
			}
			finally{
				if(session!=null) {
					session.close();
				}
				if(HibernateUtil.getSessionFactory()!=null) {
					HibernateUtil.getSessionFactory().close();
				}
				
			}
		return 0;
	}


}
