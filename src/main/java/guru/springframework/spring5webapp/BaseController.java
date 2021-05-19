package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.entities.Author;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {

    public static void main(String[] args) {
        System.out.println("Landed on Base");
        Author author1 = new Author("Test","One", "New");
        Author author2 = new Author("Test2","Two", "New2");
        System.out.println("Author"+ author1.toString());
        System.out.println("Author"+ author2.toString());
    }
}
