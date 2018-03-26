package cn.springmvc.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


public class HttpUtils {

	private static CloseableHttpClient httpclient;

	static {
		PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
		manager.setMaxTotal(200); //连接池最大并发连接数
		manager.setDefaultMaxPerRoute(200);//单路由最大并发数,路由是对maxTotal的细�?
		httpclient = HttpClients.custom().setConnectionManager(manager).build();
	}

	/* ConnectionRequestTimeout httpclient使用连接池来管理连接，这个时间就是从连接池获取连接的超时时间，可以想象下数据库连接池
	   ConnectTimeout 建立连接�?大时�?
	   SocketTimeout 数据传输过程中数据包之间间隔的最大时�?
	   HttpHost 代理
	 */
	private static RequestConfig config = RequestConfig.copy(RequestConfig.DEFAULT)
			 .setSocketTimeout(10000)
			 .setConnectTimeout(5000)
			 .setConnectionRequestTimeout(100).build();
			//.setProxy(new HttpHost("127.0.0.1", 8888, "http")).build();

	public static String doGet(String url) throws HttpClientException {
		return doGet(url, null);
	}

	public static String doGet(String url, Map<String, Object> header) throws HttpClientException {
		String ret = "";
		HttpGet get = new HttpGet(url);
		get.setConfig(config);
		get.addHeader(HTTP.CONTENT_ENCODING, "UTF-8");
		CloseableHttpResponse closeableHttpResponse = null;
		try {
			if (header != null) {
				for (Map.Entry<String, Object> entry : header.entrySet()) {
					get.setHeader(entry.getKey(), entry.getValue().toString());
				}
			}
			closeableHttpResponse = httpclient.execute(get);
			if (closeableHttpResponse.getStatusLine().getStatusCode() == 200) {
				ret = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			} else {
				throw new HttpClientException(
						"System level error, Code=[" + closeableHttpResponse.getStatusLine().getStatusCode() + "].");
			}
		} catch (ClientProtocolException e) {
			throw new HttpClientException("HttpClient error," + e.getMessage());
		} catch (IOException e) {
			throw new HttpClientException("IO error," + e.getMessage());
		} finally {
			if (closeableHttpResponse != null) {
				try {
					closeableHttpResponse.close();
				} catch (IOException e) {
				}
			}
		}
		return ret;
	}

	public static String doPostString(String url, String params, String regx) throws HttpClientException {
		Map<String, Object> paramsMp =null;
		if(params!=null) {
		    paramsMp = new HashMap<String, Object>();
			String[] strp = params.split(regx);
			for (int i = 0; i < strp.length; i++) {
				String singleparms = strp[i];
				String[] key_values = singleparms.split("=");
				paramsMp.put(key_values[0], key_values[1]);
			}
		}
		return doPost(url, paramsMp);
	}
	
	
	public static String doPost(String url, Map<String, Object> params) throws HttpClientException {
		return doPost(url, params, null);
	}

	public static String doPost(String url, Map<String, Object> params, Map<String, Object> header)
			throws HttpClientException {
		String ret = "";
		HttpPost post = new HttpPost(url);
		post.setConfig(config);
		post.addHeader(HTTP.CONTENT_ENCODING, "UTF-8");
		CloseableHttpResponse closeableHttpResponse = null;
		HttpEntity postEntity = null;
		try {
			if (params != null) {
				List<NameValuePair> list = new ArrayList<NameValuePair>();
				for (Map.Entry<String, Object> entry : params.entrySet()) {
					list.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
				}
				postEntity = new UrlEncodedFormEntity(list,"UTF-8");
				post.setEntity(postEntity);
			}

			if (header != null) {
				for (Map.Entry<String, Object> entry : header.entrySet()) {
					post.setHeader(entry.getKey(), entry.getValue().toString());
				}
			}
			closeableHttpResponse = httpclient.execute(post);
			if (closeableHttpResponse.getStatusLine().getStatusCode() == 200) {
				ret = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			} else {
				throw new HttpClientException(
						"System level error, Code=[" + closeableHttpResponse.getStatusLine().getStatusCode() + "].");
			}
		} catch (ClientProtocolException e) {
			throw new HttpClientException("HttpClient error," + e.getMessage());
		} catch (IOException e) {
			throw new HttpClientException("IO error," + e.getMessage());
		} finally {
			if (postEntity != null) {
				try {
					EntityUtils.consume(postEntity);
				} catch (IOException e) {
				}
			}
			if (closeableHttpResponse != null) {
				try {
					closeableHttpResponse.close();
				} catch (IOException e) {
				}
			}
		}
		return ret;
	}

	public static String doPostJson(String url, String jsonParam) throws HttpClientException {
		return doPostJson(url, jsonParam, null);
	}

