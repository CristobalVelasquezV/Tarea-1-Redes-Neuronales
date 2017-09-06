package gates;

import java.util.ArrayList;

import neuronFactory.NeuronFactory;

public class NeuronalNetwork {
	private ArrayList<NeuronLayer> network;
	
	public NeuronalNetwork(int ninputs,int nlayers,int[] sizelayers,NeuronFactory factory,double[][] nw){
		network=new ArrayList<NeuronLayer>();
		double[] w=new double[ninputs];
		if(nw.length==0){
		for(int i=0;i<nlayers;i++){
			
			network.add(new NeuronLayer(sizelayers[i],factory,w));
			w=new double[sizelayers[i]];
		}
		}
		else{
			for(int i=0;i<nlayers;i++){	
				network.add(new NeuronLayer(sizelayers[i],factory,nw[i]));		
			}
		}
	}
	
	public NeuronalNetwork(int ninputs,int nlayers,int[] sizelayers,NeuronFactory factory,int min,int max){
		network=new ArrayList<NeuronLayer>();
		network.add(new NeuronLayer(sizelayers[0],ninputs,min,max,factory));	
		for(int i=1;i<nlayers;i++){
			network.add(new NeuronLayer(sizelayers[i],sizelayers[i-1],min,max,factory));	
		}		

	}
	
	public double[] networkOutput(double[] input){
		double[] value=input;
	
		for(int i=0;i<network.size();i++){
			NeuronLayer layer=network.get(i);
			value=layer.LayerOutput(value);
		}

		return value;
	}
	
	public void networkLearn(double[] input,double[] expectedOutput){
		double[] output = this.networkOutput(input);
		int n = network.size();
		network.get(n-1).errorPropagationoutput(expectedOutput);
		for (int i =n-2;i>=0;i--){
			NeuronLayer nextlayer=network.get(i+1);
			network.get(i).errorPropagation(nextlayer);
		}
		
		NeuronLayer flayer=network.get(0);
		int m1=flayer.layerSize();
		for(int u=0;u<m1;u++){
			GenericNeuron neuron=flayer.getNeuron(u);
			for(int v=0;v<input.length;v++){
				neuron.changeWeight(v);
			}
		}
		for(int j=1;j<n;j++){
			
			NeuronLayer layer=network.get(j);
			NeuronLayer layer2=network.get(j-1);
			int m=layer.layerSize();
			for(int u=0;u<m;u++){
				GenericNeuron neuron=layer.getNeuron(u);
				for(int v=0;v<layer2.layerSize();v++){
					neuron.changeWeight(v);
				}
			}
		}

	}
}
