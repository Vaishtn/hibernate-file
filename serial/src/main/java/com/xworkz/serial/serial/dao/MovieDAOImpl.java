package com.xworkz.serial.serial.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.xworkz.serial.serial.dto.MovieDTO;
import com.xworkz.singleton.HibernateUtil;

public class MovieDAOImpl implements MovieDAO{
	SessionFactory sessionFactory = null;
	Session session = null;

	@Override
	public void save(MovieDTO movieDTO) {
		Transaction transaction = null;
		try {

			sessionFactory = HibernateUtil.getSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(movieDTO);
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
	public MovieDTO getMovieName(int id) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			MovieDTO movieDTO = session.get(MovieDTO.class, id);

			return movieDTO;
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
			System.out.println(sessionFactory);
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			MovieDTO movieDTO = session.get(MovieDTO.class, id);
			movieDTO.setMovieRating(rating);
			session.update(movieDTO);
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
			MovieDTO movieDTO = session.get(MovieDTO.class, id);
			session.delete(movieDTO);
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
	public List<MovieDTO> getAllMovies() {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("select dto from MovieDTO dto");
			List<MovieDTO> dtos = query.list();
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
	public MovieDTO getMovieByMovieId(int id) {
		Session session = null;
		String hql = "select dto from MovieDTO dto where dto.movieId=:mid";
		MovieDTO movieDTO = new MovieDTO();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("mid", id);
			movieDTO = (MovieDTO) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session.close();
			} else {
				System.out.println("session cannot be closed");
			}
		}
		return movieDTO;
	}

	@Override
	public String getMovieLanguageByMovieName(String movieName) {
		Session session = null;
		String movielanguage = null;
		String hql = "select dto.language from MovieDTO  dto where dto.movieName=:mName";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("mName", movieName);
			movielanguage = (String) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.clear();
			} else {

				System.out.println("session cannot be closed");
			}
			if (HibernateUtil.getSessionFactory() != null) {
				HibernateUtil.getSessionFactory().close();
			}
		}
		return movielanguage;
	}

	@Override
	public Object[] getNameAndRatingByLanguage(String language) {
		Session session = null;
		Object[] movieNameAndRating = null;
		String hql = "select dto.movieName, dto.movieRating from MovieDTO dto where dto.language=:lg";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("lg", language);
			movieNameAndRating = (Object[]) query.uniqueResult();
			return movieNameAndRating;
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
	public List<Object[]> getNameAndRatingByLanguage() {
		Session session = null;
		List<Object[]> movieNameAndRating = null;
		String hql = "select dto.movieName, dto.movieRating from MovieDTO dto";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			movieNameAndRating = query.list();
			return movieNameAndRating;
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
	public int updateLanguageByName(String language, String name) {
		Session session = null;
		int noOfRowAffected = 0;
		String hql = "update MovieDTO dto set dto.language=:lg where dto.movieName=:mname";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("lg", language);
			query.setParameter("mname", name);
			noOfRowAffected = query.executeUpdate();

			transaction.commit();

			return noOfRowAffected;

		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
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

		return 0;
	}

	@Override
	public int updateRatingByName(int rating, String name) {
		Session session = null;
		int noOfRowAffected = 0;
		String hql = "update MovieDTO dto set dto.movieRating=:rt where dto.movieName=:nm";
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("rt", rating);
			query.setParameter("nm", name);
			noOfRowAffected = query.executeUpdate();

			transaction.commit();
			return noOfRowAffected;
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
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

		return 0;
	}

	Transaction transaction = null;

	@Override
	public int deleteMovieByLanguage(String language) {
		Session session = null;
		int noOfAffected = 0;
		String hql = "delete dto from MovieDTO dto where dto.language=:lg";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("lg", language);
			noOfAffected = query.executeUpdate();
			transaction.commit();
			return noOfAffected;
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
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

		return 0;
	}

}
