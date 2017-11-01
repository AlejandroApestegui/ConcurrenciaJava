package edu.cibertec.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import edu.cibertec.taks.TareaSuma;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Callable<Integer>> tareas =  new ArrayList<>();
		tareas.add(new TareaSuma(Arrays.asList(1,2)));
		tareas.add(new TareaSuma(Arrays.asList(3,4)));
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		try {
			List<Future<Integer>> futures =  executorService.invokeAll(tareas);
			for(Future<Integer> future : futures){
				System.out.println(future.get());
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

}
