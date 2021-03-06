/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.library.dao;

import com.sg.library.model.Author;
import com.sg.library.model.Book;
import com.sg.library.model.Publisher;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.tree.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author LENOVO USER
 */
public class LibraryDaoJdbcTemplateImpl implements LibraryDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_INSERT_AUTHOR
            = "insert into auhtors (first_name, last_name,street, city, state, zip, phone) values(?,?,?,?,?,?,?)";

    private static final String SQL_DELETE_AUTHOR
            = "delete from authors where author_id = ?";
    private static final String SQL_UPDATE_AUHTOR
            = "update authors set first_name =?, last_name=?, street =?, zip=?, phone=? where author_id = ?";
    private static final String SQL_SELECT_AUTHOR
            = "select * from authors where author_id = ?";
    private static final String SQL_SELECT_AUTHORS_BY_BOOK_ID
            = "select au.author_id, au.first_name, au.last_name, au.street, "
            + "au.city, au.state, au.zip, au.phone from authors au "
            + "join books_authors ba on au.author_id = ba.author_id where "
            + "ba.book_id = ?";
    private static final String SQL_SELECT_ALL_AUTHORS
            = "select * from auhtors";
    // BOOKS AND BOOKS_AUTHORS

    private static final String SQL_INSERT_BOOK
            = "insert into books "
            + "(isbn, title, publisher_id, price, publish_date) "
            + "values (?, ?, ?, ?, ?)";

    private static final String SQL_INSERT_BOOKS_AUTHORS
            = "insert into books_authors (book_id, author_id) values(?, ?)";

    private static final String SQL_DELETE_BOOK
            = "delete from books where book_id = ?";

    private static final String SQL_DELETE_BOOKS_AUTHORS
            = "delete from books_authors where book_id = ?";

    private static final String SQL_UPDATE_BOOK
            = "update books set isbn = ?, title = ?, publisher_id = ?, "
            + "price = ?, publish_date = ? "
            + "where book_id = ?";

    private static final String SQL_SELECT_BOOK
            = "select * from books where book_id = ?";

    private static final String SQL_SELECT_BOOKS_AUTHORS_AUTHOR_ID_BY_BOOK_ID
            = "select author_id from books_authors where book_id = ?";

    private static final String SQL_SELECT_ALL_BOOKS
            = "select * from books";

    private static final String SQL_SELECT_BOOKS_BY_AUTHOR_ID
            = "select b.book_id, b.isbn, b.title, b.publisher_id, b.price, "
            + "b.publish_date from books b join books_authors ba on author_id "
            + "where b.book_id = ba.book_id "
            + "and ba.author_id  =  ?;";
    private static final String SQL_SELECT_BOOKS_BY_PUBLISHER_ID
            = "select * from books where publisher_id = ?";
    //for the publisher

    private static final String SQL_INSERT_PUBLISHER
            = "insert into publishers (name, street, city, state, zip, phone) "
            + "values (?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_PUBLISHER
            = "delete from publishers where publisher_id = ?";
    private static final String SQL_UPDATE_PUBLISHER
            = "update publishers set name = ?, street = ?, city = ?, "
            + "state = ?, zip = ?, phone = ? where publisher_id  =  ?";
    private static final String SQL_SELECT_PUBLISHER
            = "select * from publishers where publisher_id = ?";
    private static final String SQL_SELECT_PUBLISHER_BY_BOOK_ID
            = "select pub.publisher_id, pub.name, pub.street, pub.city, "
            + "pub.state, pub.zip, pub.phone from publishers pub "
            + "join books on pub.publisher_id = books.publisher_id where "
            + "books.book_id = ?";
    private static final String SQL_SELECT_ALL_PUBLISHERS
            = "select * from publishers";

    private static final class AuthorMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet rs, int i) throws SQLException {
            Author au = new Author();
            au.setFirstName(rs.getString("first_name"));
            au.setLastName(rs.getString("last_name"));
            au.setStreet(rs.getString("street"));
            au.setCity(rs.getString("city"));
            au.setState(rs.getString("state"));
            au.setZip(rs.getString("zip"));
            au.setPhone(rs.getString("phone"));
            au.setAuthorId(rs.getInt("author_id"));
            return au;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    
    @Override
    public void addAuthor(Author author) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAuhtor(int authorId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateAuthor(Author auhtor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Author getAuthorById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Author> getAllAuthors() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addBook(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteBook(int bookId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateBook(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Book getBookId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Book> getBooksByAuthorId(int publihserId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Book> getBooksByPublisherId(int publisherId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Book> getAllBooks() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addPublisher(Publisher publisher) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePublisher(Publisher publisher) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Publisher getPublisherById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Publisher> getAllPublishers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
