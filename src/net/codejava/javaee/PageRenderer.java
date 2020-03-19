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
				"<title>���������</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" +
				"<div class=forma>";

	}
	
	public void setResultPrice(PriceParams price) {
		this.ResultPrice = price;
	}
	
	public String generateHTML(boolean isDataCorrect) {
		
		if (isDataCorrect) {
			ResultHtml += "<h1>��������� �����:  "; 
			ResultHtml += ResultPrice.CalculatePrem;
			ResultHtml += " ���.</h1><h2>�������������� ������������</h2><h3>T� (������� �����) =";
			ResultHtml += ResultPrice.TB + "</h3><h3>KT (����������� ���������� ����������������� �������������) =";
			ResultHtml += ResultPrice.KT + "</h3><h3>K�M (����������� '�����-�����') ="; 
			ResultHtml += ResultPrice.KBM + "</h3><h3>��� (����������� � ����������� �� �������� � ����� ��������) =";
			ResultHtml += ResultPrice.KVS + "</h3><h3>�� (����������� ����������� ������������ ��) =";
			ResultHtml += ResultPrice.KM + "</h3></div>";
		} else {
			ResultHtml += "<h1>������. ���������� ������ ������ ������</h1>";
		}
		
		return this.ResultHtml;
	}

}
