package cn.easybuy.dao.order;
import cn.easybuy.dao.BaseDao;
import cn.easybuy.entity.News;
import cn.easybuy.entity.Detail;
import cn.easybuy.param.NewsParams;
import cn.easybuy.param.DetailParam;
import java.sql.SQLException;
import java.util.List;

/**
 * ��������Dao�ӿ�
 * @author Administrator
 *
 */
public interface DetailDao extends BaseDao {
	/**
	 * ��Ӷ�������
	 * @param detail
	 * @throws Exception
	 */
    public void add(Detail detail) throws Exception;
    /**
     * ����Idɾ������
     * @param detail
     * @throws Exception
     */
	public void deleteById(Detail detail) throws Exception;
	/**
	 * ����Id��ö���
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Detail getDetailById(Integer id)throws Exception; 
	/**
	 * ���ݶ���Id��ö������鼯
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public List<Detail> getDetailList(Integer orderId)throws Exception;
	/**
	 * ���ݶ������������ö���������
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public Integer queryDetailCount(DetailParam params)throws Exception; 
}
