package com.example.demo090.control;

import com.example.demo090.control.param.UserReq;
import com.example.demo090.dao.entity.CommodityEntity;
import com.example.demo090.dao.entity.DealEntity;
import com.example.demo090.dao.entity.UserEntity;
import com.example.demo090.dao.repository.UserRepository;
import com.example.demo090.domain.User;
import com.example.demo090.service.Result;
import com.example.demo090.service.ResultUtil;
import com.example.demo090.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserHandler {

    private static final int USERALREADYEXIST = -1;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public User findUserByData(@RequestBody UserReq userReq){
        User user = null;
        user = userService.findUserByUsernameAndPassword(userReq.getUsername(), userReq.getPassword());
        return user;
    }

    /**
     * 用户注册contrllor,
     * @param userReq
     * @return
     */
    @PostMapping("/register")
    public User registerUser(@RequestBody UserReq userReq){
        //System.out.println(userReq.getUsername());

        //如果用户名已经存在，提示用户名已经存在
        if (userService.isUserAlreadyReg(userReq)){
            User error_user = new User();
            error_user.setId(USERALREADYEXIST);
            error_user.setPassword("alreadyused");
            error_user.setUsername("alreadyused");
            return error_user;
        }
        //否则新建用户
        else {
            User user = userService.createOne(userReq);
            return user;
        }

    }

    /**
     * 别动这个方法，出大问题
     * @return
     */
    @GetMapping("/listtest")
    public Set<DealEntity> getSet(){
        return userRepository.findByUsername("haha").getDealEntities();
    }


}