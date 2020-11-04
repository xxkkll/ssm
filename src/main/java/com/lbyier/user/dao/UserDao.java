package com.lbyier.user.dao;

import com.lbyier.user.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author LByier
 * @date 2020/10/9 15:05
 */
@Repository
public interface UserDao {
//@Param给参数命名
     User login(@Param("stuName") String stuName, @Param("stuPwd")String stuPwd);

     int regist(User user);

     //int addUser();
}
