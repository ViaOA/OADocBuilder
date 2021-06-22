;This file will be executed next to the application bundle image
;I.e. current directory will contain folder OADocBuilder with application files
[Setup]
AppId={{com.viaoa.docbuilder}}
AppName=OADocBuilder
AppVersion=0.0.1
AppVerName=OADocBuilder 0.0.1
AppPublisher=Goldovi
AppComments=OADocBuilder Platform
AppCopyright=(c) 2019 Goldovi
AppPublisherURL=http://www.goldovi.com/
AppSupportURL=http://www.goldovi.com/
AppUpdatesURL=http://www.goldovi.com/
DefaultDirName={localappdata}\OADocBuilder
DisableStartupPrompt=No
DisableDirPage=No
DisableProgramGroupPage=No
DisableReadyPage=No
DisableFinishedPage=No
DisableWelcomePage=No
DefaultGroupName=Goldovi AppStore
;Optional License
LicenseFile=license.txt
;WinXP or above
MinVersion=0,5.1 
OutputBaseFilename=OADocBuilder-0.0.1
Compression=lzma
SolidCompression=yes
PrivilegesRequired=lowest
SetupIconFile=OADocBuilder\OADocBuilder.ico
UninstallDisplayIcon={app}\OADocBuilder.ico
UninstallDisplayName=OADocBuilder
WizardImageStretch=No
WizardSmallImageFile=OADocBuilder-setup-icon.bmp   
ArchitecturesInstallIn64BitMode=x64


[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Files]
Source: "OADocBuilder\OADocBuilder.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "OADocBuilder\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs

[Icons]
Name: "{group}\OADocBuilder"; Filename: "{app}\OADocBuilder.exe"; IconFilename: "{app}\OADocBuilder.ico"; Check: returnTrue()
;Name: "{commondesktop}\OADocBuilder"; Filename: "{app}\OADocBuilder.exe";  IconFilename: "{app}\OADocBuilder.ico"; Check: returnFalse()
Name: "{userdesktop}\OADocBuilder"; Filename: "{app}\OADocBuilder.exe"; IconFilename: "{app}\OADocBuilder.ico"; Tasks: desktopicon
Name: "{group}\Uninstall OADocBuilder"; Filename: "{uninstallexe}";IconFilename: "{app}\OADocBuilder.ico";


[Run]
Filename: "{app}\OADocBuilder.exe"; Parameters: "-Xappcds:generatecache"; Check: returnFalse()
Filename: "{app}\OADocBuilder.exe"; Description: "{cm:LaunchProgram,OADocBuilder}"; Flags: nowait postinstall skipifsilent; Check: returnTrue()
Filename: "{app}\OADocBuilder.exe"; Parameters: "-install -svcName ""OADocBuilder"" -svcDesc ""OADocBuilder from Goldovi"" -mainExe ""OADocBuilder.exe""  "; Check: returnFalse()

[UninstallRun]
Filename: "{app}\OADocBuilder.exe"; Parameters: "-uninstall -svcName OADocBuilder -stopOnUninstall"; Check: returnFalse()

[Code]
function returnTrue(): Boolean;
begin
  Result := True;
end;

function returnFalse(): Boolean;
begin
  Result := False;
end;

function InitializeSetup(): Boolean;
begin
// Possible future improvements:
//   if version less or same => just launch app
//   if upgrade => check if same app is running and wait for it to exit
//   Add pack200/unpack200 support? 
  Result := True;
end;  
