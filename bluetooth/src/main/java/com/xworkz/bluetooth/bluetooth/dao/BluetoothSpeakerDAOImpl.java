package com.xworkz.bluetooth.bluetooth.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.bluetooth.bluetooth.dto.BluetoothSpeakerDTO;
import com.xworkz.singleton.HibernateUtil;

public class BluetoothSpeakerDAOImpl implements BluetoothSpeakerDAO{
public void save(BluetoothSpeakerDTO bluetoothSpeakerDTO) {
		
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(BluetoothSpeakerDTO.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(bluetoothSpeakerDTO);
		transaction.commit();
		session.close();
		factory.close();
		
		
	}

	public BluetoothSpeakerDTO getBrandById(int id) {
		
		Configuration config = new Configuration();
		config.configure();
		config.addAnnotatedClass(BluetoothSpeakerDTO.class);
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		BluetoothSpeakerDTO bDTO = session.get(BluetoothSpeakerDTO.class,id);
		session.close();
		factory.close();
		
		return bDTO;
	}

	public List<BluetoothSpeakerDTO> getAllDetails() {
		Session session = null;
		
		try {
			
			 return HibernateUtil.getSessionFactory().openSession().createQuery("from BluetoothSpeakerDTO bDTO").list();
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

	public void deleteById(int id) {
		Configuration config = new Configuration();
		config.configure();
		config.addAnnotatedClass(BluetoothSpeakerDTO.class);
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		BluetoothSpeakerDTO bDTO1 = session.get(BluetoothSpeakerDTO.class,id);
		Transaction transaction = session.beginTransaction();
		session.delete(bDTO1);
		transaction.commit();
		session.close();
		factory.close();
		
	}

	public void updateRangeByName(int id,String range) {
		Configuration confi = new Configuration();
		confi.configure();
		confi.addAnnotatedClass(BluetoothSpeakerDTO.class);
		SessionFactory factory = confi.buildSessionFactory();
		Session session = factory.openSession();
		BluetoothSpeakerDTO blueeDTO = session.get(BluetoothSpeakerDTO.class,id);
		blueeDTO.setRange(range);
		Transaction transaction = session.beginTransaction();
		session.update(blueeDTO);
		transaction.commit();
		session.close();
		factory.close();
		
	}

	@Override
	public BluetoothSpeakerDTO getDetailsByBluetoothBrand(String brand) {
		Session session = null;
		String hql = "Select dto from BluetoothSpeakerDTO dto where dto.brand='"+brand+"'";
		
		try {
			return (BluetoothSpeakerDTO) HibernateUtil.getSessionFactory().openSession().createQuery(hql).uniqueResult();
		}catch (HibernateException e) {
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

	@Override
	public String getBluetoothNameByBrand(String brand) {
		Session session =null;
		String hql = "Select dto.bluetoothName from BluetoothSpeakerDTO dto where dto.brand='"+brand+"'";

		try {
			return (String) HibernateUtil.getSessionFactory().openSession().createQuery(hql).uniqueResult();
		}catch (HibernateException e) {
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

	@Override
	public Object[] getBluetoothRangeAndbluetoothNameByBrand(String brand) {
		Session session =null;
		String hql = "Select dto.range ,dto.bluetoothName from BluetoothSpeakerDTO dto where dto.brand='"+brand+"'";

		try {
			return (Object[]) HibernateUtil.getSessionFactory().openSession().createQuery(hql).uniqueResult();
		}catch (HibernateException e) {
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
	


}
