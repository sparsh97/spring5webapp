package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.domain.repositories.AuthorRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    public final AuthorRepositories authorRepositories;

    public AuthorController(AuthorRepositories authorRepositories) {
        this.authorRepositories = authorRepositories;
    }
    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("author",authorRepositories.findAll());
        return "books/author/list";
    }
}
