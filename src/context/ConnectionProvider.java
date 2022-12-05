package context;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class ConnectionProvider {
	//싱글톤패턴 활용 -> 커넥션 풀 만들기 dataSource = dataPool
	private static BasicDataSource dataSource;
	static {
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@kosa402.iptime.org:50041/orcl");
		dataSource.setUsername("user1");
		dataSource.setPassword("oracle");
		dataSource.setMaxTotal(5); // 최대 커넥션 갯수 
		dataSource.setInitialSize(5); //처음 커넥션 갯수 
		dataSource.setMaxIdle(1); // 몇개까지 남기고 줄일 것 인가 (사용되지 않을때 남길 커넥션) 
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
}
