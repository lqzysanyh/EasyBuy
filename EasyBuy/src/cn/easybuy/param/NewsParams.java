package cn.easybuy.param;

import cn.easybuy.entity.News;
/**
 * ��Ѷ��ѯ������
 * @author Administrator
 *
 */
public class NewsParams extends News{
	//��ʼ�±�
	private Integer startIndex;
	//ҳ���С
	private Integer pageSize;
	//����
	private String sort;
	//�Ƿ��ҳ
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
	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
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
}
