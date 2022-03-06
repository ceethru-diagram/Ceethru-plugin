package com.hello.myideademo;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.openapi.wm.ex.ToolWindowEx;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class WebViewToolFactory implements ToolWindowFactory {

    public static String ID = "Ceethru";
   public static WebView myToolWindow;
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
         myToolWindow = new WebView();

        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(myToolWindow.getContent(), "Diagram", false);
        toolWindow.getContentManager().addContent(content);
        ToolWindowEx ex = (ToolWindowEx) toolWindow;
        ex.stretchHeight(100);
    }

    static void relod(){
        WebView.relod();
    }
}