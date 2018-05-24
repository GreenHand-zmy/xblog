/*
Navicat MySQL Data Transfer

Source Server         : myconn
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : xblog

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2018-05-24 16:22:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `mto_channels`
-- ----------------------------
DROP TABLE IF EXISTS `mto_channels`;
CREATE TABLE `mto_channels` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '频道编号',
  `key` varchar(255) DEFAULT NULL COMMENT '频道标识',
  `name` varchar(255) DEFAULT NULL COMMENT '频道名',
  `status` int(11) DEFAULT NULL COMMENT '频道状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mto_channels
-- ----------------------------
INSERT INTO `mto_channels` VALUES ('1', 'blog', '博客', '0');
INSERT INTO `mto_channels` VALUES ('2', 'questions', '问答', '0');
INSERT INTO `mto_channels` VALUES ('3', 'share', '分享', '0');

-- ----------------------------
-- Table structure for `mto_comments`
-- ----------------------------
DROP TABLE IF EXISTS `mto_comments`;
CREATE TABLE `mto_comments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论编号',
  `author_id` bigint(20) DEFAULT NULL COMMENT '作者编号',
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `to_id` bigint(20) DEFAULT NULL COMMENT '评论的文章编号',
  `status` int(11) DEFAULT NULL COMMENT '评论状态',
  `created` datetime DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mto_comments
-- ----------------------------
INSERT INTO `mto_comments` VALUES ('1', '4', '奥林匹亚为奥林匹克运动的发祥地，位于希腊首都雅典。', '4', '0', '2018-05-22 08:37:25');
INSERT INTO `mto_comments` VALUES ('2', '1', '写的也太好了吧', '2', '0', '2018-05-23 14:09:29');
INSERT INTO `mto_comments` VALUES ('3', '5', '分析的好', '2', '0', '2018-05-24 15:47:09');

-- ----------------------------
-- Table structure for `mto_posts`
-- ----------------------------
DROP TABLE IF EXISTS `mto_posts`;
CREATE TABLE `mto_posts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author_id` bigint(20) DEFAULT NULL,
  `channel_id` bigint(20) DEFAULT NULL,
  `content` text,
  `created` datetime DEFAULT NULL,
  `editor` varchar(255) DEFAULT NULL,
  `comments` int(11) DEFAULT NULL,
  `favors` int(11) DEFAULT NULL,
  `featured` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `title` varchar(64) DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mto_posts
-- ----------------------------
INSERT INTO `mto_posts` VALUES ('1', '1', '1', '清华大学有28个本科专业荣膺中国八星级专业（8），跻身世界一流、中国最顶尖专业行列，雄居2018世界一流专业排行榜冠军。北京大学72个专业全国排名第一，雄居2018中国大学排名第1专业排行榜榜首。报告依据国务院学位委员会、教育部颁布的《学位授予和人才培养学科目录（2011年）》发布最新2018中国大学各学科一流专业排行榜。其中，北京大学勇夺2018中国大学理学、医学、历史学、哲学和文学等5个学科门类一流专业排行榜第1；清华大学赢得2018中国大学工学和管理学等2个学科门类一流专业排行榜第1，中国人民大学问鼎2018中国大学法学和经济学等2个学科门类一流专业排行榜第1，北京体育大学名列2018中国大学教育学一流专业排行榜第1，中国农业大学雄居2018中国大学农学一流专业排行榜第1，中央美术学院高居2018中国大学艺术学一流专业排行榜第1。', '2018-05-21 16:49:16', '4', '0', '0', '2', '2', '清华大学有28个本科专业荣膺中国八星级专业（8），跻身世界一流、中国最顶尖专业行列', '教育', '校友会2018中国大学一流专业排行榜800出炉，清华大学问鼎榜首', '0', '2');
INSERT INTO `mto_posts` VALUES ('2', '2', '1', '数据，不会帮助一支球队解决全部问题，但它的辅助作用往往能发现一些问题。\r\n\r\n   截至目前，恒大打了11场中超联赛，8场亚冠，1场超级杯，2场足协杯。在已经进行的22场比赛中，本土球员仅打进11球。从本土球员的表现来看，在进球数上，本赛季前22场比赛创造了近几年的新低。回头看看，2017赛季前22场比赛恒大本土球员打进17球，2016赛季前22场比赛恒大本土球员打进13球，2015赛季则有19球入账，2014赛季更是达到了史上同期最高的20球。\r\n\r\n   相比之下，恒大外援在前11轮中超表现并不算差，至少从数据来看，恒大几名外援在中超还是有一定竞争力的。放眼前11轮中超，阿兰虽遭禁赛，但打了4场就收获6球，高拉特虽有状态起伏，但6球2助攻的表现同样可圈可点，普遍不被看好的新援古德利11轮联赛全勤，是恒大阵中唯一一名打满11轮联赛的球员，他送出了2球1助攻的表现。3名恒大中前场的外援，贡献14球3助攻。在这样的数据面前，上轮0-2不敌北京人和之后，恒大高层放出“外援全换”的指示，看上去不免有些极端和冲动。\r\n\r\n   至于有人说恒大多线作战太疲劳，同样值得商榷。正如前文所说，除了古德利全勤，恒大阵中已没有“使劲用”的球员了。除了门将曾诚，于汉超前11轮10次首发，郜林9次首发，李学鹏9次首发，就几乎是全队的“铁血战士”了。像冯潇霆、张琳芃这样的昔日铁打主力，11轮比赛得到2次轮休。如此来看，卡纳瓦罗的轮换并没有起到应有的作用。\r\n\r\n   任何一支球队都会经历低谷、低迷，恒大前11轮虽没有发挥出应有的统治力，但并不能因此就妄下断言“恒大王朝崩塌”。联赛是一个漫长过程，在现有人员基础上，确保不折腾，进一步激发对胜利的饥渴感，似乎更加重要。（作者微博：@张连杰87）', '2018-05-22 16:12:39', '4', '2', '0', '1', '1', '数据，不会帮助一支球队解决全部问题，但它的辅助作用往往能发现一些问题。', '体育', '恒大本土球员急需提升进攻主导', '0', '2');
INSERT INTO `mto_posts` VALUES ('3', '4', '1', '一位记者在探访香坊火车站时这样写道：“提起哈尔滨火车站，你一定会想到匆匆的旅客，喧嚣的售票厅，热闹的候车室……这些标志性的符号，都与香坊区通站街118号的那个建筑搭不上边儿。它是那么安静、从容，没有密密麻麻的人潮，没有纷乱嘈杂的声音，经过岁月百年的洗礼，依然安静地站在那里——它就是哈尔滨香坊火车站。”香坊火车站就是这样，可能你与它已近在咫尺，你却嗅不到它的味道；那座掩映在树丛后的一层俄式站房，像一位饱经风霜的老者，将自己的故事看得云淡风轻，从不与人诉说。（一）\r\n\r\n哈尔滨的历史与铁路是密切相关的。据史料记载，香坊火车站始建于1898年10月，是哈尔滨最早的火车站。1898年，俄国人开始修建中东铁路，两年内在哈尔滨建设了3个火车站，分别是哈尔滨站、松花江站、秦家岗站。松花江站位于松花江南岸、中央大街北端西侧（现友谊宫址），后改称码头站，最后停用并拆除，仅留下两座建筑，现为公园餐厅和江畔餐厅。秦家岗站就是现在的哈尔滨火车站，但其俄式建筑已于1959年拆除。而当时的哈尔滨站曾改名为老哈尔滨站，也就是现在的香坊火车站。\r\n\r\n哈尔滨老一辈人中有这样的传说：“先有香坊，后有哈尔滨”。1898年，中东铁路工程局设立在当时的香坊“田家烧锅”院内，俄国首批铁路工程技术人员抵达香坊后，即在这里修建了火车站，称“哈尔滨驿”。并将周边各村屯联片规划，建立了工兵路（现公滨路）、草料街、陆军街等30多条街道。同时，修建了许多附属建筑，包括宗教建筑、地方事务所、铁路医院、守备军司令部、小学及近代企业等。这些道路与建筑形成了近代哈尔滨的城市雏形，这大概就是“先有香坊，后有哈尔滨”的由来。1903年7月14日，中东铁路全线通车，由于人们称南岗区为“新哈尔滨”，为了区别起见，1904年把香坊“哈尔滨站”改为“老哈尔滨站”，1924年，又将“老哈尔滨站”改为“香坊站”。（二）1925年10月香坊火车站建成新站舍，由俄罗斯工程师设计，属典型的俄式建筑，仿古典的折衷主义建筑风格，砖木结构单层建筑，平面呈“山”字形。临广场立面为主立面，“横三纵五”构图，中间为入口，左右对称，形态完整。上开瘦长的拱券窗，带有白色装饰窗楣。窗额檐口的装饰构件衬托隆起的屋面，整体造型简洁、曲线流畅。屋面上有三个独立的孟莎式绿色屋顶，变化丰富，上开老虎窗，突出古典之风。墙面色彩以米黄为主基调，辅以白色线脚装饰，体现出富丽而典雅的气氛。这种折衷主义风格盛行于19世纪的欧美，是一种博众家之长于一身建筑风格。现存的香坊站建成已近百年，它既显示了哈尔滨百年前铁路建筑的形态，又反映了20世纪初哈尔滨近代铁路建筑的建造技术水平。香坊火车站原隶属于哈尔滨铁路局哈尔滨车务段管辖，2015年6月起划归哈尔滨东站管辖。2017年11月开始隶属于中国铁路哈尔滨局集团有限公司。2007年被哈尔滨市政府列为哈尔滨市一类保护建筑。', '2018-05-23 10:19:18', '1', '0', '0', '1', '1', '百年小站—香坊火车站的前生今世', '史话', '冰城史话｜百年小站—香坊火车站的前生今世', '0', '11');
INSERT INTO `mto_posts` VALUES ('4', '2', '2', '求助', '2018-05-24 11:23:11', '1', '1', '0', '1', '2', ' 奥林匹克运动的发祥地在何处?', '体育', ' 奥林匹克运动的发祥地在何处?', '0', '2');
INSERT INTO `mto_posts` VALUES ('5', '5', '3', '马上就是五一小长假了，姑娘们决定好了要怎么放松一下了没？对于饼这种懒癌晚期，比起出门观赏各地的人山人海，假期窝在家里追剧，逛街试衣shopping才是最好的休闲方式~最近最火的剧，一定是今晚就将更新马上愈半的聚集了超高配置的《欢乐颂》了吧，这部“我和我的闺蜜们”，不仅演绎了魔都的五个女生相互扶持共同向前的成长过程，其实更是让我们展示了不同生活环境里的姑娘们的思想甚至穿搭。说到思想，在饼看来小美美眉的经典语录已经足够我们来分享一大波了，而实则穿搭着实也挺值得咱来根据她们的不同情况来细究一番滴~咱们不再过多废话，直接开扒：1、精英总攻.安迪\r\n\r\n刘涛饰演的安迪是个从华尔街挖过来的海归精英，超级经理人。高冷精干，理性得体，高智商的她对数字极为敏感，逻辑思维强大，甚至曾有跳级经历。真是一个集美貌与才华于一身的女子！所以，CFO作为霸气女总裁，全程都用上了质感的职场套装来塑造自己的形象，与自己荧幕下的贤母形象还真是大相径庭。涛姐用新形象告诉你，你也会有更多的可能。', '2018-05-24 15:53:12', '1', '0', '0', '1', '1', '穿搭', '时尚', '《欢乐颂》里的五美你爱谁？轻熟OL究竟应该如何穿？', '0', '2');

-- ----------------------------
-- Table structure for `mto_users`
-- ----------------------------
DROP TABLE IF EXISTS `mto_users`;
CREATE TABLE `mto_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `mobile` varchar(11) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT '/assets/images/ava/default.png',
  `updated` datetime DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mto_users
-- ----------------------------
INSERT INTO `mto_users` VALUES ('1', '2018-05-22 13:48:03', '18757551111', '123456', null, 'zgxyh', '艾瑞深中国校友会网', '/assets/images/ava/default.png', null, null, '高校资讯', '2018-05-24 15:15:19');
INSERT INTO `mto_users` VALUES ('2', '2018-05-22 13:49:17', '18757552222', '123456', null, 'zlj', '张连杰', '/assets/images/ava/default.png', '2018-05-24 14:45:58', null, '知名体育博主 头条文章作者 微博签约自媒体', '2018-05-24 15:20:04');
INSERT INTO `mto_users` VALUES ('3', '2018-05-22 16:17:46', null, '123456', null, 'admin', 'admin', '/assets/images/ava/default.png', null, null, '管理员', '2018-05-14 15:28:16');
INSERT INTO `mto_users` VALUES ('4', '2018-05-23 15:10:23', '1875755333', '123456', null, 'ppg123', '皮皮狗', '/assets/images/ava/default.png', null, null, '娱乐节目评委', '2018-05-24 15:28:10');
INSERT INTO `mto_users` VALUES ('5', '2018-05-24 15:44:01', '18757554444', '123456', null, 'dabin', '大饼穿搭札记', '/assets/images/ava/default.png', null, null, '时尚达人', '2018-05-24 15:46:32');
