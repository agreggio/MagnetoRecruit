/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MercadoLibre.Service.User;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alejandro Greggio
 */
@RestController
@RequestMapping("user")
public class UserController {
  // 011-63296888
  // seginf-idn@bancogalicias.com.ar
    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "Create new user")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> addNewUser(@RequestBody User user) {

        User n = new User();
        n.setUsername(user.getUsername());
        n.setPassword(user.getPassword());

        if (!userRepository.findByUsername(user.getUsername()).isPresent()) {
//            userRepository.save(n);
        } else {
            return new ResponseEntity<>("User Duplicate ", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("User Created", HttpStatus.OK);
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public Iterable<User> getAllUsers() {
//        // This returns a JSON or XML with the users
//        return userRepository.findAll();
//    }

}
