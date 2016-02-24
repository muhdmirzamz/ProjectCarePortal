package GSECarePortal.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainFrame extends JFrame {

	private SigninPanel contentPane;
	
	// to centralise
	private final int COMPUTER_SCREEN_W = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private final int COMPUTER_SCREEN_H = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	public final static int APP_WINDOW_W = 640;
	public final static int APP_WINDOW_H = 480;
	private final int APP_WINDOW_X = (COMPUTER_SCREEN_W - APP_WINDOW_W) / 2;
	private final int APP_WINDOW_Y = (COMPUTER_SCREEN_H - APP_WINDOW_H) / 2;

	private static JFrame frame = null;
	
	/**
	 * Launch the application in the main method
	 */
	public static void main(String[] args) {
		try {
			// sets the UI according to the system
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame in the constructor
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(APP_WINDOW_X, APP_WINDOW_Y, APP_WINDOW_W, APP_WINDOW_H);
		setTitle("GSE Care Portal");
		setResizable(false);
		
		contentPane = new SigninPanel(this);
		setContentPane(contentPane);
	}
}
