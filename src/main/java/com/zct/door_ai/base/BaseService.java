package com.zct.door_ai.base;


import com.zct.door_ai.bean.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author zct
 * Created by zct11 on 2018/1/13.
 * 基本服务，封装一些数据库处理的功能
 */

public class BaseService {

   /*每一页的数据条目*/
    public static final int PAGE_SIZE=10;

    @Autowired
    protected JdbcTemplate jdbcTemplate;


    /**
     * 分页查询
     * @param page
     * @param size
     * @param sql
     * @param params
     * @return
     */
    protected Pager pager(int page, int size, String sql, Object... params){
        //拼装分页查询参数列表
        Object[] wrapperParams= new Object[params.length+2];
        System.arraycopy(params,0,wrapperParams,0,params.length);
        wrapperParams[params.length]=(page-1)*size;
        wrapperParams[params.length+1]=size;

        List<Map<String,Object>> data=jdbcTemplate.queryForList(sql+" limit ?,?",wrapperParams);

        long count=jdbcTemplate.queryForObject("select count(*) from ("+sql+") d",Long.class,params);

        Pager pager=new Pager();
        pager.setLast(page);
        pager.setPagecount((int) ((count/size)+1));
        pager.setRows(data);
        return  pager;

    }


    /**
     * 根据id 查找单条数据
     * @param table 表名
     * @param id id
     * @return
     */
    protected Map<String,Object> revert(String table,Object id){
        List<Map<String,Object>> data=jdbcTemplate.queryForList("select * from "+table+"where id=?",id);
        if(data.size()>0){
            return data.get(0);
        }else {
            return  null;
        }
    }

    /**
     * 根据id删除单条数据
     * @param table
     * @param id
     */
    protected void delete (String table,String id){
        jdbcTemplate.update("delete *from "+table+"where id=?",id);
    }

    protected boolean nullcheck(String data){
        return data==null|| "".equals(data);
    }
}
