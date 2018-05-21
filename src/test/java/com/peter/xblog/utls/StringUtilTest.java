package com.peter.xblog.utls;

import org.junit.Assert;
import org.junit.Test;
import utils.StringUtil;

import static org.junit.Assert.*;

/**
 * Created by zmy on 2018/5/21.
 */
public class StringUtilTest {
    @Test
    public void isEmpty() throws Exception {
        String emptyStr = "";
        String nonEmptyStr = "x";
        Assert.assertTrue(StringUtil.isEmpty(emptyStr));
        Assert.assertTrue(!StringUtil.isEmpty(nonEmptyStr));
    }

    @Test
    public void isNotEmpty() throws Exception {
        String emptyStr = "";
        String nonEmptyStr = "x";
        Assert.assertTrue(!StringUtil.isNotEmpty(emptyStr));
        Assert.assertTrue(StringUtil.isNotEmpty(nonEmptyStr));
    }

}