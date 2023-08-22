package Filter.Decentrailization;

import Models.Entities.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "AdminFilter", urlPatterns = {"/admin/*"})
public class AdminFilter implements Filter{
  public void init(FilterConfig config) throws ServletException{
  }

  public void destroy(){
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException{
    HttpServletRequest httpServletRequest = (HttpServletRequest)request;
    HttpServletResponse httpServletResponse = (HttpServletResponse)response;
    if(((User)httpServletRequest.getSession().getAttribute("user")).getIsAdmin()){
      chain.doFilter(request, response);

    }else {
      httpServletResponse.sendRedirect("../../../../../../../../");
    }
  }
}
