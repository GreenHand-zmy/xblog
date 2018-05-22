package com.peter.xblog.service;

import Service.ChannelService;
import Service.Impl.ChannelServiceImpl;
import bean.Channel;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zmy on 2018/5/22.
 */
public class ChannelServiceTest {
    private ChannelService channelService = new ChannelServiceImpl();

    @Test
    public void save() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void findById() throws Exception {
    }

    @Test
    public void findAll() throws Exception {
        List<Channel> channelList = channelService.findAll();
    }

}