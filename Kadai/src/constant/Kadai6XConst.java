package constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Kadai6XConst {
	// privateコンストラクタでインスタンス生成を抑止
	private Kadai6XConst() {
	}

	/** 課題1用 */
	// 計算前
	public static final Integer CALC_BEFORE = 0;
	// 計算後
	public static final Integer CALC_AFTER = 1;
	// リストボックス値
	public static final Integer LIST_DIV_BLANK = 0;
	public static final Integer LIST_DIV_PLUS = 1;
	public static final Integer LIST_DIV_MINUS = 2;
	public static final Integer LIST_DIV_MULTI = 3;
	public static final Integer LIST_DIV_DIVI = 4;
	// リストボックス取得
	public static final Map<Integer, String> LIST_DIV_DOX;
	static {
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(LIST_DIV_BLANK, "");
		map.put(LIST_DIV_PLUS, "加算");
		map.put(LIST_DIV_MINUS, "減算");
		map.put(LIST_DIV_MULTI, "掛け算");
		map.put(LIST_DIV_DIVI, "除算");
		LIST_DIV_DOX = Collections.unmodifiableMap(map);
	}
	// リストボックス取得
	public static final Map<Integer, String> EVEN_ODD_BOX;
	static {
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(0, "偶数");
		map.put(1, "奇数");
		EVEN_ODD_BOX = Collections.unmodifiableMap(map);
	}
	// 計算結果ラベル
	public static final String RESULT_LABEL = "演算結果";
	public static final String RESULT_LABEL_FORMAT = "%s結果";
	// その他（正規表現等）
	public static final String REG_NUMERIC = "^\\d+(\\.\\d+)?$";
	public static final String REG_INTEGER = "^(\\d+)";
	public static final String REG_DECIMAL = "\\.(\\d+)";
	public static final String REG_POINT = "\\.";

	/** 課題2用 */
	// 検索対象
	public static final Integer SEARCH_TYPE_TOP_MATCH = 0;
	public static final Integer SEARCH_TYPE_BACKWARD_MATCH = 1;
	public static final Integer SEARCH_TYPE_PERFECT_MATCH = 2;
	public static final Integer SEARCH_TYPE_FUZZY_MATCH = 3;
	//検索名称
	public static final Map<Integer, String> SEARCH_TYPE_DOX;
	static {
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(SEARCH_TYPE_TOP_MATCH, "先頭検索");
		map.put(SEARCH_TYPE_BACKWARD_MATCH, "末尾検索");
		map.put(SEARCH_TYPE_PERFECT_MATCH, "完全一致");
		map.put(SEARCH_TYPE_FUZZY_MATCH, "あいまい");
		SEARCH_TYPE_DOX = Collections.unmodifiableMap(map);
	}
	//検索条件
	public static final Map<Integer, String> SEARCH_TYPE_COND;
	static {
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(SEARCH_TYPE_TOP_MATCH, "^(%s|%s)");
		map.put(SEARCH_TYPE_BACKWARD_MATCH, "(%s|%s)$");
		map.put(SEARCH_TYPE_PERFECT_MATCH, "^%s$");
		map.put(SEARCH_TYPE_FUZZY_MATCH, "(%s|%s)");
		SEARCH_TYPE_COND = Collections.unmodifiableMap(map);
	}
	//検索数
	public static final Map<Integer, Integer> SEARCH_TYPE_CNT;
	static {
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		map.put(SEARCH_TYPE_TOP_MATCH, 2);
		map.put(SEARCH_TYPE_BACKWARD_MATCH, 2);
		map.put(SEARCH_TYPE_PERFECT_MATCH, 1);
		map.put(SEARCH_TYPE_FUZZY_MATCH, 2);
		SEARCH_TYPE_CNT = Collections.unmodifiableMap(map);
	}

	// ラベル名一覧
	public static final List<String> LABEL_NAME_LIST;
	static {
		ArrayList<String> list = new ArrayList<String>();
		list.add("00000");
		list.add("00001");
		list.add("00002");
		list.add("00003");
		list.add("00004");
		list.add("ABCDE");
		list.add("Zabcd");
		list.add("00010");
		list.add("00011");
		list.add("00012");
		list.add("00013");
		list.add("00014");
		list.add("FGHIJ");
		list.add("efghi");
		list.add("00100");
		list.add("00101");
		list.add("00102");
		list.add("00103");
		list.add("00104");
		list.add("KLMNO");
		list.add("jklmn");
		list.add("01000");
		list.add("01001");
		list.add("01002");
		list.add("01003");
		list.add("01004");
		list.add("PQRST");
		list.add("opqrs");
		list.add("10000");
		list.add("10001");
		list.add("10002");
		list.add("10003");
		list.add("10004");
		list.add("UVWXY");
		list.add("tuvwx");
		LABEL_NAME_LIST = Collections.unmodifiableList(list);
	}

}
