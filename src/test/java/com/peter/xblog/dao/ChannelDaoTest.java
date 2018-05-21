package com.peter.xblog.dao;

import Dao.ChannelDao;
import Dao.Impl.ChannelDaoImpl;
import bean.Channel;
import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertTrue(channelDao.save(channel) > 0);
        Assert.assertTrue(channel.getId() > 0);
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void findById() throws Exception {
    }

    @Test
    public void findAll() throws Exception {
    }

}