import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
	
	static Scanner userStringInput = new Scanner(System.in);
	static Scanner userIntInput = new Scanner(System.in);
	static boolean play = true;
	static boolean start = true;
	static Player p;
	static int foodAmount;
	static int miles;
	static int dayCounter;
	
	
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, moneyLabel, moneyLabelName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 80);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 24);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	String position;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();


	public static void main(String[] args) {

		new Game();
	}
	
	public Game(){
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("The Oregon Trail");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);	
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		
		window.setVisible(true);
	}
	
	public void createGameScreen(){
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea();
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		con.add(playerPanel);
		
		hpLabel = new JLabel("Health:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		
		moneyLabel = new JLabel("Money:");
		moneyLabel.setFont(normalFont);
		moneyLabel.setForeground(Color.white);
		playerPanel.add(moneyLabel);
		
		moneyLabelName = new JLabel();
		moneyLabelName.setFont(normalFont);
		moneyLabelName.setForeground(Color.white);
		playerPanel.add(moneyLabelName);
		
		moneyLabelName.setText("0");
		hpLabelNumber.setText("100");

		welcome();
//		numReset();
//		playerSetup();

	}
	
	public void welcome()
	{
		position = "welcome";
		mainTextArea.setText("Welcome to The Oregon Trail ");
		choice1.setText("Play");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	
	public void numReset()
	{
		moneyLabelName.setText("" +p.getMoney());
		hpLabelNumber.setText("" + p.getHealth());
	}
	
	public void playerSetup(){
		
		
		setJob();
	}
	
	public void setJob()
	{
		position = "setJob";
		mainTextArea.setText("Many kinds of people made the trip to Oregon. \n You may: ");
		choice1.setText("\tBe a banker from Boston");
		choice2.setText("\tBe a carpenter from Ohio");
		choice3.setText("\tBe a farmer from Illinois");
		choice4.setText("\tFind out the differences between the choices");
	}
	
	public void setFood()
	{
		position = "setFood";
		mainTextArea.setText("Your going to need supplies for your trip."
				+ "\nThe amount of food you get will help you survive"
				+ "\n200 lbs of food is recommended"
				+ "\n1 pound of food costs $2 ");
		choice1.setText("\t10 lbs");
		choice2.setText("\t50 lbs");
		choice3.setText("\t100 lbs");
		choice4.setText("\t200 lbs");
	}
	
	public void travel()
	{
		position = "travel";
		mainTextArea.setText("Lets travel the trail");
		choice1.setText(">");
		choice2.setText("Get Food");
		choice3.setText("");
		choice4.setText("");
		
	}
	
	
	public void win(){
		position = "win";
		
		mainTextArea.setText("You won");
		
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void lose(){
		position = "lose";
		
		mainTextArea.setText("You are dead!\n\n");
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void ending(){
		position = "ending";
		
		mainTextArea.setText("You Lost");
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}



	
	
	
		
	
	
	
	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			createGameScreen();
		}
	}
	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			String yourChoice = event.getActionCommand();
			
			switch(position){
				case "welcome":
					switch(yourChoice)
					{
						case "c1":
							setJob();
							
							break;
					}
					break;
				case "setJob":
					switch(yourChoice)
					{
					case "c1": 
						
//						p.setMoney(800.00);
//						numReset();
						setFood();
						
						
						break;
					case "c2": 
						
//						p.setMoney(400.00);
//						numReset();
						setFood();
					
						break;
					case "c3": 
						
//						p.setMoney(200.00);
//						numReset();
						setFood();
					
						break;
						
						
					} 
					break;
					
				case "setFood":
					switch(yourChoice)
					{
						case "c1":
							//p.setFood(10);
							travel();
							
							break;
						case "c2":
							//p.setFood(50);
							travel();
							
							break;
						case "c3":
							//p.setFood(100);
							travel();
							
							break;
						case "c4":
							//p.setFood(200);
							travel();
							
							break;
					
				}
					break;
					
				case "travel":
					switch(yourChoice)
					{
						case "c1":
							travel();
							
							break;
							
						case "c2":
							setFood();
							
							break;
							
							
						
					}
					
					break;
		
			
				
			}
			
			
		}
	}



}