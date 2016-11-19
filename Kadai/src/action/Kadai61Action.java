package action;

import static constant.Kadai6XConst.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Kadai61InputBean;

/**
 * Servlet implementation class Kadai61Action
 */
@WebServlet("/Kadai61")
public class Kadai61Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Kadai61Action() {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/kadai61.jsp");
		// 入力の初期設定
		Kadai61InputBean input = new Kadai61InputBean(request);
		request.setAttribute("input", input);
		request.setAttribute("LIST_DIV_DOX", LIST_DIV_DOX);
		// 入力値取得及び型チェック
		Integer listDiv;
		Integer roundTiming;
		BigDecimal param1;
		BigDecimal param2;
		try {
			roundTiming = Integer.parseInt(request.getParameter("roundTiming"));
			listDiv = Integer.parseInt(request.getParameter("listDiv"));
			String param1Str = request.getParameter("param1");
			isNumeric(param1Str);
			String param2Str = request.getParameter("param2");
			isNumeric(param2Str);
			if (roundTiming==0) {
				param1 = formatter(new BigDecimal(param1Str));
				param2 = formatter(new BigDecimal(param2Str));
			} else {
				param1 = new BigDecimal(param1Str);
				param2 = new BigDecimal(param2Str);
			}
		} catch (Exception e) {
			dispatcher.forward(request, response);
			return;
		}
		// 改ざんチェック
		if (!LIST_DIV_DOX.containsKey(listDiv)) {
			dispatcher.forward(request, response);
			return;
		}
		// 計算
		BigDecimal result;
		Integer resultInteger=0;
		BigDecimal resultDecimal=null;
		if (listDiv==LIST_DIV_PLUS) {
			result = param1.add(param2);
		} else if (listDiv==LIST_DIV_MINUS) {
			result = param1.subtract(param2);
		} else if (listDiv==LIST_DIV_MULTI) {
			result = param1.multiply(param2);
		} else if (listDiv==LIST_DIV_DIVI) {
			result = param1.divide(param2, 2, BigDecimal.ROUND_HALF_UP);
			resultInteger = result.intValue();
			resultDecimal = param1.subtract(param2.multiply(new BigDecimal(resultInteger)));
		} else {
			dispatcher.forward(request, response);
			return;
		}
		if (roundTiming!=0) {
			result = formatter(result);
		}
		// 入力の再設定
		if (listDiv == LIST_DIV_DIVI) {
			input.setShowDivi(true);
		}
		input.setResultLabel(String.format(RESULT_LABEL_FORMAT, LIST_DIV_DOX.get(listDiv)));
		// 出力の再設定
		request.setAttribute("resultInteger", resultInteger);
		request.setAttribute("resultDecimal", resultDecimal);
		request.setAttribute("evenOdd", EVEN_ODD_BOX.get(new Integer(Math.abs(result.intValue()%2))));
		request.setAttribute("result", result.toString());

		dispatcher.forward(request, response);
	}

	/**
	 * 入力値の入力チェック
	 *
	 * @param param
	 * @throws Exception
	 */
	private static void isNumeric(String param) throws Exception {
		// 数字？
		if (!param.matches(REG_NUMERIC)) {
			throw new NumberFormatException();
		}
		// 整数部？
		{
			Pattern p = Pattern.compile(REG_INTEGER);
			Matcher m = p.matcher(param);
			if (m.find()) {
				if (m.group(1).length() > 5) {
					throw new NumberFormatException();
				}
			}
		}
		// 少数部？
		{
			Pattern p = Pattern.compile(REG_DECIMAL);
			Matcher m = p.matcher(param);
			if (m.find()) {
				if (m.group(1).length() > 2) {
					throw new NumberFormatException();
				}
			}
		}
	}

	/**
	 * 入力値をフォマット
	 * @param param
	 * @return
	 */
	private static BigDecimal formatter(BigDecimal param) {
		param = param.add(new BigDecimal(0.01));
		param = param.setScale(1, BigDecimal.ROUND_HALF_UP);
		param = param.setScale(0, BigDecimal.ROUND_HALF_UP);
		return param;
	}


}
