package cn.easybuy.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * �ж��Ƿ�Ϊ�� ������
 * @author Administrator
 *
 */
public class EmptyUtils {
	 /**
	  * �ж�Ϊ��
	  * @param obj
	  * @return
	  */
    public static boolean isEmpty(Object obj){

    	
        if (obj == null)
            return true;
        if (obj instanceof CharSequence)
            return ((CharSequence) obj).length() == 0;
        if (obj instanceof Collection)
            return ((Collection) obj).isEmpty();
        if (obj instanceof Map)
            return ((Map) obj).isEmpty();
        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            if (object.length == 0) {
                return true;
            }
            boolean empty = true;
            for (int i = 0; i < object.length; i++) {
                if (!isEmpty(object[i])) {
                    empty = false;
                    break;
                }
            }
            return empty;
        }
        return false;
    }
    /**
     * �жϷǿ�
     * @param obj
     * @return
     */
    public static boolean isNotEmpty(Object obj){
        return !isEmpty(obj);
    }


    /**
     * �ж��Ƿ�����Ч��ʵ��
     * @param args
     * @return
     */
    private boolean validPropertyEmpty(Object ...args) {
        for (int i = 0; i < args.length; i++) {
            if(EmptyUtils.isEmpty(args[i])){
                return true;
            }
        }
        return false;
    }
}
