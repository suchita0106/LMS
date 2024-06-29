package com.librarymanagement.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import com.librarymanagement.pojo.Request;

public class RequestDAO extends DAO {

	public void save(Request req) {
		beginTransaction();
		getSession().persist(req);
		commitTransaction();
	}

	public List<Request> getAllPendingRequests(Long user_id) {
		System.out.println("Pending Req DAO reacheed");
		List<Request> booksrequests = null;

		try {

			beginTransaction();
			String hql = "FROM Request WHERE userId=:userid AND statusFlg='P'";

			Query<Request> query = getSession().createQuery(hql, Request.class);
			query.setParameter("userid", user_id);

			Query<Request> q = query;
			booksrequests = q.list();

			commitTransaction();

		} catch (HibernateException e) {
			rollbackTransaction();
		}
		return booksrequests;
	}

	public List<Request> getAllBookReuests() {
		List<Request> booksrequests = null;

		try {

			beginTransaction();
			String hql = "FROM Request WHERE statusFlg='P'";
			Query<Request> query = getSession().createQuery(hql, Request.class);
			booksrequests = query.list();

			commitTransaction();

		} catch (HibernateException e) {
			rollbackTransaction();
		}
		return booksrequests;
	}

	public int updateReq(Long id, char flg, Long aid) {
		int updatedCount = 0;
		try {

			beginTransaction();
			String sql = "UPDATE BOOK_REQUESTS SET status_flg = :flg, admin_id= :aid WHERE id = :id";
			Query<Request> query = getSession().createNativeQuery(sql, Request.class);
			query.setParameter("flg", flg);
			query.setParameter("id", id);
			query.setParameter("aid", aid);

			updatedCount = query.executeUpdate();

			commitTransaction();

		} catch (HibernateException e) {
			rollbackTransaction();
		}
		return updatedCount;
	}

	public List<Request> getMyBooks(Long user_id) {
		List<Request> booksrequests = null;

		try {

			beginTransaction();
			String hql = "FROM Request WHERE userId =:user_id";
			Query<Request> query = getSession().createQuery(hql, Request.class);
			query.setParameter("user_id", user_id);
			booksrequests = query.list();

			commitTransaction();

		} catch (HibernateException e) {
			rollbackTransaction();
		}
		return booksrequests;

	}

	public Object getAssignedRequests(Long id) {
		List<Request> booksrequests = null;

		try {

			beginTransaction();
			String hql = "FROM Request WHERE adminUserAccount =:a_id";
			Query<Request> query = getSession().createQuery(hql, Request.class);
			query.setParameter("a_id", id);
			booksrequests = query.list();

			commitTransaction();

		} catch (HibernateException e) {
			rollbackTransaction();
		}
		return booksrequests;
	}

}
