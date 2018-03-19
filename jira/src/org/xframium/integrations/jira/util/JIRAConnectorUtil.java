package org.xframium.integrations.jira.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.json.JSONObject;
import org.xframium.integrations.jira.HTTPMethod;
/**
 * Util class.
 *
 */
public class JIRAConnectorUtil {

	/**
	 * Used for creating an instance of HttpURLConnection
	 * @param url
	 * @param credentials
	 * @param useProxy
	 * @param proxy
	 * @return
	 * @throws IOException
	 */
	public static HttpURLConnection getHttpURLConnection(final String url,HTTPMethod method,  String credentials, boolean useProxy, Proxy proxy)
			throws IOException {
		HttpURLConnection httpCon = createHttpCon(url, method.getValue(), credentials, useProxy, proxy);
		return httpCon;
	}
	
	
	/**
	 * Used for creating an instance of HttpsURLConnection
	 * @param url
	 * @param credentials
	 * @param useProxy
	 * @param proxy
	 * @return
	 * @throws IOException
	 */
	public static HttpsURLConnection getHttpsURLConnection(final String url,HTTPMethod method,  String credentials, boolean useProxy, Proxy proxy)
			throws Exception {
		HttpsURLConnection httpsCon = createHttpsCon(url, method.getValue(), credentials, useProxy, proxy);
		return httpsCon;
	}

	/**
	 * used to read the JSOS response as a String
	 * @param httpCon
	 * @return
	 * @throws Exception
	 */
	public static String httpGetJSONString(InputStream inputStream) throws Exception {

		final BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

		final StringBuffer httpResponse = new StringBuffer();
		String line = "";
		while (null != (line = br.readLine())) {
			httpResponse.append(line);
		}

		return httpResponse.toString();
	}

	/**
	 * 
	 * @param url
	 * @param method
	 * @param credentials
	 * @param useProxy
	 * @param proxy
	 * @return
	 * @throws IOException
	 */
	private static HttpURLConnection createHttpCon(final String url, final String method, String credentials, boolean useProxy,
			Proxy proxy) throws IOException {
		final HttpURLConnection httpCon;
		if (useProxy) {
			httpCon = (HttpURLConnection) new URL(url).openConnection(proxy);
		} else {
			httpCon = (HttpURLConnection) new URL(url).openConnection();
		}

		httpCon.setDoOutput(true);
		httpCon.setRequestMethod(method);

		if (!credentials.isEmpty()) {
			final String encoding = new Base64().encodeToString(credentials.getBytes());
			httpCon.setRequestProperty("Authorization", "Basic " + encoding);
		}

		httpCon.setRequestProperty("Content-type", "application/json");

		return httpCon;
	}
	
	
	
	/**
	 * created HttpsURLConnection
	 * @param url
	 * @param method
	 * @param credentials
	 * @param useProxy
	 * @param proxy
	 * @return
	 * @throws IOException
	 */
	private static HttpsURLConnection createHttpsCon(final String url, final String method, String credentials, boolean useProxy,
			Proxy proxy) throws Exception {
		HttpsURLConnection.setDefaultSSLSocketFactory(getMockCertificate().getSocketFactory());
		
		final HttpsURLConnection httpsCon;
		if (useProxy) {
			httpsCon = (HttpsURLConnection) new URL(url).openConnection(proxy);
		} else {
			httpsCon = (HttpsURLConnection) new URL(url).openConnection();
		}

		httpsCon.setDoOutput(true);
		httpsCon.setRequestMethod(method);

		if (!credentials.isEmpty()) {
			final String encoding = new Base64().encodeToString(credentials.getBytes());
			httpsCon.setRequestProperty("Authorization", "Basic " + encoding);
		}

		httpsCon.setRequestProperty("Content-type", "application/json");
		

		return httpsCon;
	}
	
	
	/**
	 * Create POST request
	 * @param url
	 * @param credentials
	 * @return HttpPost
	 */
	public static HttpPost getHttpPostRequest(String url, String credentials){
		HttpPost postRequest = new HttpPost(url);
        String encoding = new String(Base64.encodeBase64((credentials).getBytes()));
        postRequest.setHeader("Authorization", "Basic " + encoding);
		
        return postRequest;
	}
	
	/**
	 * Create PUT request
	 * @param url
	 * @param credentials
	 * @return HttpPost
	 */
	public static HttpPut getHttpPutRequest(String url, String credentials){
		HttpPut postRequest = new HttpPut(url);
        String encoding = new String(Base64.encodeBase64((credentials).getBytes()));
        postRequest.setHeader("Authorization", "Basic " + encoding);
		
        return postRequest;
	}
	
	/**
	 * Removes null values
	 * @param jsonBody
	 * @return
	 */
	public static String removeNullValues(String jsonBody){
		JSONObject jsonObject = new JSONObject(jsonBody);
		JSONObject data = null;
	
		
		Iterator<String> jsonObjIterator = jsonObject.keys();
		
		while(jsonObjIterator.hasNext()){
			data = (JSONObject)jsonObject.get(jsonObjIterator.next());
		}
		
		Iterator<String> dataIterator = data.keys();
		Set<String> nullDataKeys = new HashSet<String>();
		while(dataIterator.hasNext()){
			String dataKey = dataIterator.next();
			if(data.get(dataKey).equals("null")){
				nullDataKeys.add(dataKey);
			}
		}
		
		for(String nullDataKey: nullDataKeys){
			data.remove(nullDataKey);
		}
		
		return data.toString();
	}
	
	/**
	 * Returns a mock certificate
	 * @return
	 */
	public static SSLContext getMockCertificate() throws Exception{
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {

				@Override
				public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
				}
	
				@Override
				public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
	
				}
	
				@Override
				public X509Certificate[] getAcceptedIssuers() {
					return new X509Certificate[0];
				}

		}};
		
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		
		return sc;
		
	}
	
    
    
    

}
