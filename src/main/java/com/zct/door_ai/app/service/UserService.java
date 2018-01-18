package com.zct.door_ai.app.service;

import com.zct.door_ai.app.bean.User;
import com.zct.door_ai.base.BaseService;
import com.zct.door_ai.bean.CurrentUser;
import com.zct.door_ai.utils.MD5Util;
import com.zct.door_ai.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.List;
import java.util.Map;

/**
 * 户主登录账号密码检验
 */
@Service("userservice")
public class UserService extends BaseService {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    /**
     * 户主登录账号密码检验
     * 验证码待修复
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public Map<String,Object> checkUserLogin(String username,String password){
        List<Map<String,Object>> users=jdbcTemplate.queryForList("select * from hoster_tb where username=?",username);
        if(users.size()==0){
            return null;
        }
        Map<String,Object> user=users.get(0);
        if(MD5Util.MD5(password).equals(user.get("password"))){
            return user;
        }else {
            return null;
        }

    }

    /**
     * 户主注册检验
     * @param user
     * @return
     */
    public int registercheck(CurrentUser user){
        if(jdbcTemplate.queryForList("select * from hoster_tb where idcard=?",user.getIdcard()).size()!=0){
            return 1;
        }
        if(jdbcTemplate.queryForList("select * from hoster_tb where username=?",user.getUsername()).size()!=0){
            return  2;
        }
        if(jdbcTemplate.queryForList("select * from hoster_tb where room_id=?",user.getRoomid()).size()!=0){
            return  3;
        }
        return 0;

    }

    /**
     * 登记户主信息
     * @param user
     */
    public void register(CurrentUser user){
        jdbcTemplate.update("insert into hoster_tb values (?,?,?,?,?,?,?,?,?)",new Object[]{user.getRoomid(),user.getUsername(),MD5Util.MD5(user.getPassword()),user.getName(),user.getTelephone(),user.getIdcard(),user.getWechat(), TimeUtil.getCurrentTime(),1});
    }

}
