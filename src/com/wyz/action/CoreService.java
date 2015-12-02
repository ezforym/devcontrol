package com.wyz.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.wyz.pojo.Article;
import com.wyz.pojo.NewsMessage;
import com.wyz.pojo.TextMessage;
import com.wyz.util.MessageUtil;

/**
 * 核心服务类
 * 
 * @author 杨建冬
 * @date 2013-09-10
 */
public class CoreService {
	/**
	 * 处理微信发来的请求 换行符仍然是"\n"
	 * 
	 * @param request
	 * @return
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	public static String processRequest(HttpServletRequest request) throws InterruptedException, SQLException {

		String yonghuurl = null;
		String yonghuur2 = null;
		String dizhi = null;
		String respMessage = null;
		boolean temp1 = false;
		boolean temp2 = false;
		boolean temp3 = false;
		boolean temp4 = false;
		boolean temp5 = false;
		boolean temp6 = false;
		boolean temp7 = false;
		boolean temp8 = false;
		boolean temp9 = false;
		boolean temp10 = false;
		boolean temp11 = false;
		boolean temp12 = false;
		try {
			// 默认返回的文本消息内容
			int temp = 0;
			String respContent = "请求处理异常，请稍候尝试！";

			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			yonghuurl = "http://1.yizelover.sinaapp.com/bueatiful/images.php?yonghu=" + fromUserName;
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			System.out.println("1toUserName is :" + toUserName);
			System.out.println("2FromUserName is :" + fromUserName);
			String msgType = requestMap.get("MsgType");
			// 回复文本消息
			System.out.println("MsgType is :" + msgType);
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			// 两种获取整形时间的方法。
			// 获取到的结果表示当时时间距离1970年1月1日0时0分0秒0毫秒的毫秒数。公众平台api中消息创建时间CreateTime，它表示1970年1月1日0时0分0秒至消息创建时所间隔的秒数，注意是间隔的秒数，不是毫秒数！
			// long longTime1 = System.currentTimeMillis();
			// long longTime2 = new java.util.Date().getTime();
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);
			// 文本消息
			String content = requestMap.get("Content");
			if ("1".equals(content) || "2".equals(content) || "3".equals(content) || "4".equals(content)
					|| "6".equals(content) || "5".equals(content) || "7".equals(content) || "8".equals(content)
					|| "9".equals(content) || "10".equals(content) || "11".equals(content) || "12".equals(content)) {
				content = "nothing";
			}
			System.out.println("----------123------:" + content);
			if ("美白".equals(content)) {
				content = "1";
			} else if ("补水".equals(content)) {
				content = "2";
			} else if ("祛斑".equals(content)) {
				content = "3";
			} else if ("所有商品".equals(content)) {
				content = "4";
			} else if ("美即".equals(content)) {
				content = "5";
			} else if ("戴莱美".equals(content)) {
				content = "6";
			} else if ("蓝莓".equals(content)) {
				content = "7";
			} else if ("奇迹".equals(content)) {
				content = "8";
			} else if ("韩后".equals(content)) {
				content = "9";
			} else if ("订单".equals(content)) {
				content = "10";
			} else if ("查询订单".equals(content)) {
				content = "10";
			} else if ("订单详情".equals(content)) {
				content = "10";
			} else if ("收货地址".equals(content)) {
				content = "11";
			} else if ("收货地址管理".equals(content)) {
				content = "11";
			} else if ("地址".equals(content)) {
				content = "11";
			}
			System.out.println("----------321------:" + content);
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = "谢谢您的关注！";
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// 事件KEY值，与创建自定义菜单时指定的KEY值对应
					String eventKey = requestMap.get("EventKey");
					if (eventKey.equals("11")) {
						yonghuurl = "http://1.yizelover.sinaapp.com/bueatiful/images.php?yonghu=" + fromUserName
								+ "&gongxiao=美白";
						temp = 1;
						content = "1";
						// respContent = "天气预报菜单项被点击！";
					} else if (eventKey.equals("12")) {
						yonghuurl = "http://1.yizelover.sinaapp.com/bueatiful/images.php?yonghu=" + fromUserName
								+ "&gongxiao=补水";
						temp = 2;
						content = "2";
						// respContent = "公交查询菜单项被点击！";
					} else if (eventKey.equals("13")) {
						yonghuurl = "http://1.yizelover.sinaapp.com/bueatiful/images.php?yonghu=" + fromUserName
								+ "&gongxiao=祛斑";
						temp = 3;
						content = "3";
						// respContent = "周边搜索菜单项被点击！";
					} else if (eventKey.equals("14")) {
						yonghuurl = "http://1.yizelover.sinaapp.com/bueatiful/images.php?yonghu=" + fromUserName;
						temp = 4;
						content = "4";
						// respContent = "历史上的今天菜单项被点击！";
					} else if (eventKey.equals("21")) {
						yonghuurl = "http://1.yizelover.sinaapp.com/bueatiful/images.php?yonghu=" + fromUserName
								+ "&pinpai=美即";
						temp = 5;
						content = "5";
						// respContent = "歌曲点播菜单项被点击！";
					} else if (eventKey.equals("22")) {
						yonghuurl = "http://1.yizelover.sinaapp.com/bueatiful/images.php?yonghu=" + fromUserName
								+ "&pinpai=戴莱美";
						temp = 6;
						content = "6";
						// respContent = "经典游戏菜单项被点击！";
					} else if (eventKey.equals("23")) {
						yonghuurl = "http://1.yizelover.sinaapp.com/bueatiful/images.php?yonghu=" + fromUserName
								+ "&pinpai=蓝莓";
						temp = 7;
						content = "7";
						// respContent = "美女电台菜单项被点击！";
					} else if (eventKey.equals("24")) {
						yonghuurl = "http://1.yizelover.sinaapp.com/bueatiful/images.php?yonghu=" + fromUserName
								+ "&pinpai=奇迹";
						temp = 8;
						content = "8";
						// respContent = "人脸识别菜单项被点击！";
					} else if (eventKey.equals("25")) {
						yonghuurl = "http://1.yizelover.sinaapp.com/bueatiful/images.php?yonghu=" + fromUserName
								+ "&pinpai=韩后";
						temp = 9;
						content = "9";
						// respContent = "聊天唠嗑菜单项被点击！";
					} else if (eventKey.equals("31")) {
						temp = 10;
						content = "10";
						yonghuur2 = "http://1.yizelover.sinaapp.com/bueatiful/dingdan.php?xxxx=" + fromUserName;
						// respContent = "Q友圈菜单项被点击！";
					} else if (eventKey.equals("32")) {
						temp = 11;
						content = "11";
						dizhi = "http://1.yizelover.sinaapp.com/bueatiful/shouhuoguanli.php?dizhi=" + fromUserName;
						// respContent = "电影排行榜菜单项被点击！";
					} else if (eventKey.equals("33")) {
						temp = 12;
						content = "12";
						// respContent = "幽默笑话菜单项被点击！";
					}
				}
			}
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT) || temp != 0) {
				temp1 = "1".equals(content);
				temp2 = "2".equals(content);
				temp3 = "3".equals(content);
				temp4 = "4".equals(content);
				temp5 = "5".equals(content);
				temp6 = "6".equals(content);
				temp7 = "7".equals(content);
				temp8 = "8".equals(content);
				temp9 = "9".equals(content);
				temp10 = "10".equals(content);
				temp11 = "11".equals(content);
				temp12 = "12".equals(content);
				// 文本消息内容
				respContent = "我没有明白你的意思：";
				// 创建图文消息
				System.out.println("~~~~~~~~~" + respContent);
				NewsMessage newsMessage = new NewsMessage();
				newsMessage.setToUserName(fromUserName);
				newsMessage.setFromUserName(toUserName);
				System.out.println("1toUserName is :" + toUserName);
				System.out.println("2FromUserName is :" + fromUserName);
				newsMessage.setCreateTime(new Date().getTime());
				newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
				newsMessage.setFuncFlag(0);
				List<Article> articleList = new ArrayList<Article>();
				// 单图文消息
				if (temp1) {
					Article article = new Article();
					article.setTitle("想要美白？");
					article.setDescription("点击图片。");
					article.setPicUrl("http://yizelover-wuyize.stor.sinaapp.com/meibai.jpg");
					article.setUrl(yonghuurl);
					articleList.add(article);
					// 设置图文消息个数
					newsMessage.setArticleCount(articleList.size());
					// 设置图文消息包含的图文集合
					newsMessage.setArticles(articleList);
					// 将图文消息对象转换成xml字符串
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
				} else if (temp2) {
					Article article = new Article();
					article.setTitle("想要补水？");
					article.setDescription("点击图片。");
					article.setPicUrl("http://yizelover-wuyize.stor.sinaapp.com/bushui.jpg");
					article.setUrl(yonghuurl);
					articleList.add(article);
					// 设置图文消息个数
					newsMessage.setArticleCount(articleList.size());
					// 设置图文消息包含的图文集合
					newsMessage.setArticles(articleList);
					// 将图文消息对象转换成xml字符串
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
				} else if (temp3) {
					Article article = new Article();
					article.setTitle("想要祛斑？");
					article.setDescription("点击图片。");
					article.setPicUrl("http://yizelover-wuyize.stor.sinaapp.com/quban.jpg");
					article.setUrl(yonghuurl);
					articleList.add(article);
					// 设置图文消息个数
					newsMessage.setArticleCount(articleList.size());
					// 设置图文消息包含的图文集合
					newsMessage.setArticles(articleList);
					// 将图文消息对象转换成xml字符串
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
				} else if (temp4) {
					Article article = new Article();
					article.setTitle("所有商品：");
					article.setDescription("点击图片。");
					article.setPicUrl("http://yizelover-wuyize.stor.sinaapp.com/qudou.jpg");
					article.setUrl(yonghuurl);
					articleList.add(article);
					// 设置图文消息个数
					newsMessage.setArticleCount(articleList.size());
					// 设置图文消息包含的图文集合
					newsMessage.setArticles(articleList);
					// 将图文消息对象转换成xml字符串
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
				} else if (temp5) {
					Article article = new Article();
					article.setTitle("美即面膜、重新开始。");
					article.setDescription("点击图片。");
					article.setPicUrl("http://yizelover-wuyize.stor.sinaapp.com/meiji.jpg");
					article.setUrl(yonghuurl);
					articleList.add(article);
					// 设置图文消息个数
					newsMessage.setArticleCount(articleList.size());
					// 设置图文消息包含的图文集合
					newsMessage.setArticles(articleList);
					// 将图文消息对象转换成xml字符串
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
				} else if (temp6) {
					Article article = new Article();
					article.setTitle("戴莱美面膜、为美丽而生。");
					article.setDescription("点击图片。");
					article.setPicUrl("http://1.yizelover.sinaapp.com/bueatiful/images/product/dailaimei.jpg");
					article.setUrl(yonghuurl);
					articleList.add(article);
					// 设置图文消息个数
					newsMessage.setArticleCount(articleList.size());
					// 设置图文消息包含的图文集合
					newsMessage.setArticles(articleList);
					// 将图文消息对象转换成xml字符串
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
				} else if (temp7) {
					Article article = new Article();
					article.setTitle("蓝莓面膜、总是惊喜。");
					article.setDescription("点击图片。");
					article.setPicUrl("http://yizelover-wuyize.stor.sinaapp.com/lanmei.jpg");
					article.setUrl(yonghuurl);
					articleList.add(article);
					// 设置图文消息个数
					newsMessage.setArticleCount(articleList.size());
					// 设置图文消息包含的图文集合
					newsMessage.setArticles(articleList);
					// 将图文消息对象转换成xml字符串
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
				} else if (temp8) {
					Article article = new Article();
					article.setTitle("奇迹面膜、每天都是奇迹。");
					article.setDescription("点击图片。");
					article.setPicUrl("http://yizelover-wuyize.stor.sinaapp.com/qiji.jpg");
					article.setUrl(yonghuurl);
					articleList.add(article);
					// 设置图文消息个数
					newsMessage.setArticleCount(articleList.size());
					// 设置图文消息包含的图文集合
					newsMessage.setArticles(articleList);
					// 将图文消息对象转换成xml字符串
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
				} else if (temp9) {
					Article article = new Article();
					article.setTitle("韩后面膜、专业且专注。");
					article.setDescription("点击图片。");
					article.setPicUrl("http://yizelover-wuyize.stor.sinaapp.com/hanhou.jpg");
					article.setUrl(yonghuurl);
					articleList.add(article);
					// 设置图文消息个数
					newsMessage.setArticleCount(articleList.size());
					// 设置图文消息包含的图文集合
					newsMessage.setArticles(articleList);
					// 将图文消息对象转换成xml字符串
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
				} else if (temp10) {
					Article article = new Article();
					article.setTitle("查询订单：");
					article.setDescription("点击图片。");
					article.setPicUrl("http://yizelover-wuyize.stor.sinaapp.com/dingdanchaxun.jpg");
					article.setUrl(yonghuur2);
					articleList.add(article);
					// 设置图文消息个数
					newsMessage.setArticleCount(articleList.size());
					// 设置图文消息包含的图文集合
					newsMessage.setArticles(articleList);
					// 将图文消息对象转换成xml字符串
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
				} else if (temp11) {
					Article article = new Article();
					article.setTitle("收货地址管理：");
					article.setDescription("点击图片。");
					article.setPicUrl("http://yizelover-wuyize.stor.sinaapp.com/dizhiguanli.jpg");
					article.setUrl(dizhi);
					articleList.add(article);
					// 设置图文消息个数
					newsMessage.setArticleCount(articleList.size());
					// 设置图文消息包含的图文集合
					newsMessage.setArticles(articleList);
					// 将图文消息对象转换成xml字符串
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
				}
				if (temp12) {
					Article article = new Article();
					article.setTitle("联系卖家：");
					article.setDescription("扫描二维码。");
					article.setPicUrl("http://2.yizelover.sinaapp.com/qqq/wuyize.jpg");
					article.setUrl("http://2.yizelover.sinaapp.com/chat/home.html");
					articleList.add(article);
					// 设置图文消息个数
					newsMessage.setArticleCount(articleList.size());
					// 设置图文消息包含的图文集合
					newsMessage.setArticles(articleList);
					// 将图文消息对象转换成xml字符串
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
				}
			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "不好意思！我还看不懂图片。";
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "您发送的是地理位置消息！";
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "您发送的是<a href=\"http://www.24hs.cn/\">链接</a>消息！";
			}
			// 音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "不好意思！我还听不懂语音。";
			}
			// 事件推送
			respContent = respContent + "你可以回复美白、补水、祛斑、所有商品、戴莱美、美即、韩后、蓝莓、奇迹、订单详情等等，我们就为你查询相关信息。";
			textMessage.setContent(respContent);
			if (temp1 || temp2 || temp3 || temp4 || temp5 || temp6 || temp7 || temp8 || temp9 || temp10 || temp11
					|| temp12) {
				;
			} else {
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return respMessage;
	}
}