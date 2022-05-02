package suntuity.PageObjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import suntuity.Leadonepagerfunctionallibraries.CommonFunctions;

public class LeadOnePager_Web extends CommonFunctions{
	public WebDriver driver;
	public static HashMap<String,String> fieldInformation=new HashMap<String,String>();
	public String spinner ="//h1[contains(.,'Loading')]";

	public LeadOnePager_Web(WebDriver driver) {
		this.driver = driver;
	}

	
	@FindBy(xpath = "//input[@id='email_main']/../span")
	public WebElement emailaddresshepertext;
	
	
	@FindBy(id = "first_name_main")
	public WebElement Onepager_FirstName;

	@FindBy(id = "last_name_main")
	public WebElement Onepager_LastName;

	@FindBy(id = "email_main")
	public WebElement Onepager_Emailid;

	@FindBy(id = "phone_main")
	public WebElement Onepager_PhoneNo;

	@FindBy(xpath = "//input[@id='autocomplete-input_main']")
	public WebElement Onepager_SearchforAddress;

	@FindBy(id = "street_main")
	public WebElement Onepager_Street;

	@FindBy(id = "city_main")
	public WebElement Onepager_City;

	@FindBy(xpath = "//input[@id='campaignsearch_main']")
	public WebElement RelatedCampaignTextField;

	@FindBy(xpath = "//label[@for='state_main']/../div/input[@type='text']")
	public WebElement Onepager_State;

	@FindBy(id = "zip_main")
	public WebElement Onepager_Zip;
	/* Lead Source Info */
	@FindBy(xpath = "//label[contains(.,'Mentor')]/../div/input[@type='text']")
	public WebElement Onepager_Mentor;

	@FindBy(xpath = "//label[contains(.,'Related Campaign')]/../div/input[@type='text']")
	public WebElement Onepager_RelatedCampaign;

	@FindBy(xpath = "//label[contains(.,'Lead Source')]/../div/input[@type='text']")
	public WebElement Onepager_LeadSource;

	@FindBy(xpath = "//i[contains(.,'search')]")
	public WebElement Onepager_ReferredBy;

	@FindBy(id = "lead_hoa_main")
	public WebElement Onepager_HOA_Switch;

	@FindBy(xpath = "//input[@id='lead_hoa_name_main']")
	public WebElement Onepager_HOA_Name;

	@FindBy(id = "mentorsearch_main")
	public WebElement MentorTextField;

	@FindBy(xpath = "//input[@id='lead_hoa_email_main']")
	public WebElement Onepager_HOA_EmailAddress;

	@FindBy(xpath = "//input[@id='lead_hoa_phone_main']")
	public WebElement Onepager_HOA_MobileNumbers;

	@FindBy(xpath = "//input[@id='lead_hoa_phone_ext_main']")
	public WebElement Onepager_HOA_MobileExtension;

	@FindBy(xpath = "//button[@id='save_lead_button_bottom_main']")
	public WebElement Onepager_SaveButton;

	/* Utiltiy and Financing */

	@FindBy(xpath = "//select[@id='utility_company']/../../input[@type='text']")
	public WebElement Onepager_UtilityCompany;

	@FindBy(xpath = "//select[@id='utility_company']/../../../following-sibling::div//child::input[@type='text']")
	public WebElement Onepager_FinancingTypes;

	@FindBy(id = "electric_bill_name")
	public WebElement Onepager_Elctric_Bill;

	@FindBy(id = "electric_bill_email")
	public WebElement Onepager_Elctric_BillHolderEmail;

	@FindBy(xpath = "//button[contains(text(),'New Note')]")
	public WebElement Onepager_NewNoteButton;

	@FindBy(id = "note_text_main")
	public WebElement Onepager_NotesTextField;

	@FindBy(xpath = "//select[@id='tag_choice_main']//following-sibling::input[@type='text']")
	public WebElement Onepager_taginputtextbox;

	@FindBy(xpath = "//div[@id='financeInfo']//following-sibling::div//child::button[contains(.,'Save Lead')]")
	public WebElement Onepager_SaveLead_2;

	// Appointment

	@FindBy(id = "new_appointment_button")
	public WebElement Onepager_NewTradiitonalAppointment;

	@FindBy(xpath = "//button[contains(.,'Direct Appointment')]")
	public WebElement Onepager_NewDirectAppointment;

	@FindBy(id = "appointment_modal_date")
	public WebElement Onepager_DateField;

	@FindBy(xpath = "//select[@class='datepicker-select orig-select-month']/../../input[@type='text']")
	public WebElement Onepager_clickon_month;

	@FindBy(xpath = "//select[@class='datepicker-select orig-select-year']/../../input[@type='text']")
	public WebElement Onepager_clickon_year;

	@FindBy(xpath = "(//div[@class='datepicker-footer'])[2]/div/button[contains(.,'Ok')]")
	public WebElement Onepager_Appointmentokbutton;

	@FindBy(xpath = "")
	public WebElement Onepager_Appointment_sethour;

	@FindBy(xpath = "")
	public WebElement Onepager_Appointment_setminute;

	@FindBy(id = "appointment_modal_time")
	public WebElement Onepager_Appointment_time;

	@FindBy(xpath = "//div[@id='modal_body']//input[@class='select-dropdown dropdown-trigger']")
	public WebElement Onepager_Appointment_Result;

	@FindBy(id = "appointment_modal_notes")
	public WebElement Onepager_Appointment_Notes;

	@FindBy(xpath = "//div[@id='new_edit_appointment']//child::div[@class='modal-footer']/button[contains(.,'Save')]")
	public WebElement Onepager_Appointment_SubmitButton;

	@FindBy(id = "new_proposal_button")
	public WebElement Onepager_Request_ProposalButton;

	@FindBy(xpath = "//span[contains(.,'PPA /Lease')]")
	public WebElement Onepager_Proposal_PPALease_CheckBox;

	@FindBy(xpath = "//span[contains(text(),'Cash')]")
	public WebElement Onepager_Proposal_Cash;

	@FindBy(xpath = "//span[contains(text(),'Loan')]")
	public WebElement Onepager_Proposal_Loan;

	@FindBy(xpath = "//span[contains(text(),'Financing Partners')]")
	public WebElement Onepager_FinancingPartners;

	@FindBy(xpath = "//h5[contains(.,'Utility')]/../div/div//child::input[@type='text']")
	public WebElement Onepager_UtilityCompany_DropDown;

	@FindBy(id = "consultation_date")
	public WebElement Onepager_NewProposalConcultationdate;

	@FindBy(id = "consultation_time")
	public WebElement Onepager_NewProposalConcultationTime;

	@FindBy(xpath = "//label[contains(.,'Installation Type')]/../div//child::input[@type='text']")
	public WebElement Onepager_NewProposalinstallationdropdown;

	@FindBy(xpath = "//div[@id='new_note_main']//input[@class='select-dropdown dropdown-trigger']")
	public WebElement Onepager_LeadNoteStatus;

	@FindBy(xpath = "//label[contains(.,'Roof Type')]/../div//child::input")
	public WebElement Onepager_NewProposalRooftypeDropdown;

