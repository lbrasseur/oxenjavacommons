package ar.com.oxen.commons.converter.impl;

import ar.com.oxen.commons.converter.api.Converter;

public class CompoundConverter<S, M, T> implements Converter<S, T> {
	private Converter<S, M> sourceConverter;
	private Converter<M, T> targetConverter;

	public CompoundConverter(Converter<S, M> sourceConverter,
			Converter<M, T> targetConverter) {
		super();
		this.sourceConverter = sourceConverter;
		this.targetConverter = targetConverter;
	}

	@Override
	public T convert(S source) {
		return this.targetConverter.convert(this.sourceConverter
				.convert(source));
	}
}
