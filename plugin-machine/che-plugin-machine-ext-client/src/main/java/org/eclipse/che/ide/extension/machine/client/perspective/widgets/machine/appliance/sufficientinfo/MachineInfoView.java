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
package org.eclipse.che.ide.extension.machine.client.perspective.widgets.machine.appliance.sufficientinfo;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.ImplementedBy;

import org.eclipse.che.ide.extension.machine.client.machine.Machine;

import javax.annotation.Nonnull;

/**
 * Defines methods which allows update displaying information about current machine.
 *
 * @author Dmitry Shnurenko
 */
@ImplementedBy(MachineInfoViewImpl.class)
public interface MachineInfoView extends IsWidget {

    /**
     * Updates view representation which contains information about current machine.
     *
     * @param machine
     *         machine for which need update view
     */
    void updateInfo(@Nonnull Machine machine);

    /**
     * Sets owner's name in special place on view.
     *
     * @param ownerName
     *         name which need set
     */
    void setOwner(@Nonnull String ownerName);

    /**
     * Sets workspace in special place on view.
     *
     * @param workspaceName
     *         name which need set
     */
    void setWorkspaceName(@Nonnull String workspaceName);

    /**
     * Sets view visibility.
     *
     * @param visible
     *         <code>true</code> panel is visible,<code>false</code> panel isn't visible
     */
    void setVisible(boolean visible);
}