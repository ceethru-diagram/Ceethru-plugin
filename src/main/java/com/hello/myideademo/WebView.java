package com.hello.myideademo;

import com.intellij.ui.jcef.JBCefBrowser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WebView {
    private JPanel internalPanel;
    private JButton backButton;
    private JButton relodButton;
    //    private JButton backButton;
//    private JButton reloadButton;

    static JBCefBrowser browser;
    public WebView() {
       String URL = "http://localhost:3000/?folderpath=" + HelloAction.getProjectPath() + "&filename=" + HelloAction.fileName;
        System.out.println(URL);
         browser = new JBCefBrowser(URL);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                browser.getCefBrowser().goBack();
            }
        });

        relodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                browser.getCefBrowser().reload();
            }
        });
        internalPanel.add(browser.getComponent());
    }

    static void relod(){
//        URL=UR= "http://localhost:3000/?folderpath=" + HelloAction.getProjectPath() + "&filename=" + HelloAction.fileName;
        String URL = "http://localhost:3000/?folderpath=" + HelloAction.getProjectPath() + "&filename=" + HelloAction.fileName;
        browser.loadURL(URL);
    }

    public JPanel getContent() {
        return internalPanel;
    }
}
