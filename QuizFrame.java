import java.awt.event.*;

import java.awt.*;

import javax.swing.*;


public class QuizFrame implements ActionListener{


	JFrame frame = new JFrame();

	JTextField textfield = new JTextField();

	JTextArea questionText = new JTextArea();

	JButton btnA = new JButton();

	JButton btnB = new JButton();

	JButton btnC = new JButton();

	JButton btnD = new JButton();

	JLabel answerLabelA = new JLabel();

	JLabel answerLabelB = new JLabel();

	JLabel answerLabelC = new JLabel();

	JLabel answerLabelD = new JLabel();

	JLabel left_time = new JLabel();

	JTextField correctQ = new JTextField();

	JTextField correct_percentage = new JTextField();
	
	private char answer;
	
	
	private String[] questions = 	{

			"   Java is a ________ programming language?",

			"   Java is case sensitive?",
			
			"   Which of the following is not a primitive data    type?",
		 	
		    "   What is the default return type of a method in    Java language?",

			"   Single line comment starts with _____ in Java",
		
			"   In standalone Java applications, which method is mandatory?",
			
			"   Which is the alternative to SWITCH in the Java language?"
			
		};

	private String[][] options = 	{

			{"High-level","Low-Level","None of the above","Middle-level"},
			
			{"Depends On Complier","True","False","May be true or false"},

			{"byte","int","short","enum"},
			
			{"int","Non of the above","short","void"},
			
			{"/*","None of these","//","/**"}, 
			
			{"main method","display method","show method","print method"},
			
			{"if,else","break,continue","for,while","goto,exit"}
					
		};
	
	private char[] answers = {'A','B','D','B','C','A','A'};
	
	private int i, correct_questions = 0, no_of_questions = questions.length, percentage_result, timer_seconds=15;


	
	Timer timer = new Timer(1000, new ActionListener() {

		@Override

		public void actionPerformed(ActionEvent e) {

			timer_seconds--;

			left_time.setText(String.valueOf(timer_seconds));

			if(timer_seconds<=0) {

				showAnswer();

			}

		 }

		});

	/**
	 * @wbp.parser.entryPoint
	 */
	