	public static String doPostJson(String url, String jsonParam, Map<String, Object> header)
			throws HttpClientException {
		String ret = "";
		HttpPost post = new HttpPost(url);
		post.setConfig(config);
		post.addHeader(HTTP.CONTENT_ENCODING, "UTF-8");
		CloseableHttpResponse closeableHttpResponse = null;
		StringEntity postEntity = null;
		try {
			if (jsonParam != null) {
				postEntity = new StringEntity(jsonParam, "utf-8");// ���������������?
				postEntity.setContentEncoding("UTF-8");
				postEntity.setContentType("application/json");
				post.setEntity(postEntity);
			}

			if (header != null) {
				for (Map.Entry<String, Object> entry : header.entrySet()) {
					post.setHeader(entry.getKey(), entry.getValue().toString());
				}
			}
			closeableHttpResponse = httpclient.execute(post);
			if (closeableHttpResponse.getStatusLine().getStatusCode() == 200) {
				ret = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			} else {
				throw new HttpClientException(
						"System level error, Code=[" + closeableHttpResponse.getStatusLine().getStatusCode() + "].");
			}
		} catch (ClientProtocolException e) {
			throw new HttpClientException("HttpClient error," + e.getMessage());
		} catch (IOException e) {
			throw new HttpClientException("IO error," + e.getMessage());
		} finally {
			if (postEntity != null) {
				try {
					EntityUtils.consume(postEntity);
				} catch (IOException e) {
				}
			}
			if (closeableHttpResponse != null) {
				try {
					closeableHttpResponse.close();
				} catch (IOException e) {
				}
			}
		}
		return ret;
	}

	public static String doUpload(String url, File file) throws HttpClientException {
		return doUpload(url, file,null,null);
	}
	
	public static String doUpload(String url, File file, Map<String, Object> params) throws HttpClientException {
		return doUpload(url, file,params,null);
	}

	public static String doUpload(String url, File file, Map<String, Object> params, Map<String, Object> header)
			throws HttpClientException {
		String ret = "";
		HttpPost post = new HttpPost(url);
		post.setConfig(config);
		post.addHeader(HTTP.CONTENT_ENCODING, "UTF-8");
		CloseableHttpResponse closeableHttpResponse = null;
		try {
			MultipartEntityBuilder mEntityBuilder = MultipartEntityBuilder.create();
			mEntityBuilder.addBinaryBody("file", file);
			if (params != null) {
				for (Map.Entry<String, Object> entry : params.entrySet()) {
					mEntityBuilder.addTextBody(entry.getKey(), entry.getValue().toString());
				}
			}
			post.setEntity(mEntityBuilder.build());

			if (header != null) {
				for (Map.Entry<String, Object> entry : header.entrySet()) {
					post.setHeader(entry.getKey(), entry.getValue().toString());
				}
			}
			closeableHttpResponse = httpclient.execute(post);
			if (closeableHttpResponse.getStatusLine().getStatusCode() == 200) {
				ret = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			} else {
				throw new HttpClientException(
						"System level error, Code=[" + closeableHttpResponse.getStatusLine().getStatusCode() + "].");
			}
		} catch (ClientProtocolException e) {
			throw new HttpClientException("HttpClient error," + e.getMessage());
		} catch (IOException e) {
			throw new HttpClientException("IO error," + e.getMessage());
		} finally {
			if (closeableHttpResponse != null) {
				try {
					closeableHttpResponse.close();
				} catch (IOException e) {
				}
			}
		}
		return ret;
	}
	
	
	public static void doDown(String url, File descFile) throws HttpClientException {
		doDown(url,null,descFile);
	}
	
	public static void doDown(String url, Map<String, Object> header, File descFile) throws HttpClientException {
		HttpPost post = new HttpPost(url);
		post.setConfig(config);
		post.addHeader(HTTP.CONTENT_ENCODING, "UTF-8");
		CloseableHttpResponse closeableHttpResponse = null;
		try {
			if (header != null) {
				for (Map.Entry<String, Object> entry : header.entrySet()) {
					post.setHeader(entry.getKey(), entry.getValue().toString());
				}
			}
			closeableHttpResponse = httpclient.execute(post);
			if (closeableHttpResponse.getStatusLine().getStatusCode() == 200) {
				FileUtils.copyToFile(closeableHttpResponse.getEntity().getContent(), descFile);
				//ret = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			} else {
				throw new HttpClientException(
						"System level error, Code=[" + closeableHttpResponse.getStatusLine().getStatusCode() + "].");
			}
		} catch (ClientProtocolException e) {
			throw new HttpClientException("HttpClient error," + e.getMessage());
		} catch (IOException e) {
			throw new HttpClientException("IO error," + e.getMessage());
		} finally {
			if (closeableHttpResponse != null) {
				try {
					closeableHttpResponse.close();
				} catch (IOException e) {
				}
			}
		}
	}


	public static void main(String[] args) {
		
		// try {
		// String result =
		// doGet("http://123.58.251.183:8080/goods/UserServlet?method=loginMobile&loginname=test1&loginpass=test1");
		// System.out.println(result);
		// } catch (HttpClientException e) {
		// e.printStackTrace();
		// }
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("method", "loginMobile");
//		params.put("loginname", "test1");
//		params.put("loginpass", "test1");

//		try {
//			String result = doPost("http://123.58.251.183:8080/goods/UserServlet", params);
//			System.out.println(result);
//			TestResult resultobj = JSON.parseObject(result, TestResult.class);
//			System.out.println(resultobj);
//		} catch (HttpClientException e) {
//			e.printStackTrace();
//		}
	}

}
