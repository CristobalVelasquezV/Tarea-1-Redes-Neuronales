package neuronFactory;

import gates.GenericNeuron;

public abstract class NeuronFactory {
	protected double bias;
	protected double learningrate;
	public abstract GenericNeuron CreateNeuron(double ...weights);
	
}
