package ifacespractice.transportsym;

import ifacespractice.TransportadorDeCarga;

public class Helicoptero extends AparatoVolador implements TransportadorDeCarga
{
	@Override
	public void volar() {
		System.out.println("Uso mi rotor y las aspas para volar.");
	}


	@Override
	public void transportarCarga() {
		// TODO Auto-generated method stub
	}
}
