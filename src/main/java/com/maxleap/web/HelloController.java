package com.maxleap.web;

import com.maxleap.config.AppModuleConfig;
import com.maxleap.store.bean.UserJpa;
import com.maxleap.store.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * User：David Young
 * Date：17/11/6
 */
@Controller
public class HelloController {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private AppModuleConfig appModuleConfig;

  @RequestMapping(value = "/ext/${prefix}")
  public String home(ModelMap map){
    map.addAttribute("prefix", appModuleConfig.prefix());
    map.addAttribute("dataSource", appModuleConfig);
    return "index";
  }

  @RequestMapping(value = "/ext/${prefix}/users/list", method = RequestMethod.GET)
  public String usersList(ModelMap map) {
    List<UserJpa> list = userRepository.findAll();
    map.addAttribute("prefix", appModuleConfig.prefix());
    map.addAttribute("userList", list);
    return "userList";
  }

  @RequestMapping(value = "/ext/${prefix}/users", method = RequestMethod.GET)
  public String users(ModelMap map) {
    List<UserJpa> list = userRepository.findAll();
    map.addAttribute("prefix", appModuleConfig.prefix());
    map.addAttribute("userList", list);
    return "userManage";
  }

  // 添加用户表单页面
  @RequestMapping(value = "/ext/${prefix}/addUser", method = RequestMethod.GET)
  public String addUser(ModelMap map){
    map.addAttribute("prefix", appModuleConfig.prefix());
    return "addUser";
  }

  // 添加用户处理
  @RequestMapping(value = "/ext/${prefix}/addUserPost", method = RequestMethod.POST)
  public String addUserPost(@ModelAttribute("user") UserJpa userJpa){
    // 向数据库添加一个用户
    //userRepository.save(UserJpa);

    // 向数据库添加一个用户，并将内存中缓存区的数据刷新，立即写入数据库，之后才可以进行访问读取
    userRepository.saveAndFlush(userJpa);

    // 返回重定向页面
    return "redirect:"+appModuleConfig.prefix()+"/users";
  }

  // 查看用户详细信息
  // @PathVariable可以收集url中的变量，需匹配的变量用{}括起来
  // 例如：访问 localhost:8080/showUser/1 ，将匹配 userId = 1
  @RequestMapping(value = "/ext/${prefix}/showUser/{userId}", method = RequestMethod.GET)
  public String showUser(@PathVariable("userId") Integer userId, ModelMap modelMap ){
    UserJpa userJpa = userRepository.findById(userId.longValue());
    modelMap.addAttribute("user", userJpa);
    modelMap.addAttribute("prefix", appModuleConfig.prefix());
    return "userDetail";
  }

  // 更新用户信息页面
  @RequestMapping(value = "/ext/${prefix}/updateUser/{userId}", method = RequestMethod.GET)
  public String updateUser(@PathVariable("userId") Integer userId, ModelMap modelMap){
    UserJpa userJpa = userRepository.findById(userId.longValue());
    modelMap.addAttribute("user", userJpa);
    modelMap.addAttribute("prefix", appModuleConfig.prefix());
    return "updateUser";
  }
  // 处理用户修改请求
  @RequestMapping(value = "/ext/${prefix}/updateUserPost", method = RequestMethod.POST)
  public String updateUserPost(@ModelAttribute("user") UserJpa userJpa){
    userRepository.save(userJpa);
    return "redirect:"+appModuleConfig.prefix()+"/users";  }

  // 删除用户
  @RequestMapping(value = "/ext/${prefix}/deleteUser/{userId}", method = RequestMethod.GET)
  public String deleteUser(@PathVariable("userId") Integer userId){
    // 删除id为userId的用户
    userRepository.delete(userId.longValue());
    // 立即刷新数据库
    userRepository.flush();
    return "redirect:"+appModuleConfig.prefix()+"/users";  }

}
