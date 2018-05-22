package com.peter.xblog.dao;

import Dao.ChannelDao;
import Dao.Impl.ChannelDaoImpl;
import bean.Channel;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zmy on 2018/5/21.
 */
public class ChannelDaoTest {
    private ChannelDao channelDao = new ChannelDaoImpl();

    @Test
    public void save() throws Exception {
        Channel channel = new Channel();
        channel.setKey("xxx");
        channel.setName("it");
        channel.setStatus(0);
        channelDao.save(channel);
        Assert.assertTrue(channel.getId() > 0);
    }

    @Test
    public void update() throws Exception {
        Channel channel = channelDao.findById(1L);
        channel.setName("IT技术分享");
        channelDao.update(channel);

        Assert.assertTrue(channel.getId() > 0);
    }

    @Test
    public void findById() throws Exception {
        Channel channel = channelDao.findById(1L);

        Assert.assertNotNull(channel);
        System.out.println(channel);
    }

    @Test
    public void findAll() throws Exception {
        List<Channel> channelList = channelDao.findAll();

        Assert.assertNotNull(channelList);
        for (Channel channel : channelList) {
            System.out.println(channel);
        }
    }

}