package ca.sheridancollege.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.fluttercode.datafactory.impl.DataFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ca.sheridancollege.beans.Person;
import lombok.*;

@Data
public class DAO {

	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	public void addPerson(Person person) {
		// Open a new session and begin a transaction.
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(person);

		// Commit the transaction and close the session.
		session.getTransaction().commit();
		session.close();
	}

	public List<Person> getPerson() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from Person");
		List<Person> personList = (List<Person>) query.getResultList();

		session.getTransaction().commit();
		session.close();

		return personList;
	}

	public Person queryByID(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from Person where id=:id");
		query.setParameter("id", id);
		List<Person> personList = (List<Person>) query.getResultList();

		session.getTransaction().commit();
		session.close();

		Person person = new Person();
		if (!personList.isEmpty()) {
			person = personList.get(0);
		}
		return person;
	}

	public void generateRandom() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		DataFactory df = new DataFactory();

		for (int i = 1; i < 10; i++) {
			Person person = new Person(df.getName(), df.getNumberText(10), df.getAddress(), df.getEmailAddress());
			session.save(person);

		}

		// ending of the method
		session.getTransaction().commit();
		session.close();

	}

	public void deletePerson(int index) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Person person = (Person) session.get(Person.class, index);
		session.delete(person);

		session.getTransaction().commit();
		session.close();
	}

//	public List<Movie> queryByCategory(String color) {
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//
//		Query query = session.createQuery("from Movie where genre=:genre");
//		query.setParameter("color", color);
//		List<Movie> persons = (List<Movie>) query.getResultList();
//
//		session.getTransaction().commit();
//		session.close();
//
//		return persons;
//	}

}
