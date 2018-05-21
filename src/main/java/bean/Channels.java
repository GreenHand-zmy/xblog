package bean;

/**
 * Created by Fang on 2018/5/21.
 */
public class Channels {
    private int id;//栏目标号
    private String name;//栏目名称
    private String key;//唯一关键字
    private int status;//状态
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getKey() {return key;}
    public void setKey(String key) {this.key = key;}
    public int getStatus() {return status;}
    public void setStatus(int status) {this.status = status;}
}
