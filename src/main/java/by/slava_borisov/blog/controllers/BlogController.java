package by.slava_borisov.blog.controllers;

import by.slava_borisov.blog.models.Post;
import by.slava_borisov.blog.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {

    @Autowired
    private PostRepository repository;

    @GetMapping("/blog")
    public String blogMain(Model model) {
        Iterable<Post> posts = repository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("blog/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }

    @PostMapping("blog/add")
    public String blogPostAdd(
            @RequestParam String title,
            @RequestParam String anons,
            @RequestParam String full_text,
            Model model) {
        Post post = new Post(title, anons, full_text);
        repository.save(post);
        return "redirect:/blog";
    }

}
