package cn.easybuy.param;

import cn.easybuy.entity.Address;

/**
 * 地址查询参数类
 * @author Administrator
 *
 */
public class AddressParam extends Address{
	
	private Integer startIndex;
	
	private Integer pageSize;
	
	private boolean isPage=false;
	
	private String sort;

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
