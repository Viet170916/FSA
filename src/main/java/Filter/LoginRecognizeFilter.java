package Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "LoginRecognizeFilter", urlPatterns = {"/login"})
public class LoginRecognizeFilter implements Filter{
  public void init(FilterConfig config) throws ServletException{
  }

  public void destroy(){
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException{
      HttpServletResponse httpResponse = (HttpServletResponse)response;
      HttpServletRequest httpRequest = (HttpServletRequest)request;
      if(httpRequest.getSession().getAttribute("user") !=null){
          httpResponse.sendRedirect("../");
      }else {
          chain.doFilter(request, response);
      }
  }
}
