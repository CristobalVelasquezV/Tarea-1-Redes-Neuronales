package gates;

public abstract class GenericNeuron {
	
	abstract double output(double ...inputs);
	
	abstract void learn(double ...values);
	
	abstract void changeError(double error);
	
	abstract void changeDelta(double delta);
	
	abstract void changeOutput(double output);
	
	abstract void changeWeight(int i);
	
	abstract void changeBias();
	
	abstract void changeLastInput(double[] input);
	
	abstract double getLastOutput();
	
	abstract double getDelta();
	
	abstract double returnError(int i);
	
	
}
