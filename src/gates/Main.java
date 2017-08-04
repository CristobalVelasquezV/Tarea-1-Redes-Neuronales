package gates;

import java.util.Scanner;

public class Main {
	/**Main class tarea 1 : Redes neuronales.
	 * @param args
	 */

	public static void main(String[] args) {
		
		System.out.println("Ejemplo 1: un perceptron con comportamiento de gate AND");
		perceptron AndPerceptron=new perceptron(-1,1,1);
		/*Un ejemplo de AND perceptron posee un bias= - 1 y pesos w1=1 y w2=1, notamos que los outputs son los de un operador AND.*/
		System.out.println(AndPerceptron.output(0,0));
		System.out.println(AndPerceptron.output(0,1));
		System.out.println(AndPerceptron.output(1,0));
		System.out.println(AndPerceptron.output(1,1));
		
		System.out.println("Ejemplo 2: un perceptron con comportamiento de gate OR");
		perceptron ORPerceptron=new perceptron(0,1,1);
		/*Un ejemplo de OR perceptron posee un bias= 0 y pesos w1=1 y w2=1, notamos que los outputs son los de un operador OR.*/
		System.out.println("Input x1 = 0, x2 = 0 : "+ ORPerceptron.output(0,0));
		System.out.println(ORPerceptron.output(0,1));
		System.out.println(ORPerceptron.output(1,0));
		System.out.println(ORPerceptron.output(1,1));
		
		System.out.println("Ejemplo 3: un perceptron con comportamiento de gate NAND");
		perceptron NANDPerceptron=new perceptron(2,-1,-1);
		/*Un ejemplo de OR perceptron posee un bias= 0 y pesos w1=1 y w2=1, notamos que los outputs son los de un operador OR.*/
		System.out.println(NANDPerceptron.output(0,0));
		System.out.println(NANDPerceptron.output(0,1));
		System.out.println(NANDPerceptron.output(1,0));
		System.out.println(NANDPerceptron.output(1,1));
		
		

		System.out.println("Ejemplo 4: Usando perceptrones para sumar, ingrese dos bits (0 o 1) a sumar ");
		Scanner in = new Scanner(System.in);
		int x1 = in.nextInt();
		int x2 = in.nextInt();
		
		

		int val1=NANDPerceptron.output(x1,x2);
		int val2=NANDPerceptron.output(x1,val1);
		int val3=NANDPerceptron.output(val1,x2);
		int sum=NANDPerceptron.output(val2,val3);
		int carry=NANDPerceptron.output(val1,val1);
		System.out.println("Sum = " +Integer.toString(sum));
		System.out.println("Carry = " +Integer.toString(carry));
	}

}
