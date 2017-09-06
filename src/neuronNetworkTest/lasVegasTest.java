package neuronNetworkTest;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gates.NeuronalNetwork;
import neuronFactory.SigmoidNeuronFactory;


public class lasVegasTest {
	NeuronalNetwork networklasvegas;
	double[][] tests=new double[150][18];
	double[][] testoutput=new double[150][5];

	@Before
	public void setUp() throws Exception {
		double learningrate=0.2;
		double learningrate2=0.1;
		double bias=1;
		int nlayers = 3;
		int ninputs=18;
		int min=0;
		int max=2;
		int[] sizelayers={2,3,5};
		int nlearns=354;
		int ntest=150;
	
		int u=0;
		int v=0;
		SigmoidNeuronFactory factory=new SigmoidNeuronFactory(learningrate,bias);
		SigmoidNeuronFactory factory2=new SigmoidNeuronFactory(learningrate2,bias);
		NeuronalNetwork network=new NeuronalNetwork(ninputs,nlayers,sizelayers,factory,min,max);
		NeuronalNetwork network2=new NeuronalNetwork(ninputs,nlayers,sizelayers,factory2,min,max);
		
		String filename ="LasVegasTripAdvisorReviews-Dataset.csv";
		File file=new File(filename);
		try {
			Scanner inputStream=new Scanner(file);
			String data=inputStream.nextLine();
			while(inputStream.hasNext()){
				data=inputStream.nextLine();
				String[] values=data.split(";");
				

				double nrreview=Double.parseDouble(values[1]);//755 1
				double nrhotel=Double.parseDouble(values[2]);// 263 0
				double helpfulvotes=Double.parseDouble(values[3]); //365 1
				double score=Double.parseDouble(values[4]);  //5  1
				double country = 0;//0 43
				int travelertype = 0; //0 4
				double pool=0;
				double gym = 0;
				double teniscourse = 0;
				double spa = 0;
				double casino = 0;
				double freeinternet = 0;
				double hotelname = 0; //0 20 
				double hotelstars=Double.parseDouble(values[14]);//5 3
				double rooms=Double.parseDouble(values[15]);// 4027 188
				double continent = 0; //0 5
				double memberyears=Double.parseDouble(values[17]); //13 0
				double reviewmonth = 0; //0 11
				double revieweekday =0; //0 6
				
		
				switch(values[0]){
				
				case("USA"):{
					country=0;
					break;
				}
				case("UK"):{
					country=1;
					break;
				}
				case("Canada"):{
					country=2;
					break;
				}
				case("India"):{
					country=3;
					break;
				}
				case("Australia"):{
					country=4;
					break;
				}
				case("New Zeland"):{
					country=5;
					break;
				}
				case("Ireland"):{
					country=6;
					break;
				}
				case("Egypt"):{
					country=7;
					break;
				}
				case("Finland"):{
					country=8;
					break;
				}
				case("Kenya"):{
					country=9;
					break;
				}
				case("Jordan"):{
					country=10;
					break;
				}
				case("Netherlands"):{
					country=11;
					break;
				}
				case("Syria"):{
					country=12;
					break;
				}
				case("Scotland"):{
					country=13;
					break;
				}
				case("South Africa"):{
					country=14;
					break;
				}
				case("Swiss"):{
					country=15;
					break;
				}
				case("United Arab Emirates"):{
					country=16;
					break;
				}
				case("Hungary"):{
					country=17;
					break;
				}
				case("China"):{
					country=18;
					break;
				}
				case("Greece"):{
					country=19;
					break;
				}
				case("Mexico"):{
					country=20;
					break;
				}
				case("Croatia"):{
					country=21;
					break;
				}
				case("Germany"):{
					country=22;
					break;
				}
				case("Malaysia"):{
					country=23;
					break;
				}
				case("Thailand"):{
					country=24;
					break;
				}
				case("Phillippines"):{
					country=25;
					break;
				}
				case("Israel"):{
					country=26;
					break;
				}
				case("Belgium"):{
					country=27;
					break;
				}
				case("Puerto Rico"):{
					country=28;
					break;
				}
				case("Switzerland"):{
					country=29;
					break;
				}
				case("Norway"):{
					country=30;
					break;
				}
				case("France"):{
					country=31;
					break;
				}
				case("Spain"):{
					country=32;
					break;
				}
				case("Singapore"):{
					country=33;
					break;
				}
				case("Brazil"):{
					country=34;
					break;
				}
				case("Saudi Arabia"):{
					country=35;
					break;
				}
				case("Honduras"):{
					country=36;
					break;
				}
				case("Denmark"):{
					country=37;
					break;
				}
				case("Taiwan"):{
					country=38;
					break;
				}
				case("Hawaii"):{
					country=39;
					break;
				}
				case("Kuwait"):{
					country=40;
					break;
				}
				case("Czech Republic"):{
					country=41;
					break;
				}
				case("Korea"):{
					country=42;
					break;
				}
				case("Italy"):{
					country=43;
					break;
				}
				/*Paises totales =44*/

				}
				
				/*Traveler type*/
				switch(values[6]){
				case("Friends"):{
					travelertype=0;
					break;
				}
				case("Business"):{
					travelertype=1;
					break;
				}
				case("Families"):{
					travelertype=2;
					break;
				}
				case("Solo"):{
					travelertype=3;
					break;
				}
				
				case("Couples"):{
					travelertype=4;
					break;
				}
				}
				/*Total traveler type = 5*/
				/*Pool*/
				switch(values[7]){
				case("NO"):{
					pool=0;
					break;
				}
				case("YES"):{
					pool=1;
					break;
				}

				}
				/*GYM*/
				switch(values[8]){
				case("NO"):{
					gym=0;
					break;
				}
				case("YES"):{
					gym=1;
					break;
				}

				}
				/*Tennis course*/
				switch(values[9]){
				case("NO"):{
					teniscourse=0;
					break;
				}
				case("YES"):{
					teniscourse=1;
					break;
				}

				}
				/*Spa*/
				switch(values[10]){
				case("NO"):{
					spa=0;
					break;
				}
				case("YES"):{
					spa=1;
					break;
				}

				}
				
				/*casino*/
				switch(values[11]){
				case("NO"):{
					casino=0;
					break;
				}
				case("YES"):{
					casino=1;
					break;
				}

				}
				/*continent*/
				switch(values[16]){
				case("North America"):{
					continent=0;
					break;
				}
				case("Europe"):{
					continent=1;
					break;
				}
				case("Asia"):{
					continent=2;
					break;
				}
				case("Oceania"):{
					continent=3;
					break;
				}
				case("Africa"):{
					continent=4;
					break;
				}
				case("South America"):{
					continent=5;
					break;
				}


				}
				
				/*review month*/
				switch(values[18]){
				case("January"):{
					reviewmonth=0;
					break;
				}
				case("February"):{
					reviewmonth=1;
					break;
				}
				case("March"):{
					reviewmonth=2;
					break;
				}
				case("April"):{
					reviewmonth=3;
					break;
				}
				case("May"):{
					reviewmonth=4;
					break;
				}
				case("June"):{
					reviewmonth=5;
					break;
				}
				case("July"):{
					reviewmonth=6;
					break;
				}
				case("August"):{
					reviewmonth=7;
					break;
				}
				case("September"):{
					reviewmonth=8;
					break;
				}
				case("October"):{
					reviewmonth=9;
					break;
				}
				case("November"):{
					reviewmonth=10;
					break;
				}
				case("December"):{
					reviewmonth=11;
					break;
				}

				}
				/*Review weekday=7*/
				switch(values[19]){
				case("Monday"):{
					revieweekday=0;
					break;
				}
				case("Tuesday"):{
					revieweekday=1;
					break;
				}
				case("Wednesday"):{
					revieweekday=2;
					break;
				}
				case("Thursday"):{
					revieweekday=3;
					break;
				}
				case("Friday"):{
					revieweekday=4;
					break;
				}
				case("Saturday"):{
					revieweekday=5;
					break;
				}
				case("Sunday"):{
					revieweekday=6;
					break;
				}

				}
				
				/*Hotel name*/
				switch(values[13]){
				case("Circus Circus Hotel & Casino Las Vegas"):{
					hotelname=0;
					break;
				}
				case("Excalibur Hotel & Casino"):{
					hotelname=1;
					break;
				}
				case("Monte Carlo Resort&Casino"):{
					hotelname=2;
					break;
				}
				case("Treasure Island- TI Hotel & Casino"):{
					hotelname=3;
					break;
				}
				case("Tropicana Las Vegas - A Double Tree by Hilton Hotel"):{
					hotelname=4;
					break;
				}
				case("Caesars Palace"):{
					hotelname=5;
					break;
				}
				case("The Cosmopolitan Las Vegas"):{
					hotelname=6;
					break;
				}
				case("The Palazzo Resort Hotel Casino"):{
					hotelname=7;
					break;
				}
				case("Wynn Las Vegas"):{
					hotelname=8;
					break;
				}
				case("Trump International Hotel Las Vegas"):{
					hotelname=9;
					break;
				}
				case("The Cromwell"):{
					hotelname=10;
					break;
				}
				case("Encore at wynn Las Vegas"):{
					hotelname=11;
					break;
				}
				case("Hilton Grand Vacations on the Boulevard"):{
					hotelname=12;
					break;
				}
				case("Marriott's Grand Chateau"):{
					hotelname=13;
					break;
				}
				case("Tuscany Las Vegas Suites & Casino"):{
					hotelname=14;
					break;
				}
				case("Hilton Grand Vacations at the Flamingo"):{
					hotelname=15;
					break;
				}
				case("Wyndham Grand Desert"):{
					hotelname=16;
					break;
				}
				case("The Venetian Las Vegas Hotel"):{
					hotelname=17;
					break;
				}
				case("Bellagio Las Vegas"):{
					hotelname=18;
					break;
				}
				case("Paris Las Vegas"):{
					hotelname=19;
					break;
				}
				case("The Westin las Vegas Hotel Casino & Spa"):{
					hotelname=20;
					break;
				}

				}
				
				/*Normalization:*/

				nrreview=normalizationOneZero(nrreview,755,1);
				nrhotel=normalizationOneZero(nrhotel, 263,0);
				helpfulvotes=normalizationOneZero(helpfulvotes, 365,1);
				score=normalizationOneZero(score, 5,1);
				country=normalizationOneZero(score, 43,0);
				//travelertype=normalizationOneZero(travelertype, 4,0);
				hotelname=normalizationOneZero(hotelname, 20,0);
				hotelstars=normalizationOneZero(hotelstars, 5,3);
				rooms=normalizationOneZero(rooms, 4027,188);
				continent=normalizationOneZero(continent, 5,0);
				memberyears=normalizationOneZero(memberyears, 13,0);
				reviewmonth=normalizationOneZero(reviewmonth, 11,0);
				revieweekday=normalizationOneZero(revieweekday, 6,0);
				
				double[] input={country,nrreview,nrhotel,helpfulvotes,score,pool,gym,teniscourse,spa,
						casino,freeinternet,hotelname,hotelstars,rooms,continent,memberyears,reviewmonth,revieweekday};
				
				double[] output={0,0,0,0,0};
				
				output[travelertype]=1;
				if(u<nlearns){
					network.networkLearn(input, output);
				}
				else{
					tests[v]=input;
					testoutput[v]=output;
					v++;
				}
				u++;
				}
				networklasvegas=network;
			
			
			
			}
		

		catch(FileNotFoundException e){
			
		}

	}

