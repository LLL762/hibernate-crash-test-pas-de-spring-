package book.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import book.app.entity.Book;

public class Main {

	public static void main(String[] args) {

		// à mettre dans une classe à part et ensuite l'appeler de l'extérieur.
		final SessionFactory sessionFactory = new Configuration()
				.addAnnotatedClass(Book.class) // peut aussi se faire dans le xml.
				.configure().buildSessionFactory();

		// à mettre dans les classes d'accès aux données, créer un nouveau livre.
		try (final Session session = sessionFactory.openSession()) {
			final Transaction tx = session.beginTransaction();
			session.persist(new Book("title"));
			tx.commit();
		}

	}

}
