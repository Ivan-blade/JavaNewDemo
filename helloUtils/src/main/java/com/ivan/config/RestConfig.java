package com.ivan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Configuration
public class RestConfig {

//    @Bean
    public RestTemplate normal() {
        return new RestTemplate();
    }

    // 解决中文乱码
    @Bean
    public RestTemplate noConfusionChinese() {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> list = restTemplate.getMessageConverters();
        for (HttpMessageConverter<?> httpMessageConverter : list) {
            if(httpMessageConverter instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter) httpMessageConverter).setDefaultCharset(StandardCharsets.UTF_8);
                break;
            }
        }
        return restTemplate;
    }

    // 添加代理
//    @Bean
    public RestTemplate proxy(String ip,int port) {
        RestTemplate restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setProxy(new Proxy(Proxy.Type.HTTP,new InetSocketAddress(ip,port)));
        restTemplate.setRequestFactory(simpleClientHttpRequestFactory);
        return restTemplate;
    }

    // 请求绕过证书认证
//    @Bean
    public RestTemplate disableSsl() {
        HostnameVerifier PROMISCUOUS_VERIFIER = (s, sslSession ) -> true;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory( new SimpleClientHttpRequestFactory() {
            @Override
            protected void prepareConnection(HttpURLConnection connection, String httpMethod) throws IOException {
                if(connection instanceof HttpsURLConnection){
                    ((HttpsURLConnection) connection).setHostnameVerifier(PROMISCUOUS_VERIFIER);
                }
                super.prepareConnection(connection, httpMethod);
            }
        });
        return restTemplate;
    }

    // 使用代理并绕过证书认证
//    @Bean
    public RestTemplate proxyDisableSsl(String ip,int port) {
        HostnameVerifier PROMISCUOUS_VERIFIER = (s, sslSession ) -> true;
        RestTemplate restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory(){
            @Override
            protected void prepareConnection(HttpURLConnection connection, String httpMethod) throws IOException {
                if(connection instanceof HttpsURLConnection){
                    ((HttpsURLConnection) connection).setHostnameVerifier(PROMISCUOUS_VERIFIER);
                }
                super.prepareConnection(connection, httpMethod);
            }
        };
        simpleClientHttpRequestFactory.setProxy(new Proxy(Proxy.Type.HTTP,new InetSocketAddress(ip,port)));
        restTemplate.setRequestFactory(simpleClientHttpRequestFactory);
        return restTemplate;
    }

}