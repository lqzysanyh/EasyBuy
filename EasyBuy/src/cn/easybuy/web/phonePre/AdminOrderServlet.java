package cn.easybuy.web.phonePre;
import cn.easybuy.entity.*;
import cn.easybuy.service.order.OrderService;
import cn.easybuy.service.order.OrderServiceImpl;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.Pager;
import cn.easybuy.web.AbstractServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 后台订单响应类
 * @author Administrator
 *
 */
@WebServlet(urlPatterns = {"/Porder"},name = "Porder")
public class AdminOrderServlet extends AbstractServlet{

    private OrderService orderService;

    public void init() throws ServletException {
        orderService = new OrderServiceImpl();
    }
    /**
     * 订单的主页面
     * @param request
     * @param response
     * @return
     */
    public String index(HttpServletRequest request,HttpServletResponse response)throws Exception{
        //获取用户id
        String userId=request.getParameter("userId");
        //获取当前页数
        String currentPageStr = request.getParameter("currentPage");
        //获取页大小
        String pageSize = request.getParameter("pageSize");
        int rowPerPage  = EmptyUtils.isEmpty(pageSize)?5:Integer.parseInt(pageSize);
        int currentPage = EmptyUtils.isEmpty(currentPageStr)?1:Integer.parseInt(currentPageStr);
        int total=orderService.count(Integer.valueOf(userId));
        Pager pager=new Pager(total,rowPerPage,currentPage);
        pager.setUrl("/Porder?action=index&userId="+userId);
        List<Order> orderList=orderService.getOrderList(Integer.valueOf(userId), currentPage, rowPerPage);
        request.setAttribute("orderList", orderList);
        request.setAttribute("pager", pager);
        request.setAttribute("menu", 1);
        return "/phone/order/orderList";
    }
    /**
     * 查询订单明细
     * @param request
     * @param response
     * @return
     */
    public String queryOrderDeatil(HttpServletRequest request,HttpServletResponse response)throws Exception{
        String orderId=request.getParameter("orderId");
        List<Detail> detailList=orderService.getDetailList(Integer.valueOf(orderId));
        request.setAttribute("detailList", detailList);
        request.setAttribute("menu", 1);
        return "/phone/order/detailList";
    }
    
    /**
     * 翻页
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String queryAllOrder(HttpServletRequest request,HttpServletResponse response)throws Exception{
        //获取当前页数
        String currentPageStr = request.getParameter("currentPage");
        //获取页大小
        String pageSize = request.getParameter("pageSize");
        int rowPerPage  = EmptyUtils.isEmpty(pageSize)?5:Integer.parseInt(pageSize);
        int currentPage = EmptyUtils.isEmpty(currentPageStr)?1:Integer.parseInt(currentPageStr);
        int total=orderService.count(null);
        Pager pager=new Pager(total,rowPerPage,currentPage);
        pager.setUrl("/Porder?action=queryAllOrder");
        List<Order> orderList=orderService.getOrderList(null, currentPage, rowPerPage);
        request.setAttribute("orderList", orderList);
        request.setAttribute("pager", pager);
        request.setAttribute("menu", 9);
        return "/phone/order/orderList";
    }

    @Override
    public Class getServletClass() {
        return AdminOrderServlet.class;
    }
}
