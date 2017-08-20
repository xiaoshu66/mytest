package cn.itcast.springboot;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/** 定义ServletInitializer作为web.xml用 */
public class ServletInitializer extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		System.out.println("========");
		/** 设置SpringBoot的启动类 */
		builder.sources(Application.class); 
		/** 设置Banner模式 */
		builder.bannerMode(Mode.OFF);
		/** 返回Spring应用的构建对象 */
		return builder;
	}
}
