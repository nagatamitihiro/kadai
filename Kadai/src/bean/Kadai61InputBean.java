package bean;

import static constant.Kadai6XConst.*;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class Kadai61InputBean implements Serializable {
	/** 商余の表示非表示 */
	private boolean showDivi;
	/** 演算結果ラベル */
	private String resultLabel;
	/** 端数処理タイミング */
	private String roundTiming;
	/** リストボックス値 */
	private String listDiv;
	/** 値1 */
	private String param1;
	/** 値2 */
	private String param2;

	public Kadai61InputBean(HttpServletRequest request) {
		super();
		showDivi = false;
		resultLabel = RESULT_LABEL;
		roundTiming = request.getParameter("roundTiming");
		listDiv = request.getParameter("listDiv");
		param1 = request.getParameter("param1");
		param2 = request.getParameter("param2");

	}

	/**
	 * @return showDivi
	 */
	public boolean isShowDivi() {
		return showDivi;
	}
	/**
	 * @param showDivi セットする showDivi
	 */
	public void setShowDivi(boolean showDivi) {
		this.showDivi = showDivi;
	}
	/**
	 * @return resultLabel
	 */
	public String getResultLabel() {
		return resultLabel;
	}
	/**
	 * @param resultLabel セットする resultLabel
	 */
	public void setResultLabel(String resultLabel) {
		this.resultLabel = resultLabel;
	}
	/**
	 * @return roundTiming
	 */
	public String getRoundTiming() {
		return roundTiming;
	}
	/**
	 * @param roundTiming セットする roundTiming
	 */
	public void setRoundTiming(String roundTiming) {
		this.roundTiming = roundTiming;
	}
	/**
	 * @return listDiv
	 */
	public String getListDiv() {
		return listDiv;
	}
	/**
	 * @param listDiv セットする listDiv
	 */
	public void setListDiv(String listDiv) {
		this.listDiv = listDiv;
	}
	/**
	 * @return param1
	 */
	public String getParam1() {
		return param1;
	}
	/**
	 * @param param1 セットする param1
	 */
	public void setParam1(String param1) {
		this.param1 = param1;
	}
	/**
	 * @return param2
	 */
	public String getParam2() {
		return param2;
	}
	/**
	 * @param param2 セットする param2
	 */
	public void setParam2(String param2) {
		this.param2 = param2;
	}
}
