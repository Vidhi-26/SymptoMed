/*
 * Name: Vidhi Ruparel
 * Date: January 10, 2022
 * Notes:
 */
package view;


//imports
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

//imports
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.FindDiseasesController;
import model.Disease;


/**
 * MoreInformationFrame class is  used to show more information about a disease a user is detected with.
 * It shows the about, causes, treatments, research of a disease with a web link for further reading.
 */
@SuppressWarnings("serial")
public class MoreInformationFrame extends JFrame {
	
	//instance variables
	private HeaderPanel headerPanel = new HeaderPanel();	//header
	
	private JPanel about;
	private JPanel causes;
	private JPanel treatments;
	private JPanel webLink;
	
	private JLabel aboutTitle;
	private JLabel causesTitle;
	private JLabel treatmentsTitle;
	private JLabel linkTitle;
	
	private JLabel aboutContent;
	private JLabel causesContent;
	private JLabel treatmentsContent;
	private JLabel linkContent;

	private ShapePanel shapePanel;
	
	
	//constructor
	public MoreInformationFrame(Disease disease) {
		
		setTitle("Final Project");
		setLayout(null);
		setSize(1400, 800);
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		headerPanel.setBounds(0, 0, 1400, 75);
		headerPanel.setBackground(new Color(21, 132, 121));
		headerPanel.getLogoLabel().setForeground(Color.white);
		add(headerPanel);
		
		//adds the back button
		JButton backButton = new JButton("BACK");
		backButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		backButton.setFont(new Font("Roboto", Font.PLAIN, 14));
		backButton.setForeground(Color.white);
		backButton.setBounds(10, 15, 70, 45);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MatchedPotentialDiseasesFrame(FindDiseasesController.getAllDiseases());
			}
		});
		headerPanel.add(backButton);
		
		//adds the title
		JLabel title = new JLabel("Disease Information");
		title.setFont(new Font("Roboto", Font.PLAIN, 25));
		title.setForeground(Color.white);
		title.setBounds(600, 0, 500, 50);
		headerPanel.add(title);
		
		JLabel titleTwo = new JLabel("Please have a look at disease information. To exit the symptom checker, click Home button.");
		titleTwo.setFont(new Font("Roboto", Font.PLAIN, 16));
		titleTwo.setForeground(Color.white);
		titleTwo.setBounds(360, 50, 730, 15);
		headerPanel.add(titleTwo);
		
		shapePanel = new ShapePanel();
		shapePanel.setBounds(0, 0, 300, 400);
		add(shapePanel);
		
		//about
		about = new JPanel();
		about.setLayout(new BoxLayout(about, BoxLayout.Y_AXIS));
		about.setBackground(new Color(189, 244, 239));
		about.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		about.setBounds(350, 106, 700, 200);
		add(about);
		
		aboutTitle = new JLabel("<html><div style='text-align:center; padding: 5px'> About </div></html>", SwingConstants.CENTER);
		aboutTitle.setFont(new Font("Roboto", Font.BOLD, 20));
		aboutTitle.setBackground(getBackground());
		aboutTitle.setBounds(0, 0, 700, 25);
		about.add(aboutTitle);
		
		aboutContent = new JLabel("<html><div style='word-wrap: break-word; padding: 5px'>" + disease.getAbout() + "</div></html>");
		aboutContent.setFont(new Font("Roboto", Font.PLAIN, 16));
		aboutContent.setBackground(getBackground());
		aboutContent.setBounds(15, 25, 700, 175);
		aboutContent.setVerticalAlignment(SwingConstants.TOP);
		aboutContent.setVerticalTextPosition(SwingConstants.TOP); 
		about.add(aboutContent);
		
		//causes
		causes = new JPanel();
		causes.setLayout(new BoxLayout(causes, BoxLayout.Y_AXIS));
		causes.setBackground(new Color(233, 251, 250));
		causes.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		causes.setBounds(50, 342, 625, 400);
		add(causes);
		
		causesTitle = new JLabel("<html><div style='text-align:center; padding: 5px'> Causes </div></html>", SwingConstants.CENTER);
		causesTitle.setFont(new Font("Roboto", Font.BOLD, 20));
		causesTitle.setBackground(getBackground());
		causesTitle.setBounds(0, 0, 625, 25);
		causes.add(causesTitle);
		
		causesContent = new JLabel("<html><div style='word-wrap: break-word; padding: 5px'>" + disease.getCauses() + "</div></html>");
		causesContent.setFont(new Font("Roboto", Font.PLAIN, 16));
		causesContent.setBackground(getBackground());
		causesContent.setBounds(0, 30, 625, 275);
		causesContent.setVerticalAlignment(SwingConstants.TOP);
		causesContent.setVerticalTextPosition(SwingConstants.TOP); 
		causes.add(causesContent);
		
		//treatments
		treatments = new JPanel();
		treatments.setLayout(new BoxLayout(treatments, BoxLayout.Y_AXIS));
		treatments.setBackground(new Color(211, 248, 244));
		treatments.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		treatments.setBounds(725, 342, 625, 400);
		add(treatments);
		
		treatmentsTitle = new JLabel("<html><div style='text-align:center; padding: 5px'> Treatments </div></html>", SwingConstants.CENTER);
		treatmentsTitle.setFont(new Font("Roboto", Font.BOLD, 20));
		treatmentsTitle.setBackground(getBackground());
		treatmentsTitle.setBounds(0, 0, 625, 25);
		treatments.add(treatmentsTitle);
		
		treatmentsContent = new JLabel("<html><div style='word-wrap: break-word; padding: 5px'>" + disease.getTreatments() + "</div></html>");
		treatmentsContent.setFont(new Font("Roboto", Font.PLAIN, 16));
		treatmentsContent.setBackground(getBackground());
		treatmentsContent.setBounds(0, 30, 625, 275);
		treatmentsContent.setVerticalAlignment(SwingConstants.TOP);
		treatmentsContent.setVerticalTextPosition(SwingConstants.TOP); 
		treatments.add(treatmentsContent);
		
		//webLink
		webLink = new JPanel();
		webLink.setLayout(new BoxLayout(webLink, BoxLayout.Y_AXIS));
		webLink.setBackground(new Color(211, 248, 244));
		webLink.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		webLink.setBounds(1100, 106, 250, 200);
		add(webLink);
		
		linkTitle = new JLabel("<html><div style='text-align:center; padding: 5px;'> Link </div></html>", SwingConstants.CENTER);
		linkTitle.setFont(new Font("Roboto", Font.BOLD, 20));
		linkTitle.setBackground(getBackground());
		linkTitle.setBounds(0, 0, 250, 25);
		webLink.add(linkTitle);
		
		linkContent = new JLabel("<html><div style='word-wrap: break-word; padding: 5px;'> Click here </div></html>");
		linkContent.setFont(new Font("Roboto", Font.PLAIN, 16));
		linkContent.setBackground(getBackground());
		linkContent.setBounds(0, 50, 250, 25);
		linkContent.setVerticalAlignment(SwingConstants.TOP);
		linkContent.setVerticalTextPosition(SwingConstants.TOP); 
		linkContent.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI(disease.getWebLink()));
				}
				catch (IOException | URISyntaxException el){
					el.printStackTrace();
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				linkContent.setText("Click here");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				linkContent.setText("Click here");
			}
		});
		webLink.add(linkContent);
		
		setVisible(true);
	}
		
}	// end of MoreInformationFrame class
