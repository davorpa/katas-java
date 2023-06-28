package ifacespractice.birdsym;

import ifacespractice.ObjetoVolador;

public class Pajaro implements ObjetoVolador
{
	@Override
	public void volar() {
		System.out.println("Estoy agitando mis alitas para volar placidamente como pájaro...");
	}

}
