package com.didispace.controller;

import com.didispace.domain.User;
import com.didispace.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description: UserController <br>
 * date: 2019/12/26 16:05 <br>
 *
 * @author: Zhangdi <br>
 * version: 1.0 <br>
 */
@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "test", method = RequestMethod.POST)
    public String test() {
        return "222";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public int add() {
        userRepository.save(new User("AAA", 10));
        userRepository.save(new User("BBB", 20));
        userRepository.save(new User("CCC", 30));
        userRepository.save(new User("DDD", 40));
        userRepository.save(new User("EEE", 50));
        userRepository.save(new User("FFF", 60));
        userRepository.save(new User("GGG", 70));
        userRepository.save(new User("HHH", 80));
        userRepository.save(new User("III", 90));
        userRepository.save(new User("JJJ", 100));
        return 1;
    }

    @RequestMapping(value = "getAllUsers", method = RequestMethod.POST)
    public Object getAllUsers() {
        List<User> all = userRepository.findAll();

        return all;
    }

    @RequestMapping(value = "deleteById/{id}", method = RequestMethod.POST)
    public void deleteById(@PathVariable Long id) {
        userRepository.delete(id);
    }
}
