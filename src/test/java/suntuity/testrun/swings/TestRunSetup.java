package suntuity.testrun.swings;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;

import suntuity.testrun.swings.TextPrompt;
import suntuity.testrun.beans.TestRunBean;
import suntuity.testrun.constants.Environments;
import suntuity.testrun.constants.Group_Layout;
import suntuity.testrun.constants.TypeLists;




public class TestRunSetup extends JFrame implements ActionListener {

	//variable appending with Lbl represents label.

	private JLabel OSTypeLbl;
	private JLabel browserAndVersionLbl;
	private JLabel executionTypeLbl;
	private JLabel buildInfoLbl;
	private JLabel environmentLbl;
	private JLabel urlLbl;
	private JLabel testScriptFilepathAndNameLbl;
	private JLabel RunTestTypeLbl;
	private JLabel DatasetNumbersLbl;
	private JLabel PlatformversionLbl;
	private JLabel AndroidDeviceLbl;
	private JLabel ExecutionOnLbl;
	private JLabel ApppacakageLbl;
	private JLabel AppActivityLbl;
	private JLabel AppTypeLbl;
	private JLabel IOSAppLbl;
	private JLabel IOSdeviceLbl;
    private JLabel Mobile_OS_TypeLbl;
    private JLabel Role;
    private JLabel UserNamelbl;
    private JLabel PasswordLbl;
    private JLabel SandBoxLbl;
    private JLabel Runapplbl;
    private JComboBox<String> RunApp;
	private JComboBox<String> OSType;
	private JComboBox<String> Mobile_OS_Type;
	private JComboBox<String> browserAndVersion;
	private JComboBox<String> executionType;
	private JTextField buildInfo;
	private JComboBox<String> environment;
	private JComboBox<String> Platformversion;
	private JComboBox<String> RunTestType;
	private JTextField UserNametext;
	private JTextField Passwordtext;
	private JTextField url;
	private JTextField testScriptFilepathAndName;
	private JTextField DatasetNumbers;
	private JTextField SandBoxTextBox;
	private JComboBox<String> AndroidDeviceName;
	private JComboBox<String> IOSDeviceNames;
	private JComboBox<String> ExecutionOn;
	private JComboBox<String> Apppacakage;
	private JComboBox<String> AppActivity;
	private JComboBox<String> AppType;
	private JComboBox<String> IOSApp;
	private JComboBox<String> UserRole;
	private JButton runTest;
	private TestRunBean testRunBean;
	public String ExecutionOnVal;
	private JWindow loader;

	private TestRunSetup(TestRunBean testRunBean){
		// Form size	
		try {
			this.testRunBean = testRunBean;
			setTitle("Suntuity Automation Test Run Setup");
			setSize(600, 500);
			setLayout(new GridLayout(Group_Layout.ROWS, Group_Layout.COLUMNS));
			//System.out.println(getHeight());
			setIconImage(loadImageIcon(".\\icon3.jpg").getImage());
			setLocation(new Point((Group_Layout.SCREEN_WIDTH/2)-(getWidth()/2),Group_Layout.SCREEN_HEIGHT/2-(getHeight()/2)));
			setDefaultCloseOperation(EXIT_ON_CLOSE);			
			setResizable(false);		
			setVisible(true);		
			createTestRunSetup();
		} catch (Exception e) {
			System.out.println("error message is "+e.getMessage());
		}

	}

