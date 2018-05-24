package constant;

/**
 * 用户状态常量
 * Created by zmy on 2018/5/24.
 */
public interface UserStatusConstant {
    /**
     * 用户正常状态
     */
    Integer NORMAL_STATUS = 0;

    /**
     * 用户锁定状态
     */
    Integer LOCK_STATUS = 1;

    /**
     * 用户删除状态
     */
    Integer DELETED_STATUS = 2;
}
