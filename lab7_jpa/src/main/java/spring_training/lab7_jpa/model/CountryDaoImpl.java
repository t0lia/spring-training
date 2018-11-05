package spring_training.lab7_jpa.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class CountryDaoImpl implements CountryDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Country country) {
        em.persist(country);
    }

    @Override
    public List<Country> getAllCountries() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Country> cq = builder.createQuery(Country.class);
        Root<Country> root = cq.from(Country.class);
        cq.select(root);
        return em.createQuery(cq).getResultList();
    }

    @Override
    public void update(Country country) {
        em.merge(country);
    }

    @Override
    public Optional<Country> getCountryByName(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Country> cq = builder.createQuery(Country.class);
        Root<Country> root = cq.from(Country.class);
        cq.select(root).where(builder.equal(root.get("name"), name));
        return em.createQuery(cq).getResultList().stream().findFirst();
    }

    @Override
    public List<Country> getStartWith(String prefix) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Country> cq = builder.createQuery(Country.class);
        Root<Country> root = cq.from(Country.class);
        cq.select(root).where(builder.like(root.get("name"), prefix + "%"));
        return em.createQuery(cq).getResultList();
    }

    @Override
    @Transactional
    public void clear() {
        getAllCountries().forEach(em::remove);
    }
}
