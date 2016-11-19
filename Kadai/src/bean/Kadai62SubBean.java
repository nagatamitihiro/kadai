package bean;

import java.io.Serializable;

public class Kadai62SubBean implements Serializable {

	/** ラベルに表示する名前 */
	private String labelName;
	/** ステータス */
	private boolean status;

	/**
	 * @return labelName
	 */
	public String getLabelName() {
		return labelName;
	}
	/**
	 * @param labelName セットする labelName
	 */
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	/**
	 * @return status
	 */
	public boolean getStatus() {
		return status;
	}
	/**
	 * @param status セットする status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

}
