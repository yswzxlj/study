package com.example.mydockertest.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;

import java.util.List;

/**
 * @Auther: lich
 * @Description:
 * @Date: 2022/8/5 14:17
 * @Version: v1.0
 */
public class test {
    public static void main(String[] args) {
        Table<String, String, List<Object>> tables = HashBasedTable.create();
        tables.put("财务部", "总监", Lists.newArrayList("123"));
        tables.put("财务部", "职员",Lists.newArrayList());
        tables.put("法务部", "助理",Lists.newArrayList());
        System.out.println(tables.get("财务部", "总监"));
        
    }
}
