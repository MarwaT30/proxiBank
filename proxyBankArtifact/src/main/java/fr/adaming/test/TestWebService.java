package fr.adaming.test;

import fr.adaming.service.CurrencyService;


public class TestWebService {

	public static void main(String[] args) {
		CurrencyService.sendLiveRequest("EUR");
	}
}
