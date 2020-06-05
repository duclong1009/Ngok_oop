package exportsentences;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import input.*;
import pre_process.Export;
import process.Sentences;

public class Export1 extends Sentences implements Export {
	private String process(String st, String s,String replace) {
		StringBuffer buf = new StringBuffer();
		if (st.indexOf(s)<0) {
			return null;
		}
		else {
			int l = st.indexOf(s);
			buf.append(st.substring(0,l));
			buf.append(replace);
			buf.append(st.substring(l+s.length()));
			return buf.toString();
		}
	}
	@Override
	public String replace(String st)  {
		// TODO Auto-generated method stub
		Random rd = new Random();
		try {
			Session session = Information.getRow(setNameIndex[rd.nextInt(5)], 3+rd.nextInt(17));
			Float price = session.getPrice();
			Float change = session.getChange();
			Float state =session.getState();
			String[] repl = {session.getNameIndex(),session.getDay(),price.toString(),change.toString(),state.toString(),session.getMatchingTradeWeight(),session.getMatchingTradeValue(),session.getTransactionWeight(),session.getTransactionValue()};
			
			String[] conv = {NAME_INDEX,DAY,CURRENTPRICE,CHANGEPRICE,STATE,MATCHING_TRADE_WEIGHT,MATCHING_TRADE_VALUE,TRANSACTION_WEIGHT,TRANSACTION_VALUE};
			StringBuffer buffer = new StringBuffer();
			List<String> list = new ArrayList<String>();
			for (String s:st.split(" ")) {
				list.add(s);
			}
			for (int i=0;i<list.size();i++) {
				String str = list.get(i);
				for (int j=0;j<9;j++) {
					if (str.indexOf(conv[j])>=0) {
						if (j!=3 && j!=4 && j!=2) list.set(i, process(str, conv[j], repl[j]));
						else {
							if (session.getState()<0) {
								if (j==2) {
									list.set(i, process(str, conv[j], repl[j]));
									if (list.get(i-1).equals("lên")) {
										list.set(i-1, "xuống");
									}
									if (list.get(i-1).equals("đạt")) {
										list.set(i-1, "còn");
									}
								}
								else {
									list.set(i,process(str, conv[j], repl[j].substring(1)));
									if (list.get(i-1).equals("tăng")) {
										list.set(i-1, "giảm");
									}
								}
							}
							else {
								if (j==2) {
									list.set(i, process(str, conv[j], repl[j]));
									if (list.get(i-1).equals("xuống") || list.get(i-1).equals("về")) {
										list.set(i-1, "lên");
									}if (list.get(i-1).equals("còn")) {
										list.set(i-1, "đạt");
									}
								}
								else {
									list.set(i,process(str, conv[j], repl[j]));
									if (list.get(i-1).equals("giảm")) {
										list.set(i-1, "tăng");
									}
								}
							}
						}
					}
					
				}
				
			}
			for (String s:list) {
				buffer.append(s);
				buffer.append(' ');
			}
			return buffer.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<String> output(List<String> list) {
		// TODO Auto-generated method stub
		List<String> kq = new ArrayList<String>();
		for (String st:list) {
			kq.add(replace(st));
		}
		return kq;
	}
	
	}

