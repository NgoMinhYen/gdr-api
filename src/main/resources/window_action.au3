#include <SendMessage.au3>
#include <array.au3>
; GET ARGUMENT FROM COMMAND LINE

Global $error = "An error occurred when autoIT "
Global $waitTimeOut = "AutoIT spent %s seconds for "
Global $SHORT_TIME = 10
Global $LONG_TIME = 60
Sleep(1000)


Switch (Ubound($CmdLine) - 1)
Case 1
	  Call($CmdLine[1])
   Case 2
	  Call($CmdLine[1],$CmdLine[2])
   Case 3
	  Call($CmdLine[1],$CmdLine[2],$CmdLine[3])
   Case 4
	  Call($CmdLine[1],$CmdLine[2],$CmdLine[3],$CmdLine[4])
   Case 5
	  Call($CmdLine[1],$CmdLine[2],$CmdLine[3],$CmdLine[4],$CmdLine[5])
   Case Else
	  MsgBox (0,"Method List",$description)
EndSwitch

; WINDOW METHOD

Func ActiveWindow ($infoWindow, $timeout = 10)
   Local $window = _GetHandleWindow($infoWindow, $timeout)
   WinActivate($window)
EndFunc

Func _GetHandleWindow($infoWindow, $timeout = 10)
   Local $window = WinWait($infoWindow,"",$timeout)
   return $window
EndFunc

Func FindElement($infoWindow, $infoControl, $timeout)
   Local $window = _GetHandleWindow($infoWindow)
   if $window == 0 Then
	  $msg = StringFormat("AutoIT spent %s seconds for finding window '%s' with control '%s' but it isn't exist", $timeout, $infoWindow, $infoControl)
	  ConsoleWrite($msg & @CRLF)
   Else
	  return ControlGetHandle($window,"",$infoControl)
   EndIf

EndFunc

Func TakeScreenshot($path, $infoWindow)
   $img = StringFormat($path & "autoit_screenshot%d.png", Random ( 1, 99999999,1) )
   Local $window = _GetHandleWindow($infoWindow)
   ActiveWindow($wNotepad)
   _ScreenCapture_CaptureWnd ( $img, $window)
   If @error Then
	  $msg = StringFormat($error & "take screenshot on window '%s'", $infoWindow)
	  ConsoleWrite($msg & @CRLF)
   Else
	  ConsoleWrite($img)
   EndIf
EndFunc

; SUPPORT METHOD
Func WaitUntil($FunctionName, $aArguments = "", $timeout = 10)
   Local $hTimer = TimerInit() ; Begin the timer and store the handle in a variable.
   Do
	  $result = CallFunction($FunctionName, $aArguments)
	  If TimerDiff($hTimer) >= ($timeout*1000) Then
		 Return 0
	  EndIf
	  Sleep(500)
   Until $result <> 0
   Return $result
EndFunc

Func CallFunction($FunctionName, $aArguments = "")
   Switch (Ubound($aArguments))
	  Case 1
		 Return Call($FunctionName, $aArguments[0])
	  Case 2
		 Return Call($FunctionName, $aArguments[0],$aArguments[1])
	  Case 3
		 Return Call($FunctionName, $aArguments[0],$aArguments[1],$aArguments[2])
	  Case 4
		 Return Call($FunctionName, $aArguments[0],$aArguments[1],$aArguments[2],$aArguments[3])
	  Case Else
		 Return Call($FunctionName, $aArguments)
   EndSwitch
EndFunc

; ACTION METHOD

Func Click($infoWindow, $infoControl)
   $element =  FindElement($infoWindow, $infoControl, $SHORT_TIME)
   if $element <> 0 Then
	  Dim $aArguments[3] = ["","",$element]
	  $isClick = WaitUntil("ControlClick", $aArguments)
	  If $isClick == 0 Then
		 $msg = StringFormat($error & "click on window '%s' with control '%s' ", $infoWindow, $infoControl)
		 ConsoleWrite($msg & @CRLF)
	  EndIf
   EndIf
EndFunc

Func SendText($infoWindow, $infoControl, $str)
   Local $window = FindElement($infoWindow, $infoControl, $SHORT_TIME)
   ControlSend ( "", "", $window, $str )
EndFunc

Func SetText($infoWindow, $infoControl, $str)
   Local $element = FindElement($infoWindow, $infoControl, $SHORT_TIME)
   if $element <> 0 Then
	  Dim $aArguments[4] = ["", "", $element, $str]
	  $setText = WaitUntil("ControlSetText", $aArguments)
	  If $setText == 0 Then
		 $msg = StringFormat($error & "set text '%s' on window '%s' with control '%s' ", $str, $infoWindow, $infoControl)
		 ConsoleWrite($msg & @CRLF)
	  EndIf
   EndIf
EndFunc

Func SendKey($str)
   Send($str)
EndFunc

Func GetText($infoWindow, $infoControl)
   $element =  FindElement($infoWindow, $infoControl, $SHORT_TIME)
   if $element <> 0 Then
	  Dim $aArguments[3] = ["","",$element]
	  $getText = WaitUntil("ControlGetText", $aArguments)
	  If @error <> 1 Then
		 $msg = StringFormat($error & "get text on window '%s' with control '%s' ", $infoWindow, $infoControl)
		 ConsoleWrite($msg & @CRLF)
	  Else
		 return $getText
	  EndIf
   EndIf
EndFunc

Func verify_window_exist ($window_name, $timeout = 60)
   Local $window = _GetHandleWindow($window_name, $timeout)
   If $window <> 0 Then
	  ConsoleWrite(1)
   Else
	  ConsoleWrite(0)
   EndIf
EndFunc