	@FindBy(xpath = "//label[contains(.,'Age of the Roof')]/../div/child::input[@type='text']")
	public WebElement Onepager_NewProposalAgeOfRoofDropDown;

	@FindBy(id = "annual_kwh_usage")
	public WebElement Onepager_NewProposal_AnnualKilowatsusage;

	@FindBy(id = "proposal_modal_note")
	public WebElement Onepager_NewProposal_Notes;

	@FindBy(xpath = "(//button[contains(.,'Save')])[6]")
	public WebElement Onepager_NewProposal_CreateButton;

	@FindBy(xpath = "//i[contains(.,'menu')]")
	public WebElement Onepager_Hamburger;

	@FindBy(xpath = "//button[@class='btn-flat noteSave_main pulse']")
	public WebElement OnepagerNotesSavebutton;

	@FindBy(xpath = "//a[@data-tooltip='Google Drive Folder']")
	public WebElement Onepager_GoogleDrive;

	@FindBy(xpath = "deal_acceptance_link")
	public WebElement Onepager_DealAcceptance;

	@FindBy(xpath = "chatbubble")
	public WebElement Onepager_ChatBubble;

	@FindBy(xpath = "//span[contains(.,'Errors found. Please fix before updating lead.')]")
	public WebElement Onepager_Error;

	@FindBy(xpath = "//h4[@id='title']/../descendant::i[contains(.,'save')]")
	public WebElement Onepager_topsavebutton;

	@FindBy(id = "leadsourcesearch_main")
	public WebElement Onepager_LeadSourceTextField;

	@FindBy(xpath = "//div[@id='toast-container']/div[contains(.,'ZERO_RESULTS')]")
	public WebElement Onepager_Zeroesults;

	@FindBy(xpath = "//select[@id='lead_hoa_select_main']/../..//input[@type='text']")
	public WebElement HOADropDown;

	@FindBy(id = "lead_hoa_name_main")
	public WebElement HOAName;

	@FindBy(id = "lead_hoa_email_main")
	public WebElement HOAEmail;

	@FindBy(id = "lead_hoa_phone_main")
	public WebElement HOAMobileNumber;

	@FindBy(id = "lead_hoa_phone_ext_main")
	public WebElement HOAMobileExt;

	@FindBy(id = "lead_annual_kwh_usage_main")
	public WebElement AnnualKWUSage;

	@FindBy(xpath = "//h1[contains(.,'Loading')]")
	public WebElement SPINNER;

	@FindBy(xpath = "//span[contains(text(),'Financing Partners')]")
	public WebElement Proposal_Financingpartner_CheckBox;

	@FindBy(xpath = "//label[@for='proposal_target_epc']")
	public WebElement Proposal_Target_EPC_label;

	@FindBy(id = "proposal_target_epc")
	public WebElement Proposal_Target_EPC_Input;

	@FindBy(id = "proposal_include_promotions_in_epc")
	public WebElement Include_Promotions_EPS;

	@FindBy(xpath = "//select[@id='proposal_utility_company']/../../ul/li[@class='selected']/span")
	public WebElement getutilitycompanyfromproposals;

	@FindBy(id = "proposal_other_incentive")
	public WebElement Proposalotherincentives;

	@FindBy(xpath = "//input[@id='proposal_modal_date']")
	public WebElement ProposalConcultationdate;

	@FindBy(xpath = "//input[@id='proposal_modal_time']")
	public WebElement ProposalConcultingTime;

	@FindBy(xpath  = "//span[@class='qbIcon iconUI-settings-filled']")
	public WebElement Onepager_Settings;

	@FindBy(xpath  = "//a[contains(.,'Tables')]")
	public WebElement Onepager_Tables;

	@FindBy(xpath  = "//a[contains(.,'Fields ')]")
	public WebElement Table_Fields;

	@FindBy(xpath  = "//li/span[text()='2 Legs']/../../../input")
	public WebElement DropdownLegsMainField;


	@FindBy(xpath  = "//div[@id='appointment_if_sold']//child::i")
	public WebElement ProposalSearch;

	@FindBy(xpath  = "//h4[contains(.,'Select A Proposal')]/..//child::a[text()='Make New']")
	public WebElement Appointment_Proposal_MakeNew;

	@FindBy(xpath  = "//h4[contains(.,'Select A Proposal')]/../..//child::button[contains(.,'Select')]")
	public WebElement Appointment_Proposal_SelectButton;

	@FindBy(xpath  = "//div[@id='new_appointment_proposal']/div[1]//child::input")
	public WebElement ChooseFinancingOptionDropdown;


	@FindBy(xpath  = "(//input[@id='appointment_modal_proposal_size']/../../div[1]//child::span[contains(.,'Cash')])[2]")
	public WebElement Appointment_ProposalDropDown_Cash;	

	@FindBy(xpath  = "//label[contains(text(),'New Proposal System Size')]")
	public WebElement   LabelProposalSystemSize;


	@FindBy(xpath  = "//input[@id='appointment_modal_proposal_size']")
	public WebElement   Apointments_ProposalSystemSizeInput;



	@FindBy(xpath  = "//label[contains(text(),'Monthly Price')]")
	public WebElement   Apointments_ProposalonthlyPriceLabel	;


	@FindBy(xpath  = "//input[@id='appointment_modal_rate']")
	public WebElement   Apointments_ProposalMonthlyPriceInput	;



	@FindBy(xpath  = "//label[contains(text(),'Customer Usage')]")
	public WebElement   Apointments_ProposalCustomerUsageLabel	;


	@FindBy(xpath  = "//input[@id='appointment_modal_usage']")
	public WebElement   Apointments_ProposalCustomerUsageInput	;

	@FindBy(xpath  = "//label[contains(.,'System Type')]/..//child::input")
	public WebElement   Apointments_ProposalSystemType	;


	@FindBy(xpath  = "//input[@id='appointment_modal_rate']")
	public WebElement   Apointments_ProposalModalRateInput	;


	@FindBy(xpath  = "//input[@id='appointment_modal_incentive']/../span")
	public WebElement   Apointments_PostSalePaperWork	;

	@FindBy(xpath  = "//input[@id='appointment_modal_photos']/../span")
	public WebElement   Apointments_Photosuploaded	;

	@FindBy(xpath  = "//input[@id='appointment_modal_promotions']/../span")
	public WebElement   Apointments_SalesPromotions	;



	@FindBy(xpath  = "//input[@id='appointment_modal_sales_promotions_offered']/../span")
	public WebElement   Apointments_SalesPromotions1;

	@FindBy(xpath  = "//label[text()='Sales Promotion']/..//child::input")
	public WebElement   Apointments_SalesPromotionDropdownlabel;



	@FindBy(xpath  = "//input[@id='appointment_modal_tree_incentive_check']/../span")
	public WebElement   Apointments_SalesPromotion_TreeIncentives_Toggle_Switch;


	@FindBy(xpath  = "//label[@for='appointment_modal_tree_incentive']")
	public WebElement   Apointments_SalesPromotion_TreeIncentives_Label;

