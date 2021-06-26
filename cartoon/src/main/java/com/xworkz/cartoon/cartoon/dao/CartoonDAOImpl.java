package com.xworkz.cartoon.cartoon.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.xworkz.cartoon.cartoon.dto.CartoonDTO;
import com.xworkz.singleton.HibernateUtil;

public class CartoonDAOImpl implements CartoonDAO{
	SessionFactory sessionFactory = null;
	Session session = null;

	@Override
	public void save(CartoonDTO cartoonDTO) {
		Transaction transaction = null;
		try {

			sessionFactory = HibernateUtil.getSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(cartoonDTO);
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
	public CartoonDTO getCartoonByName(int id) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			CartoonDTO cartoonDTO = session.get(CartoonDTO.class, id);

			return cartoonDTO;
		} finally {
			if (session != null) {
				session.close();
			}

		}

	}

	@Override
	public void updateRatingByName(int id, String name, int rating) {
		Transaction transaction = null;
		try {

			sessionFactory = HibernateUtil.getSessionFactory();
			System.out.println((sessionFactory));
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			CartoonDTO cartoonDTO = session.get(CartoonDTO.class, id);
			cartoonDTO.setRating(rating);

			session.update(cartoonDTO);
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
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			CartoonDTO cartoonDTO = session.get(CartoonDTO.class, id);
			session.delete(cartoonDTO);
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
	public List<CartoonDTO> getAllCartoon() {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("select dto from CartoonDTO dto");
			List<CartoonDTO> dtos = query.list();
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
	public CartoonDTO getCartoonByCartoonId(int id) {
		Session session = null;
		String hql = "select dto from CartoonDTO dto where dto.cartoonId=:cid";
		CartoonDTO cartoonDTO = new CartoonDTO();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("cid", id);
			cartoonDTO = (CartoonDTO) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session.close();
			} else {
				System.out.println("session cannot be closed");
			}
		}
		return cartoonDTO;
	}

	@Override
	public String getChannelNameByCartoonCharacterName(String characterName) {
		Session session = null;
		String cartoonName = null;
		String hql = "select dto.channelName from CartoonDTO  dto where dto.cartoonCharacterName=:cname";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("cname", characterName);
			cartoonName = (String) query.uniqueResult();
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
		return cartoonName;
	}

	@Override
	public Object[] getNameAndRatingByChannelName(String cName) {
		Session session = null;
		Object[] nameAndRating = null;
		String hql = "select dto.cartoonCharacterName, dto.rating from CartoonDTO dto where dto.channelName=:cname";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("cname", cName);
			nameAndRating = (Object[]) query.uniqueResult();
			return nameAndRating;
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
	public List<Object[]> getAllNameAndRatingByChannelName(String chName) {
		Session session = null;
		List<Object[]> allNameAndRating = null;
		String hql = "select dto.cartoonCharacterName, dto.rating from CartoonDTO dto where dto.channelName=:cname";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("cname", chName);
			allNameAndRating = query.list();
			return allNameAndRating;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

}
