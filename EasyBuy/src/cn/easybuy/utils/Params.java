package cn.easybuy.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * ������
 * @author Administrator
 *
 */
public class Params  implements Serializable{
	
	private String tableName;

    //ѡ�����
    private Map<String,Object> selectParams;
    //ģ����ѯ����
    private Map<String,Object> likeParams;
    //���²���
    private Map<String,Object> updateParams;
    //�������
    private Map<String,Object> sortParams;
    //��������
    private Map<String,Object> addParams;

    //��ѯ��ʼλ��
    private int startIndex;

    //��ѯ��Ŀ
    private int pageSize;

    private boolean isOpenPager=false;

    public Params() {
        selectParams=new HashMap<String, Object>();
        sortParams=new HashMap<String, Object>();
        updateParams=new HashMap<String, Object>();
        addParams=new HashMap<String, Object>();
        likeParams=new HashMap<String, Object>();
    }
    public Params(String tableName) {
        this.tableName=tableName;
        selectParams=new HashMap<String, Object>();
        sortParams=new HashMap<String, Object>();
        updateParams=new HashMap<String, Object>();
        addParams=new HashMap<String, Object>();
        likeParams=new HashMap<String, Object>();
    }

    //���Ӳ�ѯ����
    public Params addEqual(String column, Object value){
        selectParams.put(column,value);
        return this;
    }
    public Params addLike(String column, Object value){
        likeParams.put(column,value);
        return this;
    }
    //�������ò���
    public Params addSet(String column,Object value){
        updateParams.put(column,value);
        return this;
    }
    //��������
    public Params orderDesc(String cloumn){
        sortParams.put(cloumn,"desc");
        return this;
    }
    public Params orderAsc(String cloumn){
        sortParams.put(cloumn,"asc");
        return this;
    }
    //���÷�ҳ
    public Params openPager(int startIndex,int pageSize){
        this.isOpenPager=true;
        this.startIndex=startIndex;
        this.pageSize=pageSize;
        return this;
    }
    public Params addSaveParam(String column,Object value){
        addParams.put(column,value);
        return this;
    }

    public Map<String, Object> getLikeParams() {
        return likeParams;
    }

    public void setLikeParams(Map<String, Object> likeParams) {
        this.likeParams = likeParams;
    }

    public boolean isOpenPager() {
        return isOpenPager;
    }

    public void setOpenPager(boolean isOpenPager) {
        this.isOpenPager = isOpenPager;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Map<String, Object> getSelectParams() {
        return selectParams;
    }

    public void setSelectParams(Map<String, Object> selectParams) {
        this.selectParams = selectParams;
    }

    public Map<String, Object> getUpdateParams() {
        return updateParams;
    }

    public void setUpdateParams(Map<String, Object> updateParams) {
        this.updateParams = updateParams;
    }

    public Map<String, Object> getSortParams() {
        return sortParams;
    }

    public void setSortParams(Map<String, Object> sortParams) {
        this.sortParams = sortParams;
    }

    public Map<String, Object> getAddParams() {
        return addParams;
    }

    public void setAddParams(Map<String, Object> addParams) {
        this.addParams = addParams;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
