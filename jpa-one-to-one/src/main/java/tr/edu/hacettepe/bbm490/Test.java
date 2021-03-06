package tr.edu.hacettepe.bbm490;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {

	public static void main(String... args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bbm490-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Address address1 = new Address("Guncicekleri Sok", null, "Cankaya", "Ankara", "TR", 33333);
		entityManager.persist(address1);

		Employee employee = new Employee("John", "Goodman", "dog", 1);
		employee.setAddress(address1);

		entityManager.persist(employee);

		transaction.commit();
		entityManager.close();
	}
}