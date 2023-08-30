package company.friendsdog.dogcommunity.config;

import company.friendsdog.dogcommunity.interceptor.AutoLoginInterceptor;
import company.friendsdog.dogcommunity.interceptor.Interceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class InterCeptorConfig implements WebMvcConfigurer {
  private final AutoLoginInterceptor autoLoginInterceptor;
  private final Interceptor interceptor;
  @Override // 인터셉터 설정 등록
  public void addInterceptors(InterceptorRegistry registry) {

    // 자동 로그인 인터셉터 설정
    registry.addInterceptor(autoLoginInterceptor)
        .addPathPatterns("/**");
    // 게시판 인터셉터 설정
    registry.addInterceptor(interceptor)
            .addPathPatterns("/board/*")  // 어떤 경로에서 인터셉터를 실행할 것인가
            .addPathPatterns("/pet/*");
  }
}

