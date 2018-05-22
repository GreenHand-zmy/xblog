package Dao;

import bean.Channel;

import java.util.List;

/**
 * Created by zmy on 2018/5/21.
 */
public interface ChannelDao {
    /**
     * 向数据库添加一个频道
     *
     * @param channel 目标频道
     * @return sql语句影响行数
     */
    Long save(Channel channel);

    /**
     * 向数据库更新一个频道
     *
     * @param channel 目标频道
     * @return sql语句影响行数
     */
    int update(Channel channel);

    /**
     * 通过编号查找频道
     *
     * @param channelId 频道编号
     * @return 具体频道
     */
    Channel findById(Long channelId);

    /**
     * 查找所有频道
     *
     * @return 所有频道
     */
    List<Channel> findAll();

    //查询频道是否存在
    int isExits(String name);
}
