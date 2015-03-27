/*******************************************************************************
 * Copyright (c) 2014 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.plugin.angularjs.core.client.javascript.contentassist;

import com.google.gwt.core.client.JsArray;

/**
 * @author Florent Benoit
 */
public interface IContentAssistProvider {


    JsArray<JsProposal> computeProposals(String buffer, int offset, IContext context);

    JsProgram parse(String content);
}
