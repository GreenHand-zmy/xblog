package service.Impl;

import dao.ChannelDao;
import dao.Impl.ChannelDaoImpl;
import service.ChannelService;
import bean.Channel;
import constant.ChannelStatusConstant;

import java.util.List;

import static utils.CheckUtil.check;

/**
 * Created by ZH on 2018/5/22.
 */
public class ChannelServiceImpl implements ChannelService {
    private ChannelDao channelDao = new ChannelDaoImpl();

    @Override
    public Long save(Channel channel) {
        int num = channelDao.isExits(channel.getName());
        check(num == 0, "频道已存在");
        return channelDao.save(channel);
    }

    @Override
    public int update(Channel channel) {
        check(channel != null && channel.getId() != null, "频道不能为空");
        return channelDao.update(channel);
    }

    @Override
    public Channel findById(Long channelId) {
        Channel channel = channelDao.findById(channelId);
        check(channel != null, "频道不存在");
        return channel;
    }

    @Override
    public List<Channel> findAll() {
        List<Channel> list = channelDao.findAll();
        check(list != null, "无查询结果");
        return list;
    }

    @Override
    public int deleteChannel(Long id) {
        Channel channel = channelDao.findById(id);
        check(channel != null, "该用户不存在");
        channel.setStatus(ChannelStatusConstant.CLOSED_STATUS);
        return channelDao.update(channel);
    }
}
