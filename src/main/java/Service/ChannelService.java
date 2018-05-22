package Service;

import bean.Channel;

import java.util.List;

/**
 * Created by ZH on 2018/5/22.
 */
public interface ChannelService {
    Long save(Channel channel);
    int update(Channel channel);
    Channel findById(Long channelId);
    List<Channel> findAll();
}
