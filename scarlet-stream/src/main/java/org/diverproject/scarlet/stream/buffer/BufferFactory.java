package org.diverproject.scarlet.stream.buffer;

import static org.diverproject.scarlet.stream.language.BufferLanguage.BUFFER_FACTORY_IO_EXCEPTION;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class BufferFactory {

	private BufferFactory() { }

	public static BufferInput inputOf(int length) {
		return inputOf(new byte[length]);
	}

	public static BufferInput inputOf(byte[] bytes) {
		return new DefaultBufferInput().setBufferReader(
			new DefaultBufferReader()
				.setByteBuffer(new DefaultByteBuffer(bytes))
		);
	}

	public static BufferInput inputOf(String filename) {
		return inputOf(new File(filename));
	}

	public static BufferInput inputOf(File file) {
		try {
			return new DefaultBufferInput().setBufferReader(
				new DefaultBufferReader()
					.setByteBuffer(new DefaultByteBuffer(
						Files.readAllBytes(file.toPath())
					))
			);
		} catch (IOException e) {
			throw new BufferRuntimeException(e, BUFFER_FACTORY_IO_EXCEPTION, file.getAbsolutePath());
		}
	}

	public static BufferOutput outputOf(int length) {
		return outputOf(new byte[length]);
	}

	public static BufferOutput outputOf(byte[] bytes) {
		return new DefaultBufferOutput().setBufferWriter(
			new DefaultBufferWriter()
				.setByteBuffer(new DefaultByteBuffer(bytes))
		);
	}
}
