package org.easybooks.test.servlet;

import org.easybooks.test.jdbc.SqlSrvDBConn;
import org.easybooks.test.model.vo.test2.Course;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import java.io.IOException;

public class AddCourseServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        request.setCharacterEncoding("utf-8");
        String courseName = request.getParameter("courseName");
        double credit = Double.parseDouble(request.getParameter("credit"));
        int period = Integer.parseInt(request.getParameter("period"));
        String assessment = request.getParameter("assessment");
        String term = request.getParameter("term");
        String brief = request.getParameter("brief");
        SqlSrvDBConn srvDBConn = new SqlSrvDBConn();
        HttpSession session = request.getSession();
        Course course = null;
        course = (Course)session.getAttribute("course");
        String sql = "insert into addCourse(courseName,credit,period,assessment,term,brief) values " +
                "('" + courseName + "','" + credit + "','" + period + "','" + assessment + "','" + term + "','" + brief + "')";
        if (srvDBConn.executeUpdate(sql) ==0) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            if (null == course) {
                course = new Course();
                course.setCourseName(courseName);
                course.setCredit(credit);
                course.setPeriod(period);
                course.setAssessment(assessment);
                course.setTerm(term);
                course.setBrief(brief);
                session.setAttribute("course",course);
            }
            response.sendRedirect("success.jsp");
        }
        srvDBConn.closeStmt();
        srvDBConn.closeConn();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        doGet(request,response);
    }
}
