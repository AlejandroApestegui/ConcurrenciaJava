package edu.cibertec.taks;

import java.util.List;
import java.util.concurrent.Callable;

public class TareaSuma implements Callable<Integer> {

	private List<Integer> numeros;

	public TareaSuma(List<Integer> numeros) {
		this.numeros = numeros;
	}

	public List<Integer> getNumeros() {
		return numeros;
	}

	public void setNumeros(List<Integer> numeros) {
		this.numeros = numeros;
	}

	@Override
	public Integer call() throws Exception {
		Integer res = 0;
		for (Integer num : this.numeros) {
			res += num;
		}
		return res;
	}

}
