package cn.easybuy.param;

import cn.easybuy.entity.Detail;

/**
 * 订单详情查询参数类
 * @author Administrator
 *
 */
public class DetailParam extends Detail{

	private Integer startIndex;
	
	private Integer pageSize;
	
	private boolean isPage=false;
	
	private String sort;
	
	public void openPage(Integer startIndex, Integer pageSize) {
		this.isPage = true;
		this.startIndex = startIndex;
		this.pageSize = pageSize;
	}

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

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	
	
	
}
