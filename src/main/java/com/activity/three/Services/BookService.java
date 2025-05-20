package com.activity.three.Services;

import com.activity.three.Exceptions.ResourceNotFoundException;
import com.activity.three.Models.Book;
import com.activity.three.Repositories.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks()
    {
        List<Book> books = bookRepository.findAll();

        return books;
    }

    public Book getBook(@PathVariable("id") int id)
    {
        Book task = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No book found with id: " + id));

        return task;
    }

    public void addNewBook(@Valid @RequestBody Book newBook)
    {
        bookRepository.save(newBook);
    }

    public void updateBook(@Valid @RequestBody Book updatedBook, @PathVariable("id") int id)
    {
        Book existingBook = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No book found with id: " + id));

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setIsbn(updatedBook.getIsbn());
        existingBook.setPublishedDate(updatedBook.getPublishedDate());

        bookRepository.save(existingBook);
    }

    public void deleteBook(@PathVariable("id") int id)
    {
        Book existingTask = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No book found with id: " + id));
        bookRepository.deleteById(id);
    }
}
