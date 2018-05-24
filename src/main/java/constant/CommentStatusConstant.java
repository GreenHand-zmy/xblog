package constant;

/**
 * 评论状态常量
 * Created by zmy on 2018/5/24.
 */
public interface CommentStatusConstant {
    /**
     * 评论正常状态
     */
    Integer NORMAL_STATUS = 0;

    /**
     * 评论已删状态
     */
    Integer DELETED_STATUS = 1;

    /**
     * 评论涉嫌违规被禁用
     */
    Integer DISABLED_STATUS = 2;
}
