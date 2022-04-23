package com.hello.myideademo;


import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.colors.EditorColors;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.ui.jcef.JBCefBrowser;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.persistence.Entity;
import javax.swing.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

public class HelloAction extends AnAction {
    public static String ProjectPath;
    public static String fileName;
    public static String fileNamefirst;

    public static String getProjectPath() {
        return ProjectPath;
    }

    public static String getFileName() {
        return fileName;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        ProjectPath = e.getProject().getBasePath();
        Document currentDoc = FileEditorManager.getInstance(e.getProject()).getSelectedTextEditor().getDocument();
        VirtualFile currentFile = FileDocumentManager.getInstance().getFile(currentDoc);
        fileName = currentFile.getName();
//        JPanel panel = new JPanel();
//        String url = "http://localhost:3000/?folderpath=" + ProjectPath + "&filename=" + fileName;
//        panel.add(new JBCefBrowser(url).getComponent());
        fileNamefirst = "";
        System.out.println(fileName);
        System.out.println(ProjectPath);
        for (int i = 0; i < fileName.length(); i++) {
            if (Character.compare('.', fileName.charAt(i)) == 0) {
                break;
            }
            fileNamefirst += fileName.charAt(i);
        }

        Project project = e.getRequiredData(CommonDataKeys.PROJECT);

//        Project project = anActionEvent.getProject();
//        File file = new File("/Users/saketh123/Documents/demo/tictactoe-java-master/src/main/java/ttsu/game/tictactoe/TicTacToeGameState.java");
//        VirtualFile virtualFile = LocalFileSystem.getInstance().findFileByIoFile(file);
//        PsiFile psiFile = PsiManager.getInstance(project).findFile(virtualFile);
//        OpenFileDescriptor openFileDescriptor = new OpenFileDescriptor(project, virtualFile);
//        openFileDescriptor.navigate(true);
//
//        Editor editor = FileEditorManager.getInstance(project).getSelectedTextEditor();
//        int x =  editor.getDocument().getLineCount();
//        editor.getMarkupModel().addLineHighlighter(120, 20, null);//addRangeHighlighter(1, 20, (HighlighterLayer.SELECTION - 100), new TextAttributes(), HighlighterTargetArea.EXACT_RANGE);

//        Project project = e.getRequiredData(CommonDataKeys.PROJECT);

//        VirtualFile file = VfsUtil.findFileByIoFile(new File("/Users/saketh123/Documents/demo/tictactoe-java-master/src/main/java/ttsu/game/tictactoe/TicTacToeGameState.java"), true);
//        if(file != null) {
//            new OpenFileDescriptor(project, file, 0).navigate(true);
//        }
//        if (file == null) return; // file not found
//        if (file.getFileType().isBinary()) return; // file is binary
//
//        final Document document = FileDocumentManager.getInstance().getDocument(file);
//        if (document == null) return; // can't read the file. Ex: it is too big
//        System.out.println(document);
//        CommandProcessor.getInstance().executeCommand(project, new Runnable() {
//            @Override
//            public void run() {
//                ApplicationManager.getApplication().runWriteAction(new Runnable() {
//                    @Override
//                    public void run() {
//                        int index = StringUtil.indexOf(document.getCharsSequence(), "package");
//                        if (index == -1) return;
//                        int lineNumber = document.getLineNumber(index);
//                        int offset = document.getLineEndOffset(lineNumber);
//
////                        document.insertString(offset, "\nSOME_TEXT_HERE");
//                    }
//                });
//            }
//        }, "Update android manifest", null);
//        Editor editor = FileEditorManager.getInstance(project).getSelectedTextEditor();
//        int x =  editor.getDocument().getLineCount();
//        TextAttributes color = editor.getColorsScheme().getAttributes(EditorColors.BREADCRUMBS_HOVERED);
//        editor.getMarkupModel().addLineHighlighter(127, 0, color);
//      editor.getMarkupModel().addLineHighlighter(123);


//        editor.getCaretModel().addCaret(v);
////        ReadAction
////                .nonBlocking(() -> {
////
////                    VirtualFile virtualFile = file;
////
////                    final int offset = 3469;
////
////                    return new Pair<>(virtualFile, offset);
////
////                })
////                .finishOnUiThread(ModalityState.defaultModalityState(), p -> {
////                    if (p != null)
////                    {
////                        System.out.println(p.second);
////                        openInEditor(p.first, p.second);
////                        getFileEditorManager().openTextEditor(new OpenFileDescriptor(project,
////                                virtualFile, offset), true);
////                    }
////                })
////                .inSmartMode(project)
////                .submit(NonUrgentExecutor.getInstance());
//        FileEditorManager.getInstance(project).openTextEditor(new OpenFileDescriptor(project,file,127),true);
//        FileEditorManager.getInstance(project).openTextEditor(new OpenFileDescriptor(project,
//                file, 3469), true);
//        addRangeHighlighter(1, 20, (HighlighterLayer.SELECTION - 100), new TextAttributes(), HighlighterTargetArea.EXACT_RANGE);
        open(e);

       try{
//           exexcute(ProjectPath,project);
       }
       catch (Exception ex){
           System.out.println(ex);
       }


    }


    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
    public void exexcute(String projectpath,Project project) throws Exception, IOException{
        while(true){
            wait(2000);
            BufferedReader br=null;
               try{
                   br = new BufferedReader(new FileReader(projectpath+"/file.txt"));

               }
               catch (Exception ex){

               }


            if(br==null) continue;
            try {

                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                String everything = sb.toString();
                VirtualFile file = VfsUtil.findFileByIoFile(new File("/Users/saketh123/Documents/demo/tictactoe-java-master/src/main/java/ttsu/game/tictactoe/TicTacToeGameState.java"), true);
//        if (file != null) {
            new OpenFileDescriptor(project, file, 3469).navigate(true);
//        }
        if (file == null) return; // file not found
                System.out.println(everything);
                try {
                    Files.deleteIfExists(
                            Paths.get(projectpath+"/file.txt"));
                }
                catch (NoSuchFileException e) {
                    System.out.println(
                            "No such file/directory exists");
                }
                catch (DirectoryNotEmptyException e) {
                    System.out.println("Directory is not empty.");
                }
                catch (IOException e) {
                    System.out.println("Invalid permissions.");
                }

                System.out.println("Deletion successful.");
            } finally {
                br.close();
            }
        }
    }

    public void open(AnActionEvent e) {
        ToolWindow toolWindow = ToolWindowManager.getInstance(e.getProject()).getToolWindow(WebViewToolFactory.ID);
//        if (toolWindow.isVisible()) {
//            toolWindow.hide();
//        } else {
//            toolWindow.show();
//        }

        toolWindow.show();
        WebViewToolFactory.relod();


    }
}