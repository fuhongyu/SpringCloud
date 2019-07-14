package cn.tedu.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component		//让这个类生效，告诉底层它要处理
public class HelloFallback implements FallbackProvider{

	@Override
	public String getRoute() {
		return "*";
	}

	@Override	//失败后返回什么信息
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		return new ClientHttpResponse() {	//匿名内部类，java特殊写法，它没名字，私有，只在这里执行
			
			@Override	//网页头信息
			public HttpHeaders getHeaders() {
				//创建一个头信息
				HttpHeaders header = new HttpHeaders();
				//设置返回格式：json字符串，中文utf-8
				header.setContentType(MediaType.APPLICATION_JSON_UTF8);
				return header;
			}
			
			@Override	//网页内容
			public InputStream getBody() throws IOException {
				//返回信息
				String msg = "4599";
				//创建一个字节数组的输入流
				return new ByteArrayInputStream(msg.getBytes()) ;
			}
			
			@Override	//状态文字
			public String getStatusText() throws IOException {
				return HttpStatus.BAD_REQUEST.toString();
			}
			
			@Override	//状态码对象
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.BAD_REQUEST;
			}
			
			@Override	//具体状态码
			public int getRawStatusCode() throws IOException {
				return HttpStatus.BAD_REQUEST.value();
			}
			
			@Override	//释放资源
			public void close() {
				// TODO Auto-generated method stub
				
			}
		};
	}

}
