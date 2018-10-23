//package com.test.utils;
//
//import org.hibernate.Hibernate;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
//
///**
// * Created by Wdnnccey on 2016/10/24.
// */
//public class HibernateUtils {
//
//    private static SessionFactory sessionFactory;
//
//    //保证单例模式
//    private HibernateUtils(){
//
//    }
//
//    //公有的静态方法
//    public static SessionFactory getSessionFactory(){
//
//        if(sessionFactory ==null){
//            Configuration configuration =new Configuration().configure();
//            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
//            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//            return sessionFactory;
//        }else {
//            return sessionFactory;
//        }
//    }
//
//}