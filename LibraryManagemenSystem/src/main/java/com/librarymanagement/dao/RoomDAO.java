package com.librarymanagement.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.librarymanagement.pojo.Room;

public class RoomDAO extends DAO {

	public void createRoom(Room room) {
		beginTransaction();
		getSession().persist(room);
		commitTransaction();
	}

	public Room getRoom(String roomName) {
		beginTransaction();
		String hql = "FROM Room WHERE roomName = :roomName";
		Query<Room> query = getSession().createQuery(hql, Room.class);
		query.setParameter("roomName", roomName);
		Room room = query.uniqueResult();
		commitTransaction();
		return room;
	}

	public void updateRoom(Room room) {
		beginTransaction();
		Room existingRoom = getSession().get(Room.class, room.getId());
		existingRoom.setStartTime(room.getStartTime());
		existingRoom.setEndTime(room.getEndTime());
		existingRoom.setStatus(room.getStatus());
		getSession().merge(existingRoom);
		commitTransaction();
	}

	public void updateRoomAdmin(Room room) {
		beginTransaction();
		Room existingRoom = getSession().get(Room.class, room.getId());
		existingRoom.setRoomName(room.getRoomName());
		existingRoom.setStartTime(room.getStartTime());
		existingRoom.setEndTime(room.getEndTime());
		existingRoom.setCapacity(room.getCapacity());
		existingRoom.setStatus(room.getStatus());
		getSession().merge(existingRoom);
		commitTransaction();
	}

	public List<Room> getAllRooms() {
		List<Room> rooms = null;

		try {

			beginTransaction();
			String hql = "FROM Room";
			Query<Room> query = getSession().createQuery(hql, Room.class);
			Query<Room> q = query;
			rooms = q.list();

			commitTransaction();

		} catch (HibernateException e) {
			rollbackTransaction();
		}
		return rooms;
	}

	public List<Room> getFilteredRooms() {
		List<Room> rooms = null;

		beginTransaction();

		String hql = "FROM Room r WHERE r.status = 'Available'";
		Query<Room> query = getSession().createQuery(hql, Room.class);

		rooms = query.list();
		commitTransaction();

		return rooms;
	}

	public List<Room> getAllRoomsByDate(String selectedDate1) {
		List<Room> rooms = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = dateFormat.parse(selectedDate1);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		beginTransaction();

		String hql = "FROM Room r WHERE YEAR(r.startTime) = YEAR(:date) AND MONTH(r.startTime) = MONTH(:date) AND DAY(r.startTime) = DAY(:date)";

		Query<Room> query = getSession().createQuery(hql, Room.class);
		query.setParameter("date", date);

		rooms = query.list();
		commitTransaction();

		return rooms;
	}

}
