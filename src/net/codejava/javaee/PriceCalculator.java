package net.codejava.javaee;
import javax.servlet.http.HttpServletRequest;


public class PriceCalculator {
	
	private int TB; //Базовая максимальная тарифная ставка 
	private double KT;  //Коэффициент территории
	private double KBM; //Коэффициент Бонус-Малус, по умолчанию 3 (1)
	private double KVS; //Коэффициент Возраст-стаж (Вычисляется 
	//private double KOMultidrive; //Для мультидрайва
	private double KM; //Коэффициент мощности
	private double CalculatePrem; //Переменная для расчета страховой премии
	private int Power;
	private int Age;
	private int Experience;
	
	public PriceCalculator(HttpServletRequest request) {
		
		this.TB = 4118; 
		this.KBM = 1;
		this.KVS = 0; 
		//this.KOMultidrive = 1.8;
		this.KM = 0;
					
		if (request.getParameter("UsageMoscow") !=null) this.KT = 2;
		else if (request.getParameter("UsageSPB") != null) this.KT = 1.8;
		else if (request.getParameter("UsageUfa") != null) this.KT = 1.8;
		
		//парсим строковые значения в инт
		this.Power = Integer.parseInt(request.getParameter("Power")); 
		this.Age = Integer.parseInt(request.getParameter("Age"));
		this.Experience = Integer.parseInt(request.getParameter("Experience"));

	}
	
	public PriceParams calculatePrice() {

		if (Power <= 50) KM = 0.6;	
		if (Power > 50 & Power <= 70) KM = 1;
		if (Power > 70 & Power <= 100) KM = 1.1;
		if (Power > 100 & Power <= 120) KM = 1.2;
		if (Power > 120 & Power <= 150) KM = 1.4;
		if (Power > 150) KM = 1.6;
		if (Age <= 22 & Experience <= 3 ) KVS = 1.8;
		if (Age > 22 & Experience <= 3) KVS = 1.7;
		if (Age < 22 & Experience > 3) KVS = 1.6;	
		if (Age > 22 & Experience > 3) KVS = 1;
		CalculatePrem = TB * KT * KBM * KVS * KM; //расчет страховой премии
		CalculatePrem = Math.rint(100.0 * CalculatePrem) / 100.0; //оставляем два знака после запятой
		
		//out.println(ResultHtml + "<h1>Стоимость ОСАГО:  " + CalculatePrem + " руб.</h1><h2>Использованные коэффициенты</h2><h3>TБ (Базовый тариф) =" + TB + "</h3><h3>KT (Коэффициент территории преимущественного использования) =" + KT + "</h3><h3>KБM (Коэффициент 'бонус-малус') =" + KBM + "</h3><h3>КВС (Коэффициент в зависимости от возраста и стажа водителя) =" + KVS + "</h3><h3>КМ (Коэффициент технических характристик ТС) =" + KM + "</h3></div>");
		
		PriceParams priceParams = new PriceParams();
		priceParams.CalculatePrem = CalculatePrem;
		priceParams.TB = this.TB;
		priceParams.KT = this.KT;
		priceParams.KBM = this.KBM;
		priceParams.KVS = this.KVS;
		priceParams.KM = this.KM;
		
		return priceParams;
		
	}

}
