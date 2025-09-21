//package com.example.gooddetect.repository.impl;
//
//import com.example.gooddetect.model.Subscriber;
//import com.example.gooddetect.repository.SubscriberRepository;
//import jakarta.persistence.EntityManager;
//import org.hibernate.Session;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.StreamSupport;
//
//public class SubscriberRepositoryImpl implements SubscriberRepository {
//
//    private final EntityManager em;
//
//    public SubscriberRepositoryImpl(EntityManager em) {
//        this.em = em;
//    }
//
//    @Override
//    public List<Subscriber> findByEmailContaining(String keyword) {
//        Session session = em.unwrap(Session.class);
//        List<Subscriber> subs = session.createQuery(
//                        "from Subscriber s where s.email like :kw", Subscriber.class)
//                .setParameter("kw", "%" + keyword + "%")
//                .getResultList();
//        session.close();
//        return subs;
//    }
//
//    public List<Subscriber> findAllCustom() {
//        Session session = em.unwrap(Session.class);
//        List<Subscriber> subs = session.createQuery("from Subscriber", Subscriber.class).getResultList();
//        session.close();
//        return subs;
//    }
//
//    @Override
//    public <S extends Subscriber> S save(S entity) {
//        Session session = em.unwrap(Session.class);
//        session.beginTransaction();
//        session.persist(entity);
//        session.getTransaction().commit();
//        session.close();
//        return entity;
//    }
//
//    @Override
//    public <S extends Subscriber> Iterable<S> saveAll(Iterable<S> entities) {
//        Session session = em.unwrap(Session.class);
//        session.beginTransaction();
//        for (S e : entities) session.persist(e);
//        session.getTransaction().commit();
//        session.close();
//        return entities;
//    }
//
//    @Override
//    public Optional<Subscriber> findById(Integer id) {
//        Session session = em.unwrap(Session.class);
//        Subscriber s = session.get(Subscriber.class, id);
//        session.close();
//        return Optional.ofNullable(s);
//    }
//
//    @Override
//    public boolean existsById(Integer id) {
//        return findById(id).isPresent();
//    }
//
//    @Override
//    public Iterable<Subscriber> findAll() {
//        return findAllCustom();
//    }
//
//    @Override
//    public Iterable<Subscriber> findAllById(Iterable<Integer> ids) {
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
//        Long count = session.createQuery("select count(s.id) from Subscriber s", Long.class).getSingleResult();
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
//    public void delete(Subscriber entity) {
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
//    public void deleteAll(Iterable<? extends Subscriber> entities) {
//        entities.forEach(this::delete);
//    }
//
//    @Override
//    public void deleteAll() {
//        Session session = em.unwrap(Session.class);
//        session.beginTransaction();
//        session.createQuery("delete from Subscriber").executeUpdate();
//        session.getTransaction().commit();
//        session.close();
//    }
//}
