package action;

import static constant.Kadai6XConst.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Kadai62InputBean;
import bean.Kadai62SubBean;

/**
 * Servlet implementation class Kadai62Action
 */
@WebServlet("/Kadai62")
public class Kadai62Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Kadai62Action() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// JSP指定
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/kadai62.jsp");
		// 値の保持
		List<Kadai62SubBean> labelNameList = new ArrayList<Kadai62SubBean>();
		Kadai62InputBean input = new Kadai62InputBean(request, labelNameList);
		request.setAttribute("input", input);
		request.setAttribute("SEARCH_TYPE_DOX", SEARCH_TYPE_DOX);
		// 入力値取得及び型チェック
		Integer searchType;
		String searchParam;
		try {
			searchType = Integer.parseInt(request.getParameter("searchType"));
			searchParam = request.getParameter("searchParam");
		} catch (Exception e) {
			dispatcher.forward(request, response);
			return;
		}
		// 改ざんチェック
		if (!SEARCH_TYPE_DOX.containsKey(searchType)) {
			dispatcher.forward(request, response);
			return;
		}
		// 検索＆ラベル設定
		String searchKey = null;
		if (searchParam!=null && !searchParam.isEmpty()) {
			searchKey = SEARCH_TYPE_COND.get(searchType);
			Formatter fm = new Formatter();
			if (SEARCH_TYPE_CNT.get(searchType)==1) {
				String tmp = Pattern.quote(searchParam);
				searchKey = fm.format(searchKey, tmp).toString();
			} else {
				String tmp1 = Pattern.quote(searchParam.toLowerCase());
				String tmp2 = Pattern.quote(searchParam.toUpperCase());
				searchKey = fm.format(searchKey, tmp1, tmp2).toString();
			}
			fm.close();
		}
		Pattern p = Pattern.compile(searchKey);
		for (Kadai62SubBean bean : labelNameList) {
			if (searchKey!=null && p.matcher(bean.getLabelName()).find()) {
				bean.setStatus(true);
			}
		}
		// 出力値設定
		dispatcher.forward(request, response);
	}
}
