/*
 * ******************************************************************************
 *  * Copyright 2015 See AUTHORS file.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *   http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *  *****************************************************************************
 */

package com.uwsoft.editor.mvc.view.ui.dialog;

import com.badlogic.ashley.core.Entity;
import com.puremvc.patterns.mediator.SimpleMediator;
import com.puremvc.patterns.observer.Notification;
import com.uwsoft.editor.Overlap2D;
import com.uwsoft.editor.gdx.sandbox.Sandbox;
import com.uwsoft.editor.mvc.Overlap2DFacade;
import com.uwsoft.editor.mvc.view.Overlap2DMenuBar;
import com.uwsoft.editor.mvc.view.stage.UIStage;
import com.uwsoft.editor.mvc.view.ui.properties.panels.UIBasicItemProperties;
import com.uwsoft.editor.renderer.utils.CustomVariables;

/**
 * Created by azakhary on 5/12/2015.
 */
public class CustomVariablesDialogMediator extends SimpleMediator<CustomVariablesDialog> {
    private static final String TAG = CustomVariablesDialogMediator.class.getCanonicalName();
    private static final String NAME = TAG;

    private Entity observable = null;

    public CustomVariablesDialogMediator() {
        super(NAME, new CustomVariablesDialog());
    }

    @Override
    public void onRegister() {
        super.onRegister();
        facade = Overlap2DFacade.getInstance();
        viewComponent.setEmpty();
    }

    @Override
    public String[] listNotificationInterests() {
        return new String[]{
                Overlap2D.ITEM_SELECTED,
                Overlap2D.EMPTY_SPACE_CLICKED,
                UIBasicItemProperties.CUSTOM_VARS_BUTTON_CLICKED,
                CustomVariablesDialog.ADD_BUTTON_PRESSED,
                CustomVariablesDialog.DELETE_BUTTON_PRESSED,
                Overlap2DMenuBar.CUSTOM_VARIABLES_EDITOR_OPEN
        };
    }

    @Override
    public void handleNotification(Notification notification) {
        super.handleNotification(notification);

        Sandbox sandbox = Sandbox.getInstance();
        UIStage uiStage = sandbox.getUIStage();

        switch (notification.getName()) {
            case Overlap2DMenuBar.CUSTOM_VARIABLES_EDITOR_OPEN:
                viewComponent.show(uiStage);
                break;
            case UIBasicItemProperties.CUSTOM_VARS_BUTTON_CLICKED:
                viewComponent.show(uiStage);
                break;
            case Overlap2D.ITEM_SELECTED:
                setObservable(notification.getBody());
                break;
            case Overlap2D.EMPTY_SPACE_CLICKED:
                setObservable(null);
                break;
            case CustomVariablesDialog.ADD_BUTTON_PRESSED:
                setVariable();
                updateView();
                break;
            case CustomVariablesDialog.DELETE_BUTTON_PRESSED:
                removeVariable(notification.getBody());
                updateView();
                break;
        }
    }

    private void setVariable() {
    	//TODO fix and uncomment
//        CustomVariables vars = observable.getCustomVariables();
//        String key = viewComponent.getKey();
//        String value = viewComponent.getValue();
//        vars.setVariable(key, value);
//        observable.updateDataVO();
    }

    private void removeVariable(String key) {
    	//TODO fix and uncomment
//        CustomVariables vars = observable.getCustomVariables();
//        vars.removeVariable(key);
//        observable.updateDataVO();
    }

    private void setObservable(Entity item) {
        observable = item;
        updateView();
        viewComponent.setKeyFieldValue("");
        viewComponent.setValueFieldValue("");
    }

    private void updateView() {
        if(observable == null) {
            viewComponent.setEmpty();
        } else {
        	//TODO fix and uncomment
            //CustomVariables vars = observable.getCustomVariables();
            //viewComponent.updateView(vars);
        }
    }
}
