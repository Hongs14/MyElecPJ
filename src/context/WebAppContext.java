package context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dao.CartDAO;
import dao.CategoryDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import dao.QnABoardDAO;
import dao.ReviewBoardDAO;
import dao.SubCategoryDAO;
import dao.UserDAO;
import service.BoardListService;
import service.CartService;
import service.CreateQnAService;
import service.CreateReviewService;
import service.FindPasswordService;
import service.JoinService;
import service.LoginService;
import service.ProductDetailService;
import service.ProductListService;
import service.ReadReviewService;
import service.ReviewboardListService;
import service.UpdateUserService;

public class WebAppContext implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("WebApplication(ServletContext) 생성 완료");
		
		ServletContext application = sce.getServletContext();
		
		//ServletContext 객체에 데이터 저장
//		application.setAttribute("adminService", new AdminService(application));
//		application.setAttribute("adminListService", new AdminListService(application));
		application.setAttribute("QnAboardListService", new BoardListService(application));
		application.setAttribute("createQnAService", new CreateQnAService(application));
		application.setAttribute("reviewboardListService", new ReviewboardListService(application));
		application.setAttribute("createReviewService", new CreateReviewService(application));
		application.setAttribute("readReviewService", new ReadReviewService(application));
		application.setAttribute("cartService", new CartService(application));
//		application.setAttribute("orderService", new OrderService(application));
//		application.setAttribute("orderListService", new OrderListService(application));
		application.setAttribute("productDetailService", new ProductDetailService(application));
		application.setAttribute("productListService", new ProductListService(application));
		application.setAttribute("findPasswordService", new FindPasswordService(application));
		application.setAttribute("joinService", new JoinService(application));
		application.setAttribute("loginService", new LoginService(application));
		application.setAttribute("updateUserService", new UpdateUserService(application));
//		application.setAttribute("userInfoService", new UserInfoService(application));
//		application.setAttribute("homeService", new HomeService(application));

		application.setAttribute("cartDAO", new CartDAO());
		application.setAttribute("categoryDAO", new CategoryDAO());
		application.setAttribute("orderDAO", new OrderDAO());
		application.setAttribute("productDAO", new ProductDAO());
		application.setAttribute("QnABoardDAO", new QnABoardDAO());
		application.setAttribute("reviewBoardDAO", new ReviewBoardDAO());
		application.setAttribute("subCategoryDAO", new SubCategoryDAO());
		application.setAttribute("userDAO", new UserDAO());
	}
}
