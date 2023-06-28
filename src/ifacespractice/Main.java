package ifacespractice;

import java.util.List;

import ifacespractice.birdsym.Pajaro;
import ifacespractice.transportsym.Helicoptero;
import ifacespractice.transportsym.Hidroavion;

public class Main {

	public static void main(String[] args) {
		List<ObjetoVolador> flyers = List.of(
				new Pajaro(),
				new Hidroavion(),
				new Helicoptero()
			);

		symOtherProyect(flyers);
	}

	public static void symOtherProyect(List<ObjetoVolador> flyers) {
		for (ObjetoVolador flyer : flyers) {
			flyer.volar();
		}
	}

}
