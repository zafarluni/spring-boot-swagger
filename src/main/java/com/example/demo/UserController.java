package com.example.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Api(value = "UserManagement", description = "Operation related to user management.")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private List<User> userList;

    public UserController() {
        userList = new ArrayList<User>(Arrays.asList(
                new User("lunizh", "Zafar Luni"),
                new User("haroonhx", "Haroon Idrees"), new User("paracha", "Sajjad Paracha")));
    }


    @ApiOperation(value = "Returns list of all users.", response = Iterable.class)
    @GetMapping
    public List<User> getUserList() {
        return userList;
    }

    @ApiOperation(value = "Finds user by network id.", response = User.class)
    @GetMapping("/{networkId}")
    public ResponseEntity<User> getUser(@PathVariable("networkId") final String networkId) {
        return new ResponseEntity<User>((User) userList.stream().filter(x -> x.getNetworkId().equals(networkId)).toArray()[0], HttpStatus.OK);
    }

    @ApiOperation(value = "Adds a new User to exiting list", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User Created Successfully.")
    })
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        this.userList.add(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }
}
