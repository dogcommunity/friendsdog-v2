package company.friendsdog.dogcommunity.interceptor;

import company.friendsdog.dogcommunity.util.LoginUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Configuration
@Slf4j
// BoardInterceptor가 하는일

public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 전처리로 요청이 들어오면 컨트롤러로 가기 전에 로그인을 했는지 검사
        // 로그인을 했는지 확인할 것임.
        // 로그인을 안했으면 로그인페이지로 강제 리다이렉션 할 것임.
        if (!LoginUtil.isLogin(request.getSession())) {
            log.info("this request ( {} ) denied!!", request.getRequestURI());
            response.sendRedirect("/user/login");
            return false;
        }
        log.info("board interceptor pass!!");
        return true;

    }
}
