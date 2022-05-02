'Prepare the message to be displayed
Set objArgs = WScript.Arguments
iTestCaseExecuting = objArgs(0)
iTotalTestCasesToBeExecuted = objArgs(1)
iTotalPassed = objArgs(2)
iTotalFailed = objArgs(3)
iFailedTestCases=objArgs(4)
sMsg = "Executing " & iTestCaseExecuting & " of " & iTotalTestCasesToBeExecuted & " Test Cases..." & VbCrLf
sMsg = sMsg & "Passed - " & iTotalPassed & VbCrLf  & "Failed - " & iTotalFailed & VbCrLf
sMsg = sMsg & "Failed Test Case Numbers - " & iFailedTestCases
sMsg = sMsg &  VbCrLf  & VbCrLf  & "(This message will close automatically in 5 seconds)"
'Display the message for certain number of seconds
Set WshShell = CreateObject("Wscript.Shell")
WshShell.Popup sMsg, 5, "Intermediate Test Run Status"
Set WshShell = Nothing