package bean;


import java.util.Date;

/**
 * Created by ZH on 2018/5/21.
 */
public class User {
    //用户ID
    private Long id;
    //用户创建时间
    private Date created;
    //用户电话
    private String mobile;
    //用户密码
    private String password;
    //用户状态(普通用户，管理员)
    private int status;
    //用户名
    private String username;
    //用户真实姓名
    private String name;
    //用户头像
    private String avatar;
    //用户更新时间
    private Date updated;
    //用户性别
    private String gender;
    //用户个性签名
    private String singnature;
    //用户最后一次登录
    private Date lastLogin;
}
