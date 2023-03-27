package com.hibernatehelloworld.utils;


import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
		private static final SessionFactory sessionFactory =buildSessionFactory();

		private static SessionFactory buildSessionFactory() {
			StandardServiceRegistry serviceRegistry =new StandardServiceRegistryBuilder().configure("hibernate.config.xml").build();
			Metadata metadata=new MetadataSources(serviceRegistry).getMetadataBuilder().build();
			return metadata.getSessionFactoryBuilder().build();
		}
		public static SessionFactory getSessionFactory() {
			return sessionFactory;
		}
}
