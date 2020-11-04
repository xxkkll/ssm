package com.lbyier.user.service.impl;



import com.lbyier.user.dao.UserDao;
import com.lbyier.user.model.User;
import com.lbyier.user.service.UserService;
import com.util.ErrorCode;
import com.util.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author LByier
 * @date 2020/10/9 15:05
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public ResponseVo login(String stuName, String stuPwd) {
        ResponseVo responseVo = new ResponseVo(false, ErrorCode.FAIL, "用户账号或手机号不存在，密码错误，登陆失败");
        System.out.println("service：登录验证中............");
        System.out.println("service:"+stuName+stuPwd);
       //校验数据非空 账号信息和密码信息
        if (StringUtils.isEmpty(stuName)){
            //账号信息为空
            responseVo.setMsg("用户账号或手机号不能为空！");
            return responseVo;
        }
        if (StringUtils.isEmpty(stuPwd)){
            //密码信息为空
            responseVo.setMsg("密码不能为空！");
            return responseVo;
        }
        //密码加密
        //user.setStuPwd(MD5Util.inputPassToFormPass(user.getStuPwd()));

        //匹配数据库
        User result=userDao.login(stuName,stuPwd);
        System.out.println("service：用户信息"+result);
        if (result!=null){
            //登陆成功 保存用户信息到redis
            responseVo.setMsg("登陆成功");
            responseVo.setSuccess(true);
            responseVo.setCode(ErrorCode.SUCCESS);
            //返回前台登录的用户信息
            responseVo.setData(result);
            //保存用户信息到redis 确定key 和value
            // key ---> 用户账号
            //redisTemplate.opsForValue().set(customerByBb.getUserAccount(),customerByBb);
            return responseVo;
        }
        return responseVo;
    }

    @Override
    public ResponseVo regist(User user) {
        /*
         *methodName: 用户注册
         * @Description:
         * @param user
         * @return com.util.ResponseVo
         * @author: bier
         * @date 2020/10/17 15:57
         *
         */
        ResponseVo responseVo = new ResponseVo(false, ErrorCode.FAIL, "用户已存在，注册失败");
        //校验用户信息是否完整
    if (StringUtils.isEmpty(user.getStuName())||StringUtils.isEmpty(user.getStuPwd())){
        responseVo.setSuccess(false);
        responseVo.setCode(ErrorCode.FAIL);
        responseVo.setMsg("昵称和密码不能为空哦");
        return responseVo;
    }
        if (!StringUtils.isEmpty(user.getStuNum())){
            if (user.getStuNum().length()!=11){
                responseVo.setSuccess(false);
                responseVo.setCode(ErrorCode.FAIL);
                responseVo.setMsg("请输入有效手机位数");
                return responseVo;
            }

        }else {
            responseVo.setSuccess(false);
            responseVo.setCode(ErrorCode.FAIL);
            responseVo.setMsg("手机号不能为空哦");
            return responseVo;
        }
        //校验用户是否已经存在
            User result0=userDao.login(user.getStuName(),user.getStuPwd());
            if (result0!=null){
               return responseVo;
            }
            else {
                //注册
                int result1=userDao.regist(user);
                if (result1==1){
                    System.out.println("注册结果："+result1);
                    responseVo.setMsg("注册成功！");
                    responseVo.setCode(ErrorCode.SUCCESS);
                    responseVo.setSuccess(true);
                }
                else {
                    responseVo.setMsg("注册失败，请重新注册！");
                    responseVo.setCode(ErrorCode.FAIL);
                    responseVo.setSuccess(false);
                }
            }
        return responseVo;
    }
}
