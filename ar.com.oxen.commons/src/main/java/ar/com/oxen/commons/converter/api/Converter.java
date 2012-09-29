package ar.com.oxen.commons.converter.api;

public interface Converter<S, T> {
	T convert(S source);
}
