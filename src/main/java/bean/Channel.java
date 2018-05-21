package bean;

/**
 * Created by Fang on 2018/5/21.
 */
public class Channel {
    //栏目标号
    private int id;

    //栏目名称
    private String name;

    //唯一关键字
    private String key;

    //状态
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
