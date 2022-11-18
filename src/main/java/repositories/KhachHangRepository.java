/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import java.util.List;
import models.KhachHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utilities.HibernateUtil;

/**
 *
 * @author homna
 */
public class KhachHangRepository {
    private Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    public List<KhachHang> getAll() {
        Query query = session.createQuery("SELECT kh FROM KhachHang kh");
        List<KhachHang> list = query.getResultList();
        return list;
    }
    
    public List<KhachHang> findByName(String ten) {
        Query query = session.createQuery("SELECT kh FROM KhachHang kh WHERE kh.ten like :ten");
        query.setParameter("ten", "%" + ten + "%");
        List<KhachHang> list = query.getResultList();
        return list;
    }

    public boolean save(KhachHang kh) {
        try {
            transaction.begin();
            session.saveOrUpdate(kh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
            return false;
        }
    }
    public boolean delete(KhachHang kh) {
        try {
            transaction.begin();
            session.delete(kh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
            return false;
        }
    }

    public KhachHang getObj(String ma) {
        KhachHang kh = null;
        try {
            Query query = session.createQuery("SELECT kh FROM KhachHang kh WHERE kh.ma = :ma");
            query.setParameter("ma", ma);
            kh = (KhachHang) query.getSingleResult();
        } catch (Exception e) {
        }
        return kh;
    }

    public KhachHang getObjectById(int id) {
        KhachHang kh = null;
        try {
            Query query = session.createQuery("SELECT kh FROM KhuyenMai kh WHERE kh.id = :id");
            query.setParameter("id", id);
            kh = (KhachHang) query.getSingleResult();
        } catch (Exception e) {
        }
        return kh;
    }
    
    public static void main(String[] args) {
        KhachHangRepository khr = new KhachHangRepository();
        for (KhachHang x : khr.getAll()) {
            System.out.println(x);
        }
    }
}