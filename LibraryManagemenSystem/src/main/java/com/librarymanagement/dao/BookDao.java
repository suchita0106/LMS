package com.librarymanagement.dao;

import java.util.List;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.librarymanagement.pojo.Book;

public class BookDao extends DAO {
	public void save(Book book) {
		System.out.println("Book DAO reacher");
		beginTransaction();
		getSession().persist(book);
		commitTransaction();
	}

	@Transactional
	public void update(Book updatedBook) {

		beginTransaction();
		Book existingBook = getSession().get(Book.class, updatedBook.getId());

		if (existingBook != null) {
			existingBook.setTitle(updatedBook.getTitle());
			existingBook.setAuthor(updatedBook.getAuthor());
			getSession().merge(existingBook);
			commitTransaction();

		}
	}

	public List<Book> getAllBooks() {
		List<Book> books = null;

		try {

			beginTransaction();
			String hql = "FROM Book";
			Query<Book> query = getSession().createQuery(hql, Book.class);
			books = query.list();

			commitTransaction();

		} catch (HibernateException e) {
			rollbackTransaction();
		}
		return books;
	}

	public Book getBookDetails(Long id) {
		Book book = null;

		try {

			beginTransaction();
			String hql = "FROM Book where id = :bId";
			Query<Book> query = getSession().createQuery(hql, Book.class);
			query.setParameter("bId", id);
			book = query.uniqueResult();

			commitTransaction();

		} catch (HibernateException e) {
			rollbackTransaction();
		}
		return book;
	}

	public List<Book> searchByCriteria(String criteriaa, String input) {
		List<Book> books = null;
		Transaction transaction = null;
		try {
			transaction = getSession().beginTransaction();

			CriteriaBuilder builder = getSession().getCriteriaBuilder();
			CriteriaQuery<Book> criteriaQuery = builder.createQuery(Book.class);
			Root<Book> root = criteriaQuery.from(Book.class);
			criteriaQuery.select(root);

			if (criteriaa.equals("A")) {
				Predicate authorPredicate = builder.like(root.get("author"), "%" + input + "%");
				criteriaQuery.where(authorPredicate);
			} else {
				Predicate titlePredicate = builder.like(root.get("title"), "%" + input + "%");
				criteriaQuery.where(titlePredicate);
			}

			books = getSession().createQuery(criteriaQuery).getResultList();

			transaction.commit();
		} catch (Exception e) {
			rollbackTransaction();

		}
		return books;
	}

	public List<Book> searchByCriteriaOrig(String criteriaa, String input) {
		List<Book> books = null;
		Transaction transaction = null;
		try {
			Session session = getSession();
			transaction = session.beginTransaction();

			String queryString;
			if ("A".equals(criteriaa)) {
				queryString = "FROM Book WHERE LOWER(author) LIKE LOWER(:input)";
			} else {
				queryString = "FROM Book WHERE LOWER(title) LIKE LOWER(:input)";
			}

			Query<Book> query = session.createQuery(queryString, Book.class);
			query.setParameter("input", "%" + input.toLowerCase() + "%");

			books = query.getResultList();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return books;
	}

	public void updateQty(char flg, Long bookID) {
		beginTransaction();
		Book existingBook = getSession().get(Book.class, bookID);

		if (existingBook != null) {
			Long qty = existingBook.getQuantity();
			if (flg == 'P' || flg == 'A') {
				existingBook.setQuantity(qty - 1);
			} else {
				existingBook.setQuantity(qty + 1);
			}
			getSession().merge(existingBook);
			commitTransaction();

		}
	}

}
