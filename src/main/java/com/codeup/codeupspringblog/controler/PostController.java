package com.codeup.codeupspringblog.controler;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    private final PostRepository postDao;

    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String postId(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getById(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String postsCreate() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPostPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
        User user = userDao.getById(1L);
        postDao.save(new Post(title, body, user));
        return "redirect:/posts";
    }
}
