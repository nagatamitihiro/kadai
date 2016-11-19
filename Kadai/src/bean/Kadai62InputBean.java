package bean;

import static constant.Kadai6XConst.*;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Kadai62InputBean implements Serializable {
	/** 計算方法 */
	private String searchType;
	/** 計算値 */
	private String searchParam;
	/** 検索対象 */
	private List<Kadai62SubBean> labelNameList;

	public Kadai62InputBean(HttpServletRequest request, List<Kadai62SubBean> labelNameList) {
		super();
		for (String labelName : LABEL_NAME_LIST) {
			Kadai62SubBean subBean = new Kadai62SubBean();
			subBean.setLabelName(labelName);
			labelNameList.add(subBean);
		}
		searchType = request.getParameter("searchType");
		searchParam = request.getParameter("searchParam");
		this.labelNameList = labelNameList;
	}

	/**
	 * @return searchType
	 */
	public String getSearchType() {
		return searchType;
	}
	/**
	 * @param searchType セットする searchType
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	/**
	 * @return searchParam
	 */
	public String getSearchParam() {
		return searchParam;
	}
	/**
	 * @param searchParam セットする searchParam
	 */
	public void setSearchParam(String searchParam) {
		this.searchParam = searchParam;
	}
	/**
	 * @return labelNameList
	 */
	public List<Kadai62SubBean> getLabelNameList() {
		return labelNameList;
	}
	/**
	 * @param labelNameList セットする labelNameList
	 */
	public void setLabelNameList(List<Kadai62SubBean> labelNameList) {
		this.labelNameList = labelNameList;
	}

}
