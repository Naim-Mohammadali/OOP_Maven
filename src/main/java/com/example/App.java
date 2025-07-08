package com.example;

import jakarta.persistence.*;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        User user = new User("Ali");
        em.persist(user);

        em.getTransaction().commit();

        User found = em.find(User.class, user.getId());
        System.out.println("Found user: " + found);

        em.close();
        emf.close();
    }
}