	@FindBy(xpath  = "//input[@id='appointment_modal_tree_incentive']")
	public WebElement   Apointments_SalesPromotion_TreeIncentives_Input;


	@FindBy(xpath  = "//input[@id='appointment_modal_roof_incentive_check']/../span")
	public WebElement   Apointments_RoofIncentives;

	@FindBy(xpath  = "//input[@id='appointment_modal_roof_incentive']/../label[contains(.,'Amount')]")
	public WebElement   Apointments_RoofIncentives_Label;

	@FindBy(xpath  = "//input[@id='appointment_modal_roof_incentive']")
	public WebElement   Apointments_RoofIncentives_Input;

	@FindBy(xpath  = "//input[@id='appointment_modal_signing_incentive_check']/../span")
	public WebElement   AppointmentsSigningBonusSwitch;

	@FindBy(xpath  = "//input[@id='appointment_modal_signing_incentive']/../label")
	public WebElement   AppointmentsSigningBonusLabel;

	@FindBy(xpath  = "//input[@id='appointment_modal_signing_incentive']")
	public WebElement   AppointmentsSigningBonusInput;


	@FindBy(xpath  = "//label[contains(.,'Decision Maker Present')]/..//child::input")
	public WebElement  QualificationDecisionMakerPresent ;
	
	
	
	@FindBy(xpath  = "//label[contains(.,'Pitched for 30+ Minutes')]/..//child::input")
	public WebElement  QualificationPitchedfor30 ;
	
	
	@FindBy(xpath  = "//label[contains(.,'Bill Status')]/..//child::input")
	public WebElement  QualificaitonBillstatus ;
	
	
	
