//处理查询请求,调用searchOrder方法，跳转页面

package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Yes;
import domain.serchOrder;

@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet{
	public searchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String oId=request.getParameter("oid");
		
		Yes buy=serchOrder.serch_(oId);
		
		if(oId!=null)
		{
			request.setAttribute("buy", buy);
	    	request.getRequestDispatcher("uOrder.jsp").forward(request, response);
		}
		else {
		
    	request.getRequestDispatcher("noOrder.jsp").forward(request, response);
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
