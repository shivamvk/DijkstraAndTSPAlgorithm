import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.util.concurrent.*;

public class DijkstraUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private int selectedButtons = 0;
	JLabel lblSelectAStarting;
	Button btsolveByDijkstra;
	Button startButton = null;
	Button endButton = null;
	static int startButtonLabel;
	static int endButtonLabel;
	static Button button[] = new Button[32];
	boolean resetRequired = false;
	Button resetButton;
	
	public static Vector<Integer> obstacles = new Vector<Integer>();
	
	public static DijkstraUI frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		startApplication();
	}
	
	public static void startApplication(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DijkstraUI();
					frame.setVisible(true);
					frame.setTitle("Dijkstra Algorithm");
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DijkstraUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblPathFinder = new JLabel("Path Finder");
		lblPathFinder.setFont(new Font("Sylfaen", Font.PLAIN, 32));
		lblPathFinder.setBounds(500, 11, 200, 50);
		contentPane.add(lblPathFinder);
		
		lblSelectAStarting = new JLabel("Select a starting point from the following grid!");
		lblSelectAStarting.setFont(new Font("Nirmala UI", Font.ITALIC, 15));
		lblSelectAStarting.setBounds(430, 104, 350, 20);
		contentPane.add(lblSelectAStarting);
		
		Panel panel = new Panel();
		panel.setBounds(10, 180, 1180, 280);
		contentPane.add(panel);
		panel.setLayout(null);
		
		for(int i=0; i<32; i++) {
			button[i] = new Button();
		}
		
		button[0].setBounds(100, 10, 100, 50);
	
		button[1].setBounds(220, 10, 100, 50);
		
		button[2].setBounds(340, 10, 100, 50);
		
		button[3].setBounds(460, 10, 100, 50);
		
		button[4].setBounds(580, 10, 100, 50);
		
		button[5].setBounds(700, 10, 100, 50);
		
		button[6].setBounds(820, 10, 100, 50);
		
		button[7].setBounds(940, 10, 100, 50);
		
		button[8].setBounds(100, 80, 100, 50);
		
		button[9].setBounds(220, 80, 100, 50);
		
		button[10].setBounds(340, 80, 100, 50);
		
		button[11].setBounds(460, 80, 100, 50);
		
		button[12].setBounds(580, 80, 100, 50);
		
		button[13].setBounds(700, 80, 100, 50);
		
		button[14].setBounds(820, 80, 100, 50);
		
		button[15].setBounds(940, 80, 100, 50);
		
		button[16].setBounds(100, 150, 100, 50);
		
		button[17].setBounds(220, 150, 100, 50);
		
		button[18].setBounds(340, 150, 100, 50);
		
		button[19].setBounds(460, 150, 100, 50);
		
		button[20].setBounds(580, 150, 100, 50);
		
		button[21].setBounds(700, 150, 100, 50);
		
		button[22].setBounds(820, 150, 100, 50);
		
		button[23].setBounds(940, 150, 100, 50);
		
		button[24].setBounds(100, 220, 100, 50);
		
		button[25].setBounds(220, 220, 100, 50);
		
		button[26].setBounds(340, 220, 100, 50);
		
		button[27].setBounds(460, 220, 100, 50);
		
		button[28].setBounds(580, 220, 100, 50);
		
		button[29].setBounds(700, 220, 100, 50);
		
		button[30].setBounds(820, 220, 100, 50);

		button[31].setBounds(940, 220, 100, 50);
		
		
		for(int i=0; i<32; i++) {
			button[i].setLabel(i+"");
			panel.add(button[i]);
			button[i].addActionListener((ActionListener)this);
		}
		
		btsolveByDijkstra = new Button("Solve by Dijkstra");
		btsolveByDijkstra.setFont(new Font("Dialog", Font.PLAIN, 18));
		btsolveByDijkstra.setBounds(496, 519, 150, 80);
		contentPane.add(btsolveByDijkstra);
		btsolveByDijkstra.addActionListener((ActionListener) this);
		
		resetButton = new Button("Reset");
		resetButton.setBounds(535, 605, 70, 22);
		contentPane.add(resetButton);
		resetButton.addActionListener(this);
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Button clickedButton = (Button)e.getSource();
		if (selectedButtons == 0 && clickedButton != btsolveByDijkstra && clickedButton != resetButton) {
			resetRequired = true;
			startButtonLabel = Integer.parseInt(clickedButton.getLabel());
			clickedButton.setLabel("Start");
			clickedButton.setBackground(Color.RED);
			startButton = clickedButton;
			lblSelectAStarting.setText("Select a ending");
			lblSelectAStarting.setBounds(530, 104, 350, 20);
			selectedButtons++;
		}
		else if (selectedButtons == 1 && clickedButton != btsolveByDijkstra && clickedButton != resetButton) {
			if (clickedButton == startButton) {
				JOptionPane.showMessageDialog(null, "Starting and ending point can't be same");
			} else {
				endButtonLabel = Integer.parseInt(clickedButton.getLabel());
				clickedButton.setLabel("End");
				clickedButton.setBackground(Color.GREEN);
				endButton = clickedButton;
				lblSelectAStarting.setText("Select the obstacles");
				lblSelectAStarting.setBounds(515, 104, 280, 14);
				selectedButtons++;
			}
		}
		else if (selectedButtons > 1 && selectedButtons < 15 && clickedButton != btsolveByDijkstra && clickedButton != resetButton) {
			 if (clickedButton == startButton) {
				 JOptionPane.showMessageDialog(null, "Starting point can't be an obstacle");
			 } else if (clickedButton == endButton) {
				 JOptionPane.showMessageDialog(null, "Ending point can't be an obstacle");
			 } else {
				 clickedButton.setForeground(Color.WHITE);
				 clickedButton.setBackground(Color.BLACK);
				 int label = Integer.parseInt(clickedButton.getLabel());
				 makeObstaclesVector(label);
				 clickedButton.setLabel("Obstacle");
				 selectedButtons++;
			 }
		}
		else if (selectedButtons == 15 && clickedButton != btsolveByDijkstra && clickedButton != resetButton) {
			JOptionPane.showMessageDialog(null, "Obstacles can't be more than 13");
		}
		
		if (clickedButton == resetButton && resetRequired == true) {
			frame.dispose();
			JOptionPane.showMessageDialog(null, "Reset done!");
			startApplication();
		}
		
		if (clickedButton == btsolveByDijkstra) {
			if(startButton != null && endButton != null) {
				DijkstraUtils utils = new DijkstraUtils();
				colorThePath();
			}
		}
	}
	
	private static void colorThePath() {
		if(DijkstraUtils.path.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No Path Found! Reset and try again.");
			return;
		}
		for(int i=1; i<31; i++) {
	        Iterator<Integer> itr = DijkstraUtils.path.iterator();
	    	System.out.println("Path is: ");
	    	while(itr.hasNext()) {
	    		System.out.println(itr.next());
	    	}
			if(DijkstraUtils.path.contains(i) && i!=DijkstraUI.startButtonLabel
					&& i!=DijkstraUI.endButtonLabel 
					&& !DijkstraUI.obstacles.contains(i)) {
				button[i].setBackground(Color.YELLOW);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void makeObstaclesVector(int label) {
		obstacles.add(label);
	}
}
