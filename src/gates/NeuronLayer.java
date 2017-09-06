package gates;

import java.util.ArrayList;
import java.util.Random;

import neuronFactory.NeuronFactory;

public class NeuronLayer {
	
	private ArrayList<GenericNeuron> layer;
	
	
	public NeuronLayer (int n , NeuronFactory factory,double...weights){
		layer=new ArrayList<GenericNeuron>();
		if(weights.length>0){
		
		for(int i=0;i<n;i++){
			layer.add(factory.CreateNeuron(weights));
		}}
		else{
			double [] w=new double[n];
			
			for(int i=0;i<n;i++){
				w[i]=1;
			}
			
			for(int i=0;i<n;i++){
				layer.add(factory.CreateNeuron(w));
			}
		}
	}
	
	public NeuronLayer (int n ,int nweights,int min,int max, NeuronFactory factory){
		layer=new ArrayList<GenericNeuron>();
			Random ran = new Random();
			double [] w=new double[nweights];
			
			for(int i=0;i<n;i++){
				for(int j=0;j<nweights;j++){
					int x=ran.nextInt(max - min + 1)+ min;
					w[j]=x;
				}
				layer.add(factory.CreateNeuron(w));
			}
	
	}
	public double[] LayerOutput(double[] inputs){
		double[] ret=new double[layer.size()];
		for(int i=0;i<layer.size();i++){
			GenericNeuron neuron=layer.get(i);
			neuron.changeLastInput(inputs);
			ret[i]=neuron.output(inputs);
		}
		return ret;
	}
	
	public void errorPropagation(NeuronLayer nextlayer) {
		int n=nextlayer.layerSize();
		int m=this.layerSize();
		double totalerror=0;
		double output;
		for(int j=0;j<m;j++){
		for(int i=0;i<n;i++){
			GenericNeuron neuron=nextlayer.getNeuron(i);
			totalerror+=neuron.returnError(j);
		}
		GenericNeuron thisneuron=layer.get(j);
		output=thisneuron.getLastOutput();
		thisneuron.changeDelta(totalerror*output*(1-output));
		totalerror=0;
		}
				
	}
	public void errorPropagationoutput(double[] expectedOutput){
		double error;
		double delta;
		double output;
		int n=layer.size();
		
		for(int i=0;i<n;i++){
			GenericNeuron neuron=layer.get(i);
			output=neuron.getLastOutput();
			error=expectedOutput[i]-output;
			delta=error*output*(1-output);
			neuron.changeDelta(delta);
			neuron.changeError(error);
		}
	}
	
	public GenericNeuron getNeuron(int i){
		return layer.get(i);
	}
	
	public int layerSize(){
		return layer.size();
	}
	public void updateWeight(int i) {
			
		
	}
	


}
