/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.AccountEntity;
import entities.NotificationEntity;
import entities.PostEntity;
import entities.UserEntity;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.AccountService;
import service.MessageService;
import service.NotificationService;
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

    @Autowired
    NotificationService notificationService;

    @Autowired
    MessageService messageService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String init(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("currentUser") != null) {
            return "home";
        }
        return "index";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    protected String logOut(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "index";
    }

    @RequestMapping(value = "posts", method = RequestMethod.GET)
    protected ModelAndView posts(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession(false);
        System.out.println("controllers.UserController.posts() - session : " + session);
        if (session != null && session.getAttribute("currentUser") != null) {
            ModelAndView mv = new ModelAndView("posts");
            UserEntity user = ((AccountEntity) session.getAttribute("currentUser")).getUser();
            mv.addObject("posts", postService.getPosts(user.getId()));
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("index");
            mv.addObject("message", "You must login ");
            return mv;
        }
    }

    @RequestMapping(value = "friends", method = RequestMethod.GET)
    protected ModelAndView friends(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("currentUser") != null) {
            ModelAndView mv = new ModelAndView("friends");
            UserEntity user = ((AccountEntity) session.getAttribute("currentUser")).getUser();
            mv.addObject("friends", user.getFriends());
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("index");
            mv.addObject("message", "You must login ");
            return mv;
        }
    }

    @RequestMapping(value = "notifications", method = RequestMethod.GET)
    protected ModelAndView notifications(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("currentUser") != null) {
            ModelAndView mv = new ModelAndView("notifications");
            UserEntity user = ((AccountEntity) session.getAttribute("currentUser")).getUser();
            mv.addObject("notifications", notificationService.getNotifications(user.getId()));
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("index");
            mv.addObject("message", "You must login");
            return mv;
        }
    }

    @RequestMapping(value = "setting", method = RequestMethod.GET)
    protected ModelAndView setting(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("currentUser") != null) {
            ModelAndView mv = new ModelAndView("setting");
            AccountEntity account = (AccountEntity) session.getAttribute("currentUser");
            mv.addObject("account", account);
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("index");
            mv.addObject("message", "You must login");
            return mv;
        }
    }
    
    @RequestMapping(value = "chat", method = RequestMethod.GET)
    protected ModelAndView chat(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("currentUser") != null) {
            ModelAndView mv = new ModelAndView("chat");
            AccountEntity account = (AccountEntity) session.getAttribute("currentUser");
            mv.addObject("account", account);
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("index");
            mv.addObject("message", "You must login");
            return mv;
        }
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    protected ModelAndView signUp(HttpServletRequest request) throws Exception {
        if (accountService.isExist(request.getParameter("username"))) {
            ModelAndView mv = new ModelAndView("index");
            String message = "username already exist, choose an other one";
            mv.addObject("message", message);
            return mv;
        } else {
            UserEntity user = new UserEntity(request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("birthdate"));
            AccountEntity account = new AccountEntity(
                    request.getParameter("username"),
                    request.getParameter("password"),
                    user);
            accountService.signUp(account);
            ModelAndView mv = new ModelAndView("index");
            String message = "account create succefully";
            mv.addObject("message", message);
            return mv;
        }
    }

    @RequestMapping(value = "signin", method = RequestMethod.POST)
    protected ModelAndView signIn(HttpServletRequest request) throws Exception {
        AccountEntity account = accountService.signIn(request.getParameter("username"), request.getParameter("password"));
        if (account == null) {
            ModelAndView mv = new ModelAndView("index");
            String message = "account does not exist, check your username and password.";
            mv.addObject("message", message);
            return mv;
        } else {
            request.getSession().setAttribute("currentUser", account);
            ModelAndView mv = new ModelAndView("home");
            String message = "Welcome Back " + account.getUsername();
            mv.addObject("message", message);
            return mv;
        }
    }

    @RequestMapping(value = "addpost", method = RequestMethod.POST)
    protected ModelAndView addPost(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("currentUser") != null) {
            ModelAndView mv = new ModelAndView("posts");
            UserEntity user = ((AccountEntity) session.getAttribute("currentUser")).getUser();
            String content = request.getParameter("content");
            String link = !file.getOriginalFilename().isEmpty() ? Util.uploadFile(file) : user.getImageLink();
            String fileType = !file.getOriginalFilename().isEmpty() ? file.getContentType() : "";
            PostEntity post = new PostEntity(content, link, file.getContentType(), user);
            postService.addPost(post);
            userService.addPost(user, post);
            //check fo tags
            if (content.contains("@")) {
                for (String tag : Util.getTags(content)) {
                    System.out.println("controllers.UserController.addPost() - tags : " + tag);
                    UserEntity receiver = userService.getUserByUserName(tag.substring(1));
                    if (receiver != null) {
                        NotificationEntity not = new NotificationEntity(user, receiver, post.getContent());
                        notificationService.addNotification(not);
                    }
                }
            }
            mv.addObject("posts", postService.getPosts(user.getId()));
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("index");
            mv.addObject("message", "You must login ");
            return mv;
        }
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    protected ModelAndView searchFriend(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("currentUser") != null) {
            ModelAndView mv = new ModelAndView("search");
            UserEntity user = ((AccountEntity) session.getAttribute("currentUser")).getUser();
            System.err.println("le username : " + request.getParameter("username"));
            List<UserEntity> result;
            if (request.getParameter("username").isEmpty()) {
                result = userService.search(user);
            } else {
                result = userService.search(user, request.getParameter("username"));
            }
            mv.addObject("friends", result);
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("index");
            mv.addObject("message", "You must login ");
            return mv;
        }
    }

    @RequestMapping(value = "addfriend", method = RequestMethod.POST)
    protected ModelAndView addFriend(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("currentUser") != null) {
            UserEntity user = ((AccountEntity) session.getAttribute("currentUser")).getUser();
            userService.addFriend(user, userService.getUserByID(Long.parseLong(request.getParameter("userID"))));
            ModelAndView mv = new ModelAndView("friends");
            String message = "friend added to yout friend list";
            mv.addObject("message", message);
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("index");
            mv.addObject("message", "You must login ");
            return mv;
        }
    }

    @RequestMapping(value = "removefriend", method = RequestMethod.POST)
    protected ModelAndView removeFriend(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("currentUser") != null) {
            UserEntity user = ((AccountEntity) session.getAttribute("currentUser")).getUser();
            if (request.getParameter("userID") != null) {
                int index = Util.getPosition(user.getFriends(), Long.parseLong(request.getParameter("userID")));
                user.getFriends().remove(index);
                userService.update(user);
                ModelAndView mv = new ModelAndView("friends");
                String message = "friend removed from your friend list";
                mv.addObject("message", message);
                return mv;
            }
            ModelAndView mv = new ModelAndView("friends");
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("index");
            mv.addObject("message", "You must login ");
            return mv;
        }
    }

    @RequestMapping(value = "updateProfil", method = RequestMethod.POST)
    protected ModelAndView updateProfil(@RequestParam("profilimage") CommonsMultipartFile image, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("currentUser") != null) {
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String birthdate = request.getParameter("birthdate");
            String password = request.getParameter("password");
            AccountEntity account = (AccountEntity) session.getAttribute("currentUser");
            if (firstname != null && lastname != null
                    && birthdate != null && password != null) {
                account.setPassword(password);
                account.getUser().setFirstname(firstname);
                account.getUser().setLastname(lastname);
                account.getUser().setBirthdate(birthdate);
                String imageLink = Util.uploadFile(image);
                if (imageLink != null) {
                    account.getUser().setImageLink(imageLink);
                }
                userService.update(account.getUser());
                accountService.updateAccount(account);
            }
            ModelAndView mv = new ModelAndView("setting");
            mv.addObject("account", account);
            return mv;
        }
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("message", "You must login");
        return mv;
    }
    
    @RequestMapping(value = "addMessage", method = RequestMethod.POST)
    protected ModelAndView addMessage(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("currentUser") != null) {
            ModelAndView mv = new ModelAndView("chat");
            AccountEntity account = (AccountEntity) session.getAttribute("currentUser");
            mv.addObject("account", account);
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("index");
            mv.addObject("message", "You must login");
            return mv;
        }
    }
    
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
