package com.librarymanagement.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.librarymanagement.pojo.UserAccount;
import com.librarymanagement.pojo.UserProfile;

public class UserDAO extends DAO {

	public void registerUserOld(UserProfile user) {
		beginTransaction();
		getSession().persist(user);
		commitTransaction();
	}

	public void registerUser(UserAccount userAccount, UserProfile userProfile) {
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();
			tx = session.beginTransaction();

			session.persist(userAccount);

			userProfile.setId(userAccount.getId());
			session.persist(userProfile);

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
		}
	}

	public UserAccount getUserAccount(String username, String password) {
		beginTransaction();
		String hql = "FROM UserAccount WHERE username = :username AND password = :password";
		Query<UserAccount> query = getSession().createQuery(hql, UserAccount.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		UserAccount useracc = query.uniqueResult();
		commitTransaction();
		return useracc;
	}

	public UserProfile getUserProfile(UserAccount useracc) {
		beginTransaction();
		String hql = "FROM UserProfile WHERE id = :id";
		Query<UserProfile> query = getSession().createQuery(hql, UserProfile.class);
		query.setParameter("id", useracc.getId());
		UserProfile userprof = query.uniqueResult();
		commitTransaction();
		return userprof;
	}

	public UserProfile updateUserProfile(UserProfile updatedUser) {
		beginTransaction();
		UserProfile existingUser = getSession().get(UserProfile.class, updatedUser.getId());

		if (existingUser != null) {
			if (updatedUser.getFname() != null && !updatedUser.getFname().equals(existingUser.getFname())) {
				existingUser.setFname(updatedUser.getFname());
			}
			if (updatedUser.getLname() != null && !updatedUser.getLname().equals(existingUser.getLname())) {
				existingUser.setLname(updatedUser.getLname());
			}
			if (updatedUser.getAddress() != null && !updatedUser.getAddress().equals(existingUser.getAddress())) {
				existingUser.setAddress(updatedUser.getAddress());
			}
			if (updatedUser.getMobno() != null && !updatedUser.getMobno().equals(existingUser.getMobno())) {
				existingUser.setMobno(updatedUser.getMobno());
			}

			getSession().merge(existingUser);
			commitTransaction();
		}
		return existingUser;
	}

}
