package pl.arturzaczek;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/")
public class PageHandler {
    Logger logger = LoggerFactory.getLogger(PageHandler.class);

    @GET
    @Produces("text/html")
    public String getHomePage(){
        logger.info("z Jax RS");
        return "<h1>RESTful API with Jersey</h1><br><p>Author: Artur Zaczek</p>";
    }
}
