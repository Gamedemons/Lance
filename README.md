# About
Lance is a software utility which allows you to perform several flexible operations on text(.txt) files.
This app works well in conjunction with the Lightnovel Crawler. For example you can add prefix or suffix to the file or add custom numbering to the file names.

Lance currently supports the following operations.<br>
- Remove a word from the file.
- Replace words from a file.
- Add a prefix or suffix to a filename.
- Add a numbering pattern to a file name.
- Remove blank lines from the file.
- Output the modified file in a specified location.

<br>

## Getting Started<br>
The first thing you'll need to do is select the folder where your text files are present. To do this click on the "Open Folder" button on the upper left side of application and select the folder.<br>
The "Preview button lets you preview your text documents with or without changes in the text area on the right.<br>
<br>

## Remove Option<br>
The remove option lets you remove any words from the text files.<br>
&emsp;for eg : typing "Hello" would remove the word "Hello" from all the files.<br>
You can also remove multiple words at once using "|" at delimiter.<br>
&emsp;for eg : typing "you|are" would remove both the words "you" and "are".<br>
Note : The "|" delimiter can be escaped by typing "\|".<br>
<br>

## Replace Option<br>
The replace option lets you replace certain words with the words that you type. The word to be removed is to be typed in the first text box and the word to be replaced with is to be entered in the second text box.<br>
The "|" delimiter can als be used to specify many words at the same time.<br>
Note : The "|" delimiter can be escaped by typing "\|".<br>
<br>

## Regex Field
allows the user to add the chapter title in file name based on custom regex expression<br>
- Numerical Field :<br>lets you add numbering in the name of the output file. It is quite the flexible option.<br>
Its syntax is "Start : Step : Expression"<br>
  - The "Start" field specifies the starting number.<br>
  - The "Step" field specifies the step. ie the number to be added to start for the subsequent file names.<br>
  - The "Expression" field specifies the place and format where the numbering is to be placed.<br>
    These are all the expressions that are currently available.
    - "B": start + prefix + currentfilename + suffix<br>
    - "Bs"		: start + " " + prefix + currentfilename + suffix<br>
    - "b"		: prefix + start + currentfilename + suffix<br>
    - "bs"		: prefix + start + " " + currentfilename + suffix<br>
    - "S"		: prefix + currentfilename + suffix + start<br>
    - "Ss"		: prefix + currentfilename + suffix + " " +  start<br>
    - "s"		: prefix + currentfilename + start + suffix<br>
    - "ss"		: prefix + currentfilename + " " +  start + suffix<br>
    - "RB"		: start + prefix + suffix<br>
    - "RBs"	: prefix + " " + currentfilename + " " +  start + suffix<br>
    - "RS"		: prefix + suffix + start<br>
    - "RSs"	: prefix + suffix + " " + start<br>
    - "RM"	: prefix + start + suffix<br>
    - "RMs"	: prefix + " " + start + " " + suffix<br>

- The "Prefix Field" specifies the prefix to be added to the start of the file name.<br>
- The "Suffix Field" specifies the suffix to be added to the end of the file name.<br>
 
For eg : if the input was "1 : 2 : RM" then the output would be 1.txt, 3.txt, 5.txt and so on.<br>
<br>


## Remove Blank Lines Option<br>
 - "All" option removes all blank lines from the text.<br>
 - "Extra" option removes all the extra blank line leaving only one blank line between each line<br>
<br>

## Output Option<br>
This option lets you output the modified file to your desired location.<br>
This can be done by first selecting the output location using the "Change Location" button at the bottom right side of the app.<br>
After that you have to select any one of the two output modes in the app, namely "Single file" or "Multiple Files".<br>
 - Choosing the "Single file" option will output all the contents into one file which will be named as "NameOfFirstFile - NameOfLastFile.txt"<br>
 - Choosing the "Multiple files" option which will save each file individually with their newly modified designated names.<br>

After that all you have to do is click on "Output" button on lower left side of app.<br>
<br><br>


## Additional Info<br>
You can check the newly designated names of the files in the filename tab present on top of preview area.<br>
