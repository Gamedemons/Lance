package com.gamedemons.lance;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class HelloController{

//    @FXML
//    private Button selectPath;
//
//    @FXML
//    private  Button help;
//
//    @FXML
//    private Button preview;

    @FXML
    private CheckBox removeCheck;

    @FXML
    private TextField removeBox;

    @FXML
    private CheckBox replaceCheck;

    @FXML
    private TextField replaceBox1;

    @FXML
    private TextField replaceBox2;

    @FXML
    private TextArea previewArea;

    @FXML
    private CheckBox renameCheckbox;

    @FXML
    private RadioButton numericalRadio;

    @FXML
    private RadioButton titleRadio;

    @FXML
    private TextField stepBox;

    @FXML
    private TextField regexBox;

    @FXML
    private TextField prefixBox;

    @FXML
    private TextField suffixBox;

    @FXML
    private CheckBox blankCheck;

    @FXML
    private RadioButton singleOutput;

    @FXML
    private RadioButton multipleOutput;

    @FXML
    private Label opromptLabel;

    @FXML
    private ProgressBar loader;

    @FXML
    private TextField outputPathField;

    String folderPath = "";
    String filename = "";
    String outputPath = "";
    double numberOfFiles = 0;
    double currentOpenFile = 0;
    ArrayList<String> chapters;



    public void setLoader(){
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try{
                    while(currentOpenFile<numberOfFiles){
                        String convertDouble = "" + (currentOpenFile/numberOfFiles);
                        if(convertDouble.length()>4){
                            convertDouble = convertDouble.substring(0,4);
                        }

                        loader.setProgress(Double.parseDouble(convertDouble));
                        System.out.println("Current file : " + currentOpenFile);
                        System.out.println("Number of file : " + numberOfFiles);
                        System.out.println("Div : " + convertDouble + "\n\n");
                        Thread.sleep(100);
                    }

                }catch (Exception e){
                    System.out.println(e.getMessage());
                }finally {
                    loader.setProgress(1);
                }
            }
        };
        new Thread(task).start();
    }

    public void resetUI(){
        folderPath = "";
        filename = "";
        outputPath = "";
        numberOfFiles = 0;
        currentOpenFile =0;
        removeCheck.setSelected(false);
        removeBox.setText("");
        replaceCheck.setSelected(false);
        replaceBox1.setText("");
        replaceBox2.setText("");
        previewArea.setText("");
        renameCheckbox.setSelected(false);
        numericalRadio.setSelected(false);
        titleRadio.setSelected(false);
        stepBox.setText("");
        regexBox.setText("");
        prefixBox.setText("");
        suffixBox.setText("");
        renamerUI(true);
        blankCheck.setSelected(false);
        singleOutput.setSelected(false);
        singleOutput.setDisable(false);
        multipleOutput.setSelected(false);
        opromptLabel.setText("");
        outputPathField.setText("");
        loader.setProgress(0);
    }

    public void openFilePicker() {
        try {
            DirectoryChooser dChooser = new DirectoryChooser();
            File file = dChooser.showDialog(null);
            folderPath = file.getAbsolutePath();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void previewText() {
        previewArea.setText("");

        try{
            StringBuilder text = new StringBuilder();

            File[] files = new File(folderPath).listFiles();
            if (files != null) {
                for(File file : files){
                    if(file.isFile()){
                        numberOfFiles += 1;
                    }
                }
            }

            setLoader();

            assert files != null;
            for (File file : files) {
                if (file.isFile()) {
                    filename = file.getAbsolutePath();
                    Scanner currentFile = new Scanner(new File(filename));
                    currentOpenFile += 1;


                    while(currentFile.hasNext()){
                        String line = currentFile.nextLine();
                        if (!line.isEmpty()) {
                            text.append(line).append("\n");

                        }
                    }
                    previewArea.appendText(text + "\n\n");
                    chapters.add(text + "");
                    currentFile.close();
                    previewArea.appendText("""


                            ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------




                            """);
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void renameCheck(){
        if(renameCheckbox.isSelected()){
            singleOutput.setDisable(true);
            singleOutput.setSelected(false);
            multipleOutput.setSelected(true);
            renamerUI(false);
            opromptLabel.setText("To use single output option disable renamer.");

        }else{
            singleOutput.setDisable(false);
            renameCheckbox.setSelected(false);
            numericalRadio.setSelected(false);
            renamerUI(true);
            opromptLabel.setText("");
        }
    }

    public void renamerUI(boolean input){
        numericalRadio.setDisable(input);
        titleRadio.setDisable(input);
        stepBox.setDisable(input);
        regexBox.setDisable(input);
        prefixBox.setDisable(input);
        suffixBox.setDisable(input);
    }

    public void openOutputPath() {
        try {
            DirectoryChooser dChooser = new DirectoryChooser();
            File file = dChooser.showDialog(null);
            outputPath = file.getAbsolutePath();
            outputPathField.setText(outputPath);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}