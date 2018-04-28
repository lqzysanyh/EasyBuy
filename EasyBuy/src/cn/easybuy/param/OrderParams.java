package cn.easybuy.param;

import cn.easybuy.entity.Order;

/**
 * 订单查询参数类
 * @author Administrator
 *
 */
public class OrderParams extends Order{
	
	//开始下标
	private Integer startIndex;
	//页面大小
	private Integer pageSize;
	//排序
	private String sort;
	//是否分页
	private boolean isPage=false;

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isPage() {
		return isPage;
	}

	public void setPage(boolean isPage) {
		this.isPage = isPage;
	}

	public void openPage(Integer startIndex, Integer pageSize) {
		this.isPage = true;
		this.startIndex = startIndex;
		this.pageSize = pageSize;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	
}
