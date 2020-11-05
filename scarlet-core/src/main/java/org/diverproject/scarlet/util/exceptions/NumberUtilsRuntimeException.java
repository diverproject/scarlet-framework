package org.diverproject.scarlet.util.exceptions;

import org.diverproject.scarlet.language.Language;

public class NumberUtilsRuntimeException extends ScarletUtilRuntimeException {

	private static final long serialVersionUID = 4439419903823149948L;

	public NumberUtilsRuntimeException(Language language, Object... args) {
		super(language, args);
	}

	public NumberUtilsRuntimeException(Exception e, Language language, Object... args) {
		super(e, language, args);
	}

}
