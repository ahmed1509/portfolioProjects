/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.library.dao;

import com.sg.library.model.Author;
import com.sg.library.model.Book;
import com.sg.library.model.Publisher;
import java.util.List;

/**
 *
 * @author LENOVO USER
 */
public interface LibraryDao {

    public void addAuthor(Author author);

    public void deleteAuhtor(int authorId);

    public void updateAuthor(Author auhtor);

    public Author getAuthorById(int id);
    public List<Author> getAllAuthors();
    public void addBook(Book book);
    public void deleteBook(int bookId);
    public void updateBook(Book book);
    public Book getBookId(int id);
    public List<Book> getBooksByAuthorId(int publihserId);
    public List<Book> getBooksByPublisherId(int publisherId);
    public List<Book> getAllBooks();
    public void addPublisher(Publisher publisher);
    public void deletePublisher(Publisher publisher);
    public void updatePublisher(Publisher publisher);
    public Publisher getPublisherById(int id);
    public List<Publisher> getAllPublishers();

}
