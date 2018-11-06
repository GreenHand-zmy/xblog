package bean.vo;


/**
 * Created by ZH on 2018/5/21.
 */
public class UserVo {
    //用户ID
    private Long id;
    //用户电话
    private String mobile;
    //用户真实姓名
    private String name;
    //用户头像
    private String avatar;
    //用户性别
    private String gender;
    //用户个性签名
    private String signature;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
