package ifacespractice.transportsym;

import ifacespractice.ObjetoFlotante;
import ifacespractice.TransportadorDeCarga;

public class Hidroavion extends AparatoVolador implements ObjetoFlotante, TransportadorDeCarga
{
	@Override
	public void volar() {
		System.out.println("Utilizo las hélices y mis alas para volar");
	}

	@Override
	public void flotar() {
		System.out.println("Estoy flotando usando dos flotadores como patas");
	}


	@Override
	public void transportarCarga() {
		// TODO Auto-generated method stub
	}
}
