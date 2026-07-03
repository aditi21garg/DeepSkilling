package com.library.repository;

public class BookRepository {

    public void save(String title) {
        System.out.println("Book saved to repository: " + title);
    }

    public String findById(int id) {
        return "Sample Book #" + id;
    }
}