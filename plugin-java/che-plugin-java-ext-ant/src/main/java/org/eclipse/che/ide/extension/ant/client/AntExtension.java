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
package org.eclipse.che.ide.extension.ant.client;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;

import org.eclipse.che.api.project.gwt.client.ProjectServiceClient;
import org.eclipse.che.api.project.shared.dto.ProjectDescriptor;
import org.eclipse.che.ide.api.event.ProjectActionEvent;
import org.eclipse.che.ide.api.event.ProjectActionHandler;
import org.eclipse.che.ide.api.extension.Extension;
import org.eclipse.che.ide.ext.java.client.dependenciesupdater.DependenciesUpdater;
import org.eclipse.che.ide.ext.java.shared.Constants;
import org.eclipse.che.ide.extension.ant.shared.AntAttributes;
import org.eclipse.che.ide.rest.DtoUnmarshallerFactory;

/**
 * Extension for support Ant projects.
 *
 * @author Vladyslav Zhukovskii
 */
@Singleton
@Extension(title = "Ant", version = "3.0.0")
public class AntExtension {

    /** Create instance of {@link AntExtension}. */
    @Inject
    public AntExtension(final EventBus eventBus,
                        final DependenciesUpdater dependenciesUpdater,
                        final DtoUnmarshallerFactory dtoUnmarshallerFactory,
                        final ProjectServiceClient projectServiceClient) {
        // Handle project opened event to fire update dependencies.
        eventBus.addHandler(ProjectActionEvent.TYPE, new ProjectActionHandler() {
            @Override
            public void onProjectReady(ProjectActionEvent event) {
                ProjectDescriptor project = event.getProject();
                if (AntAttributes.ANT_ID.equals(project.getType())
                    && project.getAttributes().containsKey(Constants.LANGUAGE)
                    && project.getAttributes().get(Constants.LANGUAGE).get(0).equals("java")) {
                    dependenciesUpdater.updateDependencies(project, false);
                }
            }

            @Override
            public void onProjectClosing(ProjectActionEvent event) {
            }

            @Override
            public void onProjectClosed(ProjectActionEvent event) {
            }

            @Override
            public void onProjectOpened(ProjectActionEvent event) {

            }
        });

        // Handle build.xml file save operation and if ant configuration has been changed reload project tree.
        // For example, if user provide custom source directory.
//        eventBus.addHandler(FileEvent.TYPE, new FileEventHandler() {
//            @Override
//            public void onFileOperation(final FileEvent event) {
//                if (event.getOperationType() == FileEvent.FileOperation.SAVE && "build.xml".equals(event.getFile().getName())) {
//                    final ProjectNode project = event.getFile().getProject();
//                    Unmarshallable<ProjectDescriptor> unmarshaller = dtoUnmarshallerFactory.newUnmarshaller(ProjectDescriptor.class);
//                    projectServiceClient.getProject(project.getData().getPath(),
//                                                    new AsyncRequestCallback<ProjectDescriptor>(unmarshaller) {
//                                                        @Override
//                                                        protected void onSuccess(ProjectDescriptor result) {
//                                                            if (!result.getAttributes().equals(project.getData().getAttributes())) {
//                                                                project.setData(result);
//                                                                eventBus.fireEvent(new RefreshProjectTreeEvent(project));
//                                                            }
//                                                        }
//
//                                                        @Override
//                                                        protected void onFailure(Throwable exception) {
//                                                            Log.info(getClass(), "Unable to get the project.", exception);
//                                                        }
//                                                    }
//                                                   );
//                }
//            }
//        });

    }
}
