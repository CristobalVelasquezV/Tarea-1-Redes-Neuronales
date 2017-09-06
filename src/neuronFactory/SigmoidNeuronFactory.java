package neuronFactory;

import gates.GenericNeuron;
import gates.SigmoidNeuron;

public class SigmoidNeuronFactory extends NeuronFactory{
	
	
	public SigmoidNeuronFactory(double learning,double b){
		bias=b;
		learningrate=learning;
	}

	@Override
	public
	GenericNeuron CreateNeuron(double ...weights) {
		SigmoidNeuron sigmoid=new SigmoidNeuron(learningrate,bias,weights);
		return sigmoid;
	}

}
