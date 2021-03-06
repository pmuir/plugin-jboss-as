/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.as.forge;

import org.jboss.forge.maven.MavenPluginFacet;
import org.jboss.forge.maven.plugins.MavenPluginBuilder;
import org.jboss.forge.project.dependencies.DependencyBuilder;
import org.jboss.forge.project.facets.BaseFacet;

/**
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 */
public class AS7Facet extends BaseFacet
{
   @Override
   public boolean install()
   {
      MavenPluginFacet pluginFacet = project.getFacet(MavenPluginFacet.class);
      pluginFacet.addPlugin(MavenPluginBuilder.create()
               .setDependency(DependencyBuilder.create("org.jboss.as.plugins:jboss-as-maven-plugin:7.1.0.Beta1b")));
      return true;
   }

   @Override
   public boolean isInstalled()
   {
      MavenPluginFacet pluginFacet = project.getFacet(MavenPluginFacet.class);
      return pluginFacet.hasPlugin(DependencyBuilder.create("org.jboss.as.plugins:jboss-as-maven-plugin"));
   }

}
