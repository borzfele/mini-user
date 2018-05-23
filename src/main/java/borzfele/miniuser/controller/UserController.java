package borzfele.miniuser.controller;

import borzfele.miniuser.model.User;
import borzfele.miniuser.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class UserController {

    private final UserService userService;
    private final Gson gson;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        gson = new Gson();
    }

    @RequestMapping(value = "/api", method = RequestMethod.POST)
    public String postUser(String userDetails) {
        User user = gson.fromJson(userDetails, User.class);
        try {
            userService.saveUser(user);
            return "Successful insertion.";
        } catch (Exception e) {
            return "Exception occurred during insertion: " + e.toString();
        }
    }

    @RequestMapping(value = "/api", method = RequestMethod.DELETE)
    public void deleteUser() {

    }

    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public String getUser() {
        return gson.toJson(userService.getAllUser());
    }

}
