package dev.paie.exception;

import java.util.List;

public class remunerationEmployerException extends RuntimeException {

	private List<String> messagesErreurs;

	public remunerationEmployerException(List<String> messagesErreurs) {
		this.messagesErreurs = messagesErreurs;
	}

	public List<String> getMessagesErreurs() {
		return messagesErreurs;
	}

}
