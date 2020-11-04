package com.lbyier.user.controller;

import com.lbyier.user.model.User;
import com.lbyier.user.service.UserService;
import com.util.ErrorCode;
import com.util.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author LByier
 * @date 2020/10/9 15:02
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

/*
 *methodName: 用户登录
 * @Description:
   * @param null
 * @return
 * @author: bier
 * @date 2020/10/17 13:51
 *
 */
   @RequestMapping("/login")
        public @ResponseBody ResponseVo login( String stuName, String stuPwd){
       ResponseVo responseVo = new ResponseVo();
       System.out.println("处理器：登录验证中............");
       System.out.println("表单数据："+stuName+stuPwd);
       System.out.println("-----------------------");
       try {
           responseVo=userService.login(stuName,stuPwd);
            System.out.println("处理器：用户信息"+responseVo.getData());


       } catch (Exception e) {
           //异常处理 提示前台 服务端有异常
           responseVo.setCode(ErrorCode.SERVER_EXCEPTION_CODE);
           responseVo.setSuccess(false);
           responseVo.setMsg("系统异常");
           //服务端后台打印异常
           e.printStackTrace();
       }

       return responseVo;
    }
    /*
     *methodName: 登录成功跳转到主页
     * @Description:
       * @param
     * @return java.lang.String
     * @author: bier
     * @date 2020/10/17 13:53
     *
     */
    @RequestMapping("/loginToHome")
    public  String loginToHome( ){
        System.out.println("主页面跳转............");
        return "home";
    }
/*
 *methodName: 跳转到登录页面
 * @Description:
   * @param
 * @return java.lang.String
 * @author: bier
 * @date 2020/10/17 15:54
 *
 */
    @RequestMapping("/loginToRegist")
    public  String loginToRegist( ){
        System.out.println("注册跳转............");
        return "regist";
    }

    /*
     *methodName: 用户注册
     * @Description:
       * @param
     * @return java.lang.String
     * @author: bier
     * @date 2020/10/17 15:53
     *
     */
    @PostMapping("/regist")
    public  @ResponseBody ResponseVo regist(@RequestBody User user){
        ResponseVo responseVo = new ResponseVo();
        System.out.println("处理器：注册中............");
        System.out.println("表单数据："+user);
        System.out.println("-----------------------");
        try {
            responseVo=userService.regist(user);
            System.out.println("处理器：返回新用户信息"+responseVo.getData());


        } catch (Exception e) {
            //异常处理 提示前台 服务端有异常
            responseVo.setCode(ErrorCode.SERVER_EXCEPTION_CODE);
            responseVo.setSuccess(false);
            responseVo.setMsg("系统异常");
            //服务端后台打印异常
            e.printStackTrace();
        }

        return responseVo;

    }
   /* @RequestMapping("/loginToRegist")
    public  String rgsToIndex( ){
        System.out.println("注册跳转............");
        return "regist";
    }*/

}
