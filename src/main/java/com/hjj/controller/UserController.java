package com.hjj.controller;

import com.hjj.entity.User;
import com.hjj.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: Huangjunjie
 * @Description:对用户User的增、删、查、改功能
 * @Date: Created in 15:06 2018/9/3
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 功能描述：查询user表的所有数据
     * @return list对象，默认json格式
     */
    @RequestMapping(value = {"/list"},method = RequestMethod.GET)
    @ResponseBody
    public List<User> findall(){
        List<User> list = userRepository.findAll();
        return list;
    }

    /**
     * 功能描述：返回test.html页面
     * @return "test"
     */
    @RequestMapping(value = {"/test.html"},method = RequestMethod.GET)
    public  String showUser() {
        return "test";
    }

    /**
     * 功能描述：添加功能
     * @param user
     * @return
     */
    @RequestMapping(value = {"/add"},method = RequestMethod.POST)
    @ResponseBody
    public String addUser(User user){
        userRepository.save(user);
        return "success";
    }

    /**
     * 功能描述：通过id查询
     * @param id
     * @return User user
     */
    public User findById(Long id){
        User user = userRepository.getOne(id);
        return user;
    }

    /**
     * 功能描述：更新功能
     * @param user
     */
    @RequestMapping(value = {"/update"},method = RequestMethod.POST)
    @ResponseBody
    public void updateUser(User user){
        User u = userRepository.getOne(user.getId());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setPhone(user.getPhone());
        u.setAddress(user.getAddress());
        userRepository.save(u);
    }

    /**
     * 功能描述：通过id删除
     * @param id
     * @return list
     */
    @RequestMapping(value = {"/delete"},method = RequestMethod.POST)
    @ResponseBody
    public List<User> delete(Long id){
        userRepository.deleteById(id);
        List<User> list = userRepository.findAll();
        return list;
    }
}
