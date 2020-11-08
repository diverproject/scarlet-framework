package org.diverproject.scarlet.util.exceptions;

import org.diverproject.scarlet.ScarletRuntimeException;
import org.diverproject.scarlet.language.Language;

public class HexadecimalUtilsRuntimeException extends ScarletRuntimeException {

	private static final long serialVersionUID = 4439419903823149948L;

	public HexadecimalUtilsRuntimeException(Language language, Object... args) {
		super(language, args);
	}

	public HexadecimalUtilsRuntimeException(Exception e, Language language, Object... args) {
		super(e, language, args);
	}

}
