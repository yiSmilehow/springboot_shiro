package com.shiroapache.controller;

import com.shiroapache.pojo.Users;
import com.shiroapache.service.UsersService;
import com.shiroapache.util.ResultMsg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UsersController {

    private Logger log = LoggerFactory.getLogger(UsersController.class);

    @Resource
    private UsersService usersService;

    @RequestMapping(value = "/userByName", method = RequestMethod.GET)  // users/login
    @ResponseBody
    public ResultMsg<Object> login(String username) {
        Users user = usersService.selectByUsername(username);
        return ResultMsg.success(user);
    }

    /**
     * 登录功能
     * 如果登录失败，跳到登录页面login.html
     * 如果登录成功，跳到主页面 success.html
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)  // users/login
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,Map<String, String> map) {

        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) { //当前Subject是否进行认证（登录）
            //前台用户传入的用户名和密码 (将用户名和密码封装到UsernamePasswordToken对象中）
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);//记住我
            try {
                //进行认证（登录）功能
                currentUser.login(token);
            } catch (UnknownAccountException uae) {//未知帐户异常
                log.error(uae.getMessage());
                map.put("msg", uae.getMessage());
                return "login";
            } catch (IncorrectCredentialsException ice) { //凭证匹配器异常 不正确的凭据异常
                log.error(ice.getMessage());
                map.put("msg", "密码输入错误");
                return "login";
            } catch (LockedAccountException lae) { //帐户锁定异常 锁定帐户例外  (将来要在业务逻辑中进行判断）
                log.error(lae.getMessage());
                map.put("msg", lae.getMessage());
                return "login";
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) { // 认证异常 身份验证异常

                return null;
            }
        }
        return "success";
    }

    /**
     * 登出功能 （退出登录）
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET) // users/logout
    public String logout() {
        Subject currentUser = SecurityUtils.getSubject();
        //all done - log out!   登出
        currentUser.logout();
        return "login";
    }

}
