package ar.com.oxen.commons.converter.api;

import ar.com.oxen.commons.converter.impl.CompoundConverter;

public class ConverterBuilder<S, T> {
	private Converter<S, T> converter;

	private ConverterBuilder(Converter<S, T> converter) {
		super();
		this.converter = converter;
	}

	public static <X, Y> ConverterBuilder<X, Y> create(Converter<X, Y> converter) {
		return new ConverterBuilder<X, Y>(converter);

	}

	public <X> ConverterBuilder<S, X> add(Converter<T, X> chainedConverter) {
		return create(new CompoundConverter<S, T, X>(this.converter,
				chainedConverter));
	}

	public Converter<S, T> build() {
		return this.converter;
	}
}
