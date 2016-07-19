package fr.adaming.test;

import fr.adaming.proxy.CurrencyServiceProxy;


public class TestWebService {

	public static void main(String[] args) {
		CurrencyServiceProxy.sendLiveRequest("EUR");
	}
}
