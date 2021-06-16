package database;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SunriseDao {

    public void create(Sunrise sunrise) {

        Transaction transaction = null;

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(sunrise);
            transaction.commit();
        } catch (IllegalStateException | RollbackException e) {
            System.err.println("Błąd zapisu encji sunrise");
            e.printStackTrace();
        }
    }

    public Sunrise getByLocation(String lat, String lng) {

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Sunrise> query = cb.createQuery(Sunrise.class);
            Root<Sunrise> table = query.from(Sunrise.class);

            Predicate[] predicates = new Predicate[2];
            predicates[0] = cb.equal(table.get("lat"), lat);
            predicates[1] = cb.equal(table.get("lng"), lng);

            query.select(table).where(predicates);

            Sunrise sunrise = session.createQuery(query).getSingleResult();


            return sunrise;


        } catch (PersistenceException e) {


        }

        return null;

    }

    public List<Sunrise> getAll() {
        List<Sunrise> result = new ArrayList<>();

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Sunrise> query = criteriaBuilder.createQuery(Sunrise.class);
            Root<Sunrise> table = query.from(Sunrise.class);
            query.select(table);
            List<Sunrise> list = session.createQuery(query).list();
            result.addAll(list);
        } catch (HibernateException he) {
            System.err.println("get all error");
            he.printStackTrace();
        }
        return result;
    }
}
