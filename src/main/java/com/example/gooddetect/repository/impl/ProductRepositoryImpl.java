//package com.example.gooddetect.repository.impl;
//
//import com.example.gooddetect.model.Product;
//import com.example.gooddetect.repository.ProductRepository;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class ProductRepositoryImpl implements ProductRepository {
//
//    @PersistenceContext
//    private EntityManager em;
//
//    @Override
//    public <S extends Product> S save(S entity) {
//        em.persist(entity); // Không tự begin/commit
//        return entity;
//    }
//
//    @Override
//    public List<Product> findAll() {
//        return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
//    }
//
//    @Override
//    public <S extends Product> Iterable<S> saveAll(Iterable<S> entities) {
//        for (S entity : entities) em.persist(entity);
//        return entities;
//    }
//
//    @Override
//    public void deleteById(Long aLong) { /* implement if needed */ }
//
//    @Override
//    public void delete(Product entity) { /* implement if needed */ }
//
//    @Override
//    public void deleteAll() { /* implement if needed */ }
//
//    @Override
//    public boolean existsById(Long aLong) { return em.find(Product.class, aLong) != null; }
//
//    @Override
//    public long count() { return ((Number) em.createQuery("SELECT COUNT(p) FROM Product p").getSingleResult()).longValue(); }
//
//    @Override
//    public Iterable<Product> findAllById(Iterable<Long> longs) { /* implement if needed */ return null; }
//
//    @Override
//    public Optional<Product> findById(Long aLong) { return Optional.ofNullable(em.find(Product.class, aLong)); }
//}
