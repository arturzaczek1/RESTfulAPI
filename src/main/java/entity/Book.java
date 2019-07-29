package entity;

import java.io.Serializable;

public class Book implements Serializable, Comparable<Book> {
    private Long id;
    private String author;
    private String title;


    public Book(Long id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int compareTo(Book o) {
        int result = 0;
        result = this.id.compareTo(o.id);
        return result;
    }
}
