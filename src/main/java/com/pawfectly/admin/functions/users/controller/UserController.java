package com.pawfectly.admin.functions.users.controller;

import com.pawfectly.admin.functions.users.service.UserService;
import com.pawfectly.common.dto.ApiResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Handles GET requests to "/hello-world" and returns an {@link ApiResultModel} representing the result.
     *
     * @return An {@link ApiResultModel} object with a success status, a message, and result data.
     */
    @GetMapping("hello-world")
    @ResponseStatus(HttpStatus.OK)
    public ApiResultModel helloWorld() {
        return ApiResultModel.builder()
                .isSuccess(true)
                .message("Test User Controller")
                .resultData("result data test")
                .build();
    }

    /**
     * Retrieves a list of all users.
     * Handles GET requests to "/get-all" and returns a success response with the list of users.
     *
     * @return an {@link ApiResultModel} containing a list of {@link com.pawfectly.common.model.UserModel objects.
     */
    @GetMapping("get-all")
    @ResponseStatus(HttpStatus.OK)
    public ApiResultModel getAll() {
        return ApiResultModel.builder()
                .isSuccess(true)
                .message("User Master List")
                .resultData(userService.getAll())
                .build();
    }
}
