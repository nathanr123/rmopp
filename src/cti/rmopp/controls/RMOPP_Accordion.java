package cti.rmopp.controls;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import cti.rmopp.utils.RMOPP_Utilitties;

public class RMOPP_Accordion extends JPanel implements RMOPP_BaseControl,
		ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel topPanel = new JPanel(new GridLayout(1, 1));
	
	private JPanel bottomPanel = new JPanel(new GridLayout(1, 1));
	
	private Map<String, BarInfo> bars = new LinkedHashMap<String, BarInfo>();
	
	private int visibleBar = 0;
	
	private JComponent visibleComponent = null;

	public RMOPP_Accordion() {
	
		this.setLayout(new BorderLayout());
		
		this.add(topPanel, BorderLayout.NORTH);
		
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		loadControls();
	
		setVisibleBar(2);
	}

	public void addBar(String name, JComponent component) {
		
		BarInfo barInfo = new BarInfo(name, component);
		
		barInfo.getButton().addActionListener(this);
		
		this.bars.put(name, barInfo);
		
		render();
	}

	public void addBar(String name, Icon icon, JComponent component) {
	
		BarInfo barInfo = new BarInfo(name, icon, component);
		
		barInfo.getButton().addActionListener(this);
		
		this.bars.put(name, barInfo);
		
		render();
	}

	public void removeBar(String name) {
		
		this.bars.remove(name);
		
		render();
	}

	public int getVisibleBar() {
		
		return this.visibleBar;
	}

	public void setVisibleBar(int visibleBar) {
		
		if (visibleBar > 0 && visibleBar < this.bars.size() - 1) {
		
			this.visibleBar = visibleBar;
			
			render();
		}
	}

	public void render() {
		
		int totalBars = this.bars.size();
		
		int topBars = this.visibleBar + 1;
		
		int bottomBars = totalBars - topBars;
		
		Iterator<String> itr = this.bars.keySet().iterator();
		
		this.topPanel.removeAll();
		
		GridLayout topLayout = (GridLayout) this.topPanel.getLayout();
		
		topLayout.setRows(topBars);
		
		BarInfo barInfo = null;
		
		for (int i = 0; i < topBars; i++) {
		
			String barName = (String) itr.next();
			
			barInfo = (BarInfo) this.bars.get(barName);
			
			this.topPanel.add(barInfo.getButton());
		}
		
		this.topPanel.validate();
		
		if (this.visibleComponent != null) {
		
			this.remove(this.visibleComponent);
		}
		
		this.visibleComponent = barInfo.getComponent();
		
		this.add(visibleComponent, BorderLayout.CENTER);
		
		this.bottomPanel.removeAll();
		
		GridLayout bottomLayout = (GridLayout) this.bottomPanel.getLayout();
		
		bottomLayout.setRows(bottomBars);
		
		for (int i = 0; i < bottomBars; i++) {			
		
			String barName = (String) itr.next();
			
			barInfo = (BarInfo) this.bars.get(barName);
			
			this.bottomPanel.add(barInfo.getButton());
		}
		
		this.bottomPanel.validate();
		
		this.validate();
	}

	public void actionPerformed(ActionEvent e) {
		
		int currentBar = 0;
		
		for (Iterator<String> i = this.bars.keySet().iterator(); i.hasNext();) {
		
			String barName = (String) i.next();
			
			BarInfo barInfo = (BarInfo) this.bars.get(barName);
			
			if (barInfo.getButton() == e.getSource()) {
			
				this.visibleBar = currentBar;
			
				render();
				
				return;
			}
			
			currentBar++;
		}
	}

	public static JPanel getPanel(RMOPP_Utilitties.Nagigation panel) {
		
		JPanel panel1 = null;
		
		switch (panel) {
		
		case HOME:
		
			RMOPP_Hyperlink lbl = new RMOPP_Hyperlink("Home");
			
			lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			panel1 = new JPanel();
			
			panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
			
			panel1.add(lbl);
			
			break;
			
		case SWITCHES:
		
			RMOPP_Hyperlink lbl1[] = new RMOPP_Hyperlink[4];
			
			lbl1[0] = new RMOPP_Hyperlink("Add New Switch");
			
			lbl1[1] = new RMOPP_Hyperlink("Modify Switch");
			
			lbl1[2] = new RMOPP_Hyperlink("Delete Switch(s)");
			
			lbl1[3] = new RMOPP_Hyperlink("Show Switchs");
			
			lbl1[0].setAlignmentX(Component.CENTER_ALIGNMENT);
			
			lbl1[1].setAlignmentX(Component.CENTER_ALIGNMENT);
			
			lbl1[2].setAlignmentX(Component.CENTER_ALIGNMENT);
			
			lbl1[3].setAlignmentX(Component.CENTER_ALIGNMENT);

			panel1 = new JPanel();
			
			panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
			
			panel1.add(lbl1[0]);
			
			panel1.add(lbl1[1]);
			
			panel1.add(lbl1[2]);
			
			panel1.add(lbl1[3]);
			
			break;
			
		case SETTINGS:
			
			RMOPP_Hyperlink lbl2 = new RMOPP_Hyperlink("Change Password");
			
			lbl2.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			panel1 = new JPanel();
			
			panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
			
			panel1.add(lbl2);
			
			break;
		case USER:
			
			RMOPP_Hyperlink lbl3[] = new RMOPP_Hyperlink[8];
			
			lbl3[0] = new RMOPP_Hyperlink("Add New User");
			
			lbl3[1] = new RMOPP_Hyperlink("Modify User");
			
			lbl3[2] = new RMOPP_Hyperlink("Delete User(s)");
			
			lbl3[3] = new RMOPP_Hyperlink("Show Users");

			JLabel lb13 = new JLabel("------------------");

			lbl3[4] = new RMOPP_Hyperlink("Add New Group");
			
			lbl3[5] = new RMOPP_Hyperlink("Modify Group");
			
			lbl3[6] = new RMOPP_Hyperlink("Delete Group(s)");
			
			lbl3[7] = new RMOPP_Hyperlink("Show Groups");

			lbl3[0].setAlignmentX(Component.CENTER_ALIGNMENT);
			
			lbl3[1].setAlignmentX(Component.CENTER_ALIGNMENT);
			
			lbl3[2].setAlignmentX(Component.CENTER_ALIGNMENT);
			
			lbl3[3].setAlignmentX(Component.CENTER_ALIGNMENT);
			
			lbl3[4].setAlignmentX(Component.CENTER_ALIGNMENT);
			
			lbl3[5].setAlignmentX(Component.CENTER_ALIGNMENT);
			
			lbl3[6].setAlignmentX(Component.CENTER_ALIGNMENT);
			
			lbl3[7].setAlignmentX(Component.CENTER_ALIGNMENT);
			
			lb13.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			panel1 = new JPanel();
			
			panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

			panel1.add(lbl3[0]);
			
			panel1.add(lbl3[1]);
			
			panel1.add(lbl3[2]);
			
			panel1.add(lbl3[3]);
			
			panel1.add(lb13);
			
			panel1.add(lbl3[4]);
			
			panel1.add(lbl3[5]);
			
			panel1.add(lbl3[6]);
			
			panel1.add(lbl3[7]);

			break;
			
		case LOGOUT:
			
			RMOPP_Hyperlink lbl4 = new RMOPP_Hyperlink("Logout");
			
			lbl4.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			panel1 = new JPanel();
			
			panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
			
			panel1.add(lbl4);
			
			break;
		}
		
		return panel1;
	}

	public static void main(String[] args) {
		
		try {
			UIManager
					.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceGraphiteLookAndFeel");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		JFrame frame = new JFrame("JAccordion Test");
		RMOPP_Accordion outlookBar = new RMOPP_Accordion();
		/*
		 * outlookBar.addBar("One", getDummyPanel("One"));
		 * outlookBar.addBar("Two", getDummyPanel("Two"));
		 * outlookBar.addBar("Three", getDummyPanel("Three"));
		 * outlookBar.addBar("Four", getDummyPanel("Four"));
		 * outlookBar.addBar("Five", getDummyPanel("Five"));
		 */
		outlookBar.setVisibleBar(2);
		frame.getContentPane().add(outlookBar);

		frame.setSize(800, 600);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(d.width / 2 - 400, d.height / 2 - 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class BarInfo {
		
		private String name;
		
		private JButton button;
		
		private JComponent component;

		public BarInfo(String name, JComponent component) {
		
			this.name = name;
			
			this.component = component;
			
			this.button = new JButton(name);
		}

		public BarInfo(String name, Icon icon, JComponent component) {
			
			this.name = name;
			
			this.component = component;
		
			this.button = new JButton(name, icon);
		}

		public String getName() {
		
			return this.name;
		}

		public void setName(String name) {
			
			this.name = name;
		}

		public JButton getButton() {
			
			return this.button;
		}

		public JComponent getComponent() {
			
			return this.component;
		}
	}

	@Override
	public void loadControls() {
		
		addBar("Home", getPanel(RMOPP_Utilitties.Nagigation.HOME));
		
		addBar("User Mangement",		
				getPanel(RMOPP_Utilitties.Nagigation.USER));
		
		addBar("Switch Management",
				getPanel(RMOPP_Utilitties.Nagigation.SWITCHES));
		
		addBar("Settings", getPanel(RMOPP_Utilitties.Nagigation.SETTINGS));
		
		addBar("Logout", getPanel(RMOPP_Utilitties.Nagigation.LOGOUT));
	}
}