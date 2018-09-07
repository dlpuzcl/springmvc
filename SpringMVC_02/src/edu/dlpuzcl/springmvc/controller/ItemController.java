package edu.dlpuzcl.springmvc.controller;

import edu.dlpuzcl.springmvc.pojo.Item;
import edu.dlpuzcl.springmvc.pojo.QueryVO;
import edu.dlpuzcl.springmvc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping
    public ModelAndView itemList() {
        ModelAndView modelAndView = new ModelAndView();
        List<Item> itemList = itemService.getItemList();
        modelAndView.addObject("itemList", itemList);
        modelAndView.setViewName("itemList");
        return modelAndView;
    }

    /**
     * 根据ID查询商品信息，跳转修改商品界面
     * 演示默认支持参数传递
     * model和modelman返回数据模型
     * @param model
     * @return
     */
//    @RequestMapping("itemEdit")
//    public String itemEdit(Model model, ModelMap modelMap,HttpServletRequest request) {
//        ModelAndView modelAndView = new ModelAndView();
//        String id = request.getParameter("id");
//        //查询商品信息
//        Item itemById = itemService.getItemById(new Integer(id));
//        //返回数据模型
//        model.addAttribute("item",itemById);
//        //modelAndView.addObject("item",itemById);
//        //modelAndView.setViewName("itemEdit");
//        return "itemEdit";
//
//    }

    @RequestMapping("itemEdit")
    public String itemEdit(Model model, @RequestParam(value="id",required=true,defaultValue = "1") Integer ids) {
        //查询商品信息
        Item itemById = itemService.getItemById(new Integer(ids));
        //返回数据模型
        model.addAttribute("item",itemById);
        //modelAndView.addObject("item",itemById);
        //modelAndView.setViewName("itemEdit");
        return "itemEdit";

    }

    /**
     * 修改商品的操作
     * 演示pojo参数绑定
     * @param item
     * @return
     */
   @RequestMapping("updateItem" )
    public String updateItem(Item item,Model model){
        itemService.updateItem(item);
        model.addAttribute("item",item);
        model.addAttribute("msg","修改商品信息成功");
        return "itemEdit";
    }

    @RequestMapping("quItem")
    public String queryItem(QueryVO queryVO,Model model){
        if(queryVO.getItem()!=null){
            System.out.println(queryVO.getItem());
            System.out.println("9999999999");
        }
        System.out.println("88888888888999");

        //模拟搜索商品
        List<Item> itemListm = itemService.getItemList();
        model.addAttribute("item",itemListm);
        return "itemList";
    }

}
