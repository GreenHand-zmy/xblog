package Dao.Impl;

import Dao.ChannelDao;
import bean.Channel;
import constant.TableNameConstant;
import utils.DBUtil;

import java.util.List;

/**
 * Created by zmy on 2018/5/21.
 */
public class ChannelDaoImpl implements ChannelDao {

    @Override
    public int save(Channel channel) {
        return DBUtil.executeUpdate("insert into " + TableNameConstant.CHANNEL_TABLE +
                        "(`key`,`name`,`status`) values(?,?,?)",
                channel.getKey(), channel.getName(), channel.getStatus());
    }

    @Override
    public int update(Channel channel) {
        return 0;
    }

    @Override
    public Channel findById(Long channelId) {
        return null;
    }

    @Override
    public List<Channel> findAll() {
        return null;
    }
}
