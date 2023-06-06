package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.object.AccountInfo;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/servlet/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		
		try {
			request.setCharacterEncoding(("UTF-8"));
			AccountInfo accountinfo = new AccountInfo();
			
			accountinfo.setAdmin_id(request.getParameter("admin_id"));
			accountinfo.setName(request.getParameter("name"));
			accountinfo.setAddress(request.getParameter("address"));
			
			AccountDao4 objDao4 = new AccountDao4();
			
			int count = objDao4.insert(accountinfo);
			
			request.setAttribute("count", count);
			
		}catch (IllegalStateException e) {
			error ="DB接続エラーのため、登録できませんでした";
			e.printStackTrace();
			
		}catch (Exception e) {
			error = "予期せぬエラーが発生しました。<br>"+e;
		}finally {
			request.setAttribute("error", error);
			request.getRequestDispatcher("../jsp/insertReceipt.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
