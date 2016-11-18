package com.icegrayxtt.controller;

import com.icegrayxtt.model.User;
import com.icegrayxtt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * Created by Валерий on 13.11.2016.
 */

@Controller
public class UserController {
    int offset = 0;
    int num = 3;
    public static int count = 0;

    @Autowired
    private UserService userService;

//    @Autowired(required = true)
//    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/")
    public String hello(){
        return "startpage";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAllUsers(Model model){
        List<User> usersfull = userService.listUsers();
        List<User> users = userService.getAllPage(0, 3);
        counter(usersfull);

        model.addAttribute("count", count);
        model.addAttribute("users", users);
        model.addAttribute("usersfull", usersfull);
        return "userpage";
    }

    private void counter(List<User> usersfull) {
        if (usersfull.size() < 3) {
            count = 1;
        }else if (usersfull.size() > 3 && usersfull.size() % 3 > 0){
            count = usersfull.size()/3+1;
        }else{
            count = usersfull.size()/3;
        }
    }

    @RequestMapping(value = "/usersPage", method = RequestMethod.GET)
    public String getUsers(@RequestParam(value="numpage", required=true) Integer numpage, Model model) {
        List<User> usersfull = userService.listUsers();
        offset = numpage*3-3;
        List<User> users = userService.getAllPage(offset, num);
        counter(usersfull);
        model.addAttribute("count", count);
        model.addAttribute("users", users);
        model.addAttribute("usersfull", usersfull);
        return "userpage";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
        model.addAttribute("userAttribute", new User());
        return "addpage";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("userAttribute") User user) {
        user.setDate(new Date());
        userService.addUser(user);
        return "addedpage";
    }

    @RequestMapping(value = "/users/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="id", required=true) Integer id, Model model) {
        userService.deleteUser(id);
        model.addAttribute("id", id);
        return "deletedpage";
    }

    @RequestMapping(value = "/users/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value="id", required=true) Integer id, Model model) {
        model.addAttribute("userAttribute", userService.getUser(id));
        return "editpage";
    }

    @RequestMapping(value = "/users/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("userAttribute") User user, @RequestParam(value="id", required=true) Integer id, Model model) {
        user.setId(id);
        userService.editUser(user);
        model.addAttribute("id", id);
        return "editedpage";
    }

    /*    @RequestMapping(value = "/users/edit/{id}", method = RequestMethod.GET)
    public String getEdit(@PathVariable("id") Integer id, ModelMap modelMap) {
        modelMap.put("userAttribute", userService.getUser(id));
        return "editpage";
    }

    @RequestMapping(value = "/users/edit", method = RequestMethod.POST)
    public String getEdit(@ModelAttribute("userAttribute") User user) {
        userService.editUser(user);
        return "editedpage";
    }*/

    /*сделать через модельивью*/

/*    @RequestMapping(value = "/users/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getEdit(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("editpage");
        User user = userService.getUser(id);
        modelAndView.addObject("userAttribute", user);
        return modelAndView;
    }

    @RequestMapping(value = "/users/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editingUser(@ModelAttribute User user, @PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("editedpage");
        userService.editUser(user);
        modelAndView.addObject("id", id);

        return modelAndView;
    }*/

    @RequestMapping(value = "/users/filter", method = RequestMethod.GET)
    public String getFilter(Model model) {
        model.addAttribute("userFilter", new User());
        return "filter";
    }

    @RequestMapping(value = "/users/filter", method = RequestMethod.POST)
    public String listFilter(@ModelAttribute("userAttribute") User user, Model model) {
        List<User> users = userService.getNotAll(user.getName());
        model.addAttribute("users", users);
        return "filterpage";
    }
}
