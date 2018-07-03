package epam.news.config;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private FilterConfig fc;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {
    }
}
