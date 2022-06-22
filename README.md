# About
Lance is a software utility which allows you to perform several flexible operations on text(.txt) files.
This app works well in conjunction with the Lightnovel Crawler. For example you can add prefix or suffix to the file or add custom numbering to the file names.

Lance currently supports the following operations.
1 Remove a word from the file.
2 Replace words from a file.
3 Add a prefix or suffix to a filename
4 Add a numbering pattern to a file name.
5 Remove blank lines from the file.
6 Output the modified file in a specified location.


Getting Started
The first thing you'll need to do is select the folder where your text files are present. To do this click on the "Open Folder" button on the upper left side of application and select the folder.
The "Preview button lets you preview your text documents with or without changes in the text area on the right.

Remove Option
The remove option lets you remove any words from the text files.
for eg : typing "Hello" would remove the word "Hello" from all the files.
You can also remove multiple words at once using "|" at delimiter.
for eg : typing "you|are" would remove both the words "you" and "are".
Note : The "|" delimiter can be escaped by typing "\|".

Replace Option
The replace option lets you replace certain words with the words that you type. The word to be removed is to be typed in the first text box and the word to be replaced with is to be entered in the second text box.
The "|" delimiter can als be used to specify many words at the same time.
Note : The "|" delimiter can be escaped by typing "\|".

Renamer Option
The renamer option lets you change and adjust the names of the output files. renamer is quite flexible and can be used in many different ways to get the desired name.
	Regex Field : allows the user to add the chapter title in file name based on custom regex expression
	Numerical Field : lets you add numbering in the name of the output file. It is quite the flexible option.
		Its syntax is "Start : Step : Expression"
		The "Start" field specifies the starting number.
		The "Step" field specifies the step. ie the number to be added to start for the subsequent file names.
		The "Expression" field specifies the place and format where the numbering is to be placed.
		These are all the expressions that are currently available.
			"B"		: start + prefix + currentfilename + suffix
			"Bs"		: start + " " + prefix + currentfilename + suffix
			"b"		: prefix + start + currentfilename + suffix
			"bs"		: prefix + start + " " + currentfilename + suffix
			"S"		: prefix + currentfilename + suffix + start
			"Ss"		: prefix + currentfilename + suffix + " " +  start
			"s"		: prefix + currentfilename + start + suffix
			"ss"		: prefix + currentfilename + " " +  start + suffix
			"RB"		: start + prefix + suffix
			"RBs"	: prefix + " " + currentfilename + " " +  start + suffix
			"RS"		: prefix + suffix + start
			"RSs"	: prefix + suffix + " " + start
			"RM"	: prefix + start + suffix
			"RMs"	: prefix + " " + start + " " + suffix
		For eg : if the input was "1 : 2 : RM" then the output would be 1.txt, 3.txt, 5.txt and so on.
	The "Prefix Field" specifies the prefix to be added to the start of the file name.
	The "Suffix Field" specifies the suffix to be added to the end of the file name.

Remove Blank Lines Option
	"All" option removes all blank lines from the text.
	"Extra" option removes all the extra blank line leaving only one blank line between each line

Output Option
This option lets you output the modified file to your desired location.
This can be done by first selecting the output location using the "Change Location" button at the bottom right side of the app. 
After that you have to select any one of the two output modes in the app, namely "Single file" or "Multiple Files".
Choosing the "Single file" option will output all the contents into one file which will be named as "NameOfFirstFile - NameOfLastFile.txt"
Choosing the "Multiple files" option which will save each file individually with their newly modified designated names.
After that all you have to do is click on "Output" button on lower left side of app.


Additional Info
You can check the newly designated names of the files in the filename tab present on top of preview area.
