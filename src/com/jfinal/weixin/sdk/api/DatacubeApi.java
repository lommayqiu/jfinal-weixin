package com.jfinal.weixin.sdk.api;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.kit.HttpKit;
import com.jfinal.weixin.sdk.utils.JsonUtils;

/**
 * 数据统计接口
 * @author L.cm
 * 文档地址：http://mp.weixin.qq.com/wiki/3/ecfed6e1a0a03b5f35e5efac98e864b7.html
 */
public class DatacubeApi {
	
	private static String getUserSummaryUrl = "https://api.weixin.qq.com/datacube/getusersummary?access_token="; 
	
	private static String getUserCumulateUrl = "https://api.weixin.qq.com/datacube/getusercumulate?access_token=";
	
	/**
	 * 获取统计信息
	 * @param url url链接
	 * @param begin_date 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
	 * @param end_date 获取数据的结束日期，end_date允许设置的最大值为昨日
	 * @return ApiResult
	 */
	private static ApiResult getData(String url, String begin_date, String end_date) {
		Map<String, String> mapData = new HashMap<String, String>();
		mapData.put("begin_date", begin_date);
		mapData.put("end_date", end_date);
		
		String jsonResult = HttpKit.post(url, JsonUtils.toJson(mapData));
		return new ApiResult(jsonResult);
	}
	
	/**
	 * 用户分析数据接口，最大时间跨度：7天
	 * @param begin_date 获取数据的起始日期
	 * @param end_date 获取数据的结束日期
	 * @return ApiResult
	 */
	public static ApiResult getUserSummary(String begin_date, String end_date) {
		String url = getUserSummaryUrl + AccessTokenApi.getAccessTokenStr();
		return getData(url, begin_date, end_date);
	}
	
	/**
	 * 用户分析数据接口，最大时间跨度：7天
	 * @param begin_date 获取数据的起始日期
	 * @param end_date 获取数据的结束日期
	 * @return ApiResult
	 */
	public static ApiResult getUserCumulate(String begin_date, String end_date) {
		String url = getUserCumulateUrl + AccessTokenApi.getAccessTokenStr();
		return getData(url, begin_date, end_date);
	}
	
	private static String getArticleSummaryUrl = "https://api.weixin.qq.com/datacube/getarticlesummary?access_token=";
	
	/**
	 * 获取图文群发每日数据，最大跨度1天
	 * @param begin_date 获取数据的起始日期
	 * @param end_date 获取数据的结束日期
	 * @return
	 */
	public static ApiResult getArticleSummary(String begin_date, String end_date) {
		String url = getArticleSummaryUrl + AccessTokenApi.getAccessTokenStr();
		return getData(url, begin_date, end_date);
	}
	
	private static String getArticlEtotalURL = "https://api.weixin.qq.com/datacube/getarticletotal?access_token=";
	
	/**
	 * 获取图文群发总数据，最大跨度1天
	 * @param begin_date 获取数据的起始日期
	 * @param end_date 获取数据的结束日期
	 * @return
	 */
	public static ApiResult getArticlEtotal(String begin_date, String end_date) {
		String url = getArticlEtotalURL + AccessTokenApi.getAccessTokenStr();
		return getData(url, begin_date, end_date);
	}
	
	private static String getUserReadURL = "https://api.weixin.qq.com/datacube/getuserread?access_token=";
	
	/**
	 * 获取图文统计数据，最大跨度3天
	 * @param begin_date 获取数据的起始日期
	 * @param end_date 获取数据的结束日期
	 * @return
	 */
	public static ApiResult getUserRead(String begin_date, String end_date) {
		String url = getUserReadURL + AccessTokenApi.getAccessTokenStr();
		return getData(url, begin_date, end_date);
	}
	
	private static String getUserReadHourURL = "https://api.weixin.qq.com/datacube/getuserreadhour?access_token=";
	
	/**
	 * 获取图文统计分时数据，最大跨度1天
	 * @param begin_date 获取数据的起始日期
	 * @param end_date 获取数据的结束日期
	 * @return
	 */
	public static ApiResult getUserReadHour(String begin_date, String end_date) {
		String url = getUserReadHourURL + AccessTokenApi.getAccessTokenStr();
		return getData(url, begin_date, end_date);
	}
	
	private static String getUserShareURL = "https://api.weixin.qq.com/datacube/getusershare?access_token=";
	
	/**
	 * 获取图文分享转发数据，最大跨度7天
	 * @param begin_date 获取数据的起始日期
	 * @param end_date 获取数据的结束日期
	 * @return
	 */
	public static ApiResult getUserShare(String begin_date, String end_date) {
		String url = getUserShareURL + AccessTokenApi.getAccessTokenStr();
		return getData(url, begin_date, end_date);
	}
	
	private static String getUserShareHourURL = "https://api.weixin.qq.com/datacube/getusersharehour?access_token=";
	
	/**
	 * 获取图文分享转发分时数据，最大跨度1天
	 * @param begin_date 获取数据的起始日期
	 * @param end_date 获取数据的结束日期
	 * @return
	 */
	public static ApiResult getUserShareHour(String begin_date, String end_date) {
		String url = getUserShareHourURL + AccessTokenApi.getAccessTokenStr();
		return getData(url, begin_date, end_date);
	}
	
}
