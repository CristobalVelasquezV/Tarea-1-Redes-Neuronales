package neuronNetworkTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gates.GenericNeuron;
import gates.NeuronLayer;
import gates.NeuronalNetwork;
import gates.SigmoidNeuron;

public class teacherTest {

	@Before
	public void setUp() throws Exception {
		double learningrate1=0.5;
		double bias1=0.1;
		double[] w1={0.1,0.2};
		GenericNeuron neuron1=new SigmoidNeuron(learningrate1,bias1,w1);
		neuron1.changeOutput(0.2);
		double learningrate2=0.5;
		double bias2=0.1;
		double[] w2={0.2,0.3};
		GenericNeuron neuron2=new SigmoidNeuron(learningrate2,bias2,w2);
		neuron2.changeOutput(0.3);
		double learningrate3=0.5;
		double bias3=0.1;
		double[] w3={0.3,0.4};
		GenericNeuron neuron3=new SigmoidNeuron(learningrate3,bias3,w3);
		neuron3.changeOutput(0.2);
		ArrayList<GenericNeuron> arrayneuron=new ArrayList<GenericNeuron>();
		arrayneuron.add(neuron1);
		arrayneuron.add(neuron2);
		NeuronLayer layer1=new NeuronLayer(arrayneuron);
		ArrayList<GenericNeuron> out=new ArrayList<GenericNeuron>();
		out.add(neuron3);
		NeuronLayer layer2=new NeuronLayer(out);
		ArrayList<NeuronLayer> arraylayer=new ArrayList<NeuronLayer>();
		arraylayer.add(layer1);
		arraylayer.add(layer2);
		NeuronalNetwork network=new NeuronalNetwork(arraylayer);
		double[] inp={0.9,0.8};
		double[] outp={1};
		network.networkLearn(inp, outp);
		network.showWeights();
		System.out.println(network.size());
		System.out.println(layer1.layerSize());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
