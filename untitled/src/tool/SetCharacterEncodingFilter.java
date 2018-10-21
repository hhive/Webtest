//package tool;
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//
//public class SetCharacterEncodingFilter implements Filter{
//    FilterConfig config=null;
//    public void init(FilterConfig config) throws ServletException{
//
//        this.config=config;
//    }
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
//        String encoding=config.getInitParameter("gbk");
//        //System.out.println("过滤器1请求处理开始");
//        request.setCharacterEncoding(encoding);
//        response.setCharacterEncoding(encoding);
//        chain.doFilter(request,response);
//        //System.out.println("过滤器1响应处理开始");
//    }
//    public void destroy(){
//
//    }
//
//
//}