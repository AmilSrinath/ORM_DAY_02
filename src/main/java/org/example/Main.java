package org.example;

import org.example.entity.Laptop;
import org.example.entity.Student;
import org.example.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.setLid("L001");
        laptop.setName("Apple");

        Student student = new Student();
        student.setId("S001");
        student.setName("Amil");
        student.setAddress("No 2");
        student.setLaptop(laptop);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(laptop);
        session.persist(student);

        transaction.commit();
        session.close();
    }
}