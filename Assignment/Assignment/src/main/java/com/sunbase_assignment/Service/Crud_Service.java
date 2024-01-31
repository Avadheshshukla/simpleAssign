package com.sunbase_assignment.Service;

import com.sunbase_assignment.Model.User;
import com.sunbase_assignment.Repo.CrudRepo;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class Crud_Service {

    @Autowired
    CrudRepo crudRepo;

    /*         ***** Add User *****          */
            public String addUser(User user) {
            // if user id is not gib=ven by user store random -------
                if (user.getUserId() == null || user.getUserId().isEmpty()) {

                    user.setUserId(UUID.randomUUID().toString());

                    System.out.println(UUID.randomUUID().toString());
                    crudRepo.save(user);
                }else {
                    System.out.println(user.getUserId());
                   crudRepo.save(user);
              }
                return user.getFirst_name() + " Added Successfully!!!";
            }

    /*     ***** Get All User *****       */
            public List<User> getAllUsers() {
                return crudRepo.findAll();
            }


    /*         ***** Get User By ID *****          */
            public Optional<User> getUserById(String userId) {
                return crudRepo.findById(userId);
            }


    /*         ***** Delete User By ID *****          */
            public String deleteUserById(String userId) {
                crudRepo.deleteById(userId);
                return  "User with userId " + userId + " Deleted Successfully!!!";
            }


    /*         ***** Update user details by Id *****          */
            public String updateById(String userId, User user) {
                if (!crudRepo.existsById(userId)) {
                    return "User with " + userId + " id not found!!!";
                }

                // Fetch the existing user details
                User existingUser = crudRepo.findById(userId).orElse(null);

                // Update the user details
                if (existingUser != null) {
                    existingUser.setEmail(user.getEmail());
                    existingUser.setFirst_name(user.getFirst_name());
                    existingUser.setLast_name(user.getLast_name());
                    existingUser.setPhone(user.getPhone());
                    existingUser.setState(user.getState());
                    crudRepo.save(existingUser);
                    return "User details updated successfully !!!";
                } else {
                    return "Failed to update user details.";
                }
            }


}
