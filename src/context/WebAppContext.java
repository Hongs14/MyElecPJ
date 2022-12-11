package context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import dao.CartDAO;
import dao.CategoryDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import dao.QnABoardDAO;
import dao.ReviewBoardDAO;
import dao.SubCategoryDAO;
import dao.UserDAO;
import service.AdminDeleteUserService;
import service.AdminUserService;
import service.CreateCartService;
import service.CreateOrderService;
import service.CreateQnAService;
import service.CreateReviewService;
import service.DeleteCartService;
import service.DeleteOrderService;
import service.DeleteQnaService;
import service.FindPasswordService;
import service.JoinService;
import service.LoginService;
import service.ReadCartService;
import service.ReadOrderListService;
import service.ReadOrderService;
import service.ReadProductDetailService;
import service.ReadProductListService;
import service.ReadQnABoardListService;
import service.ReadQnADetailService;
import service.ReadReviewBoardListService;
import service.ReadReviewDetailService;
import service.UpdateCartService;
import service.UpdateOrderService;
import service.UpdateQnAService;
import service.UpdateUserService;
import service.UserInfoService;

public class WebAppContext implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		DataSource dataSource = ConnectionProvider.getDataSource();
		application.setAttribute("dataSource", dataSource);
		
		application.setAttribute("cartDAO", new CartDAO());
		application.setAttribute("categoryDAO", new CategoryDAO());
		application.setAttribute("orderDAO", new OrderDAO());
		application.setAttribute("productDAO", new ProductDAO());
		application.setAttribute("QnABoardDAO", new QnABoardDAO());
		application.setAttribute("reviewBoardDAO", new ReviewBoardDAO());
		application.setAttribute("subCategoryDAO", new SubCategoryDAO());
		application.setAttribute("userDAO", new UserDAO());
		

		application.setAttribute("adminUserService", new AdminUserService(application));
		application.setAttribute("adminDeleteUserService", new AdminDeleteUserService(application));
		application.setAttribute("findPasswordService", new FindPasswordService(application));
		application.setAttribute("joinService", new JoinService(application));
		application.setAttribute("loginService", new LoginService(application));
		application.setAttribute("userInfoService", new UserInfoService(application));
		
		application.setAttribute("createCartService", new CreateCartService(application));
		application.setAttribute("createOrderService", new CreateOrderService(application));
		application.setAttribute("createQnAService", new CreateQnAService(application));
		application.setAttribute("createReviewService", new CreateReviewService(application));	
		
		application.setAttribute("deleteCartService", new DeleteCartService(application));
		application.setAttribute("deleteOrderService", new DeleteOrderService(application));
		application.setAttribute("deleteQnaService", new DeleteQnaService(application));
		
		application.setAttribute("readCartService", new ReadCartService(application));
		application.setAttribute("readOrderService", new ReadOrderService(application));
		application.setAttribute("readOrderListService", new ReadOrderListService(application));
		application.setAttribute("readProductDetailService", new ReadProductDetailService(application));
		application.setAttribute("readProductListService", new ReadProductListService(application));
		application.setAttribute("readQnABoardListService", new ReadQnABoardListService(application));
		application.setAttribute("readQnADetailService", new ReadQnADetailService(application));
		application.setAttribute("readReviewBoardListService", new ReadReviewBoardListService(application));
		application.setAttribute("readReviewDetailService", new ReadReviewDetailService(application));
		
		application.setAttribute("updateCartService", new UpdateCartService(application));
		application.setAttribute("updateOrderService", new UpdateOrderService(application));
		application.setAttribute("updateUserService", new UpdateUserService(application));
		application.setAttribute("updateQnAService", new UpdateQnAService(application));
	}
}
