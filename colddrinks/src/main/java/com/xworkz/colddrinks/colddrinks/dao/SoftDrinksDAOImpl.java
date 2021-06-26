package com.xworkz.colddrinks.colddrinks.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.xworkz.colddrinks.colddrinks.dto.SoftDrinksDTO;
import com.xworkz.singleton.HibernateUtil;

public class SoftDrinksDAOImpl implements SoftDrinksDAO{
Transaction transaction = null;
	
	Session session = null;

	@Override
	public void save(SoftDrinksDTO cDTO) {
		
		try {
		session =HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(cDTO);
		transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			if(session!=null) {
				session.close();
			}
			
		}
	
		
	}

	@Override
	public List<SoftDrinksDTO> getAllDetails() {
		try {
			
			 return HibernateUtil.getSessionFactory().openSession().createQuery("from SoftDrinksDTO ssdto").list();
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
	public void updateColorByName(String name, int id, String color) {
		Transaction trans= null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			SoftDrinksDTO stDTO = session.get(SoftDrinksDTO.class, id);
			if(stDTO.getName().equalsIgnoreCase(name)) {
				stDTO.setColor(color);
				session.update(stDTO);
				trans.commit();
				
			}
			else {
				System.out.println("Please enter correct id of softdrinks");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			
		}
		finally {
			if(session!=null) {
				session.close();
			}
			if(HibernateUtil.getSessionFactory()!=null) {
				HibernateUtil.getSessionFactory().close();
			}
		}
		
		
	}

	@Override
	public void deleteColorByName(String name, int id) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			SoftDrinksDTO stDTO = session.get(SoftDrinksDTO.class, id);
			if(stDTO.getName().equalsIgnoreCase(name)) {
				session.delete(stDTO);
				transaction.commit();
				
			}
			else {
				System.out.println("Please enter correct id of softdrinks");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			
		}
		finally {
			if(session!=null) {
				session.close();
			}
			if(HibernateUtil.getSessionFactory()!=null) {
				HibernateUtil.getSessionFactory().close();
			}
		}
		
	}

	@Override
	public String getSoftdrinkColorBySoftdrinkName(String name) {
		String hql = "select dto.color from SoftDrinksDTO dto where dto.name = :nm";
		try {
			
			 return (String) HibernateUtil.getSessionFactory().openSession().createQuery(hql).setParameter("nm", name).uniqueResult();
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
	public SoftDrinksDTO getDetailsBySoftdrinkName(String name) {
		String hql = "select dto from SoftDrinksDTO dto where dto.name = :name ";
		try {
			
			 return (SoftDrinksDTO) HibernateUtil.getSessionFactory().openSession().createQuery(hql).setParameter("name",name).uniqueResult();
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
	public Object[] getSoftdrinkManufactureYearAndPricesBySoftdrinkName(String name) {
		String hql = "select dto.mfgYear,dto.price from SoftDrinksDTO dto where dto.name = :na";
		try {
			
			 return (Object[]) HibernateUtil.getSessionFactory().openSession().createQuery(hql).setParameter("na", name).uniqueResult();
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
	public List<Object[]> getsoftdrinkPriceAndsoftdrinkColorBysoftdrinkmfgyear(int mfgYear) {
String hql = "select dto.color,dto.price from SoftDrinksDTO dto where dto.mfgYear=:mf ";
		
		try {
			
			return HibernateUtil.getSessionFactory().openSession().createQuery(hql).setParameter("mf", mfgYear).list();
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
	public int updatePriceByNameH(String name, double price) {
String hql = "update SoftDrinksDTO dto set dto.price =:pri where dto.name=:na";
		
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
String hql = "update SoftDrinksDTO dto set dto.color =:clr where dto.name=:naa ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("naa", name);
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

	@Override
	public int updateColorByNameH(String name, int mfgyear) {
String hql = "update SoftDrinksDTO dto set dto.mfgYear =:mfy where dto.name=:nam ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("mfy", mfgyear);
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
	public int deleteColorByNameH(String name) {
String hql = "delete from SoftDrinksDTO dto where dto.name=:nam ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
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
	public int deleteColorByPriceH(double price) {
String hql = "delete from SoftDrinksDTO dto where dto.price=:pri";
		
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
	public int deleteColorByColorH(String color) {
String hql = "delete from SoftDrinksDTO dto where dto.color=:colo ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("colo", color);
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
