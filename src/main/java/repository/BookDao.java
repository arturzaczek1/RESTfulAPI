package repository;

import entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
public class BookDao {


    Logger logger = LoggerFactory.getLogger(BookDao.class);

    private static final String LOCATION = "src\\main\\resources\\biblioteka.csv";
    private static final String LOCATION2 = "src\\main\\resources\\biblioteka.csv";

    /**
     * @return List of Books imported from resources/csv
     */
    public List<Book> getBookList() {
        List<Book> bookList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(LOCATION2));
            while (scanner.hasNext()) {
                String next = scanner.nextLine();
                bookList.add(parseBook(next));
                logger.debug(next);
            }
        } catch (FileNotFoundException e) {
            logger.error("File not found: {}", e);
        }
        return bookList;
    }

    /**
     * @param s- line csv file
     * @return parsed book
     */
    private Book parseBook(String s) {
        String[] splitedString = s.split(";");
        Book book = null;
        if (s.length() == 3) {
            book = new Book(Long.parseLong(splitedString[0]), splitedString[1].trim(), splitedString[2].trim());
        } else {
            book = new Book();
            logger.error("csv line error: {}", s);
        }
        return book;
    }
}
