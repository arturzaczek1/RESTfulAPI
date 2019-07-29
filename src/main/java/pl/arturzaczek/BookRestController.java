package pl.arturzaczek;

import entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.BookDao;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/book")
public class BookRestController {

    private BookDao bookDao = new BookDao();
    Logger logger = LoggerFactory.getLogger(BookRestController.class);

    @GET
    @Produces("application/json")
    public Response getJson(HttpServletRequest request){

        List<Book> bookList = bookDao.getBookList();
        if((bookList.size()==0)){
            logger.info("Lista jest pusta");
        }else{
            logger.info("z Jax RS i zwracam json");
            return Response.ok(bookList).build();
        }
        return Response.ok(null).build();
    }
}
