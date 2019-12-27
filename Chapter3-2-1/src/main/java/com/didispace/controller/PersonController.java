package com.didispace.controller;

import com.didispace.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: PersonController <br>
 * date: 2019/12/25 15:59 <br>
 *
 * @author: Zhangdi <br>
 * version: 1.0 <br>
 */

@RestController
@RequestMapping
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "add/{name}/{age}", method = RequestMethod.POST)
    public int add(@PathVariable String name, @PathVariable int age) {
        return personService.add(name, age);
    }

    @RequestMapping(value = "getAllUsers", method = RequestMethod.POST)
    public Object getAllUsers() {
        return personService.getAllUsers();
    }

    @RequestMapping(value = "deleteAllUsers", method = RequestMethod.POST)
    public Object deleteAllUsers() {
        return personService.deleteAllUsers();
    }
}
