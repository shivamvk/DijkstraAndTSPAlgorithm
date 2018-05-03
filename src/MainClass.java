import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.Font;

public class MainClass extends JFrame implements ActionListener {

	private JPanel contentPane;
	
	public JButton btnDijkstraAlgorithm;
	public JButton btnTspAlgorithm;
	public static int numberOfNodes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClass frame = new MainClass();
					frame.setVisible(true);
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
	public MainClass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Welcome to the Path Finder");
		label.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 16));
		label.setBounds(230, 10, 221, 22);
		contentPane.add(label);
		
		btnDijkstraAlgorithm = new JButton("Dijkstra Algorithm");
		btnDijkstraAlgorithm.setBounds(169, 84, 117, 32);
		contentPane.add(btnDijkstraAlgorithm);
		btnDijkstraAlgorithm.addActionListener(this);
		
		btnTspAlgorithm = new JButton("TSP Algorithm");
		btnTspAlgorithm.setBounds(395, 84, 117, 32);
		contentPane.add(btnTspAlgorithm);
		
		Label label_1 = new Label("Submitted by:");
		label_1.setFont(new Font("Colonna MT", Font.BOLD, 16));
		label_1.setBounds(500, 242, 117, 22);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Shivam Bhasin (16103223)");
		label_2.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		label_2.setBounds(500, 281, 174, 22);
		contentPane.add(label_2);
		
		Label label_3 = new Label("Sahil Gupta (16103329)");
		label_3.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		label_3.setBounds(500, 309, 174, 22);
		contentPane.add(label_3);
		
		Label label_4 = new Label("Aman Singh (16103234)");
		label_4.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		label_4.setBounds(500, 337, 174, 22);
		contentPane.add(label_4);
		
		Label label_5 = new Label("Ashish Garg (16103323)");
		label_5.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		label_5.setBounds(500, 365, 174, 22);
		contentPane.add(label_5);
		btnTspAlgorithm.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton)e.getSource();
		if(clickedButton == btnDijkstraAlgorithm)	{
			DijkstraUI.startApplication();
		} else if(clickedButton == btnTspAlgorithm) {
			TSPAlgorithm tspalgorithm = new TSPAlgorithm();
		}
	}
}
