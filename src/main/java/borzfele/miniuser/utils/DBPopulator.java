package borzfele.miniuser.utils;

import borzfele.miniuser.model.User;
import borzfele.miniuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBPopulator {

    @Autowired
    public DBPopulator(UserService userService) {

        userService.saveUser(new User("Azazello", "azazel@woland.co"));
        userService.saveUser(new User("Behemoth", "behemoth@woland.co"));
        userService.saveUser(new User("Hella", "hella@woland.co"));
        userService.saveUser(new User("Korovjov", "korovjov@woland.co"));
        userService.saveUser(new User("Dr. Woland", "woland@woland.co"));
    }
}
