package spring.base.principle.di.common;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
/**
 * 
 * @author fanguangjie
 * 国际化
 */
public class LocaleDemo {

	@SuppressWarnings("unused")
	public static void displayLocal(){
	    //①带有语言和国家/地区信息的本地化对象  
	    Locale locale_zh_CN = new Locale("zh","CN");   
	    
	    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale_zh_CN);    
	    System.out.println(numberFormat.format(123456.78));  
	    
	    Date date = new Date();    
	    DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale_zh_CN);    
	    System.out.println(df.format(date));  

	    
	    //②只有语言信息的本地化对象  
	    Locale locale_zh = new Locale("zh");   
	      
	    //③等同于Locale("zh","CN")  
	    Locale locale_china = Locale.CHINA;   
	      
	    //④等同于Locale("zh")  
	    Locale locale_chinese = Locale.CHINESE;   
	      
	    //⑤获取本地系统默认的本地化对象  
	    Locale locale_default= Locale.getDefault();  
	    
	    
	    
	}
	/**
	 * 资源文件都必须是ISO-8859-1编码 
	 * native2ascii -encoding GBK hello_zh_CN.properties helloascii_zh_CN.properties
	 * 当你传入一个Locale.US 给ResourceBundle的时候 ,  ResourceBundle的搜索次序是这样：
	 * (1) resource_en_US.properties        --- 没找到
	 * (2) resource_en.properties           --- 还是没找到
	 * (3) resource_zh_CN.properties        ---- default locale， 找到了
	 * (4) resource_zh_properties       
	 * (5) resource.properties
	 */
	public static void displayResourceBundle(){
		Locale locale_zh_CN = new Locale("zh","CN");
		ResourceBundle rb = ResourceBundle.getBundle("META-INF.i18n.hello", locale_zh_CN,Thread.currentThread().getContextClassLoader());
		System.out.println(rb.getString("hello"));
	}
	
	
	public static void main(String[] args) {
		displayResourceBundle();
	}
	
}
