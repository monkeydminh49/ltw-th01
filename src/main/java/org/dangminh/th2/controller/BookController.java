package org.dangminh.th2.controller;

import lombok.extern.slf4j.Slf4j;
import org.dangminh.th2.repository.BookRepository;
import org.dangminh.th2.entity.Book;
import org.dangminh.th2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String showAddBookForm( Model model) {
        model.addAttribute("books", bookRepository.findAll());

        return "books";
    }

    @PostMapping("/books")
    public String addBook(@RequestParam String title, @RequestParam String authorName, @RequestParam String publishedYear, Model model) {
        bookService.addBook(title, authorName, publishedYear);
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
//        log.info(String.valueOf(books.size()));
        return "redirect:/books";
    }

}
