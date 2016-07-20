package fr.adaming.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("request")
@FacesValidator(value="ValidatorChoice")
public class ValidatorChoice implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent composant, Object valeur)
			throws ValidatorException {
		//recuperation de la valeur du champ
		String saisie=(String)valeur;
		try {if(!saisie.isEmpty()){
			throw new Exception("le champ ne doit pas etre vide");}
		} catch (Exception e) {//renvoie le message vers la page html
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

}

