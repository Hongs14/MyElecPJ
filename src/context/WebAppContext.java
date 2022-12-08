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
import service.CreateQnAService;
import service.ReadReviewService;
import service.UserInfoService;
import service.deprecated.BoardListService;
import service.deprecated.CartService;
import service.deprecated.CreateReviewService;
import service.deprecated.FindPasswordService;
import service.deprecated.JoinService;
import service.deprecated.LoginService;
import service.deprecated.ProductDetailService;
import service.deprecated.ProductListService;
import service.deprecated.ReviewboardListService;
import service.deprecated.UpdateUserService;

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
		
		//ServletContext 객체에 데이터 저장
//		application.setAttribute("adminService", new AdminService(application));
//		application.setAttribute("adminListService", new AdminListService(application));
		application.setAttribute("adminUserService", new AdminUserService(application));
		application.setAttribute("adminDeleteUserService", new AdminDeleteUserService(application));
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
		application.setAttribute("userInfoService", new UserInfoService(application));
//		application.setAttribute("homeService", new HomeService(application));

	}
}
