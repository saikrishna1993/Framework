
ClientName = "SuntuitySolar" 		'Change this for each project implementation
FileName = ClientName & "_" & funGetTimeStamp()
'******************************************************************************************

'Used to empty test results and screenshots
set fso=CreateObject("Scripting.FileSystemObject")
WorkingDirectory = fso.GetParentFolderName(Wscript.ScriptFullName)

'******************************************************************************************
'Enter Project folder path
Set objArgs = WScript.Arguments
MainFolder = objArgs(0)
'******************************************************************************************
ModuleName = ClientName

TestResultsFolder = WorkingDirectory&"\Test_Reports\"
ScreenshotsFolder = WorkingDirectory&"\ScreenShots\"
HtmlResultsFolder = WorkingDirectory&"\HTMLReports\"

BaseFolder = MainFolder&ModuleName&"\"

'Check backup folder exist, else create new
If  Not fso.FolderExists(MainFolder) Then
   fso.CreateFolder (MainFolder)
End If
If  Not fso.FolderExists(MainFolder&ModuleName&"\") Then
   fso.CreateFolder (MainFolder&ModuleName&"\")
End If

'Check Screen Shots, test reports folder exist, else create new
If  Not fso.FolderExists(TestResultsFolder) Then
   fso.CreateFolder (TestResultsFolder)
End If
If  Not fso.FolderExists(ScreenshotsFolder) Then
   fso.CreateFolder (ScreenshotsFolder)
ELSE
	fso.DeleteFile(ScreenshotsFolder & "*.*")
End If

'Check HTML reports folder exist, else create new
If  Not fso.FolderExists(TestResultsFolder) Then
   fso.CreateFolder (TestResultsFolder)
End If
If  Not fso.FolderExists(HtmlResultsFolder) Then
   fso.CreateFolder (HtmlResultsFolder)
ELSE
	fso.DeleteFile(HtmlResultsFolder & "*.*")
End If

'Check if folders are empty
set folder1 = fso.getFolder(TestResultsFolder)
Set folder1Sub = folder1.SubFolders  

set folder2 = fso.getFolder(ScreenshotsFolder)

set folder3 = fso.getFolder(HtmlResultsFolder)

'New folder name with time stamp
NewFolder = BaseFolder & FileName & "__OldData"

If (folder1Sub.Count>1 or folder2.files.Count>0) then
	fso.CreateFolder (NewFolder)
End if

If (folder1Sub.Count>1) then
	Set objShell = CreateObject("Shell.Application")
	Set objFolder = objShell.NameSpace(NewFolder) 
	objFolder.CopyHere TestResultsFolder 
	Set objFolder = Nothing
	Set objShell = Nothing
End if

If (folder2.files.Count>0) then
	Set objShell = CreateObject("Shell.Application")
	Set objFolder = objShell.NameSpace(NewFolder) 
	objFolder.CopyHere ScreenshotsFolder 
	Set objFolder = Nothing
	Set objShell = Nothing
End if

If (folder3.files.Count>0) then
	Set objShel1 = CreateObject("Shell.Application")
	Set objFolder = objShel1.NameSpace(NewFolder) 
	objFolder.CopyHere HtmlResultsFolder 
	Set objFolder = Nothing
	Set objShel1 = Nothing
End if

For Each f1 in folder1Sub
	f1.delete
Next

fso.DeleteFile(ScreenshotsFolder & "*.*")
fso.DeleteFile(HtmlResultsFolder & "*.*")

set fso = Nothing

Function funGetTimeStamp()
		sDateTIme = Now()
		
		iDate = Datepart("d",sDateTime)
		iLen = Len(iDate)
		If iLen = 1 Then
				iDate = "0" & iDate
		End If
		
		sMonth=  mid(MonthName(Datepart("m",sDateTime)),1,3)
		
		iYear = Datepart("yyyy",sDateTime)
		
		iHour = Datepart("h",sDateTime)
		iLen = Len(iHour)
		If iLen = 1 Then
				iHour = "0" & iHour
		End If
		
		iMinute = Datepart("n",sDateTime)
		iLen = Len(iMinute)
		If iLen = 1 Then
				iMinute = "0" & iMinute
		End If
		
		iSec = Datepart("s",sDateTime)
		iLen = Len(iSec)
		If iLen = 1 Then
				iSec = "0" & iSec
		End If
		
		funGetTimeStamp =  sMonth & "_" &  iDate & "_" & iYear & "_" & iHour & "_" & iMinute & "_" & iSec 
	 
End Function