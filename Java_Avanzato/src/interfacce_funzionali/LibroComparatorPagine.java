package interfacce_funzionali;

import java.util.Comparator;

public class LibroComparatorPagine implements Comparator<Libro> {

	@Override
	public int compare(Libro l1, Libro l2) {
		return l1.getPagine() - l2.getPagine();
	}

}

/*

public class LibroComparatorPagineDesc implements Comparator<Libro> {

	@Override
	public int compare(Libro l1, Libro l2) {
		return l2.getPagine() - l1.getPagine();
	}

}
*/