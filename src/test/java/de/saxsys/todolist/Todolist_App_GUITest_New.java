package de.saxsys.todolist;

import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.LabeledMatchers;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Todolist_App_GUITest_New extends FxRobot  {

    @Before
    public void setup() throws Exception {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(TodolistApp.class);
        FxToolkit.showStage();     
    }
    
    @Test
    public void new_Entry() {
        // given
        final TextField test_newItemText = lookup("#newItemText").queryFirst();
        doubleClickOn(test_newItemText).write("New Task to Delete");
        
        // when
        FxAssert.verifyThat("#addButton", NodeMatchers.isNotNull());
        final Button button_add = lookup("#addButton").queryFirst();
        clickOn(button_add);
        
        // then
        FxAssert.verifyThat("New Task to Delete", LabeledMatchers.hasText("New Task to Delete"));        
        
        sleep(5000);
        
    }
}
