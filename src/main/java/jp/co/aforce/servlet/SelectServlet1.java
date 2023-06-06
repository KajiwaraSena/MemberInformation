package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.object.AccountInfo;

/**
 * Servlet implementation class SelectServlet1
 */
@WebServlet("/servlet/SelectServlet1")
public class SelectServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		
		try {
			ArrayList<AccountInfo> list = new ArrayList<AccountInfo>();
			
			AccountDao1 objDao = new AccountDao1();
			
			list = objDao.selectAll();
			
			request.setAttribute("list", list);
		}catch(IllegalStateException e) {
			error = "DB接続エラーのため、一覧は表示できませんでした";
			e.printStackTrace();
		}catch(Exception e){
			 error ="予期せぬエラーが発生しました。<br>"+e;
		}finally{
			request.setAttribute("error", error);
			 request.getRequestDispatcher("../jsp/list1.jsp").forward(request, response);
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
