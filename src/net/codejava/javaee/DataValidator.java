package net.codejava.javaee;
import javax.servlet.http.HttpServletRequest;

public class DataValidator {
	
	private String UsageMoscow;
	private String UsageSPB;
	private String UsageUfa;
	private int Power;
	private int Age;
	private int Experience;
	

	public DataValidator(HttpServletRequest request) {
		
		//получаем статус выбора чекбокса
		this.UsageMoscow = request.getParameter("UsageMoscow");
		this.UsageSPB = request.getParameter("UsageSPB");
		this.UsageUfa = request.getParameter("UsageUfa");
		this.Power = Integer.parseInt(request.getParameter("Power")); 
		this.Age = Integer.parseInt(request.getParameter("Age"));
		this.Experience = Integer.parseInt(request.getParameter("Experience"));
		
	}
	
	public boolean ValidateData() {
		
		//ѕроверка на выбор хот€ бы одного значени€ региона регистрации
		if ( (UsageMoscow !=null & UsageSPB == null & UsageUfa == null) || 
				(UsageMoscow ==null & UsageSPB != null & UsageUfa == null) || 
				(UsageMoscow ==null & UsageSPB == null & UsageUfa != null) ||
				((Power > 0 & Age > 0 & Experience >= 0) & !(Age >= Experience + 18))) {
			
			return true;
		}
		
		return false;
		
	}
	
}
