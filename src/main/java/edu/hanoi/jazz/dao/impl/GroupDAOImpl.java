package edu.hanoi.jazz.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import edu.hanoi.jazz.dao.GroupDAO;
import edu.hanoi.jazz.model.Group;

@Component("groupDAO")
//@EnableTransactionManagement
public class GroupDAOImpl implements GroupDAO {
	
	private final static Logger LOGGER = Logger.getLogger(GroupDAOImpl.class);
	
	@Autowired
	private LocalSessionFactoryBean sessionFactory;

	@Override
//	@Transactional
	public void insert(Group group) {
		LOGGER.info("sessionFatory:" + sessionFactory + " insert group: "+group);
		Session session = sessionFactory.getObject().openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.save(group);
			session.flush();
		} catch(Exception e) {
			LOGGER.info(e.getMessage(), e);
			transaction.rollback();
		} finally {
			session.close();
		}
		
	}
}
