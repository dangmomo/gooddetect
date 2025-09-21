//package com.example.gooddetect.repository.impl;
//
//import com.example.gooddetect.model.EmailSent;
//import com.example.gooddetect.repository.EmailSentRepository;
//import jakarta.persistence.EntityManager;
//import org.hibernate.Session;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.StreamSupport;
//
//public class EmailSentRepositoryImpl implements EmailSentRepository {
//
//    private final EntityManager em;
//
//    public EmailSentRepositoryImpl(EntityManager em) { this.em = em; }
//
//    @Override
//    public List<EmailSent> findBySubjectContaining(String keyword) {
//        Session session = em.unwrap(Session.class);
//        List<EmailSent> emails = session.createQuery(
//                        "from EmailSent e where e.subject like :kw", EmailSent.class)
//                .setParameter("kw", "%" + keyword + "%")
//                .getResultList();
//        session.close();
//        return emails;
//    }
//
//    public List<EmailSent> findAllCustom() {
//        Session session = em.unwrap(Session.class);
//        List<EmailSent> emails = session.createQuery("from EmailSent", EmailSent.class).getResultList();
//        session.close();
//        return emails;
//    }
//
//    @Override
//    public <S extends EmailSent> S save(S entity) {
//        Session session = em.unwrap(Session.class);
//        session.beginTransaction();
//        session.persist(entity);
//        session.getTransaction().commit();
//        session.close();
//        return entity;
//    }
//
//    @Override
//    public <S extends EmailSent> Iterable<S> saveAll(Iterable<S> entities) {
//        Session session = em.unwrap(Session.class);
//        session.beginTransaction();
//        for (S e : entities) session.persist(e);
//        session.getTransaction().commit();
//        session.close();
//        return entities;
//    }
//
//    @Override
//    public Optional<EmailSent> findById(Integer id) {
//        Session session = em.unwrap(Session.class);
//        EmailSent e = session.get(EmailSent.class, id);
//        session.close();
//        return Optional.ofNullable(e);
//    }
//
//    @Override
//    public boolean existsById(Integer id) {
//        return findById(id).isPresent();
//    }
//
//    @Override
//    public Iterable<EmailSent> findAll() {
//        return findAllCustom();
//    }
//
//    @Override
//    public Iterable<EmailSent> findAllById(Iterable<Integer> ids) {
//        return StreamSupport.stream(ids.spliterator(), false)
//                .map(this::findById)
//                .filter(Optional::isPresent)
//                .map(Optional::get)
//                .toList();
//    }
//
//    @Override
//    public long count() {
//        Session session = em.unwrap(Session.class);
//        Long count = session.createQuery("select count(e.id) from EmailSent e", Long.class).getSingleResult();
//        session.close();
//        return count;
//    }
//
//    @Override
//    public void deleteById(Integer id) {
//        findById(id).ifPresent(this::delete);
//    }
//
//    @Override
//    public void delete(EmailSent entity) {
//        Session session = em.unwrap(Session.class);
//        session.beginTransaction();
//        session.remove(entity);
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Override
//    public void deleteAllById(Iterable<? extends Integer> ids) {
//        ids.forEach(this::deleteById);
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends EmailSent> entities) {
//        entities.forEach(this::delete);
//    }
//
//    @Override
//    public void deleteAll() {
//        Session session = em.unwrap(Session.class);
//        session.beginTransaction();
//        session.createQuery("delete from EmailSent").executeUpdate();
//        session.getTransaction().commit();
//        session.close();
//    }
//}
//
