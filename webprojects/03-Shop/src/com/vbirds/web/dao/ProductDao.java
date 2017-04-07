package com.vbirds.web.dao;

import com.vbirds.web.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 存放Product对象的增删改查方法
 * Created by vbirds on 17-4-6.
 */
public class ProductDao {
    private static HashMap<String, Product> data = new LinkedHashMap<String, Product>();

    /**
     * init
     */
    static {
        // 只执行一次
        for (int i = 0; i < 10; ++i) {
            data.put(""+i, new Product(""+i, "笔记本"+i, "LN00"+i, 3000.0+i));
        }

    }

    /**
     * search
     */
    public HashMap<String, Product>  findAll() {
        return data;
    }

    /**
     *  search by id
     */
    public Product findById(String id) {
        return data.get(id);
    }



}
