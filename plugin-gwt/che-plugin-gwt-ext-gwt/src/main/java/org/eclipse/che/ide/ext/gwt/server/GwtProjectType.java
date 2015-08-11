/*******************************************************************************
 * Copyright (c) 2012-2015 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.ide.ext.gwt.server;

import com.google.inject.Inject;

import org.eclipse.che.api.project.server.type.ProjectType;
import org.eclipse.che.ide.extension.maven.server.projecttype.MavenProjectType;

import static org.eclipse.che.ide.ext.gwt.shared.Constants.GWT_PROJECT_TYPE_ID;
import static org.eclipse.che.ide.ext.gwt.shared.Constants.GWT_PROJECT_TYPE_NAME;

/** @author Artem Zatsarynnyy */
public class GwtProjectType extends ProjectType {

    public static final String DEFAULT_RECIPE =
            "https://gist.githubusercontent.com/azatsarynnyy/aceb43e8f71f3d14e7aa/raw/545d35585dc3440aedd09591b863b812cab84ef8/gwt";

    @Inject
    public GwtProjectType(MavenProjectType mavenProjectType) {
        super(GWT_PROJECT_TYPE_ID, GWT_PROJECT_TYPE_NAME, true, false, true, DEFAULT_RECIPE);
        addParent(mavenProjectType);
    }
}
