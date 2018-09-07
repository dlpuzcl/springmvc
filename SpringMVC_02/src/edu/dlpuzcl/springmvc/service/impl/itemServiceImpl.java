package edu.dlpuzcl.springmvc.service.impl;

import edu.dlpuzcl.springmvc.mapper.ItemMapper;
import edu.dlpuzcl.springmvc.pojo.Item;
import edu.dlpuzcl.springmvc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class itemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;
    @Override
    public List<Item> getItemList() {
        return itemMapper.selectByExample(null);
    }

    @Override
    public Item getItemById(Integer id) {

        return itemMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateItem(Item item) {
        itemMapper.updateByPrimaryKeySelective(item);
    }
}
