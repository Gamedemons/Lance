package com.gamedemons.lance;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
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
    private RadioButton bc1;
    
    @FXML
    private RadioButton bc2;

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

    @FXML
    private Button output;

    @FXML
    private Label messageBar;

    @FXML
    private Label timeLabel;

    @FXML
    private TextArea originalNameBox;

    @FXML
    private TextArea newNameBox;







    String folderPath = "";
    String filename = "";
    String outputPath = "";
    double numberOfFiles = 0;
    double currentOpenFile = 0;
    List<String> chapters = new ArrayList<>();
    List<String> editedChapters = new ArrayList<>();
    List<String> filenamesList = new ArrayList<>();
    List<String> renamedFile = new ArrayList<>();
    Long timeConsumed;


    public void initialize() {
        renameCheck();
        removeCheck();
        replaceCheck();
        if(blankCheck.isSelected()){
            bc2.setSelected(true);
        }
        blankCheck();
    }

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
                        Thread.sleep(100);
                    }
                }catch (Exception e){
                    messageBar.setText("Error : " + e.getMessage());
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
        chapters.clear();
        editedChapters.clear();
        filenamesList.clear();
        renamedFile.clear();
        timeConsumed = Long.parseLong("0");
        removeCheck.setSelected(false);
        removeBox.setText("");
        replaceCheck.setSelected(false);
        replaceBox1.setText("");
        replaceBox2.setText("");
        previewArea.setText("");
        renameCheckbox.setSelected(false);
        stepBox.setText("");
        regexBox.setText("");
        prefixBox.setText("");
        suffixBox.setText("");
        renamerUI(true);
        blankCheck.setSelected(false);
        bc1.setSelected(false);
        bc1.setDisable(true);
        bc2.setSelected(false);
        bc2.setDisable(true);
        singleOutput.setSelected(false);
        singleOutput.setDisable(false);
        multipleOutput.setSelected(false);
        opromptLabel.setText("");
        outputPathField.setText("");
        loader.setProgress(0);
        messageBar.setText("");
        timeLabel.setText("");
        originalNameBox.setText("");
        newNameBox.setText("");
    }

    public void openFilePicker() {
        try {
            DirectoryChooser dChooser = new DirectoryChooser();
            File file = dChooser.showDialog(null);
            if(file != null){
                folderPath = file.getAbsolutePath();
            }
        }catch (Exception e){
            messageBar.setText("Error : " + e.getMessage());
        }
    }

    public static String readFileAsString(String fileName)throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public void previewText() {
        previewArea.setText("");
        chapters.clear();
        editedChapters.clear();
        filenamesList.clear();
        renamedFile.clear();
        try{
            timeConsumed = System.currentTimeMillis();

            //Counts no of files
            File[] files = new File(folderPath).listFiles();
            if (files != null) {
                for(File file : files){
                    if(file.isFile() && file.getName().endsWith(".txt")){
                        numberOfFiles += 1;
                    }
                }
            }

            setLoader();

            //Read chapters, file counter, filenameList
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    filename = file.getAbsolutePath();
                    filenamesList.add(file.getName().substring(0,file.getName().length()-4));
                    currentOpenFile += 1;
                    chapters.add(readFileAsString(filename));
                }
            }

            //Editing and displaying the edited chapters
            int editorCheck = editor();
            if(editorCheck == -1){
                messageBar.setText("Error : " + "Problem in editor.");
            }
            for(String chapter : editedChapters){
                previewArea.appendText(chapter + "\n\n\n\n");
            }
            timeLabel.setText("Time consumed : " + ((System.currentTimeMillis()-timeConsumed)) + " ms");
        }catch (Exception e){
            messageBar.setText("Error : " + e.getMessage());
        }
    }

    public int editor(){
        editedChapters.clear();
        for (String i : chapters){
            editedChapters.add(i);
        }

        if(removeCheck.isSelected()){
            List<String> removeEdit = new ArrayList<>();
            for(String text : editedChapters){
                String reText = text.replaceAll(removeBox.getText(), "");
                removeEdit.add(reText);
            }
            editedChapters= removeEdit;
        }

        if(replaceCheck.isSelected()){
            List<String> replaceEdit = new ArrayList<>();
            for(String text : editedChapters){
                String reText = text.replaceAll(replaceBox1.getText(), replaceBox2.getText());
                replaceEdit.add(reText);
            }
            editedChapters= replaceEdit;
        }

        if(renameCheckbox.isSelected()){
            String prefix = "";
            String suffix = "";
            Integer start = null;
            Integer step = null;
            String place = "";

            if(!stepBox.getText().isEmpty()){
                try{
                    String[] values = stepBox.getText().split(" : ");
                    if(values.length == 3){
                        start = Integer.parseInt(values[0]);
                        step = Integer.parseInt(values[1]);
                        place = values[2].trim();
                    }else{
                        throw new Exception("Invalid renamer values");
                    }
                }catch(Exception e){
                    messageBar.setText("Enter valid values in Renamer.");
                    return -1;
                }
            }
            if(!prefixBox.getText().trim().isEmpty()){
                prefix = prefixBox.getText().stripLeading();
            }
            if(!suffixBox.getText().trim().isEmpty()){
                suffix = suffixBox.getText().stripTrailing();
            }

            try{
                File[] files = new File(folderPath).listFiles();
                for(File file : files){
                    String currentfilename = file.getName().substring(0,file.getName().length()-4);
                    if(stepBox.getText().isEmpty() && (place.equals("") || place==null)){
                        renamedFile.add(prefix + currentfilename + suffix);
                    }
                    if(!stepBox.getText().isEmpty() && !place.equals("") && !(place == null) && start!=null && step!=null){
                        if(place.equals("B")){
                            renamedFile.add(start + prefix + currentfilename + suffix);
                        }else if(place.equals("Bs")){
                            renamedFile.add(start + " " + prefix + currentfilename + suffix);
                        }else if(place.equals("b")){
                            renamedFile.add(prefix + start + currentfilename + suffix);
                        }else if(place.equals("bs")){
                            renamedFile.add(prefix + start + " " + currentfilename + suffix);
                        }else if(place.equals("S")){
                            renamedFile.add(prefix + currentfilename + suffix + start);
                        }else if(place.equals("Ss")){
                            renamedFile.add(prefix + currentfilename + suffix + " " +  start);
                        }else if(place.equals("s")){
                            renamedFile.add(prefix + currentfilename + start + suffix);
                        }else if(place.equals("ss")){
                            renamedFile.add(prefix + currentfilename + " " +  start + suffix);
                        }else if(place.equals("RB")){
                            renamedFile.add(start + prefix + suffix);
                        }else if(place.equals("RBs")){
                            renamedFile.add(prefix + " " + currentfilename + " " +  start + suffix);
                        }else if(place.equals("RS")){
                            renamedFile.add(prefix + suffix + start);
                        }else if(place.equals("RSs")){
                            renamedFile.add(prefix + suffix + " " + start);
                        }
                        else if(place.equals("RM")){
                            renamedFile.add(prefix + start + suffix);
                        }else if(place.equals("RMs")){
                            renamedFile.add(prefix + " " + start + " " + suffix);
                        }
                        start = start + step;
                    }
                }
            } catch (Exception e) {
                messageBar.setText("Exception in renamer : Check the values");
            }
        }

        if(blankCheck.isSelected()){
            List<String> blankEdit = new ArrayList<>();
            for(String text : editedChapters){
                String[] line = text.split("[\r\n]+");
                List<String> textParts = Arrays.asList(line);
                String textBuilder ="";
                for (String i: textParts){
                    if(bc1.isSelected()){
                        textBuilder = textBuilder + i + "\n";
                    }else if(bc2.isSelected()){
                        textBuilder = textBuilder + i + "\n\n";
                    }
                }
                blankEdit.add(textBuilder);
            }
            editedChapters = blankEdit;
        }
//        if(!removeCheck.isSelected() && !replaceCheck.isSelected() && !blankCheck.isSelected()){
//            editedChapters.clear();
//            for (String i : chapters){
//                editedChapters.add(i);
//            }
//        }
        return 0;
    }

    public void removeCheck(){
        if(removeCheck.isSelected()){
            removeBox.setDisable(false);
        }else{
            removeBox.setDisable(true);
        }
    }

    public void replaceCheck(){
        if(replaceCheck.isSelected()){
            replaceBox1.setDisable(false);
            replaceBox2.setDisable(false);
        }else{
            replaceBox1.setDisable(true);
            replaceBox2.setDisable(true);
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
            renamerUI(true);
            opromptLabel.setText("");
        }
    }

    public void renamerUI(boolean input){
        stepBox.setDisable(input);
        regexBox.setDisable(input);
        prefixBox.setDisable(input);
        suffixBox.setDisable(input);
    }
    
    public void blankCheck(){
        if(blankCheck.isSelected()){
            bc1.setDisable(false);
            bc2.setDisable(false);
        }else{
            bc1.setDisable(true);
            bc2.setDisable(true);
        }
    }

    public void openOutputPath() {
        try {
            DirectoryChooser dChooser = new DirectoryChooser();
            File file = dChooser.showDialog(null);
//            if(file != null){
                outputPath = file.getAbsolutePath();
//            }
            outputPathField.setText(outputPath);
        }catch (Exception e){
            messageBar.setText("Error : " + e.getMessage());
        }
    }

    public void writeFiles(){
        previewText();
        filenameViewer();
        try {
            messageBar.setText("");
            if(!singleOutput.isSelected() && !multipleOutput.isSelected()){
                messageBar.setText("Select any one of the output modes.");
            }else{
                if(outputPath.isEmpty()){
                    messageBar.setText("Select a destination folder.");
                }else{
                    if(editedChapters.isEmpty()){
                        messageBar.setText("Chapters not added.");
                    }else{
                        if(singleOutput.isSelected()){
                            String text = "";
                            String name1 = filenamesList.get(0);
                            String name2 = filenamesList.get(filenamesList.size()-1);
                            for(String c : editedChapters){
                                text = text + c + "\n\n\n\n";
                            }
                            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath + "\\" + name1 + " - " + name2 + ".txt"));
                            writer.write(text);
                            writer.close();
                        }
                        if(multipleOutput.isSelected()){
                            int filenameLooper = 0;
                            for(String i : editedChapters){
                                String renamedFileLink = renamedFile.get(filenameLooper);
                                String filelink = outputPath + "\\" + renamedFileLink + ".txt";
                                BufferedWriter writer = new BufferedWriter(new FileWriter(filelink));
                                writer.write(i + "\n\n\n\n");
                                writer.close();
                                filenameLooper++;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            messageBar.setText("Error : " + e.getMessage());
        }
    }

    public void filenameViewer(){
        originalNameBox.setText("");
        newNameBox.setText("");
        String originalName = "Original Name\n\n";
        String newName = "New Name\n\n";
        for (String i : filenamesList){
            originalName = originalName + i + ".txt               ----------------------------------------------------------" + "\n\n";
        }
        for (String i : renamedFile){
            newName = newName + i + ".txt"  + "\n\n";
        }
        originalNameBox.setText(originalName);
        newNameBox.setText(newName);
    }

    public void scrollSync(){
        newNameBox.scrollTopProperty().bindBidirectional(originalNameBox.scrollTopProperty());
    }

    public void renameFile(File toBeRenamed, String new_name) {
        //need to be in the same path
        File fileWithNewName = new File(toBeRenamed.getParent(), new_name);
        if (fileWithNewName.exists()) {
            messageBar.setText("File already exists - Conflict.");
        }
        // Rename file (or directory)
        boolean success = toBeRenamed.renameTo(fileWithNewName);
        if (!success) {
            messageBar.setText("Error while renaming file.");
        }
    }

//    public void fileList(){
//        for(String i : filenamesList){
//            System.out.println(i);
//        }
//        for(String i : renamedFile){
//            System.out.println(i);
//        }
//    }

}