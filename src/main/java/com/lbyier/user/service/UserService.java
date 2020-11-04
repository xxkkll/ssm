package com.lbyier.user.service;

import com.lbyier.user.model.User;
import com.util.ResponseVo;

/**
 * @author LByier
 * @date 2020/10/9 15:04
 */

public interface UserService {
     ResponseVo login(String stuName, String stuPwd);

     ResponseVo regist(User user);
}
