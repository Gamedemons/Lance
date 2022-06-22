package com.gamedemons.lance;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.net.URI;

public class HelpController {

    @FXML
    private TextArea helpBox;

    public void initialize(){
        helpBox.setText("Lance is a software utility which allows you to perform several flexible operations on text(.txt) files.\n" +
                "This app works well in conjunction with the Lightnovel Crawler. For example you can add prefix or suffix to the file or add custom numbering to the file names.\n" +
                "\n" +
                "Lance currently supports the following operations.\n" +
                "1 Remove a word from the file.\n" +
                "2 Replace words from a file.\n" +
                "3 Add a prefix or suffix to a filename\n" +
                "4 Add a numbering pattern to a file name.\n" +
                "5 Remove blank lines from the file.\n" +
                "6 Output the modified file in a specified location.\n" +
                "\n" +
                "\n" +
                "Getting Started\n" +
                "The first thing you'll need to do is select the folder where your text files are present. To do this click on the \"Open Folder\" button on the upper left side of application and select the folder.\n" +
                "The \"Preview button lets you preview your text documents with or without changes in the text area on the right.\n" +
                "\n" +
                "Remove Option\n" +
                "The remove option lets you remove any words from the text files.\n" +
                "for eg : typing \"Hello\" would remove the word \"Hello\" from all the files.\n" +
                "You can also remove multiple words at once using \"|\" at delimiter.\n" +
                "for eg : typing \"you|are\" would remove both the words \"you\" and \"are\".\n" +
                "Note : The \"|\" delimiter can be escaped by typing \"\\|\".\n" +
                "\n" +
                "Replace Option\n" +
                "The replace option lets you replace certain words with the words that you type. The word to be removed is to be typed in the first text box and the word to be replaced with is to be entered in the second text box.\n" +
                "The \"|\" delimiter can als be used to specify many words at the same time.\n" +
                "Note : The \"|\" delimiter can be escaped by typing \"\\|\".\n" +
                "\n" +
                "Renamer Option\n" +
                "The renamer option lets you change and adjust the names of the output files. renamer is quite flexible and can be used in many different ways to get the desired name.\n" +
                "\tRegex Field : allows the user to add the chapter title in file name based on custom regex expression\n" +
                "\tNumerical Field : lets you add numbering in the name of the output file. It is quite the flexible option.\n" +
                "\t\tIts syntax is \"Start : Step : Expression\"\n" +
                "\t\tThe \"Start\" field specifies the starting number.\n" +
                "\t\tThe \"Step\" field specifies the step. ie the number to be added to start for the subsequent file names.\n" +
                "\t\tThe \"Expression\" field specifies the place and format where the numbering is to be placed.\n" +
                "\t\tThese are all the expressions that are currently available.\n" +
                "\t\t\t\"B\"\t\t: start + prefix + currentfilename + suffix\n" +
                "\t\t\t\"Bs\"\t\t: start + \" \" + prefix + currentfilename + suffix\n" +
                "\t\t\t\"b\"\t\t: prefix + start + currentfilename + suffix\n" +
                "\t\t\t\"bs\"\t\t: prefix + start + \" \" + currentfilename + suffix\n" +
                "\t\t\t\"S\"\t\t: prefix + currentfilename + suffix + start\n" +
                "\t\t\t\"Ss\"\t\t: prefix + currentfilename + suffix + \" \" +  start\n" +
                "\t\t\t\"s\"\t\t: prefix + currentfilename + start + suffix\n" +
                "\t\t\t\"ss\"\t\t: prefix + currentfilename + \" \" +  start + suffix\n" +
                "\t\t\t\"RB\"\t\t: start + prefix + suffix\n" +
                "\t\t\t\"RBs\"\t: prefix + \" \" + currentfilename + \" \" +  start + suffix\n" +
                "\t\t\t\"RS\"\t\t: prefix + suffix + start\n" +
                "\t\t\t\"RSs\"\t: prefix + suffix + \" \" + start\n" +
                "\t\t\t\"RM\"\t: prefix + start + suffix\n" +
                "\t\t\t\"RMs\"\t: prefix + \" \" + start + \" \" + suffix\n" +
                "\t\tFor eg : if the input was \"1 : 2 : RM\" then the output would be 1.txt, 3.txt, 5.txt and so on.\n" +
                "\t\tThe \"Prefix Field\" specifies the prefix to be added to the start of the file name.\n" +
                "\t\tThe \"Suffix Field\" specifies the suffix to be added to the end of the file name.\n\n" +
                "Remove Blank Lines Option\n" +
                "\t\"All\" option removes all blank lines from the text.\n" +
                "\t\"Extra\" option removes all the extra blank line leaving only one blank line between each line\n\n" +
                "Output Option\nThis option lets you output the modified file to your desired location.\n" +
                "This can be done by first selecting the output location using the \"Change Location\" button at the bottom right side of the app. \n" +
                "After that you have to select any one of the two output modes in the app, namely \"Single file\" or \"Multiple Files\".\nChoosing the \"Single file\"" +
                " option will output all the contents into one file which will be named as \"NameOfFirstFile - NameOfLastFile.txt\"\nChoosing the \"Multiple files\"" +
                " option which will save each file individually with their newly modified designated names.\n" +
                "After that all you have to do is click on \"Output\" button on lower left side of app.\n\n\n" +
                "Additional Info\nYou can check the newly designated names of the files in the filename tab present on top of preview area.");
    }

    public void lanceLink(){
        try{
            Desktop.getDesktop().browse(new URI("https://github.com/Gamedemons/Lance"));
        }catch (Exception e){
        }
    }

    public void lncLink(){
        try{
            Desktop.getDesktop().browse(new URI("https://github.com/dipu-bd/lightnovel-crawler"));
        }catch (Exception e){
        }
    }
}
