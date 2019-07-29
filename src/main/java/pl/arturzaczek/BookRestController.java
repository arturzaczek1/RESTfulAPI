package pl.arturzaczek;

import entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.BookDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;


@Path("/book")
public class BookRestController {

    private BookDao bookDao = new BookDao();
    Logger logger = LoggerFactory.getLogger(BookRestController.class);

    @GET
    @Produces("application/json")
    public Response getList() {
        List<Book> bookList = bookDao.getBookList();
        if ((bookList.size() == 0)) {
            logger.error("List is empty");
        } else {
            return Response.ok(bookList).build();
        }
        return Response.ok(null).build();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response getBookById(@PathParam("id") String id) {
        Long longID = Long.parseLong(id);
        List<Book> bookList = bookDao.getBookList();
        Optional<Book> first = bookList.stream().filter(a -> a.getId() == longID).findAny();
        if (first.isPresent()) {
            return Response.ok(first.get()).build();
        }
        logger.info("Book not found: {} ", id);
        return Response.ok(null).build();
    }
}
