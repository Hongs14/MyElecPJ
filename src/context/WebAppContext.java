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
import service.UserInfoService;

public class WebAppContext implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		DataSource dataSource = ConnectionProvider.getDataSource();
		application.setAttribute("dataSource", dataSource);
//		System.out.println("1");
		
		application.setAttribute("cartDAO", new CartDAO());
//		System.out.println("14");
		application.setAttribute("categoryDAO", new CategoryDAO());
//		System.out.println("15");
		application.setAttribute("orderDAO", new OrderDAO());
//		System.out.println("16");
		application.setAttribute("productDAO", new ProductDAO());
//		System.out.println("17");
		application.setAttribute("QnABoardDAO", new QnABoardDAO());
//		System.out.println("18");
		application.setAttribute("reviewBoardDAO", new ReviewBoardDAO());
//		System.out.println("19");
		application.setAttribute("subCategoryDAO", new SubCategoryDAO());
//		System.out.println("20");
		application.setAttribute("userDAO", new UserDAO());
//		System.out.println("21");
		
		//ServletContext 객체에 데이터 저장
//		application.setAttribute("adminService", new AdminService(application));
//		application.setAttribute("adminListService", new AdminListService(application));
		application.setAttribute("adminUserService", new AdminUserService(application));
		application.setAttribute("adminDeleteUserService", new AdminDeleteUserService(application));
		application.setAttribute("QnAboardListService", new BoardListService(application));
//		System.out.println("2");
		application.setAttribute("createQnAService", new CreateQnAService(application));
//		System.out.println("3");
		application.setAttribute("reviewboardListService", new ReviewboardListService(application));
//		System.out.println("4");
		application.setAttribute("createReviewService", new CreateReviewService(application));
//		System.out.println("5");
		application.setAttribute("readReviewService", new ReadReviewService(application));
//		System.out.println("6");
		application.setAttribute("cartService", new CartService(application));
//		System.out.println("7");
//		application.setAttribute("orderService", new OrderService(application));
//		application.setAttribute("orderListService", new OrderListService(application));
		application.setAttribute("productDetailService", new ProductDetailService(application));
//		System.out.println("8");
		application.setAttribute("productListService", new ProductListService(application));
//		System.out.println("9");
		application.setAttribute("findPasswordService", new FindPasswordService(application));
//		System.out.println("10");
		application.setAttribute("joinService", new JoinService(application));
//		System.out.println("11");
		application.setAttribute("loginService", new LoginService(application));
//		System.out.println("12");
		application.setAttribute("updateUserService", new UpdateUserService(application));
//		System.out.println("13");
		application.setAttribute("userInfoService", new UserInfoService(application));
//		application.setAttribute("homeService", new HomeService(application));

	}
}