	@After
	public void tearDown() throws Exception {
	}




	@Test
	public void speedtestnetwork() {
		int i=0;
		long start = System.nanoTime();   
		while(i<104){
		double[] val=networklasvegas.networkOutput(tests[i]);
		i++;
		}
		long elapsedTime = System.nanoTime() - start;
		System.out.println("Tiempo transcurrido en nanosegundos "+elapsedTime);
		assertTrue(true);
	}
	
	@Test
	public void acuraccytestnetwork() {
		int i=0;
		int truep=0;
		int falsep=0;
		
		while(i<150){
		double[] val=networklasvegas.networkOutput(tests[i]);
		
		int prediction=maxoutput(val);
		System.out.println("predic "+prediction);
		System.out.println("real "+maxoutput(testoutput[i]));
		if(prediction==maxoutput(testoutput[i])){
			truep++;
		}
		else{
			falsep++;
		}
		i++;
		}
		System.out.println("Aciertos "+truep);
		System.out.println("Fallos "+falsep);
		assertTrue(true);
	}
	
	

	@Test
	public void testnormalization() {
		assertEquals(0.5, normalizationOneZero(0,10,-10), 0.001);
	}
	
	static double normalizationOneZero(double v,double max, double min){
		return ((v-min)/(max-min)); 
	}
	static int maxoutput(double[] output){
		double max=output[0];
		int ret=0;
		for(int i=0;i<output.length;i++){
			if(output[i]>max){
				max=output[i];
				ret=i;
			}
		}
		return ret;
	}

}
