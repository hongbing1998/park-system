package com.bbx.jc.park.controller;

import com.bbx.jc.park.entity.Order;
import com.bbx.jc.park.entity.Park;
import com.bbx.jc.park.entity.Users;
import com.bbx.jc.park.service.OrderService;
import com.bbx.jc.park.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ParkService parkService;

    //获取列表
    @RequestMapping("/showOrder")
    public String showOrder(Model model, HttpSession session) {
        Users user = (Users) session.getAttribute("LogUser");
        List<Order> orderList = orderService.getByUserId(user.getId());
        model.addAttribute("orderList", orderList);
        return "orderList";
    }

    //获取列表
    @RequestMapping("/jiesuan")
    public String jiesuanOrder(@RequestParam("id") int id) {
        Order order = orderService.getById(id);
        order.setStatus(1);
        if (orderService.updateOrderStatus(order)) {
            Park park = parkService.getById(order.getPark_id());
            park.setStatus(0);
            parkService.updateCarStatus(park);
        }
        return "redirect:/order/showOrder";
    }
}
