package com.xworkz.paytm.paytm.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.xworkz.paytm.paytm.dto.PaymentMerchantDTO;
import com.xworkz.singleton.HibernateUtil;

public class PaymentMerchantDAOImpl implements PaymentMerchantDAO{
	Session session = null;
	Transaction transaction = null;

	public void save(PaymentMerchantDTO pDTO) {
		
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(pDTO);
		transaction.commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
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

	public PaymentMerchantDTO fetchDetailsByName(String name) {
		try {
			String hql = "select dto from PaymentMerchantDTO dto where dto.name=:nm";
			return (PaymentMerchantDTO) HibernateUtil.getSessionFactory().openSession().createQuery(hql).setParameter("nm", name).uniqueResult();
			}
			catch (HibernateException e) {
				e.printStackTrace();
			}
			finally {
				if(session!=null) {
					session.close();
				}
				if(HibernateUtil.getSessionFactory()!=null) {
					HibernateUtil.getSessionFactory().close();
				}
			}
		return null;
	}

	public Object[] fetchCEOAndEmailDetailsByName(String name) {
		try {
			String hql = "select dto.ceo,dto.email from PaymentMerchantDTO dto where dto.name=:nm";
			return (Object[]) HibernateUtil.getSessionFactory().openSession().createQuery(hql).setParameter("nm", name).uniqueResult();
			}
			catch (HibernateException e) {
				e.printStackTrace();
			}
			finally {
				if(session!=null) {
					session.close();
				}
				if(HibernateUtil.getSessionFactory()!=null) {
					HibernateUtil.getSessionFactory().close();
				}
			}
		return null;
	}

	public List<Object[]> fetchAllCEOAndEmailDetailsByLocation(String hqLocation) {
		try {
			String hql = "select dto.ceo,dto.email from PaymentMerchantDTO dto where dto.hq=:lc";
			return (List<Object[]>) HibernateUtil.getSessionFactory().openSession().createQuery(hql).setParameter("lc", hqLocation).list();
			}
			catch (HibernateException e) {
				e.printStackTrace();
			}
			finally {
				if(session!=null) {
					session.close();
				}
				if(HibernateUtil.getSessionFactory()!=null) {
					HibernateUtil.getSessionFactory().close();
				}
			}
		return null;
	}

	public int updateCEOByName(String name,String ceo) {
		try {
			String hql = "update PaymentMerchantDTO dto set dto.ceo=:ce where dto.name=:nam ";
			
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			Query query =session.createQuery(hql);
			query.setParameter("nam", name);
			query.setParameter("ce", ceo);
			int r = query.executeUpdate();
			transaction.commit();
			return r;
			
		}catch (HibernateException e) {
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
		return 0;
	}

	public int deleteDetailsByHq(String hq) {
		try {
			String hql = "delete from PaymentMerchantDTO dto  where dto.hq=:headq ";
			
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			Query query =session.createQuery(hql);
			query.setParameter("headq", hq);
			int r = query.executeUpdate();
			transaction.commit();
			return r;
			
		}catch (HibernateException e) {
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
		return 0;
	}

	

}
