package pre_process;

import org.w3c.dom.stylesheets.LinkStyle;

public interface Convention {
	public static final String[] DIEM = {"điểm"};
	public static final String[] TY = {"tỷ"};
	public static final String[] PHIEN = {"phiên"};
	public static final String[] TRIEU = {"triệu"};
	public static final String NAME_INDEX = "NameIndex";
	public static final String STATE = "State";
	public static final String CURRENTPRICE = "CurrentPrice";
	public static final String DAY = "Day";
	public static final String MATCHING_TRADE_WEIGHT = "MatchingTradeWeight";
	public static final String MATCHING_TRADE_VALUE = "MatchingTradeValue";
	public static final String TRANSACTION_WEIGHT = "TransactionWeight";
	public static final String TRANSACTION_VALUE = "TransactionValue";
	public static final String CHANGE = "Change";
	public static final String CHANGEPRICE = "ChangePrice";


	public static final String TANGLIENTUC_TXT = "C:\\Users\\Admin\\Desktop\\filetxt\\Tanglientiep.txt";
	public static final String GIAMLIENTUC_TXT = "C:\\Users\\Admin\\Desktop\\filetxt\\Giamlientiep.txt";
	public static final String TANGROIGIAMLIENTUC_TXT = "C:\\Users\\Admin\\Desktop\\filetxt\\GiamlientieprooiTang.txt";
	public static final String GIAMROITANGLIENTUC_TXT = "C:\\Users\\Admin\\Desktop\\filetxt\\Tanglientieproigiam.txt";
	public static final String SOLANTANGGIAM = "C:\\Users\\Admin\\Desktop\\filetxt\\solantang.txt";
	public static final String TANG_TXT = "C:\\Users\\Admin\\Desktop\\filetxt\\Tang.txt";
	public static final String GIAM_TXT = "C:\\Users\\Admin\\Desktop\\filetxt\\Giam.txt";
	public static final String DATMOC_TXT  = "C:\\Users\\Admin\\Desktop\\filetxt\\DATMOC.txt";

	public static String[] Giam  = {"giảm", "xuống"};
	public static String[] Tang  = {"tăng"};
	public static String[] setNameIndex = {"VN-INDEX","VN30-INDEX","HNX-INDEX","HNX30-INDEX","UPCOM-INDEX","VN-Index","Vn-Index"};
	public static String[] preCurrentPrice = {"còn","ở","đạt","lên","tại","về","xuống"};
	public static String[] preState = {"giảm","mất","tăng","rơi","tích","hồi"};
	public static String[] nearPrice = {"sát","gần"};
}
