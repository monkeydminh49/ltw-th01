package org.dangminh.th2.service;

import org.dangminh.th2.repository.BookRepository;
import org.dangminh.th2.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;


    public void addBook(String title, String authorName, String publishedYear) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthorName(authorName);
        book.setPublishedYear(publishedYear); // Ensure the input matches the expected format
        bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