	public void initialize() {
		
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		
		frame.getContentPane().setFont(new Font("STZhongsong", Font.PLAIN, 11));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(700,700);

		frame.getContentPane().setBackground(new Color(64, 128, 128));

		frame.getContentPane().setLayout(null);

		frame.setResizable(false);

		
		textfield.setBounds(195,0,293,50);

		textfield.setBackground(new Color(64, 128, 128));

		textfield.setForeground(new Color(25,255,0));

		textfield.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));

		textfield.setBorder(null);

		textfield.setHorizontalAlignment(JTextField.CENTER);

		textfield.setEditable(false);


		questionText.setBounds(24,50,638,83);

		questionText.setLineWrap(true);

		questionText.setWrapStyleWord(true);

		questionText.setBackground(new Color(0, 128, 192));

		questionText.setForeground(new Color(25,255,0));

		questionText.setFont(new Font("Perpetua", Font.BOLD, 31));

		questionText.setBorder(BorderFactory.createBevelBorder(1));

		questionText.setEditable(false);
		
		btnA.setVerticalAlignment(SwingConstants.BOTTOM);
		
		
		btnA.setForeground(new Color(128, 128, 255));
		
		btnA.setBackground(new Color(255, 255, 255));

		btnA.setBounds(92,174,68,68);

		btnA.setFont(new Font("Palatino Linotype", Font.BOLD, 35));

		btnA.setFocusable(false);

		btnA.addActionListener(this);
		
		
		btnA.setText("A");
		
		btnB.setVerticalAlignment(SwingConstants.BOTTOM);
		
		
		btnB.setBackground(new Color(255, 255, 255));
		
		btnB.setForeground(new Color(128, 128, 255));

		btnB.setBounds(92,275,68,68);

		btnB.setFont(new Font("Palatino Linotype", Font.BOLD, 35));

		btnB.setFocusable(false);

		btnB.addActionListener(this);

		btnB.setText("B");
		
		btnC.setVerticalAlignment(SwingConstants.BOTTOM);
		
		
		btnC.setBackground(new Color(255, 255, 255));
		
		btnC.setForeground(new Color(128, 128, 255));

		btnC.setBounds(92,374,68,68);

		btnC.setFont(new Font("Palatino Linotype", Font.BOLD, 35));

		btnC.setFocusable(false);

		btnC.addActionListener(this);

		btnC.setText("C");
		
		btnD.setVerticalAlignment(SwingConstants.BOTTOM);
		
		
		btnD.setBackground(new Color(255, 255, 255));
		
		btnD.setForeground(new Color(128, 128, 255));

		btnD.setBounds(92,473,68,68);

		btnD.setFont(new Font("Palatino Linotype", Font.BOLD, 35));

		btnD.setFocusable(false);

		btnD.addActionListener(this);

		btnD.setText("D");

		
		answerLabelA.setBounds(169,174,423,68);

		answerLabelA.setBackground(new Color(128, 128, 192));

		answerLabelA.setForeground(new Color(25,255,0));

		answerLabelA.setFont(new Font("SimSun", Font.PLAIN, 30));
		

		answerLabelB.setBounds(170,275,422,68);

		answerLabelB.setBackground(new Color(50,50,50));

		answerLabelB.setForeground(new Color(25,255,0));

		answerLabelB.setFont(new Font("SimSun", Font.PLAIN, 30));

		
		answerLabelC.setBounds(169,374,423,68);

		answerLabelC.setBackground(new Color(50,50,50));

		answerLabelC.setForeground(new Color(25,255,0));

		answerLabelC.setFont(new Font("SimSun", Font.PLAIN, 30));

		
		answerLabelD.setBounds(169,475,423,68);

		answerLabelD.setBackground(new Color(50,50,50));

		answerLabelD.setForeground(new Color(25,255,0));

		answerLabelD.setFont(new Font("SimSun", Font.PLAIN, 30));


		left_time.setBounds(286,574,55,50);

		left_time.setBackground(new Color(192, 192, 192));

		left_time.setForeground(new Color(255,0,0));

		left_time.setFont(new Font("MS UI Gothic", Font.BOLD, 43));

		left_time.setBorder(BorderFactory.createBevelBorder(1));

		left_time.setHorizontalAlignment(SwingConstants.CENTER);

		left_time.setText("10");


		correctQ.setBounds(75,225,500,100);
		
		correctQ.setBackground(new Color(64,128,128));

		correctQ.setForeground(new Color(255,255,51));

		correctQ.setFont(new Font("Times new roman",Font.PLAIN,40));

		correctQ.setBorder(null);

		correctQ.setHorizontalAlignment(JTextField.CENTER);

		correctQ.setEditable(false);

		
		correct_percentage.setBounds(225,325,200,100);

		correct_percentage.setBackground(new Color(64,128,128));

		correct_percentage.setForeground(new Color(255,128,0));

		correct_percentage.setFont(new Font("Times new roman",Font.BOLD,40));

		correct_percentage.setBorder(null);

		correct_percentage.setHorizontalAlignment(JTextField.CENTER);

		correct_percentage.setEditable(false);


		frame.getContentPane().add(left_time);

		frame.getContentPane().add(answerLabelA);

		frame.getContentPane().add(answerLabelB);

		frame.getContentPane().add(answerLabelC);

		frame.getContentPane().add(answerLabelD);

		frame.getContentPane().add(btnA);

		frame.getContentPane().add(btnB);

		frame.getContentPane().add(btnC);

		frame.getContentPane().add(btnD);

		frame.getContentPane().add(questionText);

		frame.getContentPane().add(textfield);

		frame.setVisible(true);

		followingQuestion();

	}

	public void followingQuestion() {

		if(i>=no_of_questions) {

			result();

		}

		else {

			textfield.setText("Quiz "+(i+1));

			questionText.setText(questions[i]);

			answerLabelA.setText(options[i][0]);

			answerLabelB.setText(options[i][1]);

			answerLabelC.setText(options[i][2]);

			answerLabelD.setText(options[i][3]);

			timer.start();

		}

	}

	@Override

	public void actionPerformed(ActionEvent e) {

			btnA.setEnabled(false);

			btnB.setEnabled(false);

			btnC.setEnabled(false);

			btnD.setEnabled(false);

			
			if(e.getSource()==btnA) {

				answer= 'A';

				if(answer == answers[i]) {

					correct_questions++;

				}

			}

			if(e.getSource()==btnB) {

				answer= 'B';

				if(answer == answers[i]) {

					correct_questions++;

				}

			}

			if(e.getSource()==btnC) {

				answer= 'C';

				if(answer == answers[i]) {

					correct_questions++;

				}

			}

			if(e.getSource()==btnD) {

				answer= 'D';

				if(answer == answers[i]) {

					correct_questions++;

				}

			}

			showAnswer();

	}

	public void showAnswer() {

		
		timer.stop();


		btnA.setEnabled(false);

		btnB.setEnabled(false);

		btnC.setEnabled(false);

		btnD.setEnabled(false);

		
		if(answers[i] != 'A')

			answerLabelA.setForeground(new Color(255,0,0));

		if(answers[i] != 'B')

			answerLabelB.setForeground(new Color(255,0,0));

		if(answers[i] != 'C')

			answerLabelC.setForeground(new Color(255,0,0));

		if(answers[i] != 'D')

			answerLabelD.setForeground(new Color(255,0,0));

		Timer wait = new Timer(3000, new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				
				answerLabelA.setForeground(new Color(25,255,0));

				answerLabelB.setForeground(new Color(25,255,0));

				answerLabelC.setForeground(new Color(25,255,0));

				answerLabelD.setForeground(new Color(25,255,0));

				answer = ' ';

				timer_seconds = 15;

				left_time.setText(String.valueOf(timer_seconds));

				btnA.setEnabled(true);

				btnB.setEnabled(true);

				btnC.setEnabled(true);

				btnD.setEnabled(true);

				i++;

				followingQuestion();

			}

		});

		wait.setRepeats(false);

		wait.start();

	}

	public void result(){

		btnA.setVisible(false);

		btnB.setVisible(false);

		btnC.setVisible(false);

		btnD.setVisible(false);
		
		left_time.setVisible(false);
		
		questionText.setVisible(false);
		

		percentage_result = (int)((correct_questions/(double)no_of_questions)*100);

		textfield.setText("Result");

		questionText.setText("");

		answerLabelA.setText("");

		answerLabelB.setText("");

		answerLabelC.setText("");

		answerLabelD.setText("");

		correctQ.setText("Correct Questions:" + correct_questions);

		correct_percentage.setText(percentage_result+"%");

		
		frame.getContentPane().add(correctQ);
		
		frame.getContentPane().add(correct_percentage);

	}
}
