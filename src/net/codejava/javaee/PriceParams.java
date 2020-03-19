package net.codejava.javaee;

public class PriceParams {

	public int TB; //Базовая максимальная тарифная ставка 
	public double KT;  //Коэффициент территории
	public double KBM; //Коэффициент Бонус-Малус, по умолчанию 3 (1)
	public double KVS; //Коэффициент Возраст-стаж (Вычисляется 
	public double KM; //Коэффициент мощности
	public double CalculatePrem; //Переменная для расчета страховой премии

}
