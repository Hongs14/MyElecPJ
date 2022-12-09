package Controller.user;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.user.UserDTO;
import service.FindPasswordService;

@WebServlet(name = "Controller.FindPasswordController", urlPatterns = "/FindPassword")
public class FindPasswordController extends HttpServlet{
   
   
   
   
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("/WEB-INF/views/findPassword.jsp").forward(request, response);
   }
   
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      UserDTO userDTO = new UserDTO();
      userDTO.setUser_id(request.getParameter("user_id"));
      userDTO.setUser_phone(request.getParameter("user_phone"));
      
      ServletContext application = request.getServletContext();
      FindPasswordService findPasswordService = (FindPasswordService)application.getAttribute("findPasswordService");
      String result = findPasswordService.findPassword(userDTO);
      
      UserDTO password = new UserDTO();
      password.setUser_password(result);
      
      request.setAttribute("password",password);
      request.getRequestDispatcher("/WEB-INF/views/findPassword.jsp").forward(request, response);
      
      
   
   }
   
   
   
}