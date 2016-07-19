package fr.adaming.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.adaming.proxy.CurrencyServiceProxy;

@ManagedBean(name = "changeMB")
@SessionScoped
public class TauxDeChangeBean implements Serializable {
	public String getChangeEuro() {
		return CurrencyServiceProxy.sendLiveRequest("EUR");
	}
}
