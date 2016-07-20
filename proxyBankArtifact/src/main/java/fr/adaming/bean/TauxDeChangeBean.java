package fr.adaming.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.adaming.service.CurrencyService;

@ManagedBean(name = "changeMB")
@RequestScoped
public class TauxDeChangeBean implements Serializable {
	public String getChangeEuro() {
		return CurrencyService.sendLiveRequest("EUR");
	}
}
