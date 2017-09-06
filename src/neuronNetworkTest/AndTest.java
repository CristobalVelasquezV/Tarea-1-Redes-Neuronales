package neuronNetworkTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gates.NeuronalNetwork;
import neuronFactory.SigmoidNeuronFactory;

public class AndTest {
	public NeuronalNetwork andnetwork;
	double[] input1={0,0};
	double[] input2={0,1};
	double[] input3={1,0};
	double[] input4={1,1};

	@Before
	public void setUp() throws Exception {
		double learningrate=0.01;
		double bias=1;
		int nlayers = 2;
		int ninputs=2;
		int min=0;
		int max=2;
		int[] sizelayers={2,1};
		SigmoidNeuronFactory factory=new SigmoidNeuronFactory(learningrate,bias);
		NeuronalNetwork network=new NeuronalNetwork(ninputs,nlayers,sizelayers,factory,min,max);

		
		double[] output0={0};
		double[] output1={1};
		int ntest=100000;
		for(int i=0;i<ntest;i++){
			network.networkLearn(input1,output0);
			network.networkLearn(input2,output0);
			network.networkLearn(input3,output0);
			network.networkLearn(input4,output1);
		}
		andnetwork=network;
	}

	@After
	public void tearDown() throws Exception {
		double[] results1=andnetwork.networkOutput(input1);
		for(int i=0;i<results1.length;i++){
			System.out.println(results1[i]);
		}
		
	}

	@Test
	public void test() {
		
		 assertEquals("Testing 0,0", true,andnetwork.networkOutput(input1)[0]<0.5);

	}
	@Test
	public void test2() {
		
		 assertEquals("Testing 0,1", true,andnetwork.networkOutput(input2)[0]<0.5);

	}
	@Test
	public void test3() {

		 assertEquals("Testing 1,0", true,andnetwork.networkOutput(input3)[0]<0.5);

	}
	@Test
	public void test4() {
		
		 assertEquals("Testing 1,1", true,andnetwork.networkOutput(input4)[0]>0.5);
	}

}
