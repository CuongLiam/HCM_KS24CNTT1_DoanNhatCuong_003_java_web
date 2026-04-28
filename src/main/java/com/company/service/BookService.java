package com.company.service;

import com.company.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final List<Book> list = new ArrayList<>();
    private Long id = 1L;

    public List<Book> findAll() {
        return list;
    }

    public void save(Book b) {
        b.setId(id++);
        list.add(b);
    }

    public Book findById(Long id) {
        return list.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
    }

    public void update(Book b) {
        delete(b.getId());
        list.add(b);
    }

    public void delete(Long id) {
        list.removeIf(b -> b.getId().equals(id));
    }

    // search (title + author)
    public List<Book> search(String keyword) {
        if (keyword == null || keyword.isEmpty()) return list;

        return list.stream()
                .filter(b ->
                        (b.getTitle() != null && b.getTitle().toLowerCase().contains(keyword.toLowerCase())) ||
                                (b.getAuthor() != null && b.getAuthor().toLowerCase().contains(keyword.toLowerCase()))
                )
                .toList();
    }
}