	private static ImageIcon loadImageIcon(String path) {
		//URL imgURL = TestRunSetup.class.getResource(path);
		if (path != null) {
			return new ImageIcon(path);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	private void loadingPanel() {
		TranslucentPane panel = new TranslucentPane();
		BoxLayout layoutMgr = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
		panel.setLayout(layoutMgr); 
		String  imageURL   = ".\\loader.gif";
		ImageIcon imageIcon = new ImageIcon(imageURL);	    
		JLabel iconLabel = new JLabel();	    
		iconLabel.setIcon(imageIcon);
		imageIcon.setImageObserver(iconLabel);
		panel.add(iconLabel);	        
		loader = new JWindow();
		loader.setAlwaysOnTop(true);
		loader.setBackground(new Color(0,0,0,0));
		loader.setContentPane(new TranslucentPane());
		loader.add(iconLabel);	   
		loader.pack();	    
		loader.setLocation(new Point((Group_Layout.SCREEN_WIDTH/2)-(loader.getWidth()/2),Group_Layout.SCREEN_HEIGHT/2-(loader.getHeight()/2)));
		loader.setVisible(true);    
	}

	private void setVisibility(){
		//Disabling Labels visibility		
		browserAndVersionLbl.setVisible(false);
		executionTypeLbl.setVisible(false);
		buildInfoLbl.setVisible(false);
		environmentLbl.setVisible(false);		
		urlLbl.setVisible(false);
		testScriptFilepathAndNameLbl.setVisible(false);
		DatasetNumbersLbl.setVisible(false);
		PlatformversionLbl.setVisible(false);
		AndroidDeviceLbl.setVisible(false);
		ExecutionOnLbl.setVisible(false);
		ApppacakageLbl.setVisible(false);
		AppActivityLbl.setVisible(false);
		OSTypeLbl.setVisible(false);
		AppTypeLbl.setVisible(false);
		IOSAppLbl.setVisible(false);
		Mobile_OS_TypeLbl.setVisible(false);
		//Disabling fields visibility
		browserAndVersion.setVisible(false);
		executionType.setVisible(false);
		buildInfo.setVisible(false);
		DatasetNumbers.setVisible(false);
		environment.setVisible(false);
		url.setVisible(false);		
		testScriptFilepathAndName.setVisible(false);
		Platformversion.setVisible(false);
		AndroidDeviceName.setVisible(false);
		ExecutionOn.setVisible(false);
		Apppacakage.setVisible(false);
		AppActivity.setVisible(false);
		OSType.setVisible(false);
		Mobile_OS_Type.setVisible(false);
		AppType.setVisible(false);
		IOSApp.setVisible(false);
		IOSdeviceLbl.setVisible(false);
		IOSDeviceNames.setVisible(false);
		Role.setVisible(false);	
		UserRole.setVisible(false);
		 UserNametext.setVisible(false);
		  Passwordtext.setVisible(false);
		 UserNamelbl.setVisible(false);
		 PasswordLbl.setVisible(false);
		 SandBoxTextBox.setVisible(false);
		 SandBoxLbl.setVisible(false);
		 Runapplbl.setVisible(false);
		 RunApp.setVisible(false);
	}

	private void createTestRunSetup(){
		//generate label objects
		RunTestTypeLbl = new JLabel("Run Test Type");
		OSTypeLbl = new JLabel("OS Type");
		browserAndVersionLbl = new JLabel("Browser");
		executionTypeLbl = new JLabel("Execution Type");
		buildInfoLbl = new JLabel("Build Info");
		environmentLbl = new JLabel("Environment");
		PlatformversionLbl= new JLabel("Platformversion");
		urlLbl = new JLabel("URL");
		testScriptFilepathAndNameLbl = new JLabel("Test Script file path & name");
		DatasetNumbersLbl = new JLabel("Enter Dataset Numbers");
		AndroidDeviceLbl = new JLabel("Select Android Device");
		IOSdeviceLbl=new JLabel("Select IOS Device");
		ExecutionOnLbl = new JLabel("Select Execution On");
		ApppacakageLbl = new JLabel("Select App Package");
		AppActivityLbl = new JLabel("Select App Activity");
		AppTypeLbl	= new JLabel("Select App Type");
		IOSAppLbl	= new JLabel("Select IOS App");
		Mobile_OS_TypeLbl=new JLabel("Mobile OS");
		Runapplbl=new JLabel("AppName");
		UserNamelbl= new JLabel("User Name");
		PasswordLbl= new JLabel("Password");
		Role=new JLabel("Set User Role");
		SandBoxLbl=new JLabel("SandBox Name");
		//generate Textfields
		RunTestType = new JComboBox<String>(TypeLists.getTesttype());
		OSType = new JComboBox<String>(TypeLists.getDesktopOS());
		Mobile_OS_Type=new JComboBox<String>(TypeLists.getMobileos());
		browserAndVersion = new JComboBox<String>(TypeLists.getWindowsBrowsers());
		executionType = new JComboBox<String>(TypeLists.getExecutionTypes());
		RunApp=new JComboBox<String>(TypeLists.getappname());
		//buildInfo = new JTextField("4.04.00.11275");
		buildInfo = new JTextField();
		DatasetNumbers = new JTextField();
		 UserNametext=new JTextField();
		 Passwordtext=new JTextField();
		 SandBoxTextBox=new JTextField();

		//buildInfo.setEditable(false);
		environment = new JComboBox<String>(TypeLists.getEnvironment());
		Platformversion = new JComboBox<String>(TypeLists.getPlatformversion());
		AndroidDeviceName = new JComboBox<String>(TypeLists.getandroiddevicelist());
		IOSDeviceNames= new JComboBox<String>(TypeLists.getIOSDevicelist());
		ExecutionOn = new JComboBox<String>(TypeLists.getExecutionOn());
		Apppacakage = new JComboBox<String>(TypeLists.getApppacakage());
		AppActivity = new JComboBox<String>(TypeLists.getAppActivity());
		AppType= new JComboBox<String>(TypeLists.getAppType());
		IOSApp= new JComboBox<String>(TypeLists.getIOSApp());
		UserRole=new JComboBox<String>(TypeLists.GetCRMROLES());
		url = new JTextField();//url.setEditable(false);
		testScriptFilepathAndName = new JTextField();//testScriptFilepathAndName.setEditable(false);
		runTest = new JButton("Run Test");
		setVisibility();
		JPanel panel = new JPanel();
		panel.setSize(200,200);

		GroupLayout layout = new GroupLayout(getContentPane());
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(RunTestTypeLbl)
								.addComponent(Runapplbl)
								.addComponent(OSTypeLbl)
								.addComponent(browserAndVersionLbl)
								.addComponent(executionTypeLbl)
								.addComponent(buildInfoLbl)
								.addComponent(environmentLbl)
								.addComponent(urlLbl)
								.addComponent(testScriptFilepathAndNameLbl)
								.addComponent(DatasetNumbersLbl)
								.addComponent(PlatformversionLbl)
								.addComponent(AndroidDeviceLbl)
								.addComponent(ExecutionOnLbl)
								.addComponent(ApppacakageLbl)
								.addComponent(AppTypeLbl)
								.addComponent(IOSAppLbl)
								.addComponent(AppActivityLbl)	
								.addComponent(Mobile_OS_TypeLbl)
								.addComponent(IOSdeviceLbl)
								.addComponent(Role)
								.addComponent(UserNamelbl)
								.addComponent(PasswordLbl)
								.addComponent(SandBoxLbl)
								)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(RunTestType,50,100,200)
								.addComponent(RunApp,50,100,200)
								.addComponent(OSType,50,100,200)				
								.addComponent(Mobile_OS_Type,50,100,200)
								.addComponent(browserAndVersion,50,100,200)
								.addComponent(executionType,50,100,200)
								.addComponent(buildInfo,50,100,200)
								.addComponent(environment,50,100,200)
								.addComponent(url,100,200,400)
								.addComponent(UserRole,100,200,400)					
								.addComponent(testScriptFilepathAndName,100,200,400)
								.addComponent(DatasetNumbers,100,200,400)
								.addComponent(Platformversion,50,50,100)
								.addComponent(AndroidDeviceName,50,100,200)	
								.addComponent(IOSdeviceLbl,50,100,200)	
								.addComponent(IOSDeviceNames,50,100,200)
								.addComponent(ExecutionOn,50,100,200)
								.addComponent(Apppacakage,50,100,200)
								.addComponent(AppActivity,50,300,400)
								.addComponent(AppType,50,100,200)
								.addComponent(IOSApp,50,100,200)
								.addComponent(UserNametext,50,100,200)
								.addComponent(Passwordtext,50,100,200)	
								.addComponent(SandBoxTextBox,100,100,400)
								.addComponent(runTest))
						)	  
				);
		layout.setVerticalGroup(layout.createSequentialGroup()
				
				
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(RunTestTypeLbl)
						.addComponent(RunTestType))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(Runapplbl)
						.addComponent(RunApp))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(OSTypeLbl)
						.addComponent(OSType))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(Mobile_OS_TypeLbl)
						.addComponent(Mobile_OS_Type))				
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(ExecutionOnLbl)
						.addComponent(ExecutionOn))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(ApppacakageLbl)
						.addComponent(Apppacakage))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(AppActivityLbl)
						.addComponent(AppActivity))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(AppTypeLbl)
						.addComponent(AppType))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(IOSAppLbl)
						.addComponent(IOSApp))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(PlatformversionLbl)
						.addComponent(Platformversion))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(AndroidDeviceLbl)
						.addComponent(AndroidDeviceName))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(IOSdeviceLbl)
						.addComponent(IOSDeviceNames))	
				
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(executionTypeLbl)
						.addComponent(executionType))		    		     
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(environmentLbl)
						.addComponent(environment))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(buildInfoLbl)
						.addComponent(buildInfo))  				    	  
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(browserAndVersionLbl)
						.addComponent(browserAndVersion))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(urlLbl)
						.addComponent(url))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(testScriptFilepathAndNameLbl)
						.addComponent(testScriptFilepathAndName))	
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(Role)
						.addComponent(UserRole))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(DatasetNumbersLbl)
						.addComponent(DatasetNumbers))		
				//..........
				
				
				
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(UserNamelbl)
						.addComponent(UserNametext))		
				
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(PasswordLbl)
						.addComponent(Passwordtext))	
				
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(SandBoxLbl)
						.addComponent(SandBoxTextBox))
				
				
