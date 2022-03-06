package com.hello.myideademo;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.colors.EditorColors;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.ui.jcef.JBCefBrowser;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.io.File;

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
        JPanel panel = new JPanel();
        String url = "http://localhost:3000/?folderpath=" + ProjectPath + "&filename=" + fileName;
        panel.add(new JBCefBrowser(url).getComponent());
        fileNamefirst = "";
        System.out.println(fileName);
        System.out.println(ProjectPath);
        for (int i = 0; i < fileName.length(); i++) {
            if (Character.compare('.', fileName.charAt(i)) == 0) {
                break;
            }
            fileNamefirst += fileName.charAt(i);
        }
//        System.out.println(fileNamefirst);
//        Diagram diagram=new Diagram();
//        diagram.setCurrentFolderPath(ProjectPath);
//        diagram.setCurrentFileName( fileName);
//        diagram.setCurrentFile(fileNamefirst);
//        System.out.println(diagram.CurrentFolderName);
//        System.out.println(diagram.CurrentFileName);
////         fileNamefirst=fileName.split(".")[0];
////        Diagram blueprint=new Diagram(e.getProject().getBasePath(),currentFile.getName(),currentFile.getName());
//        CombinedTypeSolver combinedTypeSolver = new CombinedTypeSolver();
//        combinedTypeSolver.add(new ReflectionTypeSolver());
//        combinedTypeSolver.add(new JavaParserTypeSolver(e.getProject().getBasePath()+"/src/main/java/"));
//
//        JavaSymbolSolver symbolSolver = new JavaSymbolSolver(combinedTypeSolver);
//        StaticJavaParser.getConfiguration().setSymbolResolver(symbolSolver);
//        String src = "package any; public class A implements B { private Object stack; public void clear() { stack.hashCode(); } }";
//
//        CompilationUnit cu=null;
//        try{
//            cu = StaticJavaParser.parse(new File(currentFile.getPath()));
//        }
//        catch (FileNotFoundException notfoun){
//              System.out.println("File Not Found");
//        }
////        catch (FileNotFoundException notfoun){
////
////        }
//        ClassOrInterfaceDeclaration c=cu.findAll(ClassOrInterfaceDeclaration.class).get(0);
//        System.out.println();
//        List<MethodDeclaration> m=c.getMethods();
//        List<String>methods=new ArrayList<String>(0);
//        for(MethodDeclaration md:m){
//            methods.add(md.getNameAsString());
//        }
//        Messages.showInfoMessage(fileNamefirst,"info");

//        Messages.showDialog(e.getProject().getProjectFilePath(),);
        Project project = e.getRequiredData(CommonDataKeys.PROJECT);

        VirtualFile file = VfsUtil.findFileByIoFile(new File("/Users/saketh123/Documents/demo/tictactoe-java-master/src/main/java/ttsu/game/tictactoe/TicTacToeGameState.java"), true);
        if (file != null) {
            new OpenFileDescriptor(project, file, 0).navigate(true);
        }
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
        Editor editor = FileEditorManager.getInstance(project).getSelectedTextEditor();
        int x = editor.getDocument().getLineCount();
        TextAttributes color = editor.getColorsScheme().getAttributes(EditorColors.BREADCRUMBS_HOVERED);
        editor.getMarkupModel().addLineHighlighter(122, 0, color);
//      editor.getMarkupModel().addLineHighlighter(123,20,)


//        editor.getCaretModel().addCaret(v);
//        ReadAction
//                .nonBlocking(() -> {
//
//                    VirtualFile virtualFile = file;
//
//                    final int offset = 3469;
//
//                    return new Pair<>(virtualFile, offset);
//
//                })
//                .finishOnUiThread(ModalityState.defaultModalityState(), p -> {
//                    if (p != null)
//                    {
//                        System.out.println(p.second);
//                        openInEditor(p.first, p.second);
//                        getFileEditorManager().openTextEditor(new OpenFileDescriptor(project,
//                                virtualFile, offset), true);
//                    }
//                })
//                .inSmartMode(project)
//                .submit(NonUrgentExecutor.getInstance());
//        FileEditorManager.getInstance(project).openTextEditor(new OpenFileDescriptor(project,file,123),true)
        FileEditorManager.getInstance(project).openTextEditor(new OpenFileDescriptor(project,
                file, 3469), true);
//        addRangeHighlighter(1, 20, (HighlighterLayer.SELECTION - 100), new TextAttributes(), HighlighterTargetArea.EXACT_RANGE);
        open(e);
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