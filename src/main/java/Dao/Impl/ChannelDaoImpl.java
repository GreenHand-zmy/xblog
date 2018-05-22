package Dao.Impl;

import Dao.ChannelDao;
import bean.Channel;
import constant.TableNameConstant;
import org.apache.commons.dbutils.DbUtils;
import utils.DBUtil;

import java.util.List;

/**
 * Created by zmy on 2018/5/21.
 */
public class ChannelDaoImpl implements ChannelDao {

    @Override
    public Long save(Channel channel) {
        String sql = "insert into " + TableNameConstant.CHANNEL_TABLE +
                "(`key`,`name`,`status`) values(?,?,?)";

        // 新增后,获取自增编号
        Long channelId = DBUtil.executeInsert(sql,
                channel.getKey(), channel.getName(), channel.getStatus());

        // 设置自增编号
        channel.setId(channelId);
        return channelId;
    }

    @Override
    public int update(Channel channel) {
        String sql = "update " + TableNameConstant.CHANNEL_TABLE +
                " set `key` = ?, `name` = ?, `status` = ? where id = ?";

        return DBUtil.executeUpdate(sql, channel.getKey(), channel.getName(),
                channel.getStatus(), channel.getId());
    }

    @Override
    public Channel findById(Long channelId) {
        String sql = "select * from " + TableNameConstant.CHANNEL_TABLE +
                " where id = ?";

        return DBUtil.getObject(sql, Channel.class, channelId);
    }

    @Override
    public List<Channel> findAll() {
        String sql = "select * from " + TableNameConstant.CHANNEL_TABLE;

        return DBUtil.getObjects(sql, Channel.class);
    }

    @Override
    public int isExits(String name) {
        String sql="select count(*) from mto_channels where name=? ";
        return DBUtil.getCount(sql,Channel.class,name);
    }
}
