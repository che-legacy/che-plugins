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

package org.eclipse.che.jdt.rest;

import org.eclipse.che.jdt.JavadocService;

import javax.ws.rs.core.UriBuilder;

/**
 * @author Evgen Vidolob
 */
public class UrlContextProvider {


    private static UriBuilder builder;

    public static String get(String wsId, String projectPath) {
        return builder.path(JavadocService.class).path(JavadocService.class, "get").build(wsId).toString() + "?projectpath=" + projectPath +
               "&handle=";
    }

    public static synchronized void setUriBuilder(UriBuilder builder) {
        UrlContextProvider.builder = builder;
    }
}
