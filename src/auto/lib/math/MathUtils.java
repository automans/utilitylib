package auto.lib.math;

import java.text.DecimalFormat;  
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MathUtils {

	public static String numPlus(int a, int b){
		return String.valueOf(a+b);
	}
	
	public static String numSub(int a, int b){
		return String.valueOf(a-b);
	}

	//����2λ��Ч����
	public static String fixDecimal(double num,int n){
		String format = "#.";
		for(int i = 0; i < n; i++){
			format += "0";
		}
		DecimalFormat df = new DecimalFormat(format);
		return df.format(num);
    }
	
	public static String eval2(String strs, int n) throws ScriptException {
		ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");  
		double dl = (double)jse.eval(strs);
		String format = "#.";
		for(int i = 0; i < n; i++){
			format += "0";
		}
		DecimalFormat df = new DecimalFormat(format);  
		return df.format(dl).toString();
	}
	
	//����ʽ��
	//2323.32 => 2,323.32
	public static String moneyFormat(double money){
		DecimalFormat df = new DecimalFormat("###,###,###,###,###,###.00");
		return df.format(money);
	}
	
	//��
	public static String moneyToTenThousand(double money){
		return moneyFormat(money/10000) + "��Ԫ";
	}
	
	//��
	public static String moneyToHundredMillion(double money){
		return moneyFormat(money/100000000) + "��Ԫ";
	}
	
	//ת���ɰٷֱ�
	public static String formatToPencent(double dub){
		return fixDecimal(dub*100,2).toString()+"%";
	}
	public static void main(String[] args) throws ScriptException {
		System.out.println(formatToPencent(0.233323));
    }
	
	
}
