package com.xjf.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户主页 控制器
 * @author xjf
 * @date 2019/2/5 10:10
 */
@Controller
@RequestMapping("/u")
public class UserspaceController {

    /**
     * 进入用户的博客主页
     * @param username
     * @return
     */
    @GetMapping("/{username}")
    public String userSpace(@PathVariable("username") String username){
        System.out.println("username:"+username);

        return "/userspace/u";
    }

    /**
     * 查看某用户的博客
     * @param username
     * @param order         排序方式
     * @param category      类别
     * @param keyword       关键字
     * @return
     */
    @RequestMapping("/{username}/blogs")
    public String listBlogsByOrder(@PathVariable("username") String username,
                                   @RequestParam(value = "order",required = false,defaultValue = "new") String order,
                                   @RequestParam(value = "category",required = false) Long category,
                                   @RequestParam(value = "keyword",required = false) String keyword){
        if (category != null){
            System.out.println("category:"+category);
            System.out.println("selflink:"+"redirect:/u/"+username+"/blogs?category="+category);
            return "/userspace/u";
        }else if (keyword != null && keyword.isEmpty() == false){
            System.out.println("keyword:"+keyword);
            System.out.println("selflink:"+"redirect:/u/"+username+"/blogs?keyword="+keyword);
            return "/userspace/u";
        }

        System.out.println("order:"+order);
        System.out.println("selflink:"+"redirct:/u/"+username+"/blogs?order="+order);
        return "/userspace/u";
    }

    @GetMapping("/{username}/blogs/{id}")
    public String listBlogsByOrder(@PathVariable("id") Long id){
        System.out.println("blogId:"+id);

        return "/userspace/blog";
    }

    @GetMapping("/{username}/blogs/edit")
    public String editBlog(){
        return "/userspace/blogedit";
    }
}
