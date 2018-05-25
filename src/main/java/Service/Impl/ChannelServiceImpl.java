package Service.Impl;

import Dao.ChannelDao;
import Dao.Impl.ChannelDaoImpl;
import Service.ChannelService;
import bean.Channel;
import bean.Post;

import java.util.List;

import static utils.CheckUtil.check;

/**
 * Created by ZH on 2018/5/22.
 */
public class ChannelServiceImpl implements ChannelService {
    ChannelDao cd= new ChannelDaoImpl();
    @Override
    public Long save(Channel channel) {
        int num = cd.isExits(channel.getName());
        check(num==0,"频道已存在");
        return cd.save(channel);
    }

    @Override
    public int update(Channel channel) {
        check(channel!= null&&channel.getId()!=null,"频道不能为空");
        return cd.update(channel);
    }

    @Override
    public Channel findById(Long channelId) {
        Channel channel = cd.findById(channelId);
        check(channel!=null,"频道不存在");
        return channel;
    }

    @Override
    public List<Channel> findAll() {
        List<Channel> list=cd.findAll();
        check(list!=null,"无查询结果");
        return list;
    }

    @Override
    public int deleteChannel(Long id) {
        Channel channel = cd.findById(id);
        check(channel != null, "该用户不存在");
        int num = cd.deleteChannel(id);
        return num;
    }
}
