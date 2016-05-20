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
package org.eclipse.che.ide.extension.builder.client.build;

import org.eclipse.che.api.builder.dto.BuildTaskDescriptor;
import org.eclipse.che.ide.extension.builder.client.BaseTest;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Testing {@link LogMessagesHandler} functionality.
 *
 * @author Artem Zatsarynnyy
 */
public class LogMessagesHandlerTest extends BaseTest {
    private LogMessagesHandler logMessagesHandler;
    private List<LogMessage> orderedMessages = new ArrayList<>(100);

    @Before
    public void setUp() {
        super.setUp();
        logMessagesHandler = new LogMessagesHandler(mock(BuildTaskDescriptor.class), builderConsolePresenter, messageBus);

        orderedMessages.clear();
        for (int i = 0; i < 100; i++) {
            orderedMessages.add(new LogMessage(i + 1, "message#" + i));
        }
    }

    @Test
    public void shouldPrintMessagesInCorrectOrder() throws Exception {
        List<LogMessage> shuffledMessages = new ArrayList<>(orderedMessages);
        Collections.shuffle(shuffledMessages);

        for (LogMessage logMessage : shuffledMessages) {
            logMessagesHandler.onMessageReceived(logMessage);
        }

        InOrder inOrder = inOrder(builderConsolePresenter);
        for (LogMessage logMessage : orderedMessages) {
            inOrder.verify(builderConsolePresenter, times(1)).print(logMessage.text);
        }
    }

    @Test
    @Ignore
    public void shouldSkipLostMessages() throws Exception {
        List<LogMessage> listWithMissedMessages = new ArrayList<>(orderedMessages);
        listWithMissedMessages.remove(75);
        listWithMissedMessages.remove(50);
        listWithMissedMessages.remove(25);

        for (LogMessage logMessage : listWithMissedMessages) {
            logMessagesHandler.onMessageReceived(logMessage);
        }

        for (LogMessage logMessage : orderedMessages) {
            final int index = orderedMessages.indexOf(logMessage);
            if (index == 25 || index == 50 || index == 75) {
                verify(builderConsolePresenter, never()).print(logMessage.text);
            } else {
                verify(builderConsolePresenter, timeout(5000).times(1)).print(logMessage.text);
            }
        }
    }

}
