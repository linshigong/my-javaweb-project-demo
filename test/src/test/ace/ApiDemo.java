package test.ace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.crypto.dsig.SignatureMethod;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.HttpException;

public class ApiDemo
{
	/**
	 * 服务地址
	 */
//	private String baseUrl = "http://10.230.129.182:8088/open?";
	private String baseUrl = "http://10.230.129.78:8088/open?";

	/**
	 * App Key
	 */
	private String appKey = "TestVMFhd506uBsO";

	/**
	 * App Secret
	 */
	private String appSecret = "PApUVjDCg1";


	private static final String oauthMethod = "HmacSHA1"; // 签名算法
	private static final String requestMethod = "GET";
	private static final String SEPARATOR = "&";
	private static final String EQUAL = "=";
	private static final String ENCODE_TYPE = "UTF-8";

	/**
	 * 生成签名串
	 * @param params
	 * @return
	 */
	private String generateSign(Map<String, String> params)
	{
		String sign = null;
		try
		{

			List<String> keys = new ArrayList<String>(params.keySet());
			// 签名参数进行排序
			Collections.sort(keys);

			StringBuffer buffer = new StringBuffer();// 待签名参数
			for (String key : keys)
			{
				String value = (String) params.get(key);
				buffer.append(SEPARATOR)
						.append(URLEncoder.encode(key, ENCODE_TYPE))
						.append(EQUAL)
						.append(URLEncoder.encode(value, ENCODE_TYPE));
			}

			/**
			 * 待签名串
			 */
			StringBuffer signedData = new StringBuffer();
			signedData.append(URLEncoder.encode(requestMethod.toUpperCase(),
					ENCODE_TYPE));
			signedData.append(SEPARATOR);
			signedData.append(URLEncoder.encode(baseUrl.substring(0,baseUrl.length()-1), ENCODE_TYPE));
			signedData.append(SEPARATOR);
			signedData.append(URLEncoder.encode(buffer.substring(1),
					ENCODE_TYPE));


			/**
			 * 签名
			 */
			SecretKey key = new SecretKeySpec(
					(appSecret + SEPARATOR).getBytes(ENCODE_TYPE), SignatureMethod.HMAC_SHA1);
			Mac mac = Mac.getInstance(oauthMethod);
			mac.init(key);

			/**
			 * 生成签名串
			 */
			sign = URLEncoder.encode(new String(new Base64().encode(mac.doFinal(signedData
					.toString().getBytes(ENCODE_TYPE))), ENCODE_TYPE),ENCODE_TYPE);

		} catch (Exception e)
		{

		}
		return sign;
	}

	/**
	 * 组装请求参数
	 * @param params
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private String buildParams(Map<String, String> params)
			throws UnsupportedEncodingException
	{
		StringBuffer sb = new StringBuffer();
		for (String key : params.keySet())
		{
			sb.append(SEPARATOR);
			sb.append(URLEncoder.encode(key, ENCODE_TYPE));
			sb.append(EQUAL);		
			if(key.equals("oauth_signature")){
				sb.append(params.get(key));
			}else{
				sb.append(URLEncoder.encode(params.get(key), ENCODE_TYPE));
			}
		}
		return sb.substring(1);
	}

	/**
	 * 执行请求
	 * @param params
	 * @return
	 */
	private String execute(Map<String, String> params)
	{
		params.put("oauth_consumer_key", appKey);
		params.put("oauth_signature_method", "HMAC-SHA1");
		params.put("oauth_version", "1.0");
	    params.put("oauth_timestamp",String.valueOf(System.currentTimeMillis() / 1000));
	    params.put("oauth_nonce", String.valueOf(System.nanoTime()));
		params.put("oauth_signature", generateSign(params));

		String result = null;
		try
		{
			// 组装URL
			StringBuffer sb = new StringBuffer();
			sb.append(baseUrl);
			sb.append(buildParams(params));

			// 发送HTTP请求
			System.out.println("url=" + sb.toString());
			result = sendRequest(sb.toString());
		} catch (UnsupportedEncodingException e)
		{
			System.out.println(e);
		}
		return result;
	}

	/**
	 * HTTP请求
	 *
	 * @param request
	 * @return
	 */
	private String sendRequest(String url)
	{
		String result = "";
		BufferedReader rd = null;
		URLConnection conn = null;

		try
		{
			URL u = new URL(url);
			conn = u.openConnection();
			conn.setConnectTimeout(1000 * 1000 * 60 * 5);
			conn.setReadTimeout(1000 * 1000 * 60 * 5);

			// Get the response
			rd = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));