	public void verifyhamburgeroptions()   {
		
		try {
			waitforElement(120, driver.findElement(By.xpath("//i[contains(.,'menu')]")), driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		

		Onepager_Hamburger.click();
	}

	public void signingbonus(String SigningBonus) {
		try {
			waitforElement(120, AppointmentsSigningBonusSwitch, driver);		
			AppointmentsSigningBonusSwitch.click();
			waitforElement(120,AppointmentsSigningBonusLabel ,driver);
			AppointmentsSigningBonusLabel.click();
			waitforElement(120, AppointmentsSigningBonusInput,driver);
			AppointmentsSigningBonusInput.sendKeys(SigningBonus);

		}
		catch(Exception e) {
			System.out.println("Check signingbonus in LeadOnePager_Web Method in page objects package");

		}

	}

	public void RoofIncentive(String RoofIncentive) {
		try {
			waitforElement(120, Apointments_RoofIncentives,driver);
			scrolluptoelement(Apointments_RoofIncentives, driver);
			Apointments_RoofIncentives.click();
			waitforElement(120, Apointments_RoofIncentives_Label,driver);
			Apointments_RoofIncentives_Label.click();

			waitforElement(120, Apointments_RoofIncentives_Input,driver);
			Apointments_RoofIncentives_Input.sendKeys(RoofIncentive);

		}

		catch(Exception e) {
			System.out.println("ISsue with RoofIncentive Method");
		}

	}	
public void Qualification(String Decisionmakerpresent,String pitchedfor30,String billstatus) {
	
	try {
    waitforElement(120, QualificationDecisionMakerPresent, driver);
    JavaScriptclick(driver, QualificationDecisionMakerPresent);
	waitforElement(120, driver.findElement(By.xpath("//label[contains(.,'Decision Maker Present')]/..//child::li[contains(.,'"+Decisionmakerpresent+"')]")), driver);
	driver.findElement(By.xpath("//label[contains(.,'Decision Maker Present')]/..//child::li[contains(.,'"+Decisionmakerpresent+"')]")).click();
	waitforElement(120, QualificationPitchedfor30, driver);
	JavaScriptclick(driver, QualificationPitchedfor30);
	waitforElement(120, driver.findElement(By.xpath("//label[contains(.,'Pitched for 30+ Minutes')]/..//child::li[contains(.,'"+pitchedfor30+"')]")), driver);
	driver.findElement(By.xpath("//label[contains(.,'Pitched for 30+ Minutes')]/..//child::li[contains(.,'"+pitchedfor30+"')]")).click();
	waitforElement(120, QualificaitonBillstatus, driver);
	JavaScriptclick(driver, QualificaitonBillstatus);
	waitforElement(120, driver.findElement(By.xpath("//label[contains(.,'Bill Status')]/..//child::li[contains(.,'"+billstatus+"')]")), driver);
	driver.findElement(By.xpath("//label[contains(.,'Bill Status')]/..//child::li[contains(.,'"+billstatus+"')]")).click();
	}
	catch(Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
		System.out.println("Issue in Qualification Method");
	}
	
	
	
}
	public void setTreeIncentive(String Treeincentive) {
		try {
			waitforElement(120, Apointments_SalesPromotion_TreeIncentives_Toggle_Switch,driver);
			Apointments_SalesPromotion_TreeIncentives_Toggle_Switch.click();
			waitforElement(120, Apointments_SalesPromotion_TreeIncentives_Label,driver);
			Apointments_SalesPromotion_TreeIncentives_Label.click();
			Apointments_SalesPromotion_TreeIncentives_Input.sendKeys(Treeincentive);	
		}
		catch(Exception e) {

		}

	}


	public void SalesPromotion(String salespromotion) {
		try {


			waitforElement(120, Apointments_SalesPromotionDropdownlabel,driver);
			Apointments_SalesPromotionDropdownlabel.click();

			waitforElement(120, driver.findElement(By.xpath("//label[text()='Sales Promotion']/..//child::span[contains(.,'"+salespromotion+"')]")),driver);

			driver.findElement(By.xpath("//label[text()='Sales Promotion']/..//child::span[contains(.,'"+salespromotion+"')]")).click();

		}
		catch(Exception e) {

			System.out.println("Error in Sales Promotion");
		}
	}
	public void customerusage(String Usage) {

		try {
			waitforElement(120, Apointments_ProposalCustomerUsageLabel,driver);
			Apointments_ProposalCustomerUsageLabel.click();
			waitforElement(120, Apointments_ProposalCustomerUsageInput,driver);
			Apointments_ProposalCustomerUsageInput.click();	
			Apointments_ProposalCustomerUsageInput.sendKeys(Usage);

		}
		catch(Exception e) {

			System.out.println("Issue in Customer Usage");
		}

	}public void setmonthlyprice(String  monthlyprice) {

		try {
			waitforElement(120, Apointments_ProposalCustomerUsageLabel,driver);
			Apointments_ProposalCustomerUsageLabel.click();
			waitforElement(120, Apointments_ProposalMonthlyPriceInput,driver);
			Apointments_ProposalMonthlyPriceInput.sendKeys(monthlyprice);	
		}
		catch(Exception e) {
			System.out.println("Issue in setmontly Price Method");
		}

	}
	public void setshingles(String shingles) {
		try {
			waitforElement(120,driver.findElement(By.xpath("//label[contains(.,'Shingle')]/..//input")),driver);
			driver.findElement(By.xpath("//label[contains(.,'Shingle')]/..//input")).click();
			waitforElement(120, driver.findElement(By.xpath("//label[contains(.,'Shingle')]/..//span[contains(.,'"+shingles+"')]")),driver);
			driver.findElement(By.xpath("//label[contains(.,'Shingle')]/..//span[contains(.,'"+shingles+"')]")).click();

		}
		catch(Exception e) {
			System.out.println("Found changes in the Xpath Related to setshingles Method ");
		}
	}
	public void StumpremovalDropdown(String stump) {

		switch(stump) {
		case"Didn't Check":
			try {
				waitforElement(120, driver.findElement(By.xpath("//label[contains(.,'Stump Removal')]/..//child::input")),driver);
				driver.findElement(By.xpath("//label[contains(.,'Stump Removal')]/..//child::input")).click();
				waitforElement(120, driver.findElement(By.xpath("(//label[contains(.,'Stump Removal')]/..//child::span)[2]")),driver);
				scrolluptoelement(driver.findElement(By.xpath("(//label[contains(.,'Stump Removal')]/..//child::span)[2]")), driver);
				driver.findElement(By.xpath("(//label[contains(.,'Stump Removal')]/..//child::span)[2]")).click();

			}
			catch(Exception e) {
				System.out.println("Error in StumpremovalDropdown Method");
			}
			break;
		default:
			try {
				waitforElement(120, driver.findElement(By.xpath("//label[contains(.,'Stump Removal')]/..//child::input")),driver);
				driver.findElement(By.xpath("//label[contains(.,'Stump Removal')]/..//child::input")).click();
				waitforElement(120, driver.findElement(By.xpath("//label[contains(.,'Stump Removal')]/..//child::span[contains(.,'"+stump+"')]")),driver);
				scrolluptoelement(driver.findElement(By.xpath("//label[contains(.,'Stump Removal')]/..//child::span[contains(.,'"+stump+"')]")), driver);
				driver.findElement(By.xpath("//label[contains(.,'Stump Removal')]/..//child::span[contains(.,'"+stump+"')]")).click();

			}
			catch(Exception e) {
				System.out.println("Error in StumpremovalDropdown Method");
			}
			break;
		}

	}

	public void setsalespromotion(String Promotions) throws Exception {
		try {
			waitforElement(120,Apointments_SalesPromotions1,driver );
			Apointments_SalesPromotions1.click();
			waitforElement(120,driver.findElement(By.xpath("(//label[contains(.,'Sales Promotion')])[3]/..//child::input")),driver);
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//label[contains(.,'Sales Promotion')])[3]/..//child::input")).click();
			waitforElement(120, driver.findElement(By.xpath("//label[text()='Sales Promotion']/..//child::span[text()='"+Promotions+"']")),driver);
			driver.findElement(By.xpath("//label[text()='Sales Promotion']/..//child::span[text()='"+Promotions+"']")).click();
		}
		catch(Exception e) {
			System.out.println("Issue in setsalespromotion");
			waitforElement(120,Apointments_SalesPromotions1 ,driver);
			Apointments_SalesPromotions1.click();
		}
	}

	public void setSystemType(String SystemType) {
		try {
			waitforElement(120, Apointments_ProposalSystemType,driver);
			Apointments_ProposalSystemType.click();	
			waitforElement(120, driver.findElement(By.xpath("//label[contains(.,'System Type')]/..//child::span[contains(.,'"+SystemType+"')]")),driver);
			driver.findElement(By.xpath("//label[contains(.,'System Type')]/..//child::span[contains(.,'"+SystemType+"')]")).click();

		}
		catch(Exception e) {
			System.out.println("Issue in setSystemType");
		}

	}
	public void FillNewProposalFinancingOption(String FinancingOption) {
		try {

			waitforElement(120, ChooseFinancingOptionDropdown,driver);

			JavaScriptclick(driver, ChooseFinancingOptionDropdown);


			waitforElement(120, driver.findElement(By.xpath("//input[@id='appointment_modal_proposal_size']/../../div[1]//child::span[contains(.,'"+FinancingOption+"')]")),driver);

			JavaScriptclick(driver,driver.findElement(By.xpath("//input[@id='appointment_modal_proposal_size']/../../div[1]//child::span[contains(.,'"+FinancingOption+"')]")));

			Thread.sleep(2000);

		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Issue in FillNewProposalFinancingOption Method");

		}


	}

	public void NewProposalFinancingSystemSize(String Systemsize) {
		try {
			waitforElement(120, LabelProposalSystemSize,driver);
			LabelProposalSystemSize.click();
			waitforElement(120, Apointments_ProposalSystemSizeInput,driver);
			Apointments_ProposalSystemSizeInput.click();
			Apointments_ProposalSystemSizeInput.sendKeys(Systemsize);
		}
		catch(Exception e) {
			System.out.println("Issue in NewProposalFinancingSystemSize");
		}
	}

	public void setRequestProposal(String LoanStatus, String UtilityCompany, String TargetEPC, String Other_Incentives,
			String date, String month, String year, String time, String Installationtype, String Rooftype,
			String AgeOfRoof, String Anualkilowtsusage, String Notes) {
		try {
			System.out.println("Verifying Proposals ::-");
			waitforElement(120, Onepager_Request_ProposalButton,driver);
			scrolluptoelement(Onepager_Request_ProposalButton, driver);
			JavaScriptclick(driver, Onepager_Request_ProposalButton);

			// Onepager_Request_ProposalButton.click();
			Thread.sleep(3000);
			switch (LoanStatus) {
			case "PPA /Lease":
				waitforElement(120, Onepager_Proposal_PPALease_CheckBox,driver);
				Onepager_Proposal_PPALease_CheckBox.click();
				break;
			case "Cash":
				waitforElement(120, Onepager_Proposal_Cash,driver);
				Onepager_Proposal_Cash.click();
				break;
			case "Loan":
				waitforElement(120, Onepager_Proposal_Loan,driver);
				Onepager_Proposal_Loan.click();
				break;

			case "Financing Partners":
				waitforElement(120, Proposal_Financingpartner_CheckBox,driver);
				Proposal_Financingpartner_CheckBox.click();
				break;
			}
			// Proposal_Target_EPC_label Proposal_Target_EPC_Input
			/*
			 * waitforElement(driver, Proposal_Target_EPC_label);
			 * Proposal_Target_EPC_label.click();
			 */

			waitforElement(120, Proposal_Target_EPC_Input,driver);
			JavaScriptclick(driver,Proposal_Target_EPC_Input);
			// Proposal_Target_EPC_Input.click();
			Proposal_Target_EPC_Input.sendKeys(TargetEPC);
			// Include_Promotions_EPS.click();
			waitforElement(120, Proposalotherincentives,driver);
			JavaScriptclick(driver,Proposalotherincentives);
			// Proposalotherincentives.click();
			Proposalotherincentives.sendKeys(Other_Incentives);
			if(!driver.findElement(By.xpath("//input[@id='annual_kwh_usage']")).getText().contains(Anualkilowtsusage)) {
				JavaScriptclick(driver,driver.findElement(By.xpath("(//label[contains(.,'Utility Company')])[2]/../div//child::input[@type='text']")));
				waitforElement(120, driver.findElement(By.xpath("(//label[contains(.,'Utility Company')])[2]/../div//child::ul/li/span[contains(.,'"+UtilityCompany+"')]")),driver);
				driver.findElement(By.xpath("(//label[contains(.,'Utility Company')])[2]/../div//child::ul/li/span[contains(.,'"+UtilityCompany+"')]")).click();
			}
			scrolluptoelement(driver.findElement(By.xpath("//input[@id='proposal_modal_at_home']")), driver);
			JavaScriptclick(driver,driver.findElement(By.xpath("//input[@id='proposal_modal_at_home']")));
			//driver.findElement(By.xpath("//input[@id='proposal_modal_at_home']")).click();
			waitforElement(120, Onepager_NewProposalinstallationdropdown,driver);
			JavaScriptclick(driver,Onepager_NewProposalinstallationdropdown);
			waitforElement(120,	driver.findElement(
					By.xpath("//label[contains(.,'Installation Type')]/../div//child::ul/li/span[contains(.,'"+ Installationtype + "')]")),driver);


			waitforElement(120, Onepager_NewProposalRooftypeDropdown,driver);
			Onepager_NewProposalRooftypeDropdown.click();
			waitforElement(120,driver.findElement(By.xpath("//label[contains(.,'Roof Type')]/../div//child::ul/li[contains(.,'" + Rooftype + "')]")),driver);
			waitforElement(120, Onepager_NewProposalAgeOfRoofDropDown,driver);
			Onepager_NewProposalAgeOfRoofDropDown.click();
			waitforElement(120,driver.findElement(By.xpath("//label[contains(.,'Age of the Roof')]/../div/child::ul/li/span[contains(.,'" + AgeOfRoof + "')]")),driver);
			driver.findElement(By.xpath(
					"//label[contains(.,'Age of the Roof')]/../div/child::ul/li/span[contains(.,'" + AgeOfRoof + "')]")).click();
			waitforElement(120,driver.findElement(By.xpath("//input[@id='annual_kwh_usage']")),driver);
			waitforElement(120, Onepager_NewProposal_Notes,driver);
			Onepager_NewProposal_Notes.clear();
			Onepager_NewProposal_Notes.sendKeys(Notes);
			Thread.sleep(3000);
			waitforElement(120, Onepager_NewProposal_CreateButton,driver);
			if(Onepager_NewProposal_CreateButton.isDisplayed()) {
				System.out.println("Proposals working fine ");
			}
			Onepager_NewProposal_CreateButton.click();
			Thread.sleep(10000);

		} catch (Exception e) {
			System.out.println("Check Proposal");
		}
	}
	
	public void set_NewDirect_appointment(List<WebElement> appointmentstatus ,String date, String Month, String Year, String time, String Result,String Notes,String Legs,String status,String FinancingOption,String Systemsize,String monthlyprice,String Usage,String SystemType,String Promotions,String Treeincentive,String stump,String RoofIncentive,String shingles,String SigningBonus,String decisionmakerpresent,String pitchedfor30min,String billstatus) {
		try {
			
			
			
				System.out.println("Verifying Appointments ::-");
				
				waituntilspinnerdisappear(driver);
				waitforElement(120, Onepager_NewDirectAppointment, driver);
				
				
				Onepager_NewDirectAppointment.click();
				
				setcalender(date, Month, Year);
				
				settime(time);
				
				setresultstatus(Result, Notes);
				
				NumberofApointmentLegs(Legs);
				
				UtilityBillGatheredtogglebutton();
				
				checkcreditstatus(status);
				
				
				Qualification(decisionmakerpresent, pitchedfor30min, billstatus);
				waitforElement(120, ProposalSearch,driver);
				
				JavaScriptclick(driver, ProposalSearch);
				
				waitforElement(120, Appointment_Proposal_MakeNew, driver);
				
				
				Appointment_Proposal_MakeNew.click();
				
				waitforElement(120, Appointment_Proposal_SelectButton,driver);
				
				Appointment_Proposal_SelectButton.click();
				
				FillNewProposalFinancingOption(FinancingOption);
				
				NewProposalFinancingSystemSize(Systemsize);
				
				setmonthlyprice(monthlyprice);
				
				customerusage(Usage);
				
				setSystemType(SystemType);
				
				waitforElement(120, Apointments_PostSalePaperWork,driver);
					
				Apointments_PostSalePaperWork.click();
				
				waitforElement(120, Apointments_Photosuploaded,driver);
				
				Apointments_Photosuploaded.click();
				
				waitforElement(120, Apointments_SalesPromotions,driver);
				
				Apointments_SalesPromotions.click();
				
				setsalespromotion(Promotions);
				
				setTreeIncentive(Treeincentive);
				
				StumpremovalDropdown(stump);
				
				RoofIncentive(RoofIncentive);
				
				setshingles(shingles);
				
				signingbonus(SigningBonus);
				
				Thread.sleep(3000);
				
				waitforElement(120, Onepager_Appointment_SubmitButton,driver);
				
				JavaScriptclick(driver, Onepager_Appointment_SubmitButton);
					
				Thread.sleep(5000);
				
				
				
					
					waituntilspinnerdisappear(driver);
					
					waitforElement(120, Onepager_NewDirectAppointment,driver);
					
					Onepager_NewDirectAppointment.click();
					
					setcalender(date, Month, Year);
					
					settime(time);
					
					setresultstatus(Result, Notes);
					
					NumberofApointmentLegs(Legs);
					
					UtilityBillGatheredtogglebutton();
					
					checkcreditstatus(status);
					
					waitforElement(120, Onepager_Appointment_SubmitButton,driver);
					
					Onepager_Appointment_SubmitButton.click();	
					
					
					
			
			
			
		} catch (Exception e) {
			System.out.println("Check set_appointment ");
		}
		
		
		
		
	}
	
	
	public void getCurrentAppointmentdetailsfromREST() {
		
	}
	
	
	 
	public void checkcreditstatus(String status) {
		try {
			
			waitforElement(120, driver.findElement(By.xpath("//span[text()='Not Ran']/../../../input")), driver);
			
		JavaScriptclick(driver, driver.findElement(By.xpath("//span[text()='Not Ran']/../../../input")));
			
			//driver.findElement(By.xpath("//span[text()='Not Ran']/../../../input")).click();
			
			waitforElement(120, driver.findElement(By.xpath("//span[text()='"+status+"']")),driver);	
			
			driver.findElement(By.xpath("//span[text()='"+status+"']")).click();
		}
		catch(Exception e) {
			System.out.println("Check checkcreditstatus method");
		}
		
		
	}
	
	public void UtilityBillGatheredtogglebutton() {
		try {
			waitforElement(120, driver.findElement(By.xpath("//input[@id='appointment_modal_bill_gathered']/../span")),driver);
		
		driver.findElement(By.xpath("//input[@id='appointment_modal_bill_gathered']/../span")).click();
		}
		catch(Exception e) {
			
			System.out.println("check utility bill gathered");
			
		}
	}
	public void NumberofApointmentLegs(String legs) {
		
		try {
			
			waitforElement(120, DropdownLegsMainField,driver);
			
			DropdownLegsMainField.click();
			
			waitforElement(120,driver.findElement(By.xpath("//li/span[text()='"+legs+"']")),driver);
			
			driver.findElement(By.xpath("//li/span[text()='"+legs+"']")).click();
			
		}
		
		catch(Exception e) {
			
			System.out.println("Check Number of appointments");
			
			
		}
		
	}

	public void setresultstatus(String Result, String Notes) {

		try {
			waitforElement(120, Onepager_Appointment_Result,driver);
			Onepager_Appointment_Result.click();
			waitforElement(120, driver.findElement(By.xpath("//span[contains(text(),'" + Result + "')]")),driver);
			JavaScriptclick(driver,driver.findElement(By.xpath("//span[contains(text(),'" + Result + "')]")));
			switch (Result) {

			case "Sold pending paperwork":
				waitforElement(120, Onepager_Appointment_Notes,driver);
				Onepager_Appointment_Notes.sendKeys(Notes);
				
				
				break;
			default:
				waitforElement(120, Onepager_Appointment_Notes,driver);
				Onepager_Appointment_Notes.sendKeys(Notes);
				waitforElement(120, Onepager_Appointment_SubmitButton,driver);
				if(Onepager_Appointment_SubmitButton.isDisplayed()) {
					System.out.println("appointment section is working");
				}
				break;

			}

			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("check setresultstatus");

		}
	}

	public void settime(String time) {
		try {
			waitforElement(120, Onepager_Appointment_time,driver);
			Onepager_Appointment_time.click();
			waitforElement(
					120,driver.findElement(By.xpath(
							"(//div[@class='timepicker-text-container'])[2]//child::span[@class='timepicker-span-hours text-primary']"))
					,driver);
			driver.findElement(By.xpath("(//div[@class='timepicker-text-container'])[2]//child::span[@class='timepicker-span-hours text-primary']"))
					.click();
			waitforElement(120,
					driver.findElement(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[2]/div[contains(.,'"
							+ time.split(":")[0] + "')]")),driver);
			driver.findElement(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[2]/div[contains(.,'"
					+ time.split(":")[0] + "')]")).click();
			waitforElement(120,
					driver.findElement(By.xpath("//div[@class='timepicker-dial timepicker-minutes']/div[contains(.,'"
							+ time.split(":")[1] + "')]")),driver);
			driver.findElement(By.xpath(
					"//div[@class='timepicker-dial timepicker-minutes']/div[contains(.,'" + time.split(":")[1] + "')]"))
					.click();
			waitforElement(120,driver.findElement(By.xpath(
					"(//div[@class='timepicker-analog-display']/descendant::button/../div/button[contains(.,'Ok')])[2]"))
					,driver);

			driver.findElement(By.xpath(
					"(//div[@class='timepicker-analog-display']/descendant::button/../div/button[contains(.,'Ok')])[2]"))
					.click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("check settime");
		}
	}

	public void setproposaltime(String time) {

		try {

			waitforElement(
					120,driver.findElement(By.xpath(
							"(//div[@class='timepicker-text-container'])[1]//child::span[@class='timepicker-span-hours text-primary']")),driver);
			JavaScriptclick(driver,driver.findElement(By.xpath(
					"(//div[@class='timepicker-text-container'])[1]//child::span[@class='timepicker-span-hours text-primary']"))
					 );
			waitforElement(120,driver.findElement(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[1]/div[contains(.,'"+ time.split(":")[0] + "')]")),driver);
			driver.findElement(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[1]/div[contains(.,'"
					+ time.split(":")[0] + "')]")).click();
			waitforElement(120,
					driver.findElement(By.xpath("//div[@class='timepicker-dial timepicker-minutes']/div[contains(.,'"
							+ time.split(":")[1] + "')]")),driver);
			driver.findElement(By.xpath(
					"//div[@class='timepicker-dial timepicker-minutes']/div[contains(.,'" + time.split(":")[1] + "')]"))
					.click();
			waitforElement(120,driver.findElement(By.xpath(
					"(//div[@class='timepicker-analog-display']/descendant::button/../div/button[contains(.,'Ok')])[1]")),driver);
			JavaScriptclick(driver,driver.findElement(By.xpath(
					"(//div[@class='timepicker-analog-display']/descendant::button/../div/button[contains(.,'Ok')])[1]")));
			/*
			 * driver.findElement(By.xpath(
			 * "(//div[@class='timepicker-analog-display']/descendant::button/../div/button[contains(.,'Ok')])[1]"
			 * )) .click();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("settime is not working fine");
		}

	}

	public void SetleadSource(String Leadsource) {

		try {
			waitforElement(120, Onepager_LeadSource,driver);
			JavaScriptclick(driver,Onepager_LeadSource);
			waitforElement(120, Onepager_LeadSourceTextField,driver);
			JavaScriptclick(driver,Onepager_LeadSourceTextField);
			Onepager_LeadSourceTextField.sendKeys(Leadsource);
			waitforElement(120, driver.findElement(
					By.xpath("//input[@id='leadsourcesearch_main']/../../li[contains(.,'" + Leadsource + "')]")),driver);
			Thread.sleep(3000);
			waitforElement(120, driver.findElement(
					By.xpath("//input[@id='leadsourcesearch_main']/../../li[contains(.,'" + Leadsource + "')]")),driver);

			JavaScriptclick(driver,
					driver.findElement(By
							.xpath("//input[@id='leadsourcesearch_main']/../../li[contains(.,'" + Leadsource + "')]")));
		} catch (Exception e) {
			System.out.println("Check SetleadSource Method");

		}

	}

	public void setHOA(String HOA_Status, String HOAName, String HOAEmail, String PhoneNumber, String Ext) {

		try {
			waitforElement(120, HOADropDown,driver);
			JavaScriptclick(driver,HOADropDown);

			switch (HOA_Status) {

			case "Did Not Confirm":
				waitforElement(120, driver.findElement(By.xpath("//span[contains(text(),'Did Not Confirm')]")),driver);
				driver.findElement(By.xpath("//span[contains(text(),'Did Not Confirm')]")).click();

				break;
			case "Yes":
				waitforElement(120, driver.findElement(By.xpath("//span[contains(text(),'Yes')]")),driver);
				driver.findElement(By.xpath("//span[contains(text(),'Yes')]")).click();
				break;
			case "No":
				waitforElement(120, driver.findElement(
						By.xpath("//span[contains(text(),'Yes')]/../following-sibling::li/span[contains(.,'No')]")),driver);
				driver.findElement(
						By.xpath("//span[contains(text(),'Yes')]/../following-sibling::li/span[contains(.,'No')]"))
						.click();
				break;

			}

			Onepager_HOA_Name.sendKeys(HOAName);
			Onepager_HOA_EmailAddress.sendKeys(HOAEmail);
			Onepager_HOA_MobileNumbers.sendKeys(PhoneNumber);
			HOAMobileExt.sendKeys(Ext);
			if(Onepager_HOA_Name.isDisplayed()&&Onepager_HOA_EmailAddress.isDisplayed()&&Onepager_HOA_MobileNumbers.isDisplayed()&&HOAMobileExt.isDisplayed()) {
				System.out.println("HOA section is working fine ");	
			}
			

		} catch (Exception e) {
			System.out.println("ISSUE in SetHOA");
		}

	}

	public void setproposalcalender(String date, String month, String year) {
		try {
			waitforElement(120, Onepager_clickon_month,driver);
			Onepager_clickon_month.click();
			waitforElement(120,driver.findElement(By.xpath(
					"//div[@class='modal timepicker-modal']/following-sibling::ul[2]/li[contains(.,'" + month + "')]"))
					,driver);
			driver.findElement(By.xpath(
					"//div[@class='modal timepicker-modal']/following-sibling::ul[2]/li[contains(.,'" + month + "')]"))
					.click();
			waitforElement(120, Onepager_clickon_year,driver);
			Onepager_clickon_year.click();
			waitforElement(120,driver.findElement(By.xpath(
					"//div[@class='modal timepicker-modal']/following-sibling::ul[1]/li[contains(.,'" + year + "')]"))
					,driver);
			driver.findElement(By.xpath(
					"//div[@class='modal timepicker-modal']/following-sibling::ul[1]/li[contains(.,'" + year + "')]"))
					.click();
			waitforElement(120,driver.findElement(By.xpath("//td[@data-day='" + date + "']/button[contains(.,'" + date + "')]")),driver);
			JavaScriptclick(driver,driver.findElement(By.xpath("//td[@data-day='" + date + "']/button[contains(.,'" + date + "')]")));
			//driver.findElement(By.xpath("//td[@data-day='" + date + "']/button[contains(.,'" + date + "')]")).click();
			//waitforElement(driver, Onepager_Appointmentokbutton);
			Onepager_Appointmentokbutton.click();
			Thread.sleep(2000);
			
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("ISsue in the Proposal calender");
		}
	}

	public void setcalender(String date, String month, String year) {
		try {
			waitforElement(120, Onepager_DateField,driver);
			Onepager_DateField.click();
			waitforElement(120, Onepager_clickon_month,driver);
			Onepager_clickon_month.click();
			waitforElement(120,driver.findElement(By.xpath(
					"//div[@class='modal timepicker-modal']/following-sibling::ul[2]/li[contains(.,'" + month + "')]"))
					,driver
					);
			driver.findElement(By.xpath(
					"//div[@class='modal timepicker-modal']/following-sibling::ul[2]/li[contains(.,'" + month + "')]"))
					.click();
			waitforElement(120, Onepager_clickon_year,driver);
			Onepager_clickon_year.click();
			waitforElement(120,driver.findElement(By.xpath(
					"//div[@class='modal timepicker-modal']/following-sibling::ul[1]/li[contains(.,'" + year + "')]"))
					,driver
					);
			driver.findElement(By.xpath(
					"//div[@class='modal timepicker-modal']/following-sibling::ul[1]/li[contains(.,'" + year + "')]"))
					.click();
			waitforElement(120,driver.findElement(By.xpath("//td[@data-day='" + date + "']/button[contains(.,'" + date + "')]")),driver);
			driver.findElement(By.xpath("//td[@data-day='" + date + "']/button[contains(.,'" + date + "')]")).click();
		    Thread.sleep(3000);
			Onepager_Appointmentokbutton.click();
			// Onepager_Appointmentokbutton.click();
			// javascriptclick( Onepager_Appointmentokbutton, driver);
			// Onepager_Appointmentokbutton.click();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("check set calender");
		}

	}

	public void clickutilitysavebutton() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//div[@id='financeInfo']//following-sibling::div//child::button[contains(.,'Save Lead')]")));
			Onepager_SaveLead_2.click();
		} catch (Exception e) {

		}
	}

	public void setleadnoteform(String status, String tagname, String Notes) {
		try {
			waitforElement(120, Onepager_NewNoteButton,driver);
			scrolluptoelement(Onepager_NewNoteButton, driver);
			JavaScriptclick(driver,Onepager_NewNoteButton);
			setstatus(status);
			settagname(tagname);
			Onepager_NotesTextField.sendKeys(Notes);
			if(OnepagerNotesSavebutton.isDisplayed()) {
				System.out.println("lead notes section is working fine");
			}
			waitforElement(120, OnepagerNotesSavebutton,driver);
			OnepagerNotesSavebutton.click();
			
		} catch (Exception e) {

			System.out.println("Check Lead Note Form");
		}

	}
	
	public String GetDynamicdateandTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss"); 
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println();  
		
		return dtf.format(now);
	}

	public void setstatus(String status) {
		try {
			Thread.sleep(4000);
			waitforElement(120, Onepager_LeadNoteStatus,driver);
			JavaScriptclick(driver,Onepager_LeadNoteStatus);
			// Onepager_LeadNoteStatus.click();
			waitforElement(120, driver.findElement(By.xpath("//span[contains(text(),'" + status + "')]")),driver);
			JavaScriptclick(driver,driver.findElement(By.xpath("//span[contains(text(),'" + status + "')]")));

		} catch (Exception e) {
			System.out.println("Check setleadnote");
		}
	}

	public void settagname(String tagname) {
		try {
			waitforElement(120, Onepager_taginputtextbox,driver);
			Onepager_taginputtextbox.click();
			Onepager_taginputtextbox.sendKeys(tagname);
			waitforElement(120,
					driver.findElement(By.xpath("//div[@class='choices__list']/div[contains(.,'" + tagname + "')]")),driver);
			driver.findElement(By.xpath("//div[@class='choices__list']/div[contains(.,'" + tagname + "')]")).click();
		} catch (Exception e) {
			System.out.println("check settagname");
		}

	}

	public void setfinancingtypes(String financing) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(.,'Utility
			// & Financing')]/../div[2]//child::input[@type='text']")));
			scrolluptoelement(
					driver.findElement(
							By.xpath("//label[contains(.,'Financing Type')]/../div//child::input[@type='text']")),
					driver);
			JavaScriptclick(driver,
					driver.findElement(
							By.xpath("//label[contains(.,'Financing Type')]/../div//child::input[@type='text']"))
					);
			// driver.findElement(By.xpath("//h5[contains(.,'Utility &
			// Financing')]/../div[2]//child::input[@type='text']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//select[@id='utility_company']/../../../following-sibling::div//child::ul/li/span[contains(.,'"
							+ financing + "')]")));
			driver.findElement(By.xpath(
					"//select[@id='utility_company']/../../../following-sibling::div//child::ul/li/span[contains(.,'"
							+ financing + "')]"))
					.click();
		} catch (Exception e) {
			System.out.println("Check setfinancingtypes");
		}
	}

	public void setutilitycompany(String Utilitycompany, String AnnualKilowatts) {
		try {
			Thread.sleep(3000);
			waitforElement(120, Onepager_UtilityCompany_DropDown,driver);
			scrolluptoelement(Onepager_UtilityCompany_DropDown, driver);
			JavaScriptclick(driver,Onepager_UtilityCompany_DropDown);
			Thread.sleep(2000);
			waitforElement(120,driver.findElement(By.xpath("//label[@for='utility_company_main']/../div//child::ul/li/span[contains(.,'"
									+ Utilitycompany + "')]")),driver);
			JavaScriptclick(driver,driver
					.findElement(By.xpath("//label[@for='utility_company_main']/../div//child::ul/li/span[contains(.,'"
							+ Utilitycompany + "')]")));
			waitforElement(120, AnnualKWUSage,driver);
			AnnualKWUSage.sendKeys(AnnualKilowatts);

		} catch (Exception e) {

			System.out.println("check selectutilitycompany ");
		}
	}

	public void setreference(String reference) {
		try {

			scrolluptoelement(Onepager_ReferredBy, driver);
			driver.findElement(By.xpath("//i[contains(.,'search')]/../self::button[@class='btn']")).click();
			waitforElement(120,
					driver.findElement(By.xpath("//h4[contains(.,'Select A Referrer')]/../div//child::input")),driver);
			driver.findElement(By.xpath("//h4[contains(.,'Select A Referrer')]/../div//child::input")).click();
			driver.findElement(By.xpath("//h4[contains(.,'Select A Referrer')]/../div//child::input"))
					.sendKeys(reference);
			waitforElement(120, driver.findElement(By.xpath("//a[contains(.,'" + reference + "')]")),driver);
			driver.findElement(By.xpath("//a[contains(.,'" + reference + "')]")).click();
			driver.findElement(By.xpath("//button[contains(.,'Select')]")).click();

		} catch (Exception e) {

			System.out.println("Issue in setreference");
		}
	}

	public void selectstate(String state) {
		try {
			scrolluptoelement(Onepager_State, driver);
			waitforElement(120, Onepager_State,driver);
			JavaScriptclick(driver,Onepager_State);
			// Onepager_State.click();
			Thread.sleep(2000);
			waitforElement(120, driver.findElement(
					By.xpath("//label[@for='state_main']/../div/ul/li/span[contains(.,'" + state + "')]")),driver);
			JavaScriptclick(driver,driver.findElement(
							By.xpath("//label[@for='state_main']/../div/ul/li/span[contains(.,'" + state + "')]"))
					);
			// driver.findElement(By.xpath("//label[@for='state_main']/../div/ul/li/span[contains(.,'"+state+"')]")).click();
		} catch (Exception e) {
			System.out.println("Select state method Error");
		}
	}

	public void setmentor(String Mentor) {
		try {
			JavaScriptscroll(driver, Onepager_Mentor);
			Onepager_Mentor.click();
			//JavaScriptclick(driver,Onepager_Mentor);
			waitforElement(120, driver.findElement(By.xpath("//input[@id='mentorsearch_main']")),driver);
			JavaScriptclick(driver,driver.findElement(By.xpath("//input[@id='mentorsearch_main']")));
			driver.switchTo().activeElement().sendKeys(Mentor);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='mentorsearch_main']")).sendKeys(Mentor);
			waitforElement(120, driver.findElement(By.xpath("//input[@id='mentorsearch_main']")),driver);
			JavaScriptclick(driver,driver.findElement(By.xpath("//li/span[contains(.,'" + Mentor + "')]")));
			if(driver.findElement(By.xpath("//input[@id='mentorsearch_main']")).isDisplayed()) {
				System.out.println("Mentor field is working fine");
			}
		} catch (Exception e) {
			System.out.println("Given Mentor does not Exist -MentorName :"+Mentor);
		}

	}

	public void setrelatedcampaign(String campaign) {
		try {
			Thread.sleep(2000);
			scrolluptoelement(Onepager_RelatedCampaign, driver);
			try {
				JavaScriptclick(driver,Onepager_RelatedCampaign);
			} catch (Exception e) {
				System.out.println("related campaign 1");
			}
			try {
				waitforElement(120, RelatedCampaignTextField,driver);
				Thread.sleep(3000);
				JavaScriptclick(driver,RelatedCampaignTextField);
				// RelatedCampaignTextField.click();
				RelatedCampaignTextField.sendKeys(campaign);
				waitforElement(120, driver.findElement(By.xpath("//ul/li/span[contains(.,'" + campaign + "')]")),driver);
				;
				JavaScriptclick(driver,driver.findElement(By.xpath("//ul/li/span[contains(.,'" + campaign + "')]")));
			} catch (Exception e) {
				System.out.println("related campaign 2");
			}
		} catch (Exception e) {
			System.out.println("Check setrelatedcampaign");
		}
	}

	public void webdriverwait(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}

	public void set_referredby(String referredby) {
		try {
			Thread.sleep(2000);
			waitforElement(120,driver.findElement(By.xpath("//input[@id='autocompleteReferral']")),driver);
			Onepager_ReferredBy.click();
			Onepager_ReferredBy.sendKeys(referredby);
			List<WebElement> elements = driver.findElements(By.xpath("//input[@id='autocompleteReferral']/../ul/li"));
			for (WebElement tempelement : elements) {
				String temp = tempelement.getText();

				if (temp.equals(referredby)) {
					System.out.println(temp + "    " + referredby);
					tempelement.click();
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("check set_referredby");
		}
	}
	
	public void click_on_RequiredTable(String tablename) {
		
		WebElement temp=driver.findElement(By.xpath("//table[@id='appTablesListTable']/tbody/tr/td//child::a[contains(.,'"+tablename+"')]"));
		try {
			waitforElement(120,temp,driver );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		temp.click();
		
	}
	/*
	 * public void settings(String tablename,String sanboxname) { try {
	 * 
	 * Quickbasepage QB=PageFactory.initElements(driver,Quickbasepage.class);
	 * driver.get("https://suntuity.quickbase.com/db/bqtnr4qxn");
	 * QB.selectsanbox(sanboxname); waitforElement(driver, Onepager_Settings);
	 * Onepager_Settings.click(); waitforElement(driver, Onepager_Tables);
	 * JavaScriptclick(Onepager_Tables, driver); // Onepager_Tables.click();
	 * click_on_RequiredTable(tablename); Table_Fields.click(); List<WebElement>
	 * element=driver.findElements(By.xpath("//table[@id='fieldsTable']/tbody/tr"));
	 * for(int i=3;i<element.size();i++) { String
	 * id=driver.findElement(By.xpath("//table[@id='fieldsTable']/tbody/tr["+i+"]"))
	 * .getAttribute("id"); String
	 * value=driver.findElement(By.xpath("//table[@id='fieldsTable']/tbody/tr["+i+
	 * "]/td[3]/span[2]/a")).getText(); fieldInformation.put(id, value);
	 * 
	 * } System.out.println(element.size()); System.out.println(fieldInformation);
	 * 
	 * } catch(Exception e) {
	 * 
	 * System.out.println("Click on settings not applied"); }
	 * 
	 * 
	 * }
	 */


}
