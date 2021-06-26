package com.xworkz.desktop.desktop.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.xworkz.desktop.desktop.dto.LaptopDTO;
import com.xworkz.singleton.HibernateUtil;

public class LaptopDAOImpl implements LaptopDAO {
	SessionFactory sessionFactory = null;
	Session session = null;
Transaction transaction =null;
	@Override
	public void save(LaptopDTO laptopDTO) {
		// TODO Auto-generated method stub

		Transaction transaction = null;
		try {

			sessionFactory = HibernateUtil.getSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(laptopDTO);
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
	public LaptopDTO getLaptopByName(int id) {
		// TODO Auto-generated method stub
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			LaptopDTO laptopDTO = session.get(LaptopDTO.class, id);

			return laptopDTO;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void updatePriceByName(int id, String name, double price) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		try {

			sessionFactory = HibernateUtil.getSessionFactory();
			System.out.println((sessionFactory));
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			LaptopDTO laptopDTO = session.get(LaptopDTO.class, id);
			laptopDTO.setLaptopPrice(price);

			session.update(laptopDTO);
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
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			LaptopDTO laptopDTO = session.get(LaptopDTO.class, id);
			session.delete(laptopDTO);
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
	public List<LaptopDTO> getAllLoptop() {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("select dto from LaptopDTO dto");
			List<LaptopDTO> dtos = query.list();
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
	public LaptopDTO getLaptopByLaptopId(int id) {
		// TODO Auto-generated method stub
		Session session = null;
		String hql = "select dto from LaptopDTO dto where dto.laptopId=:pid";
		LaptopDTO laptopDTO = new LaptopDTO();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("pid", id);
			laptopDTO = (LaptopDTO) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session.close();
			} else {
				System.out.println("session cannot be closed");
			}
		}
		return laptopDTO;
	}

	@Override
	public String getColorByLaptopName(String pname) {
		// TODO Auto-generated method stub
		Session session = null;
		String color = null;
		String hql = "select dto.laptopColor from LaptopDTO  dto where dto.laptopName=:pm";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("pm", pname);
			color = (String) query.uniqueResult();
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
		return color;
	}

	@Override
	public Object[] getNameAndPriceByColor(String color) {
		// TODO Auto-generated method stub
		Session session = null;
		Object[] nameAndPrice = null;
		String hql = "select dto.laptopName, dto.laptopPrice from LaptopDTO dto where dto.laptopColor=:pc";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("pc", color);
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
	public List<Object[]> getAllNameAndPriceByColor(String cname) {
		// TODO Auto-generated method stub
		Session session = null;
		List<Object[]> allNameAndPrice = null;
		String hql = "select dto.laptopName, dto.laptopPrice from LaptopDTO dto where dto.latopColor=:cm";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("cm", cname);
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
		String hql = "update LaptopDTO dto set dto.laptopPrice =:pc where dto.laptopName=:nm";

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
		String hql = "update LaptopDTO dto set dto.laptopColor =:pc where dto.laptopName=:nm ";

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
		String hql = "delete from LaptopDTO dto where dto.laptopName=:nm";

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
		String hql = "delete from LaptopDTO dto where dto.laptopPrice=:pc";

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
