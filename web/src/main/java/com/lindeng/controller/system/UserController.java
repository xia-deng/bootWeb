package com.lindeng.controller.system;

import com.lindeng.common.util.CommonUtil;
import com.lindeng.system.dto.User;
import com.lindeng.system.model.PageParam;
import com.lindeng.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public HttpEntity<User> getUser(@PathVariable("userId") String userId){
        return new HttpEntity<>(userService.getUserById(userId));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public HttpEntity<Page<User>> getAllUser(@RequestParam("index") String index, @RequestParam("size") String size){
        return new HttpEntity<>(userService.getAll(new PageParam(CommonUtil.StringToInt(index), CommonUtil.StringToInt(size))));
    }
}
