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

@WebServlet(name = "Controller.FindIdController", urlPatterns = "/FindId")
public class FindIdController extends HttpServlet{
   
   
   
   
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("/WEB-INF/views/findId.jsp").forward(request, response);
   }
   
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      UserDTO userDTO = new UserDTO();
      userDTO.setUser_name(request.getParameter("user_name"));
      userDTO.setUser_phone(request.getParameter("user_phone"));
      
      
      ServletContext application = request.getServletContext();
      FindPasswordService findPasswordService = (FindPasswordService)application.getAttribute("findPasswordService");
      String result = findPasswordService.findId(userDTO);
      
      UserDTO userid = new UserDTO();
      userid.setUser_id(result);
      
      request.setAttribute("userid",userid);
      request.getRequestDispatcher("/WEB-INF/views/findId.jsp").forward(request, response);
      
      
   
   }
   
   
   
}