package com.ivan.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author hylu.ivan
 * @date 2022/6/27 下午9:48
 * @description
 */
@Service
public class RestUtils {

    @Autowired
    private RestTemplate restTemplate;


    public String doGet(String url) {
        //设置get请求参数
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();

        //设置请求头参数
        // HashMap是以请求体传递，MultiValueMap是表单传递，主要看后来是怎么接收的来选择怎么传递
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("accept", "application/json, text/plain, */*");
        requestHeaders.add("accept-encoding", "gzip, deflate, br");
        requestHeaders.add("accept-language", "zh-CN,zh;q=0.9");
        requestHeaders.add("cookie", "XSRF-TOKEN=7l8iVbK4QTdtHvbdIEc0onEC; _s_tentry=weibo.com; Apache=7606332268244.875.1635152057745; SINAGLOBAL=7606332268244.875.1635152057745; ULV=1635152057760:1:1:1:7606332268244.875.1635152057745:; wb_view_log_6470542000=1920*10801; SUB=_2AkMWKh1kf8NxqwJRmPEUzGnlaIl2zQjEieKgduy_JRMxHRl-yT9jqk49tRB6Paozi4PZAFkXq1zHRjc04qrK3KhtG-1i; SUBP=0033WrSXqPxfM72-Ws9jqgMF55529P9D9WhcTdw0zAUCixRLcdW4TMkl; WBPSESS=IawIaCISeX-46VmeRocrJxcqdZHz-W-8T53YAjA36uvh5WIUxPJ1G7yiSNFrgzVkdsyfFHbdehEcetsSUZv3-pZEb0-MmfkJtbUPDGkc_ScANXNkozAKicK40_MWhw3y; WBPSESS=IawIaCISeX-46VmeRocrJxcqdZHz-W-8T53YAjA36uuNO-Eje0X1Qm2jewqmK4MGKvrH-PwcYOwIS_Wr9Z4G7Gyvp_rJerhNbdJXxdj3otfqZAF47SGVDWhlLL7UIndn");
        requestHeaders.add("referer", "https://weibo.com/u/1259110474");
        requestHeaders.add("sec-fetch-dest", "empty");
        requestHeaders.add("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        requestHeaders.add("sec-fetch-mode", "cors");
        requestHeaders.add("sec-fetch-site", "same-origin");
        requestHeaders.add("traceparent", "00-69f18bdc3bb649ad16f63993de15a658-567b8f4f09af6305-00");
        requestHeaders.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64); AppleWebKit/537.36 (KHTML, like Gecko); Chrome/81.0.4021.2 Safari/537.36");
        requestHeaders.add("x-requested-with", "XMLHttpRequest");
        requestHeaders.add("x-xsrf-token", "7l8iVbK4QTdtHvbdIEc0onEC");


        HttpEntity request = new HttpEntity(requestHeaders);
//        HttpEntity request = new HttpEntity(params,requestHeaders);

        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET,request, String.class);
        return exchange.toString();
    }

    public String doPost(String url) {
        //设置post请求参数
        // HashMap是以请求体传递，MultiValueMap是表单传递，主要看后来是怎么接收的来选择怎么传递
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("cb","gen_callback");
        params.add("fp","%7B%22os%22%3A%221%22%2C%22browser%22%3A%22Gecko89%2C0%2C0%2C0%22%2C%22fonts%22%3A%22undefined%22%2C%22screenInfo%22%3A%221920*1080*24%22%2C%22plugins%22%3A%22%22%7D");

        //设置请求头参数
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Host", "passport.weibo.com");
        requestHeaders.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:89.0); Gecko/20100101 Firefox/89.0");
        requestHeaders.add("Accept", "*/*");
        requestHeaders.add("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
        requestHeaders.add("Accept-Encoding", "gzip, deflate, br");
        requestHeaders.add("Content-Type", "application/x-www-form-urlencoded");
        requestHeaders.add("If-Modified-Since", "0");
        requestHeaders.add("Content-Length", "184");
        requestHeaders.add("Connection", "keep-alive");
        requestHeaders.add("Pragma", "no-cache");
        requestHeaders.add("Cache-Control", "no-cache");


        HttpEntity request = new HttpEntity(params,requestHeaders);

        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST,request, String.class);
        String body = exchange.toString();
        return body;
    }
}
