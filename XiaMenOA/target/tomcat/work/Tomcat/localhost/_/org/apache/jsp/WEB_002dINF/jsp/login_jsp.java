/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-01-16 15:09:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>登录页面</title>\n");
      out.write("    <!-- Bootstrap Core CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"http://cdn.bootcss.com/font-awesome/4.4.0/css/font-awesome.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"http://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css\">\n");
      out.write("\n");
      out.write("    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("    <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n");
      out.write("    <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("    <script src=\"//cdn.bootcss.com/jquery/2.1.4/jquery.min.js\"></script>\n");
      out.write("    <script src=\"//cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("    html,body{\n");
      out.write("        overflow:hidden;\n");
      out.write("        height:100%;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("<body>\n");
      out.write("<div class=\"container\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-md-4 col-md-offset-4\" style=\"margin: 380px 380px\">\n");
      out.write("            <div class=\"login-panel panel panel-default\"style=\"margin-top:-130px\" >\n");
      out.write("                <div class=\"panel-heading\">\n");
      out.write("                    <h3 class=\"panel-title\" style=\"text-align: center;\">登录</h3>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"panel-body\">\n");
      out.write("                    <form role=\"form\" action=\"#\" method=\"post\" id=\"login_form\">\n");
      out.write("                        <fieldset>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input class=\"form-control\" placeholder=\"用户名\" name=\"username\" autofocus>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input class=\"form-control\" placeholder=\"密码\" name=\"password\" type=\"password\" value=\"\">\n");
      out.write("                            </div>\n");
      out.write("                            <!-- Change this to a button or input when using this as a form -->\n");
      out.write("                            <a href=\"javascript:void(0)\" class=\"btn btn-lg btn-success btn-block\" id='login_btn'>登录</a>\n");
      out.write("                        </fieldset>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("    $(function () {\n");
      out.write("        $(\"#login_btn\").click(function () {\n");
      out.write("            $.ajax({\n");
      out.write("                url:\"/user/checkLogin.do\",\n");
      out.write("                type:\"POST\",\n");
      out.write("                data:$(\"#login_form\").serialize(),\n");
      out.write("                success:function (result) {\n");
      out.write("                    if(result){\n");
      out.write("                        window.location.href= \"/bug/findByPage.do\";\n");
      out.write("                    }else {\n");
      out.write("                        alert(\"账号或密码错误!\");\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
