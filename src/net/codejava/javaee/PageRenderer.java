package net.codejava.javaee;

public class PageRenderer {
	
	private String ResultHtml;
	private PriceParams ResultPrice;
		
	public PageRenderer() {
		
		this.ResultHtml = "<!DOCTYPE html>  \r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n" + 
				"<link rel = \"stylesheet\" href = \"style.css\">\r\n" + 
				"<link href=\"https://fonts.googleapis.com/css?family=Roboto+Slab\" rel=\"stylesheet\">\r\n" + 
				"<title>Результат</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" +
				"<div class=forma>";

	}
	
	public void setResultPrice(PriceParams price) {
		this.ResultPrice = price;
	}
	
	public String generateHTML(boolean isDataCorrect) {
		
		if (isDataCorrect) {
			ResultHtml += "<h1>Стоимость ОСАГО:  "; 
			ResultHtml += ResultPrice.CalculatePrem;
			ResultHtml += " руб.</h1><h2>Использованные коэффициенты</h2><h3>TБ (Базовый тариф) =";
			ResultHtml += ResultPrice.TB + "</h3><h3>KT (Коэффициент территории преимущественного использования) =";
			ResultHtml += ResultPrice.KT + "</h3><h3>KБM (Коэффициент 'бонус-малус') ="; 
			ResultHtml += ResultPrice.KBM + "</h3><h3>КВС (Коэффициент в зависимости от возраста и стажа водителя) =";
			ResultHtml += ResultPrice.KVS + "</h3><h3>КМ (Коэффициент технических характристик ТС) =";
			ResultHtml += ResultPrice.KM + "</h3></div>";
		} else {
			ResultHtml += "<h1>Ошибка. Необходимо ввести верные данные</h1>";
		}
		
		return this.ResultHtml;
	}

}
