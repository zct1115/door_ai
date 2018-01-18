package com.zct.door_ai.bean;

import java.util.List;
import java.util.Map;

/**
 * @author zct
 * Created by zct11 on 2018/1/13.
 * 每一页的实体类
 */
public class Pager {

    List<Map<String,Object>> rows;
    /*页的数量*/

    int pagecount;
    int last;

    public List<Map<String, Object>> getRows() {
        return rows;
    }

    public void setRows(List<Map<String, Object>> rows) {
        this.rows = rows;
    }

    public int getPagecount() {
        return pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }
}
