package Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(
        filterName = "Filter",
        urlPatterns = {
                "/*"
        }
)
public class AuthenticationFilter implements Filter{
  public void init(FilterConfig config) throws ServletException{
  }

  public void destroy(){
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException{
    HttpServletResponse httpResponse = (HttpServletResponse) response;
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    if(
            httpRequest.getRequestURI().equals("/login")
                    || httpRequest.getSession().getAttribute("user") != null
                    || httpRequest.getRequestURI().contains(".css")
                    || httpRequest.getRequestURI().contains(".jsp")
                    || httpRequest.getRequestURI().contains(".js")
    ){
      chain.doFilter(request, response);
    }else{
      httpResponse.sendRedirect("../../../../../../login");
    }
  }
}
