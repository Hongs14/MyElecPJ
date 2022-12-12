package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.qna.QnABoardDTO;
import util.Pager;

public class QnABoardDAO {

	// 페이징처리- 게시판 전체 행
	public int getTotalRows(Connection conn) throws Exception {
		int totalRows = 0;

		String sql = "select count(*) from qna_board ";
		PreparedStatement pstmt;
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			totalRows = rs.getInt(1);
		}

		return totalRows;
	}

	// 페이징처리- 상품 이름 검색 행수
	public int getTotalSearchRows(String search, Connection conn) throws Exception {
		int totalRows = 0;

		String sql = "select count(*) FROM qna_board q, product p WHERE p.product_id = q.product_id and product_name like ? ";
		PreparedStatement pstmt;
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, search);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			totalRows = rs.getInt(1);
			System.out.println("QnADAO totalrows: " + rs.getInt(1));
		}

		return totalRows;
	}

	// 페이징처리- 내 문의 내역
	public int getMyListRows(String users_id, Connection conn) throws Exception {
		int totalRows = 0;

		String sql = "select count(*) FROM qna_board q, product p WHERE p.product_id = q.product_id and users_id like ?";
		PreparedStatement pstmt;
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, users_id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			totalRows = rs.getInt(1);
			System.out.println("QnADAO totalrows: " + rs.getInt(1));
		}

		return totalRows;
	}

	// qna게시판
	public ArrayList<QnABoardDTO> selectAllList(Pager pager, Connection conn) throws Exception {
		ArrayList<QnABoardDTO> QnaBoardList = new ArrayList<QnABoardDTO>();

		// sql문 작성
		String sql = "" + "select * " + "from (select rownum rnum, qna_board_id, qna_board_title, users_id, "
				+ "qna_board_date, qna_category_name, qna_board_answer " + "from( "
				+ "select qna_board_id, qna_board_title, users_id, qna_board_date, qna_category_name, qna_board_answer "
				+ "from qna_board q, qna_category qc " + "where q.qna_category_id=qc.qna_category_id "
				+ "order by q.qna_board_id desc) " + "where rownum <=?) " + "where rnum >= ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pager.getEndRowNo());
		pstmt.setInt(2, pager.getStartRowNo());
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			QnABoardDTO QBoardList = new QnABoardDTO();

			// 답변은 답변여부만 담아서 리스트 DTO로 담기 위해 삼항연산자 사용
			String YN = rs.getString("qna_board_answer") != null ? "Y" : "N";

			// 한 행의 데이터를 DTO에 담아준다
			QBoardList.setQna_board_id(rs.getInt("qna_board_id"));
			QBoardList.setQna_board_title(rs.getString("qna_board_title"));
			QBoardList.setUsers_id(rs.getString("users_id"));
			QBoardList.setQna_board_date(rs.getDate("qna_board_date"));
			QBoardList.setQna_category_name(rs.getString("qna_category_name"));
			QBoardList.setQna_board_answer(YN);

			// DB의 한 행 데이터를 담은 DTO를 리스트에 더해준다
			QnaBoardList.add(QBoardList);
		}
		rs.close();
		pstmt.close();

		return QnaBoardList;
	}

	// createQna
	public int insertQnABoard(QnABoardDTO qnaDTO, Connection conn) throws Exception {
		int result = 0;
		int result2 = 0;
		String sql = "INSERT INTO qna_board (qna_board_id, qna_board_title, qna_board_content, qna_board_date, users_id, qna_category_id ) "
				+ "VALUES (seq_qna_board_id.nextval, ?, ?, SYSDATE, ?, ?) ";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, qnaDTO.getQna_board_title());
		pstmt.setString(2, qnaDTO.getQna_board_content());
		pstmt.setString(3, qnaDTO.getUsers_id());
		pstmt.setInt(4, qnaDTO.getQna_category_id());
		result = pstmt.executeUpdate();

		if (result == 1) {
			System.out.println("Qna게시물 등록에 성공하였습니다.");
		}
		pstmt.close();

		String sql2 = "select qna_board_id " + "from( " + "select qna_board_id " + "from qna_board "
				+ "where users_id = ? " + "order by qna_board_id desc) " + "where rownum = 1 ";

		PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		pstmt2.setString(1, qnaDTO.getUsers_id());
		ResultSet rs = pstmt2.executeQuery();
		if (rs.next()) {
			result2 = rs.getInt("qna_board_id");

		}
		pstmt2.close();
		return result2;

	}

	// readQna
	public QnABoardDTO selectOneQnA(int qnaNo, Connection conn) throws Exception {
		QnABoardDTO readQna = new QnABoardDTO();

		String sql = ""
				+ "SELECT qna_board_id, qna_board_title, qna_board_content, q.users_id, qna_board_date, qc.qna_category_name, nvl(qna_board_answer, '답변이 등록되지 않았습니다.') as qna_board_answer "
				+ "FROM qna_board q,  qna_category qc " + "WHERE qc.qna_category_id=q.qna_category_id "
				+ "and qna_board_id = ? ";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, qnaNo);
		ResultSet rs = pstmt.executeQuery();
		// 요청한 데이터를 rs로 받아서 QnABoardDTO에 담는다
		if (rs.next()) {
			readQna.setQna_board_id(qnaNo);
			readQna.setQna_board_title(rs.getString("qna_board_title"));
			readQna.setQna_board_content(rs.getString("qna_board_content"));
			readQna.setUsers_id(rs.getString("users_id"));
			readQna.setQna_board_date(rs.getDate("qna_board_date"));
			readQna.setQna_category_name(rs.getString("qna_category_name"));
			readQna.setQna_board_answer(rs.getString("qna_board_answer"));
		}
		pstmt.close();
		return readQna;
	}

	/*
	 * // 상품 이름 검색 목록 --응 안해 public List<QnABoardProductDTO> selectSearchList(int
	 * pageNo, String search_String, Connection conn) {
	 * System.out.println("DAO String: " + search_String);
	 * System.out.println("DAO pageNo: " + pageNo); try { // sql문 작성 String sql = ""
	 * +
	 * " SELECT RNUM, qna_board_id, product_name, qna_board_title,users_id,qna_board_date, QNA_BOARD_ANSWER "
	 * + " FROM ( " +
	 * "        SELECT ROWNUM AS RNUM, product_name,qna_board_id, product_id, qna_board_title,users_id,qna_board_date, QNA_BOARD_ANSWER  "
	 * + "			   FROM (" +
	 * "                    SELECT qna_board_id, product_name, p.product_id, qna_board_title,users_id,qna_board_date, QNA_BOARD_ANSWER "
	 * + "                     FROM QNA_BOARD q , Product p " +
	 * "                     where q.product_id = p.product_id " +
	 * "                            and p.product_name like '%'||?||'%' " +
	 * "                     ORDER BY qna_board_date desc) " +
	 * "                WHERE ROWNUM < (? * 5) + 1 " +
	 * " ) WHERE RNUM >= ((? - 1) * 5) + 1 "; PreparedStatement pstmt =
	 * conn.prepareStatement(sql); pstmt.setString(1, search_String);
	 * pstmt.setInt(2, pageNo); pstmt.setInt(3, pageNo); ResultSet rs =
	 * pstmt.executeQuery();
	 * 
	 * QnABoardProductDTO qnaBoardProductDTO;
	 * 
	 * while (rs.next()) {
	 * 
	 * qnaBoardProductDTO = new QnABoardProductDTO();
	 * 
	 * // 답변은 답변여부만 담아서 리스트 DTO로 담기 위해 삼항연산자 사용 String YN =
	 * rs.getString("qna_board_answer") != null ? "Y" : "N"; // 한 행의 데이터를 DTO에 담아준다
	 * qnaBoardProductDTO.setQna_board_id(rs.getInt("qna_board_id"));
	 * qnaBoardProductDTO.setProduct_name(rs.getString("product_name"));
	 * System.out.println(rs.getString("product_name"));
	 * qnaBoardProductDTO.setQna_board_title(rs.getString("qna_board_title"));
	 * qnaBoardProductDTO.setUsers_id(rs.getString("users_id"));
	 * qnaBoardProductDTO.setQna_board_date(rs.getDate("qna_board_date"));
	 * qnaBoardProductDTO.setQna_board_answer(YN);
	 * 
	 * // DB의 한 행 데이터를 담은 DTO를 리스트에 더해준다
	 * qnaBoardProductDTOs.add(qnaBoardProductDTO); System.out.println("DAO: " +
	 * qnaBoardProductDTOs.toString()); } rs.close(); pstmt.close();
	 * 
	 * } catch (Exception e) { e.getMessage(); } finally { try { // Connection 반납
	 * conn.close(); System.out.println("반납 성공"); } catch (SQLException e) {
	 * e.printStackTrace(); } } return qnaBoardProductDTOs; }
	 */

	// updateQna
	public int updateQnABoard(QnABoardDTO upQna, Connection conn) throws Exception {
		int result = 0;

		String sql = "UPDATE qna_board SET qna_category_id = ?, qna_board_title = ?, qna_board_content = ?, qna_board_date = sysdate WHERE qna_board_id = ? ";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, upQna.getQna_category_id());
		pstmt.setString(2, upQna.getQna_board_title());
		pstmt.setString(3, upQna.getQna_board_content());
		pstmt.setInt(4, upQna.getQna_board_id());

		result = pstmt.executeUpdate();

		pstmt.close();

		// 수정 완료되면 1
		return result;
		
		
		
	}

	// deleteQna
	public int deleteQnABoard(int qnaNo, Connection conn) throws Exception {
		int result = 0;
		
		// sql문 작성 및 받은 JSONObject에서 데이터 뽑아서 DB로 전송
		String sql = "" + " DELETE FROM qna_board " + " WHERE qna_board_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, qnaNo);
		result = pstmt.executeUpdate();
		pstmt.close();

		return result;
	}

	// Qna 답변 작성
	public String updateAnswerQnABoard(QnABoardDTO qnaDTO, Connection conn) throws Exception {

		int rsResult = 0;
		System.out.println("DAO BoardID: " + qnaDTO.getQna_board_id());
		System.out.println("DAO Answer: " + qnaDTO.getQna_board_answer());

		String result = null;

		// sql문 작성 및 받은 JSONObject에서 데이터 뽑아서 DB로 전송
		String sql = "" + " UPDATE qna_board " + " SET qna_board_answer = ? " + " WHERE qna_board_id = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, qnaDTO.getQna_board_answer());
		pstmt.setInt(2, qnaDTO.getQna_board_id());

		rsResult = pstmt.executeUpdate();
		pstmt.close();
		if (rsResult == 1) {
			result = "success";
		} else {
			result = "fail";
		}

		return result;
	}

	// deleteQna-답변이 없을 때
	public String deleteAnswerQnABoard(int qna_board_id, Connection conn) throws Exception {

		int rsResult = 0;
		System.out.println("DAO BoardID: " + qna_board_id);

		String result = null;

		// sql문 작성 및 받은 JSONObject에서 데이터 뽑아서 DB로 전송
		String sql = "" + " UPDATE qna_board " + "	SET qna_board_answer = null" + "	WHERE qna_board_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, qna_board_id);

		rsResult = pstmt.executeUpdate();
		pstmt.close();
		if (rsResult == 1) {
			result = "success";
		} else {
			result = "fail";
		}

		return result;
	}

	// 내 문의 내역 리스트
	public ArrayList<QnABoardDTO> selectMyList(Pager pager, String users_id, Connection conn) throws Exception {
		ArrayList<QnABoardDTO> myQnaList = new ArrayList<QnABoardDTO>();

		// sql문 작성
		String sql = "" + "select * " + "from( "
				+ "select rownum rnum, qna_board_id, qna_board_title, users_id, qna_board_date, qna_category_name, qna_board_answer "
				+ "from qna_board q, qna_category qc " + "where rownum <=? " + "and users_id = ? "
				+ "ORDER BY qna_board_date desc) qtable " + "where rnum >= ? ";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pager.getEndRowNo());
		pstmt.setString(2, users_id);
		pstmt.setInt(3, pager.getStartRowNo());
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			QnABoardDTO myQList = new QnABoardDTO();

			// 답변은 답변여부만 담아서 리스트 DTO로 담기 위해 삼항연산자 사용
			String YN = rs.getString("qna_board_answer") != null ? "Y" : "N";
			// 한 행의 데이터를 DTO에 담아준다
			myQList.setQna_board_id(rs.getInt("qna_board_id"));
			myQList.setQna_board_title(rs.getString("qna_board_title"));
			myQList.setUsers_id(rs.getString("users_id"));
			myQList.setQna_board_date(rs.getDate("qna_board_date"));
			myQList.setQna_category_name(rs.getString("qna_category_name"));
			myQList.setQna_board_answer(YN);

			// DB의 한 행 데이터를 담은 DTO를 리스트에 더해준다
			myQnaList.add(myQList);

		}
		rs.close();
		pstmt.close();

		return myQnaList;
	}

}
