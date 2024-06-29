package com.librarymanagement.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.librarymanagement.pojo.Event;

public class EventDAO extends DAO {

	public void createEvent(Event event) {
		beginTransaction();
		getSession().persist(event);
		commitTransaction();
	}

	public Event getEvent(String eventName) {
		beginTransaction();
		String hql = "FROM Event WHERE eventName = :eventName";
		Query<Event> query = getSession().createQuery(hql, Event.class);
		query.setParameter("eventName", eventName);
		Event event = query.uniqueResult();
		commitTransaction();
		return event;
	}

	public void updateEvent(Event event) {
		beginTransaction();
		Event existingEvent = getSession().get(Event.class, event.getId());
		existingEvent.setStartTime(event.getStartTime());
		existingEvent.setEndTime(event.getEndTime());
		existingEvent.setLocation(event.getLocation());
		getSession().merge(existingEvent);
		commitTransaction();
	}

	public void updateEventAdmin(Event event) {
		beginTransaction();
		Event existingEvent = getSession().get(Event.class, event.getId());
		existingEvent.setEventName(event.getEventName());
		existingEvent.setStartTime(event.getStartTime());
		existingEvent.setEndTime(event.getEndTime());
		existingEvent.setCapacity(event.getCapacity());
		existingEvent.setLocation(event.getLocation());
		getSession().merge(existingEvent);
		commitTransaction();
	}

	public List<Event> getAllEvents() {
		List<Event> events = null;

		try {

			beginTransaction();
			String hql = "FROM Event";
			Query<Event> query = getSession().createQuery(hql, Event.class);
			Query<Event> q = query;
			events = q.list();

			commitTransaction();

		} catch (HibernateException e) {
			rollbackTransaction();
		}
		return events;
	}

}
