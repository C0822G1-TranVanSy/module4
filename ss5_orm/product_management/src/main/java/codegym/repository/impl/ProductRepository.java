package codegym.repository.impl;

import codegym.model.Product;
import codegym.repository.IProductRepository;
import codegym.util.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> selectAll() {
        List<Product> productList = null;
        Session session = null;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product ").getResultList();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    @Override
    public void add(Product product) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction!= null){
                transaction.rollback();
            }
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
        Session session = null;
        Product product = null;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            product = (Product) session.createQuery("FROM Product where id = :id").setParameter("id",id).getSingleResult();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }


    @Override
    public void update(Product product) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction!= null){
                transaction.rollback();
            }
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Product product) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.remove(product);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction!= null){
                transaction.rollback();
            }
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Product> findByName(String name) {
        Session session = null;
        List<Product> productList = null;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            productList =  session.createQuery("FROM Product where name like concat( '%',:name , '%')").setParameter("name",name).getResultList();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

}
