package ifacespractice.transportsym;

import ifacespractice.TransportadorDeCarga;

public class Velero extends Bote implements TransportadorDeCarga
{
	@Override
	public void flotar() {
		System.out.println("Uso mi casco ligero de nave acuática para flotar.");
	}

	@Override
	public void transportarCarga() {
		System.out.println("Uso mi casco resistente para transportar carga.");
	}

}
