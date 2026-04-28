package com.company.controller;

import com.company.model.Book;
import com.company.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public String list(
            @RequestParam(name = "keyword", defaultValue = "") String keyword,
            Model model) {

        var books = service.search(keyword);

        model.addAttribute("books", books);
        model.addAttribute("keyword", keyword);

        return "book-list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("book", new Book());
        return "book-form";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Book b) {
        service.save(b);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("book", service.findById(id));
        return "book-form";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Book b) {
        service.update(b);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/books";
    }
}