package gates;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import neuronFactory.SigmoidNeuronFactory;

public class MainNeuronalNetwork {
	
	public static void main(String[] args) throws IOException {
	int nlayers = 1;
	int ninputs = 2;
	int min=0;
	int max=2;
	int[] sizelayers={2};
	SigmoidNeuronFactory factory=new SigmoidNeuronFactory(0.01,1);
	double [][] weights={{1,1}};
	NeuronalNetwork network=new NeuronalNetwork(ninputs,nlayers,sizelayers,factory,weights);
	//NeuronalNetwork randomnetwork=new NeuronalNetwork(ninputs,nlayers,sizelayers,factory,min,max);
	double[] input={0,0};
	double[] ret=network.networkOutput(input);
	
	
	}
	
}
