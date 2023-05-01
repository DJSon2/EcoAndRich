package com.dongin.ecoandrich1.publicApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PublicDataApiController {

	private static final Logger log = LoggerFactory.getLogger(PublicDataApiController.class);
	
	@GetMapping("/api/data2")
	public String getData2(@RequestParam String sidoName) throws IOException {
		
	    StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty"); /*URL*/
	    urlBuilder.append("?" + URLEncoder.encode("sidoName","UTF-8") + "=" + URLEncoder.encode(sidoName, "UTF-8")); /* 위치 */
	    urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호(조회 날짜로 검색 시 사용 안함)*/
	    urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수(조회 날짜로 검색 시 사용 안함)*/
	    urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*xml 또는 json*/
	    urlBuilder.append("&" + URLEncoder.encode("serviceKey","UTF-8") + "=" + ""); /*Service Key*/
	    urlBuilder.append("&" + URLEncoder.encode("ver","UTF-8") + "=" + URLEncoder.encode("1.0", "UTF-8")); /* version */

	    log.info("[PublicDataApiController] urlBuilder 데이터 확인 : " + urlBuilder);

	    URL url = new URL(urlBuilder.toString());
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    conn.setRequestProperty("Content-type", "application/json");
	    System.out.println("Response code: " + conn.getResponseCode());

	    BufferedReader rd;
	    if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	        rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    } else {
	        rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	    }

	    log.info("[PublicDataApiController] rd 데이터 확인 : " + rd);
	    
	    StringBuilder sb = new StringBuilder();
	    String line;
	    
	    while ((line = rd.readLine()) != null) {
	        sb.append(line);
	    }
	    rd.close();
	    conn.disconnect();
	    System.out.println("sb.toString() 로그 : " + sb.toString());
	    
	    JSONObject result = new JSONObject(sb.toString());
	    JSONArray items = result.getJSONObject("response").getJSONObject("body").getJSONArray("items");
	    
	    log.info("[PublicDataApiController] result 데이터 확인 : " + result);
	    log.info("[PublicDataApiController] items 데이터 확인 : " + items);
	    return items.toString();
	}
	
}
