package org.easybooks.test.model.vo.test2;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class InputFilter implements Filter {
    private FilterConfig config;

    public void init(FilterConfig config) {
        this.config = config;
    }

    public void destroy() {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException,ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8");

        String courseName = request.getParameter("courseName");
//        int credit = Integer.parseInt(request.getParameter("credit"));
        //int period = Integer.parseInt(request.getParameter("period"));
        String assessment = request.getParameter("assessment");
        String term = request.getParameter("term");
        String brief = request.getParameter("brief");
        if (null == courseName) {
            PrintWriter out = response.getWriter();
            out.print("<script language=\"javascript\">alert('输入框不能为空！'); request.getRequestDispatcher(\"addCourse.jsp\").forward(request, response);</script>");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
