package constant;

/**
 * 文章状态常量
 * Created by zmy on 2018/5/24.
 */
public interface PostStatusConstant {
    /**
     * 文章正常状态
     */
    Integer NORMAL_STATUS = 0;

    /**
     * 文章已删状态
     */
    Integer DELETED_STATUS = 1;

    /**
     * 文章涉嫌违规,被禁用状态
     */
    Integer DISABLED_STATUS = 2;
}
