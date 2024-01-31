package com.sunbase_assignment.Controller;

import com.sunbase_assignment.Model.User;
import com.sunbase_assignment.Service.Crud_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user/")
public class Crud_Operations {

    @Autowired
    Crud_Service crudService;

    /*         ***** Add User *****          */
        @PostMapping()
           public  String addUser(@RequestBody User user){
           return crudService.addUser(user);
        }

    /*         ***** Get All User *****          */
        @GetMapping()
        public List<User> getAllUsers(){
           return crudService.getAllUsers();
        }

    /*         ***** Get User By ID *****          */
        @GetMapping("id/{userId}")
        public Optional<User> getUserById(@RequestParam String userId){
            return crudService.getUserById(userId);
        }


    /*         ***** Delete User By ID *****          */
         @DeleteMapping("id/{userId}")
         public String deleteUserById(@RequestParam String userId){
             return crudService.deleteUserById(userId);
         }

    /*         ***** Update by Id *****          */
            @PutMapping("id/{userId}")
          public String updateById(@RequestParam String userId, @RequestBody User user){
                return crudService.updateById(userId, user);
            }


}
