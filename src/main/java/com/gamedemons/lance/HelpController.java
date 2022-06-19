package com.gamedemons.lance;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URI;
import java.net.URISyntaxException;

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
                "\t\tThese are all the expressions that are currently available.\n");
    }







}
