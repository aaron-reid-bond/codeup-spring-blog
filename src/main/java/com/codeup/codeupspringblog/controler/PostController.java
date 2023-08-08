package com.codeup.codeupspringblog.controler;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String postsHome(Model model) {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post(1,"test1", "askdjfa;ksjdflskjdflskdjfsjfbnjksnfbjsn"));
        posts.add(new Post(2,"test2", "askdjfa;ksjdflskjdflskdjfsjfbnjksnfbjsn"));
        posts.add(new Post(3,"test3", "askdjfa;ksjdflskjdflskdjfsjfbnjksnfbjsn"));
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postId(@PathVariable String id, Model model) {
        Post post = new Post(Long.parseLong(id), "this is the post", "this is the rest of the stuff!!!!!!!");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postsCreate() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postCreate() {
        return "create a new post";
    }
}
