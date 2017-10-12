package gates;

import java.util.ArrayList;
import java.util.Random;

import neuronFactory.NeuronFactory;

public class NeuronalNetwork {
	private ArrayList<NeuronLayer> network;
	
	public NeuronalNetwork(ArrayList<NeuronLayer> lst){
		network=lst;
	}
	
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
	
	public NeuronalNetwork() {
		/*5 inputs 1 output , 2 layers */
		double learningrate1=0.5;
		double bias1=0.1;
		Random ran = new Random();
		//generar pesos aleatorios entre 1 y 2

		int max = 2;
		
		int p1=ran.nextInt(max  + 1);
		int p2=ran.nextInt(max + 1);
		int p3=ran.nextInt(max + 1);
		int p4=ran.nextInt(max + 1);
		int p5=ran.nextInt(max + 1);
		double[] w1={p1,p2,p3,p4,p5};
		GenericNeuron neuron1=new SigmoidNeuron(learningrate1,bias1,w1);
	
		p1=ran.nextInt(max  + 1);
		p2=ran.nextInt(max + 1);
		p3=ran.nextInt(max + 1);
		p4=ran.nextInt(max + 1);
		p5=ran.nextInt(max + 1);
		double[] w2={p1,p2,p3,p4,p5};
		GenericNeuron neuron2=new SigmoidNeuron(learningrate1,bias1,w2);
		p1=ran.nextInt(max  + 1);
		p2=ran.nextInt(max + 1);
		p3=ran.nextInt(max + 1);
		p4=ran.nextInt(max + 1);
		p5=ran.nextInt(max + 1);

		double[] w3={p1,p2,p3,p4,p5};
		GenericNeuron neuron3=new SigmoidNeuron(learningrate1,bias1,w3);
		p1=ran.nextInt(max  + 1);
		p2=ran.nextInt(max + 1);
		p3=ran.nextInt(max + 1);
		p4=ran.nextInt(max + 1);
		p5=ran.nextInt(max + 1);
		double[] w4={p1,p2,p3,p4,p5};
		GenericNeuron neuron4=new SigmoidNeuron(learningrate1,bias1,w4);
		p1=ran.nextInt(max  + 1);
		p2=ran.nextInt(max + 1);
		p3=ran.nextInt(max + 1);
		p4=ran.nextInt(max + 1);
		p5=ran.nextInt(max + 1);
		double[] w5 ={p1,p2,p3,p4,p5};
		GenericNeuron neuron5=new SigmoidNeuron(learningrate1,bias1,w5);
		
		p1=ran.nextInt(max  + 1);
		p2=ran.nextInt(max + 1);
		p3=ran.nextInt(max + 1);
		p4=ran.nextInt(max + 1);
		p5=ran.nextInt(max + 1);
		double[] w6 ={p1,p2,p3,p4,p5};
		GenericNeuron neuron6=new SigmoidNeuron(learningrate1,bias1,w6);

		ArrayList<GenericNeuron> arrayneuron=new ArrayList<GenericNeuron>();
		arrayneuron.add(neuron1);
		arrayneuron.add(neuron2);
		arrayneuron.add(neuron3);
		arrayneuron.add(neuron4);
		arrayneuron.add(neuron5);
		NeuronLayer layer1=new NeuronLayer(arrayneuron);
		ArrayList<GenericNeuron> out=new ArrayList<GenericNeuron>();
		out.add(neuron6);
		NeuronLayer layer2=new NeuronLayer(out);
		ArrayList<NeuronLayer> arraylayer=new ArrayList<NeuronLayer>();
		arraylayer.add(layer1);
		arraylayer.add(layer2);
		network=arraylayer;
		
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
		
		/*new */
		/*for(NeuronLayer neuronl :network){
			
			for(int i=0;i<neuronl.layerSize();i++){
				GenericNeuron neuron=neuronl.getNeuron(i);
				neuron.changeOutput(output[0]);
			}
		}*/
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
			neuron.changeBias();
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
				neuron.changeBias();
				
			}
		}
		

	}
	
	public void showWeights(){
		for(int i=0;i<this.network.size();i++){
			System.out.println("Layer: "+i);
			this.network.get(i).showWeights();
		}
	}
	
	public int size(){
		return network.size();
	}
}
