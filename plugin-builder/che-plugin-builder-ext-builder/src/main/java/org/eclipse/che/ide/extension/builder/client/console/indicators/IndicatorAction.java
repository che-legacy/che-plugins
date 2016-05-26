/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.ide.extension.builder.client.console.indicators;

import org.eclipse.che.ide.api.action.Action;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.api.action.CustomComponentAction;
import org.eclipse.che.ide.api.action.Presentation;
import org.eclipse.che.ide.extension.builder.client.BuilderResources;

import com.google.gwt.user.client.ui.Widget;

/**
 * Action used to displaying some information.
 *
 * @author Artem Zatsarynnyy
 */
public class IndicatorAction extends Action implements CustomComponentAction {
    private String           caption;
    private boolean          isURL;
    private BuilderResources resources;
    private int              width;

    public IndicatorAction(String caption, boolean isURL, int width, BuilderResources resources) {
        super();
        this.caption = caption;
        this.isURL = isURL;
        this.resources = resources;
        this.width = width;
    }

    @Override
    public Widget createCustomComponent(Presentation presentation) {
        return new IndicatorView(caption, isURL, width, presentation, resources);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // no need to process any action, for now
    }

}