			String line;
			while ((line = rd.readLine()) != null)
			{
				result += line;
			}

		} catch (Exception e)
		{
			throw new RuntimeException(e);
		} finally
		{
			try
			{
				if (rd != null)
				{
					rd.close();
				}
			} catch (IOException e)
			{
			}
		}
		return result;
	}
	
	public void doTestGroup(ApiDemo app){
		Map<String, String> params = new HashMap<String, String>();
		/* 
		//create_app
		System.out.println("create_app");
		params.put("user_id", "1");
		params.put("action", "create_app");
		params.put("app_name", "testAppName1088");
		params.put("site_user_id", "1088");
		params.put("app_language", "2");
		params.put("domain_name", "ace2012.aliapp.com");
		params.put("git_url", "test.git.url");
		params.put("start_args", "test_start_args");
		params.put("stop_args", "test_stop_args");
		System.out.println(app.execute(params));
		
		
		//set_app_start_args
		System.out.println("set_app_start_args");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "set_app_start_args");
		params.put("app_id", "4");
		params.put("start_args", "test_start_args_new");
		System.out.println(app.execute(params));
		
		//set_app_stop_args
		System.out.println("set_app_stop_args");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "set_app_stop_args");
		params.put("app_id", "4");
		params.put("stop_args", "stop_args");
		System.out.println(app.execute(params));
		//set_reverse_proxy_quota
		System.out.println("set_reverse_proxy_quota");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "set_reverse_proxy_quota");
		params.put("app_id", "4");
		params.put("min_agent_number", "1");
		params.put("max_agent_number", "2");
		params.put("min_disk_size", "1");
		params.put("max_disk_size", "2");
		params.put("min_mem_size", "1");
		params.put("max_mem_size", "2");
		System.out.println(app.execute(params));
		//set_web_container_quota
		System.out.println("set_web_container_quota");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "set_web_container_quota");
		params.put("app_id", "4");
		params.put("min_agent_number", "1");
		params.put("max_agent_number", "2");
		params.put("min_disk_size", "1");
		params.put("max_disk_size", "2");
		params.put("min_mem_size", "1");
		params.put("max_mem_size", "2");
		params.put("min_cpu_number", "1");
		params.put("max_cpu_number", "2");
		System.out.println(app.execute(params));
		//set_memcache_quota
		System.out.println("set_memcache_quota");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "set_memcache_quota");
		params.put("app_id", "4");
		params.put("min_agent_number", "1");
		params.put("max_agent_number", "2");
		params.put("min_mem_size", "1");
		params.put("max_mem_size", "2");
		System.out.println(app.execute(params));
		//check_app_name
		System.out.println("check_app_name");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "check_app_name");
		params.put("app_name", "testappname");
		System.out.println(app.execute(params));
		//check_app_domain
		System.out.println("check_app_domain");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "check_app_domain");
		params.put("domain_name", "domain_name");
		System.out.println(app.execute(params));
		//build_app
		System.out.println("build_app");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "build_app");
		params.put("app_id", "4");
//		params.put("git_version", "git_version");
		System.out.println(app.execute(params));
		
		//query_build_job
		System.out.println("query_build_job");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "query_build_job");
		params.put("job_id", "4");
		System.out.println(app.execute(params));
		
		//start_app
		System.out.println("start_app");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "start_app");
		params.put("app_id", "4");
		params.put("war_git_url", "war_git_url");
		params.put("war_git_version", "war_git_version");
		System.out.println(app.execute(params));
		
		//stop_app
		System.out.println("stop_app");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "stop_app");
		params.put("app_id", "4");
		System.out.println(app.execute(params));
		//delete_app
		System.out.println("delete_app");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "delete_app");
		params.put("app_id", "nodelete");
		System.out.println(app.execute(params));
		//query_app
		System.out.println("query_app");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "query_app");
		params.put("app_id", "4");
		System.out.println(app.execute(params));
		//query_app_topolgy
		System.out.println("query_app_topolgy");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "query_app_topolgy");
		params.put("app_id", "4");
		System.out.println(app.execute(params));
		//query_reverse_proxy_quota
		System.out.println("query_reverse_proxy_quota");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "query_reverse_proxy_quota");
		params.put("app_id", "4");
		System.out.println(app.execute(params));
		//query_web_container_quota
		System.out.println("query_web_container_quota");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "query_web_container_quota");
		params.put("app_id", "4");
		System.out.println(app.execute(params));	
		//query_memcache_quota
		System.out.println("query_memcache_quota");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "query_memcache_quota");
		params.put("app_id", "4");
		System.out.println(app.execute(params));			
		//query_memcache_info
		System.out.println("query_memcache_info");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "query_memcache_info");
		params.put("app_id", "4");
		System.out.println(app.execute(params));		
		//query_os_monitor
		System.out.println("query_os_monitor");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "query_os_monitor");
		params.put("app_id", "4");
		System.out.println(app.execute(params));	
		//query_jvm_monitor
		System.out.println("query_jvm_monitor");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "query_jvm_monitor");
		params.put("app_id", "4");
		System.out.println(app.execute(params));
		
		//set_reverse_proxy_configuration
		System.out.println("set_reverse_proxy_configuration");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "set_reverse_proxy_configuration");
		params.put("app_id", "4");
		params.put("configuration", "");//yaml格式配置文件  ReadYamlFile.read(this.getClass().getResourceAsStream("config2.yaml"))
		System.out.println(app.execute(params));
		*/
		//test_reverse_proxy_configuration
		System.out.println("test_reverse_proxy_configuration");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "test_reverse_proxy_configuration");
		params.put("app_id", "4");
		params.put("configuration", "configuration");
		System.out.println(app.execute(params));
		/*
		//get_reverse_proxy_configuration
		System.out.println("get_reverse_proxy_configuration");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "get_reverse_proxy_configuration");
		params.put("app_id", "4");
		System.out.println(app.execute(params));	
		//delete_reverse_proxy_configuration
		System.out.println("delete_reverse_proxy_configuration");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "delete_reverse_proxy_configuration");
		params.put("app_id", "4");
		System.out.println(app.execute(params));
		
		//query_net_io
		System.out.println("query_net_io");
		params.clear();
		params.put("user_id", "1");
		params.put("action", "query_net_io");
		params.put("app_id", "4");
		params.put("start_time", String.valueOf(new Date().getTime() - 1000 * 60 * 60));
		params.put("end_time", String.valueOf(new Date().getTime()));
		System.out.println(app.execute(params));

		*/
		
	}
	public static void main(String[] args) throws InvalidKeyException,
			NoSuchAlgorithmException, HttpException, IOException
	{
		ApiDemo app = new ApiDemo();

		app.doTestGroup(app);
	}
}