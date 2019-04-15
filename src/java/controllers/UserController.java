/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.AccountEntity;
import entities.FileEntity;
import entities.PostEntity;
import entities.UserEntity;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.AccountService;
import service.PostService;
import service.UserService;
import util.Util;

/**
 *
 * @author THINKPAD T450
 */

@Controller
public class UserController extends AbstractController {
    
    @Autowired
    AccountService accountService;
    
    @Autowired
    UserService userService;
    
    @Autowired
    PostService postService;
    
    
    @RequestMapping(value="index", method = RequestMethod.GET)
        public String init(){
            return "index";
        }
    
    @RequestMapping(value= "signup", method = RequestMethod.POST)
    protected ModelAndView signUp(HttpServletRequest request) throws Exception {         
        if(accountService.isExist(request.getParameter("username"))){
            ModelAndView mv = new ModelAndView("index");
            String message = "username already exist, choose an other one";
            mv.addObject("message",message);
            return mv;
        }else {
            UserEntity user = new UserEntity(request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("birthdate"));
            AccountEntity account = new AccountEntity(
                    request.getParameter("username"),
                    request.getParameter("password"),
                    user);
            accountService.signUp(account);
            ModelAndView mv = new ModelAndView("index");
            String message = "account create succefully";
            mv.addObject("message",message);
            return mv;
        }
    }
    
    @RequestMapping(value= "signin", method = RequestMethod.POST)
    protected ModelAndView signIn(HttpServletRequest request) throws Exception {
            AccountEntity account = accountService.signIn(request.getParameter("username"), request.getParameter("password"));
            if(account == null){
                ModelAndView mv = new ModelAndView("index");
                String message = "account does not exist, check your username and password.";
                mv.addObject("message",message);
                return mv;
            }else {
                request.getSession().setAttribute("currentUser", account);
                ModelAndView mv = new ModelAndView("home");
                String message = "Welcome Back "+account.getUsername();
                mv.addObject("message",message);
                return mv;
            }
    }
    
    
    @RequestMapping(value= "logout", method = RequestMethod.GET)
    protected String logOut(HttpServletRequest request) throws Exception {
        request.getSession().removeAttribute("currentUser");
        return init();
    }
    
    @RequestMapping(value= "friends", method = RequestMethod.GET)
    protected ModelAndView friends(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("friends");
        UserEntity user = ((AccountEntity)request.getSession().getAttribute("currentUser")).getUser();
        mv.addObject("friends", user.getFriends());
        return mv;
    }
    
    
    @RequestMapping(value= "posts", method = RequestMethod.GET)
    protected ModelAndView wall(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("posts");
        return mv;
    }
    
    @RequestMapping(value= "addpost", method = RequestMethod.POST)
    protected ModelAndView addPost(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("posts");
        UserEntity user = ((AccountEntity)request.getSession().getAttribute("currentUser")).getUser();
        String content = request.getParameter("content");
        if (!file.getOriginalFilename().isEmpty()) {
            String link = Util.uploadFile(file);
            PostEntity post = new PostEntity(content, new FileEntity(link, file.getContentType()));
            postService.addPost(post);
            userService.addPost(user, post);
            mv.addObject("msg", "File uploaded successfully.");
      } else {
         mv.addObject("msg", "Please select a valid file..");
      }
        return mv;
    }
    
    
    @RequestMapping(value= "search", method = RequestMethod.POST)
    protected ModelAndView searchFriend(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("search");
        UserEntity user = ((AccountEntity)request.getSession().getAttribute("currentUser")).getUser();
        System.err.println("le username : "+request.getParameter("username"));
        List<UserEntity> result;
        if(request.getParameter("username").isEmpty())
            result = userService.search(user);
        else
            result = userService.search(user, request.getParameter("username"));
        mv.addObject("friends", result);
        return mv;
    }
    
    @RequestMapping(value= "addfriend", method = RequestMethod.POST)
    protected ModelAndView addFriend(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        UserEntity user = ((AccountEntity) request.getSession().getAttribute("currentUser")).getUser();
        user.getFriends().add(userService.getUserByID(Long.parseLong(request.getParameter("userID"))));
        userService.update(user);
        ModelAndView mv = new ModelAndView("friends");
        String message = "friend added to yout friend list";
        mv.addObject("message",message);
        return mv;
    }
    
    
    @RequestMapping(value= "removefriend", method = RequestMethod.POST)
    protected ModelAndView removeFriend(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        UserEntity user = ((AccountEntity) request.getSession().getAttribute("currentUser")).getUser();
        if( request.getParameter("userID") != null ){
            int index = Util.getPosition(user.getFriends(), Long.parseLong(request.getParameter("userID")));
            user.getFriends().remove(index);
            userService.update(user);
            ModelAndView mv = new ModelAndView("friends");
            String message = "friend removed from your friend list";
            mv.addObject("message",message);
            return mv;
        }
        ModelAndView mv = new ModelAndView("friends");
        return mv;
    }
    
    
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
