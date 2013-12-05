package com.h3xstream.scriptgen;

import com.h3xstream.scriptgen.gui.GeneratorController;
import com.h3xstream.scriptgen.gui.GeneratorFrame;

import javax.swing.*;


public class ScriptGenerator {
    private HttpRequestInfo req;
    private GeneratorFrame frame;

    private GeneratorController controller;

    public ScriptGenerator(HttpRequestInfo req) {
        this.req = req;

        this.controller = new GeneratorController();
        this.frame = new GeneratorFrame(LanguageOption.values);
    }

    /**
     * Constructor intend for testing purpose.
     * @param req
     * @param controller
     * @param frame
     */
    public ScriptGenerator(HttpRequestInfo req,GeneratorController controller,GeneratorFrame frame) {
        this.req = req;

        this.controller = controller;
        this.frame = frame;
    }

    public JFrame openDialogWindow() {
        this.controller.updateHttpRequest(req);

        this.frame.setController(controller); //Controller need to be set prior setting
        this.frame.setTitleSuffix(req.getUrl());
        this.frame.setVisible(true);
        this.frame.updateLanguageSelection(0);
        return frame;
    }



}