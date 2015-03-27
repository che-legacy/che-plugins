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
package org.eclipse.che.plugin.angularjs.completion.dto;

import org.eclipse.che.dto.shared.DTO;

/**
 * @author Florent Benoit
 */
@DTO
public interface Param {


    String getName();
    void setName(String name);

    String getType();
    void setType(String type);

    String getDesc();
    void setDesc(String desc);

}
