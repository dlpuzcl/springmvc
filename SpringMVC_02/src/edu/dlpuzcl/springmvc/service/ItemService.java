package edu.dlpuzcl.springmvc.service;

import edu.dlpuzcl.springmvc.pojo.Item;

import java.util.List;

/**
 * 商品信息业务逻辑
 */
public interface ItemService {

    /**
     * 获取商品列表
     */
    List<Item> getItemList();

    /**
     * 根据ID查询商品信息
     * @param id
     * @return
     */
    Item getItemById(Integer id);

    /**
     * 修改商品信息
     * @param item
     */
    void updateItem(Item item);
}

