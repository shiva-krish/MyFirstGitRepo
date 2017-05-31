import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.net.*;
import java.io.*;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Tab1 {

	private JFrame frame;
	private JTextField IPaddress;
	private JTextField Portno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tab1 window = new Tab1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tab1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 438, 293);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Connect");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				  String serverName = IPaddress.getText();
			      int port = Integer.parseInt(Portno.getText());
			      try {
			         //System.out.println("Connecting to " + serverName + " on port " + port);
			         Socket client = new Socket(serverName, port);
			         
			         System.out.println("Just connected to " + client.getRemoteSocketAddress());
			         OutputStream outToServer = client.getOutputStream();
			         DataOutputStream out = new DataOutputStream(outToServer);
			         
			         out.writeUTF("Hello from " + client.getLocalSocketAddress());
			         InputStream inFromServer = client.getInputStream();
			         DataInputStream in = new DataInputStream(inFromServer);
			         
			         System.out.println("Server says " + in.readUTF());
			         client.close();
			      }catch(IOException e) {
			         e.printStackTrace();
			      }	
			}
		});
		btnNewButton.setBounds(141, 78, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JMenuItem mntmEnterIpAddress = new JMenuItem("Enter IP Address :");
		mntmEnterIpAddress.setBounds(10, 11, 121, 22);
		frame.getContentPane().add(mntmEnterIpAddress);
		
		JMenuItem mntmPortNo = new JMenuItem("Port No :");
		mntmPortNo.setBounds(10, 44, 121, 22);
		frame.getContentPane().add(mntmPortNo);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(36, 122, 267, 111);
		frame.getContentPane().add(textArea);
		
		JButton btnSend = new JButton("Send");
		btnSend.setBounds(316, 123, 89, 23);
		frame.getContentPane().add(btnSend);
		
		IPaddress = new JTextField();
		IPaddress.setBounds(144, 13, 159, 20);
		frame.getContentPane().add(IPaddress);
		IPaddress.setColumns(10);
		
		Portno = new JTextField();
		Portno.setColumns(10);
		Portno.setBounds(144, 44, 159, 20);
		frame.getContentPane().add(Portno);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Test1", "Test2", "Test3"}));
		comboBox.setBounds(255, 79, 97, 20);
		frame.getContentPane().add(comboBox);
	}
}
