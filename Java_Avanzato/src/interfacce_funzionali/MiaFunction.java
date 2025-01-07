package interfacce_funzionali;

@FunctionalInterface
public interface MiaFunction<T, R> {
	R apply(T t);
}
