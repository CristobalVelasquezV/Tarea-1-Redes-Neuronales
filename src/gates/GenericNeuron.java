package gates;

public abstract class GenericNeuron {
	
	abstract double output(double ...inputs);
	
	abstract void learn(double ...values);
	
	abstract void changeError(double error);
	
	abstract void changeDelta(double delta);
	
	public abstract void changeOutput(double output);
	
	abstract void changeWeight(int i);
	
	abstract void changeBias();
	
	abstract void changeLastInput(double[] input);
	
	abstract double getLastOutput();
	
	abstract double getDelta();
	
	abstract double returnError(int i);

	abstract void showWeights();
	
	abstract double getWeight(int i);
	
	abstract int length();
	
	abstract void changeWeightFor(int i,double j);
	
	
}
