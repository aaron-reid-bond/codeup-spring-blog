package com.codeup.codeupspringblog.controler;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    // These two next steps are often called dependency injection, where we create a Repository instance and initialize it in the controller class constructor.
    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String postId(@PathVariable String id, Model model) {
        model.addAttribute("post", postDao.getById(Long.parseLong(id)));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String postsCreate() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPostPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
        postDao.save(new Post(title, body));
        return "redirect:/posts";
    }
}
