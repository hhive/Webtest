<%@ page import="org.easybooks.test.model.vo.User" %>
<%@ page import="org.easybooks.test.model.vo.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.ListIterator" %><%--
  Created by IntelliJ IDEA.
  User: JAX
  Date: 2018/9/15
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>findSuccess</title>
</head>
<body>

<h1>
    <%
        User user = (User)session.getAttribute("user");
        out.print(user.getName() + ",找到了你需要的书籍");
    %>
</h1>
<hr>
<h3>
   <%
       ArrayList<Book> arrayList = (ArrayList)session.getAttribute("bookList");
        Book book = null;
       ListIterator ite = arrayList.listIterator();
       while (ite.hasNext()) {
           book = (Book)ite.next();
           out.print("书名：" + book.getTitle() + "<br>" + "价格：" + book.getPrice());
           out.print("<br>");
           out.print("<br>");
       }
//       ListIterator it = bookList.listIterator();
//       while (it.hasNext()) {
//           book = (Book)it.next();
//           System.out.println(book.getTitle() + "," + book.getPrice());
//       }
//       for (int i = 0; i < bookList.size(); i++) {
//           book = bookList.get(i);
//           System.out.println(book.getTitle() + "," + book.getPrice());
//       }
//       for (Book book1 : bookList) {
//           System.out.println(book.getTitle() + "," + book.getPrice());
//       }
   %>
</h3>
<hr>
<h2>
    <a href="main.jsp">返回主页</a>
</h2>
</body>
</html>
