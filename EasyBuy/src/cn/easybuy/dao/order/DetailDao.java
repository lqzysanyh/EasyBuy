package cn.easybuy.dao.order;
import cn.easybuy.dao.BaseDao;
import cn.easybuy.entity.News;
import cn.easybuy.entity.Detail;
import cn.easybuy.param.NewsParams;
import cn.easybuy.param.DetailParam;
import java.sql.SQLException;
import java.util.List;

/**
 * 订单详情Dao接口
 * @author Administrator
 *
 */
public interface DetailDao extends BaseDao {
	/**
	 * 添加订单详情
	 * @param detail
	 * @throws Exception
	 */
    public void add(Detail detail) throws Exception;
    /**
     * 根据Id删除订单
     * @param detail
     * @throws Exception
     */
	public void deleteById(Detail detail) throws Exception;
	/**
	 * 根据Id获得订单
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Detail getDetailById(Integer id)throws Exception; 
	/**
	 * 根据订单Id获得订单详情集
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public List<Detail> getDetailList(Integer orderId)throws Exception;
	/**
	 * 根据订单详情参数获得订单详情数
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public Integer queryDetailCount(DetailParam params)throws Exception; 
}
