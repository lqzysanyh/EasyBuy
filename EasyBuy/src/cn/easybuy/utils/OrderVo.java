package cn.easybuy.utils;

import cn.easybuy.entity.Detail;
import cn.easybuy.entity.Order;

import java.io.Serializable;
import java.util.List;

/**
 * ø‚¥Êπ§æﬂ¿‡
 * @author Administrator
 *
 */
public class OrderVo implements Serializable {
    private Order order;
    private List<Detail> detailList;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Detail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<Detail> detailList) {
        this.detailList = detailList;
    }
}
