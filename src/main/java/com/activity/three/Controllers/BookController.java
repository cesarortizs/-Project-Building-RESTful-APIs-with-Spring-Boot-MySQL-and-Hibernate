package com.activity.three.Controllers;

import com.activity.three.Models.Book;
import com.activity.three.Services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks()
    {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id)
    {
        return bookService.getBook(id);
    }

    @PostMapping("/books")
    public void addNewBook(@Valid @RequestBody Book newBook)
    {
        bookService.addNewBook(newBook);
    }

    @PutMapping("/books/{id}")
    public void updateBook(@Valid @RequestBody Book updatedBook, @PathVariable("id") int id)
    {
        bookService.updateBook(updatedBook, id);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") int id)
    {
        bookService.deleteBook(id);
    }
}
