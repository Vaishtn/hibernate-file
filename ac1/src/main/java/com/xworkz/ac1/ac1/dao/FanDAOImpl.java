package com.xworkz.ac1.ac1.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.xworkz.ac1.ac1.dto.FanDTO;
import com.xworkz.singleton.HibernateUtil;

public class FanDAOImpl implements FanDAO{
	SessionFactory sessionFactory = null;
	Session session = null;
	Transaction transaction = null;

	@Override
	public void save(FanDTO fanDTO) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(fanDTO);
			transaction.commit();

		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}

		}
	}

	@Override
	public FanDTO getFanByName(int id) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			FanDTO fanDTO = session.get(FanDTO.class, id);

			return fanDTO;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void updatePriceByName(int id, String name, double price) {
		// TODO Auto-generated method stub
		try {

			sessionFactory = HibernateUtil.getSessionFactory();
			System.out.println((sessionFactory));
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			FanDTO fanDTO = session.get(FanDTO.class, id);
			fanDTO.setFanPrice(price);

			session.update(fanDTO);
			transaction.commit();

		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void deleteByName(int id, String name) {
		// TODO Auto-generated method stub
		try {
			sessionFactory = HibernateUtil.getSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			FanDTO fanDTO = session.get(FanDTO.class, id);
			session.delete(fanDTO);
			transaction.commit();

		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}

		}
	}

	@Override
	public List<FanDTO> getAllFan() {
		// TODO Auto-generated method stub
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("select dto from FanDTO dto");
			List<FanDTO> dtos = query.list();
			return dtos;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return null;
	}

	@Override
	public FanDTO getFanByFanId(int id) {
		// TODO Auto-generated method stub
		String hql = "select dto from FanDTO dto where dto.fanId=:pid";
		FanDTO fanDTO = new FanDTO();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("pid", id);
			fanDTO = (FanDTO) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session.close();
			} else {
				System.out.println("session cannot be closed");
			}
		}
		return fanDTO;

	}

	@Override
	public String getColorByFanName(String fanName) {
		// TODO Auto-generated method stub
		String cName = null;
		String hql = "select dto.fanColor from FanDTO  dto where dto.fanName=:pm";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("pm", fanName);
			cName = (String) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			} else {

				System.out.println("session cannot be closed");
			}
			if (HibernateUtil.getSessionFactory() != null) {
				HibernateUtil.getSessionFactory().close();
			}
		}
		return cName;
	}

	@Override
	public Object[] getNameAndPriceByColor(String fname) {
		Object[] nameAndPrice = null;
		String hql = "select dto.fanName, dto.fanPrice from FanDTO dto where dto.fanColor=:pc";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("pc", fname);
			nameAndPrice = (Object[]) query.uniqueResult();
			return nameAndPrice;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			} else {

				System.out.println("session cannot be closed");
			}
			if (HibernateUtil.getSessionFactory() != null) {
				HibernateUtil.getSessionFactory().close();
			}
		}
		return null;

	}

	@Override
	public List<Object[]> getAllNameAndPriceByColor(String color) {
		List<Object[]> allNameAndPrice = null;
		String hql = "select dto.fanName, dto.fanPrice from FanDTO dto where dto.fanColor=:cm";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("cm", color);
			allNameAndPrice = (List<Object[]>) query.list();
			return allNameAndPrice;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			} else {

				System.out.println("session cannot be closed");
			}
			if (HibernateUtil.getSessionFactory() != null) {
				HibernateUtil.getSessionFactory().close();
			}
		}
		return null;
	}

	@Override
	public int updatePriceByName(String name, double price) {
		// TODO Auto-generated method stub
		String hql = "update FanDTO dto set dto.fanPrice=:pc where dto.fanName=:nm";

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("pc", price);
			query.setParameter("nm", name);
			int r = query.executeUpdate();

			transaction.commit();
			return r;
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
			if (HibernateUtil.getSessionFactory() != null) {
				HibernateUtil.getSessionFactory().close();
			}

		}
		return 0;
	}

	@Override
	public int updateColorByName(String name, String color) {
		// TODO Auto-generated method stub
		String hql = "update FanDTO dto set dto.fanColor=:pc where dto.fanName=:nm ";

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			
			query.setParameter("pc", name);
			query.setParameter("nm", color);
			int r = query.executeUpdate();

			transaction.commit();
			return r;
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
			if (HibernateUtil.getSessionFactory() != null) {
				HibernateUtil.getSessionFactory().close();
			}

		}

		return 0;
	}

	@Override
	public int deleteByName(String name) {
		// TODO Auto-generated method stub
		String hql = "delete from FanDTO dto where dto.fanName=:nm";

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("nm", name);
			int n = query.executeUpdate();

			transaction.commit();
			return n;
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
			if (HibernateUtil.getSessionFactory() != null) {
				HibernateUtil.getSessionFactory().close();
			}

		}
		return 0;
	}

	@Override
	public int deleteByPrice(double price) {
		// TODO Auto-generated method stub
		String hql = "delete from FanDTO dto where dto.fanPrice=:pc";

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("pc", price);
			int n = query.executeUpdate();

			transaction.commit();
			return n;
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
			if (HibernateUtil.getSessionFactory() != null) {
				HibernateUtil.getSessionFactory().close();
			}

		}
		return 0;
	}
}