//				//............
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(runTest))	      

				);
		getContentPane().setLayout(layout);
		RunTestType.addActionListener(this);
		RunApp.addActionListener(this);
		executionType.addActionListener(this);
		environment.addActionListener(this);
		ExecutionOn.addActionListener(this);
		OSType.addActionListener(this);
		Mobile_OS_Type.addActionListener(this);
		runTest.addActionListener(this);
		//bean set up pending
		AndroidDeviceName.addActionListener(this);
		UserRole.addActionListener(this);
		setVisible(true);  
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==environment){
			String environmentVal = (String)environment.getSelectedItem();
			String executionTypeVal = (String)executionType.getSelectedItem();			
			if(null==environmentVal||environmentVal.trim().length()==0){
				url.setText("");
				testScriptFilepathAndName.setText("");	
			}else{
				String[] urlAndTestScriptFilePath = new Environments().getUrlTestScriptFilePath(executionTypeVal,environmentVal).split(",");
				if(executionTypeVal.equals("Regression")) {
					if(RunApp.getSelectedItem()=="Onepager") {
						url.setText("https://suntuity.quickbase.com/db/main?a=SignIn");
					}
					else {
						url.setText("");
					}
				
					UserNametext.setText("saikrishna.adidamu@suntuity.com");
					Passwordtext.setText("PurnaRadha@123");
				}
				else
				{
					url.setText("https://suntuity.quickbase.com/db/main?a=SignIn");
					
					
				}
				
				testScriptFilepathAndName.setText(urlAndTestScriptFilePath[1]);	
			}

		}
		
		
		if(e.getSource()==UserRole) {
			String userRole=(String) UserRole.getSelectedItem();
			switch(userRole) {
			case "IT-Admin":
				DatasetNumbers.setText("1");
				
				break;
			case "Sales Rep":
				DatasetNumbers.setText("2");
				break;
			default:
				
				TextPrompt Urltp = new TextPrompt("All users are going to execute ", DatasetNumbers);
				Urltp.setForeground(Color.RED);
				Urltp.changeStyle(Font.BOLD + Font.ITALIC);
				DatasetNumbers.setText("");
				break;
			}
			
		}
		if(e.getSource()==executionType){
			String executionTypeVal = (String)executionType.getSelectedItem();
			System.out.println("action recieved");
			System.out.println("executionTypeVal : "+executionTypeVal);
			DefaultComboBoxModel model = new DefaultComboBoxModel(TypeLists.getExecutionTypeTypelist(executionTypeVal));
			environment.setModel(model);
		}
		
		if (e.getSource()==Mobile_OS_Type) {
			String MobOS=(String) Mobile_OS_Type.getSelectedItem();
			System.out.println("action recieved");
			System.out.println("executionTypeVal : "+MobOS);
			if(MobOS.equals("Android")) {
				AndroidDeviceLbl.setVisible(true);
				AndroidDeviceName.setVisible(true);
				IOSdeviceLbl.setVisible(false);
				IOSDeviceNames.setVisible(false);
				
			}
			else if(MobOS.equals("IOS")) {
				AndroidDeviceLbl.setVisible(false);
				AndroidDeviceName.setVisible(false);
				IOSdeviceLbl.setVisible(true);
				IOSDeviceNames.setVisible(true);
				
			}
		}
	
		
		if(e.getSource()==OSType){
			String OSTypeVal = (String)OSType.getSelectedItem();
			if("Windows".equals(OSTypeVal)){  
			
				
			}else if ("IOS".equals(OSTypeVal)){
				
				browserAndVersion.insertItemAt("Safari", 1);
			
				
			}           
			System.out.println(OSTypeVal);}
		if(e.getSource()==ExecutionOn){
			ExecutionOnVal = (String)ExecutionOn.getSelectedItem();  
			if	("Browser".equals(ExecutionOnVal)){
				browserAndVersionLbl.setVisible(true);
				browserAndVersion.setVisible(true); 
				urlLbl.setVisible(true);
				testScriptFilepathAndNameLbl.setVisible(true);
				DatasetNumbersLbl.setVisible(true);    
				DatasetNumbers.setVisible(true);	
				url.setVisible(true);
				testScriptFilepathAndName.setVisible(true);
				ApppacakageLbl.setVisible(false);
				AppActivityLbl.setVisible(false); 
				Apppacakage.setVisible(false);
				AppActivity.setVisible(false);
				AppTypeLbl.setVisible(false);
				AppType.setVisible(false);
				IOSAppLbl.setVisible(false);
				IOSApp.setVisible(false);
			}
			else{ 	browserAndVersionLbl.setVisible(false);
			browserAndVersion.setVisible(false);
			urlLbl.setVisible(false);
			testScriptFilepathAndNameLbl.setVisible(true);
			testScriptFilepathAndName.setVisible(true);
			DatasetNumbersLbl.setVisible(true);
			DatasetNumbers.setVisible(true);
			url.setVisible(false);    				
			}
			System.out.println(ExecutionOnVal);}

		if(e.getSource()==RunTestType){
			String RunTestTypeVal = (String)RunTestType.getSelectedItem();
			System.out.println("action recieved");
			System.out.println("RunTestTypeVal : "+RunTestTypeVal);

			if ("Desktop_Web".equals(RunTestTypeVal)) {
				RunTestType.hidePopup();
	
				browserAndVersionLbl.setVisible(true);		
				executionTypeLbl.setVisible(true);
				buildInfoLbl.setVisible(true);
				environmentLbl.setVisible(true);		
				urlLbl.setVisible(true);				
				testScriptFilepathAndNameLbl.setVisible(true);
				DatasetNumbersLbl.setVisible(true);

				PlatformversionLbl.setVisible(false);
				AndroidDeviceLbl.setVisible(false);
				ExecutionOnLbl.setVisible(false);
				Role.setVisible(true);	
				UserRole.setVisible(true);
				OSTypeLbl.setVisible(true);

				 UserNametext.setVisible(true);
				  Passwordtext.setVisible(true);
				 UserNamelbl.setVisible(true);
				 PasswordLbl.setVisible(true);
				
				Platformversion.setVisible(false);
				AndroidDeviceName.setVisible(false);
				ExecutionOn.setVisible(false);
				IOSdeviceLbl.setVisible(false);
				IOSDeviceNames.setVisible(false);
				OSType.setVisible(true);
				Mobile_OS_TypeLbl.setVisible(false);
				Mobile_OS_Type.setVisible(false);
				browserAndVersion.setVisible(true);
				executionType.setVisible(true);
				buildInfo.setVisible(true);
				DatasetNumbers.setVisible(true);
				//water mark text	
			
				environment.setVisible(true);
				url.setVisible(true);
				SandBoxLbl.setVisible(true);
				SandBoxTextBox.setVisible(true);
				//water mark text	
				TextPrompt Urltp = new TextPrompt("https://Enter URL", url);
				Urltp.setForeground(Color.RED);
				Urltp.changeStyle(Font.BOLD + Font.ITALIC);
				testScriptFilepathAndName.setVisible(true);
				//water mark text	
				TextPrompt buildtp = new TextPrompt("Enter Build Number", buildInfo);
				buildtp.setForeground(Color.RED);
				buildtp.changeStyle(Font.BOLD + Font.ITALIC);
				Urltp = new TextPrompt("Enter QuickBase UserName",UserNametext );
				Urltp.setForeground(Color.RED);
				Urltp.changeStyle(Font.BOLD + Font.ITALIC);
				Urltp = new TextPrompt("Enter QuickBase Password",Passwordtext );
				Urltp.setForeground(Color.RED);
				Urltp.changeStyle(Font.BOLD + Font.ITALIC);
			} else if ("Mobile_Web".equals(RunTestTypeVal)) {    
				RunTestType.hidePopup();
				executionTypeLbl.setVisible(true);
				buildInfoLbl.setVisible(true);
				environmentLbl.setVisible(true);							
				PlatformversionLbl.setVisible(false);
				AndroidDeviceLbl.setVisible(false);
				AndroidDeviceName.setVisible(false);
				IOSdeviceLbl.setVisible(false);
				IOSDeviceNames.setVisible(false);
				ExecutionOnLbl.setVisible(false);								
				Mobile_OS_TypeLbl.setVisible(true);
				Mobile_OS_Type.setVisible(true);
				Platformversion.setVisible(false);
				OSTypeLbl.setVisible(false);
				ExecutionOn.setVisible(false);
				OSType.setVisible(false);
				executionType.setVisible(true);
				buildInfo.setVisible(true);				
				environment.setVisible(true);
				Mobile_OS_Type.setVisible(true);
				testScriptFilepathAndNameLbl.setVisible(true);
				testScriptFilepathAndName.setVisible(true);
				DatasetNumbersLbl.setVisible(true);
				DatasetNumbers.setVisible(true);
				browserAndVersion.setVisible(false);
				Role.setVisible(true);	
				UserRole.setVisible(true);
				
				UserNametext.setVisible(true);
				  Passwordtext.setVisible(true);
				 UserNamelbl.setVisible(true);
				 PasswordLbl.setVisible(true);
				 
				url.setVisible(true);
				testScriptFilepathAndName.setVisible(true);
				browserAndVersionLbl.setVisible(false);
				urlLbl.setVisible(true);
				testScriptFilepathAndNameLbl.setVisible(true);
				
				AppTypeLbl.setVisible(false);
				AppType.setVisible(false);
				IOSAppLbl.setVisible(false);
				IOSApp.setVisible(false);
				ApppacakageLbl.setVisible(false);
				AppActivityLbl.setVisible(false); 
				Apppacakage.setVisible(false);
				AppActivity.setVisible(false);
				
				environment.setVisible(true);
				url.setVisible(true);
				
				SandBoxLbl.setVisible(true);
				SandBoxTextBox.setVisible(true);
				//water mark text	
				
				TextPrompt Urltp = new TextPrompt("https://Enter URL", url);
				Urltp.setForeground(Color.RED);
				Urltp.changeStyle(Font.BOLD + Font.ITALIC);
				testScriptFilepathAndName.setVisible(true);
				Urltp = new TextPrompt("Enter QuickBase UserName",UserNametext );
				Urltp.setForeground(Color.RED);
				Urltp.changeStyle(Font.BOLD + Font.ITALIC);
				Urltp = new TextPrompt("Enter QuickBase Password",Passwordtext );
				Urltp.setForeground(Color.RED);
				Urltp.changeStyle(Font.BOLD + Font.ITALIC);
				//water mark text	
				TextPrompt buildtp = new TextPrompt("Enter Build Number", buildInfo);
				buildtp.setForeground(Color.RED);
				buildtp.changeStyle(Font.BOLD + Font.ITALIC);

			}else if("Windows".equals(RunTestTypeVal)){ 

				executionTypeLbl.setVisible(true);
				buildInfoLbl.setVisible(true);
				environmentLbl.setVisible(true);							
				testScriptFilepathAndNameLbl.setVisible(true);
				DatasetNumbersLbl.setVisible(true);

				browserAndVersionLbl.setVisible(false);
				urlLbl.setVisible(false);
				PlatformversionLbl.setVisible(false);
				AndroidDeviceLbl.setVisible(false);
				ExecutionOnLbl.setVisible(false);
				ApppacakageLbl.setVisible(false);
				AppActivityLbl.setVisible(false);
				OSTypeLbl.setVisible(false);

				Platformversion.setVisible(false);
				AndroidDeviceName.setVisible(false);
				ExecutionOn.setVisible(false);
				Apppacakage.setVisible(false);
				AppActivity.setVisible(false);
				OSType.setVisible(false);

				browserAndVersion.setVisible(false);
				url.setVisible(false);
				executionType.setVisible(true);
				buildInfo.setVisible(true);
				DatasetNumbers.setVisible(true);
				environment.setVisible(true);							
				testScriptFilepathAndName.setVisible(true);
			}else if("Select Test Type ".equals(RunTestTypeVal)){ 
				setVisibility();
			}
		}
		if(e.getSource()== runTest){
			loadingPanel();
			testRunBean.setRunTestType(RunTestType.getSelectedItem().toString());
		
			//	testRunBean.setDeviceType(DeviceType.getSelectedItem().toString());
			testRunBean.setOSType(OSType.getSelectedItem().toString());
			testRunBean.setBrowserAndVersion(browserAndVersion.getSelectedItem().toString());
			testRunBean.setBuildInfo(buildInfo.getText());
			testRunBean.setEnvironment(environment.getSelectedItem().toString());
			testRunBean.setExecutionType(executionType.getSelectedItem().toString());
			testRunBean.setTestScriptFilepathAndName(testScriptFilepathAndName.getText());
			testRunBean.setsandboxname(SandBoxTextBox.getText());
			testRunBean.setDatasetNumbers(DatasetNumbers.getText());
			testRunBean.setPlatformversion(Platformversion.getSelectedItem().toString());
			testRunBean.setDeviceName(AndroidDeviceName.getSelectedItem().toString());
			testRunBean.setExecutionOn(ExecutionOn.getSelectedItem().toString());
			testRunBean.setApppacakage(Apppacakage.getSelectedItem().toString());
			testRunBean.setAppActivity(AppActivity.getSelectedItem().toString());
			testRunBean.setAppType(AppType.getSelectedItem().toString());
			testRunBean.setIOSApp(IOSApp.getSelectedItem().toString());
			testRunBean.setMobileOSType(Mobile_OS_Type.getSelectedItem().toString());
			testRunBean.setAndroidDevice(AndroidDeviceName.getSelectedItem().toString());
			testRunBean.setIOSDevice(IOSDeviceNames.getSelectedItem().toString());
			testRunBean.setUserNameAndPassword(UserNametext.getText(), Passwordtext.getText());
			testRunBean.setUrl(url.getText());
			testRunBean.setLoadingPanel(loader);
			testRunBean.setRunTest(true);
			setVisible(false);
			return;
		}

	}

	

	public class TranslucentPane extends JPanel {

		public TranslucentPane() {
			setOpaque(false);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();	
			g2d.setComposite(AlphaComposite.SrcOver.derive(0.85f));
			g2d.setColor(getBackground());
			g2d.fillRect(0, 0, getWidth(), getHeight());

		}

	}

	public static void runTest(TestRunBean testrunBean) {
		new TestRunSetup(testrunBean);		
	}

}
